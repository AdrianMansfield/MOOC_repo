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

fetch('http://localhost:8095/static-info/module-info/' + moduleIdParam)
    .then(status)
    .then(json)
    .then(function (data) {
        drawLessonAndLessonItemList(data)
    }).catch(function (error) {
    console.log('Request failed', error);
});

let countNumber = 0;

function drawLessonAndLessonItemList(jsonData) {
    let moduleTitle = document.createElement('h1');
    moduleTitle.innerText = jsonData.title;
    let moduleTitleContainer = document.getElementById('module-title');
    moduleTitleContainer.appendChild(moduleTitle);

    // console.log(jsonData);
    let lessonContainer = document.getElementById('lessonContainer');
    let lessonsList = document.createElement('div');
    lessonsList.setAttribute('class', 'list-group');
    lessonContainer.appendChild(lessonsList);

    jsonData.lessonForViewDtos.forEach(function (lesson) {
        let lessonListItem = document.createElement('div');
        lessonListItem.setAttribute('class', 'list-group-item font-weight-bold');
        lessonListItem.innerText = lesson.title;
        lessonsList.appendChild(lessonListItem);
        let lessonStatus = document.createElement('span');
        if (lesson.status === 'finished') {
            lessonStatus.setAttribute('class', 'badge badge-success badge-pill  ml-2');
            lessonStatus.innerText = 'finished';
        } else if (lesson.status === "not_started") {
            lessonStatus.setAttribute('class', 'badge badge-danger badge-pill  ml-2');
            lessonStatus.innerText = 'not started';
        } else {
            lessonStatus.setAttribute('class', 'badge badge-primary badge-pill  ml-2');
            lessonStatus.innerText = "in process";
        }
        lessonListItem.appendChild(lessonStatus);
        let lessonItemList = document.createElement('div');
        lessonItemList.setAttribute('class', 'list-group');
        lessonListItem.appendChild(lessonItemList);

        lesson.lessonItemForViewDtos.forEach(function (lessonItem) {
            let lessonItemListItem = document.createElement('button');
            lessonItemListItem.setAttribute('class', 'list-group-item list-group-item-action text-dark');
            lessonItemListItem.id = lessonItem.lessonItemId + '-leftMenu';
            lessonItemListItem.onclick = function () {
                getLessonItemInfo(this);
            };
            lessonItemListItem.innerText = lessonItem.name;
            lessonItemList.appendChild(lessonItemListItem);
            let lessonItemStatus = document.createElement('span');
            if (lessonItem.status === 'finished') {
                lessonItemStatus.setAttribute('class', 'badge badge-success badge-pill ml-2');
                lessonItemStatus.innerText = 'finished';
            } else {
                lessonItemStatus.setAttribute('class', 'badge badge-danger badge-pill ml-2');
                lessonItemStatus.innerText = 'not started';
            }
            lessonItemListItem.appendChild(lessonItemStatus);
        });
    });
}

function getLessonItemInfo(button) {
    let lessonItemId = button.id.split('-')[0];
    fetch('http://localhost:8095/lesson-item/find/' + lessonItemId)
        .then(status)
        .then(json)
        .then(function (data) {
            drawlessonItemContent(data, lessonItemId);
        }).catch(function (error) {
        console.log('Request failed', error);
    });
}

function drawlessonItemContent(jsonData, lessonItemId) {
    let lessonItemContent = document.getElementById('lessonItemContent');
    lessonItemContent.removeChild(lessonItemContent.lastChild);
    let container = document.createElement('div');
    let lessonItemImg = document.createElement('img');
    lessonItemImg.setAttribute('src', jsonData.title_img_link);
    container.appendChild(lessonItemImg);
    let lessonItemTextContent = document.createElement('p');
    lessonItemTextContent.innerText = jsonData.content;
    container.appendChild(lessonItemTextContent);
    lessonItemContent.appendChild(container);
    let nextLessonItemButton = document.createElement('button');
    nextLessonItemButton.setAttribute('class', 'btn btn-success go-next-button');
    nextLessonItemButton.id = lessonItemId;
    nextLessonItemButton.innerText = 'go to next';
    if (isFinished(nextLessonItemButton) === 'no') {
        nextLessonItemButton.onclick = function () {
            setStatusForLessonItem(this);
        };
    } else if (isFinished(nextLessonItemButton) === 'yes') {
        console.log('not setting status for items');
        nextLessonItemButton.onclick = function () {
            changeLessonItemStatusOnUI(this, 1)
        };
    }

    container.appendChild(nextLessonItemButton);
}


function setStatusForLessonItem(button) {
    let lessonItemId = button.id;
    fetch('http://localhost:8095/user-to-lesson-item/setLessonItemStatus', {
        method: 'post',
        headers: {
            "Content-Type": "application/json",
        },
        body: lessonItemId
    })
        .then(status)
        .then(function () {
            console.log('Request succeeded with JSON response');
            changeLessonItemStatusOnUI(button, 0);
        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}

function changeLessonItemStatusOnUI(button, isFinishegFlag) {
    let currentLessonItemButtonFromLeftMenu = document.getElementById(button.id + '-leftMenu');
    currentLessonItemButtonFromLeftMenu.removeChild(currentLessonItemButtonFromLeftMenu.lastChild);
    let newLessonItemStatus = document.createElement('span');
    newLessonItemStatus.classList.add('badge', 'badge-success', 'badge-pill', 'ml-2');
    newLessonItemStatus.innerText = 'finished';
    currentLessonItemButtonFromLeftMenu.appendChild(newLessonItemStatus);
    let parentNodeForButton = currentLessonItemButtonFromLeftMenu.parentNode;
    let indexOfLessonItem = index(currentLessonItemButtonFromLeftMenu);
    let numberOfLessonItemsInLesson = parentNodeForButton.childElementCount;
    let lessonStatus = parentNodeForButton.previousSibling;
    let newLessonStatus = document.createElement('span');
    let topButtonParent = currentLessonItemButtonFromLeftMenu.parentNode.parentNode;
    let listGroupCapacity = topButtonParent.parentNode.childElementCount;
    newLessonStatus.classList.add('badge', 'badge-pill', 'ml-2');
    if (indexOfLessonItem === numberOfLessonItemsInLesson - 1) {
        newLessonStatus.classList.add('badge-success');
        newLessonStatus.innerText = 'finished';
        console.log(index(topButtonParent));
        if (listGroupCapacity - 1 !== index(topButtonParent)) {
            topButtonParent.nextSibling.childNodes[2].childNodes[0].click();
        } else {
            let lastButton = document.getElementById(button.id);
            lastButton.onclick = function () {
                lastButton.parentNode.removeChild(lastButton);
            };
        }
    } else {
        newLessonStatus.classList.add('badge-primary');
        newLessonStatus.innerText = 'in progress';
        currentLessonItemButtonFromLeftMenu.nextSibling.click();
    }
    lessonStatus.parentNode.replaceChild(newLessonStatus, lessonStatus);

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
    let leftMenuButton = document.getElementById(button.id + '-leftMenu');
    let buttonStatus = leftMenuButton.lastChild;
    if (buttonStatus.classList.contains('badge-success')) {
        return 'yes';
    }
    return 'no';
}