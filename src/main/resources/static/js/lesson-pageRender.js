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

fetch('http://localhost:8095/lesson/find' + moduleIdParam)
    .then(status)
    .then(json)
    .then(function (data) {
        drawLessonAndLessonItemList(data)
    }).catch(function (error) {
    console.log('Request failed', error);
});

function drawCurrentModuleLessons(jsonData) {
    console.log(jsonData);
    let lessonContainer = document.getElementById("lessonContainer");
    if (jsonData.size !== 0) {
        let lessonList = document.createElement('ul');
        lessonList.setAttribute('class', 'list-group list-group-flush text-light');
        lessonContainer.appendChild(lessonList);
        jsonData.forEach(function (lesson) {
            let lessonListItem = document.createElement('li');
            lessonListItem.setAttribute('class','list-group-item');
            lessonListItem.innerText = lesson.title;
            let statusIndicator = document.createElement('span');
            statusIndicator.setAttribute('class','badge badge-success badge-pill')
        })
    } else {

    }

}