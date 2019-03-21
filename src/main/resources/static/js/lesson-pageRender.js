function status(response) {
    if (response.status >= 200 && response.status < 300) {
        return Promise.resolve(response)
    } else {
        return Promise.reject(new Error(response.statusText))
    }
}

function json(response) {
    return response.json()
}

let moduleIdParam = new URL(window.location.href).search;

fetch('/static-info/module-info/' + moduleIdParam)
    .then(status)
    .then(json)
    .then(function (data) {
        drawLessonAndLessonItemList(data)
    }).catch(function (error) {
    console.log('Request failed', error);
});


function drawLessonAndLessonItemList(jsonData) {
    let moduleTitle = document.createElement('h1');
    moduleTitle.innerText = jsonData.title;
    let moduleTitleContainer = document.getElementById('module-title');
    moduleTitleContainer.appendChild(moduleTitle);
    let lessonContainer = document.getElementById('lessonContainer');
    let lessonsList = document.createElement('div');
    lessonsList.setAttribute('class', 'list-group');
    lessonContainer.appendChild(lessonsList);
    jsonData.lessonForViewDTOS.forEach(function (lesson) {
        let lessonListItem = document.createElement('div');
        lessonListItem.setAttribute('class', 'list-group-item font-weight-bold');
        lessonListItem.innerText = lesson.title;
        lessonsList.appendChild(lessonListItem);

        if (lesson.status === 'finished') {
            let lessonStatus = document.createElement('i');
            lessonStatus.classList.add('fas', 'fa-circle', 'finished', 'ml-1');
            lessonListItem.appendChild(lessonStatus);
        } else if (lesson.status === "IN_PROGRESS") {
            let lessonStatus = document.createElement('i');
            lessonStatus.classList.add('fas', 'fa-circle', 'in-progress', 'ml-1');
            lessonListItem.appendChild(lessonStatus);
        }

        let lessonItemList = document.createElement('div');
        lessonItemList.setAttribute('class', 'list-group');
        lessonListItem.appendChild(lessonItemList);

        lesson.lessonItemForViewDTOS.forEach(function (lessonItem) {
            let lessonItemListItem = document.createElement('button');
            lessonItemListItem.setAttribute('class', 'list-group-item list-group-item-action text-dark');
            lessonItemListItem.id = lessonItem.lessonItemId + '-leftMenu';
            lessonItemListItem.onclick = function () {
                getLessonItemInfo(this);
                markAsActive(this);
            };
            lessonItemListItem.innerText = lessonItem.name;
            lessonItemList.appendChild(lessonItemListItem);

            if (lessonItem.status === 'FINISHED') {
                let lessonItemStatus = document.createElement('i');
                lessonItemStatus.classList.add('fas', 'fa-circle', 'finished', 'ml-1');
                lessonItemListItem.appendChild(lessonItemStatus);
            }

        });
    });
}

function markAsActive(button) {
    if (document.querySelectorAll('button.active').length > 0) {
        let prevActiveLessonItem = document.getElementsByClassName('active')[0];
        prevActiveLessonItem.classList.remove('active');
    }
    let currentLessonItem = document.getElementById(button.id.split('-')[0] + '-leftMenu');
    currentLessonItem.classList.add('active');
}

function getLessonItemInfo(button) {
    let lessonItemId = button.id.split('-')[0];
    fetch('/lesson-item/find/' + lessonItemId)
        .then(status)
        .then(json)
        .then(function (data) {
            drawLessonItemContent(data, lessonItemId);
        }).catch(function (error) {
        console.log('Request failed', error);
    });
}

function drawLessonItemContent(jsonData, lessonItemId) {
    let lessonItemContent = document.getElementById('lessonItemContent');
    lessonItemContent.removeChild(lessonItemContent.lastChild);
    let container = document.createElement('div');
    let lessonItemImg = document.createElement('img');
    lessonItemImg.setAttribute('src', jsonData.titleImgLink);
    container.appendChild(lessonItemImg);
    let lessonItemTextContent = document.createElement('p');
    lessonItemTextContent.innerText = jsonData.content;
    container.appendChild(lessonItemTextContent);
    lessonItemContent.appendChild(container);
    let nextLessonItemButton = document.createElement('button');
    nextLessonItemButton.setAttribute('class', 'btn btn-success go-next-button');
    nextLessonItemButton.id = lessonItemId;
    nextLessonItemButton.innerText = 'mark as complete';
    if (!isFinished(nextLessonItemButton)) {
        nextLessonItemButton.onclick = function () {
            setStatusForLessonItem(this);
        };
    } else {
        nextLessonItemButton.onclick = function () {
            changeLessonItemStatusOnUI(this)
        };
    }
    container.appendChild(nextLessonItemButton);
}


function setStatusForLessonItem(button) {
    let lessonItemId = button.id;
    fetch('/user-to-lesson-item/setLessonItemStatus', {
        method: 'post',
        headers: {
            "Content-Type": "application/json",
        },
        body: lessonItemId
    })
        .then(status)
        .then(function () {
            changeLessonItemStatusOnUI(button);
        })
        .catch(function (error) {
        });
}


function changeLessonItemStatusOnUI(button) {
    if (!hasStatusInLessonItem(button)) {
        setStatusForLessonItemsOnUI(button);
        if (!hasStatusInLesson(button) && !isLessonFinished(button)) {
            setStatusInProcessForLesson(button);
            showNextLessonItem(button)
        } else {
            if (isLessonFinished(button)) {
                setStatusFinishedForLesson(button);
                showNextLessonItem(button);
            } else {
                showNextLessonItem(button);
            }
        }
    } else {
        showNextLessonItem(button);
    }
}

function index(el) {
    let children = el.parentNode.childNodes,
        i = 0;
    for (; i < children.length; i++) {
        if (children[i] === el) {
            return i;
        }
    }
    return -1;
}

function isFinished(button) {
    let leftMenuButtonParent = document.getElementById(button.id + '-leftMenu').parentNode;
    let numberOfLessonItemsInLesson = leftMenuButtonParent.childElementCount;
    let numbersOfStatusesInLesson = leftMenuButtonParent.querySelectorAll("i.fas").length;
    return numberOfLessonItemsInLesson === numbersOfStatusesInLesson;
}


function showNextLessonItem(button) {
    let currentLessonItemLinkFromLeftBar = document.getElementById(button.id + '-leftMenu');
    let indexOfLessonItem = index(currentLessonItemLinkFromLeftBar);
    let numberOfLessonItemsInLesson = currentLessonItemLinkFromLeftBar.parentNode.childElementCount;
    let listGroupCapacity = currentLessonItemLinkFromLeftBar.parentNode.parentNode.parentNode.childElementCount;
    if (indexOfLessonItem !== numberOfLessonItemsInLesson - 1) {
        currentLessonItemLinkFromLeftBar.nextSibling.click();
    } else if (listGroupCapacity - 1 !== index(currentLessonItemLinkFromLeftBar.parentNode.parentNode)) {
        currentLessonItemLinkFromLeftBar.parentNode.parentNode.nextSibling.lastChild.firstChild.click();
    }
}

function hasStatusInLessonItem(button) {
    let currentLessonItemLinkFromLeftBar = document.getElementById(button.id + '-leftMenu');
    return currentLessonItemLinkFromLeftBar.childElementCount === 1;
}

function hasStatusInLesson(button) {
    let topParentElementForCurrentLessonItemLinkFromLeftBar = document.getElementById(button.id + '-leftMenu').parentNode.parentNode;
    return topParentElementForCurrentLessonItemLinkFromLeftBar.childElementCount === 2;
}

function isLessonFinished(button) {
    let listOfSiblingsForCurrentLessonItem = document.getElementById(button.id + '-leftMenu').parentNode.childNodes;
    return !Array.from(listOfSiblingsForCurrentLessonItem).some(function (elem) {
        return elem.childElementCount !== 1
    });

}


function setStatusForLessonItemsOnUI(button) {
    let currentLessonItemLinkFromLeftBar = document.getElementById(button.id + '-leftMenu');
    let status = document.createElement('i');
    status.classList.add('fas', 'fa-circle', 'finished', 'ml-1');
    currentLessonItemLinkFromLeftBar.appendChild(status);
}

function setStatusFinishedForLesson(button) {
    let lessonForCurrentLessonItem = document.getElementById(button.id + '-leftMenu').parentNode.parentNode;
    let status = document.createElement('i');
    status.classList.add('fas', 'fa-circle', 'finished', 'ml-1');
    let oldLessonStatus = lessonForCurrentLessonItem.getElementsByTagName('i');
    lessonForCurrentLessonItem.replaceChild(status, oldLessonStatus[0]);
}

function setStatusInProcessForLesson(button) {
    let lessonForCurrentLessonItem = document.getElementById(button.id + '-leftMenu').parentNode.parentNode;
    let status = document.createElement('i');
    status.classList.add('fas', 'fa-circle', 'in-progress', 'ml-1');
    lessonForCurrentLessonItem.insertBefore(status, lessonForCurrentLessonItem.children[0]);
}