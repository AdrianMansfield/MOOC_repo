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

function drawLessonAndLessonItemList(jsonData) {
    let moduleTitle = document.createElement('h1');
    moduleTitle.innerText = jsonData.title;
    let moduleTitleContainer = document.getElementById('module-title');
    moduleTitleContainer.appendChild(moduleTitle);

    console.log(jsonData);
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
            lessonItemListItem.setAttribute('lessonItemId', lessonItem.lessonItemId);
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
    let lessonItemId = button.getAttribute('lessonItemId');
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
    console.log(lessonItemId);
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
    nextLessonItemButton.setAttribute('lessonItemId', lessonItemId);
    nextLessonItemButton.innerText = 'go to next';
    nextLessonItemButton.onclick = function () {
        setStatusForLessonItem(this);
    };
    container.appendChild(nextLessonItemButton);
}

function setStatusForLessonItem(button) {
    let lessonItemId = button.getAttribute('lessonItemId');
    fetch('http://localhost:8095/user-to-lesson-item/setLessonItemStatus', {
        method: 'post',
        headers: {
            "Content-Type": "application/json",
        },
        body: lessonItemId
    })
        .then(json)
        .then(function (data) {
            console.log('Request succeeded with JSON response', data);
            changeDataOnPage();
        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}