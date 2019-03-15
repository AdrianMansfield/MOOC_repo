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

let courseIdParam = new URL(window.location.href).search;


fetch('http://localhost:8095/module/find' + courseIdParam)
    .then(status)
    .then(json)
    .then(function (data) {
        fetch('http://localhost:8095/course/find' + courseIdParam)
            .then(status)
            .then(json)
            .then(function (data) {
                drawCourseTitleAndAuthor(data)
            }).catch(function (error) {
            console.log('Request failed', error);
        });
        drawCurrentCourseModule(data)
    }).catch(function (error) {
    console.log('Request failed', error);
});

function drawCourseTitleAndAuthor(jsonData) {
    let courseHeader = document.getElementById("course-title");
    courseHeader.innerText = jsonData.title;
    let courseAuthor = document.getElementById("course-author");
    courseAuthor.innerText = jsonData.creator.userName;
}

function drawCurrentCourseModule(jsonData) {
    let cardDeck = document.getElementsByClassName('card-columns');
    console.log(jsonData);
    jsonData.forEach(function (module) {
        let card = document.createElement('div');
        card.setAttribute('class', 'card bg-dark');
        let moduleImg = document.createElement('img');
        moduleImg.setAttribute('class', 'card-img-top');
        moduleImg.setAttribute('src', '/picture/logo-img.jpg');
        card.appendChild(moduleImg);
        let cardBody = document.createElement('div');
        cardBody.setAttribute('class', 'card-body text-light');
        card.appendChild(cardBody);
        let cardTitle = document.createElement('h5');
        cardTitle.setAttribute('class', 'card-title d-inline');
        cardTitle.innerText = module.title;
        cardBody.appendChild(cardTitle);
        let cardText = document.createElement('p');
        cardText.setAttribute('class', 'card-text');
        cardText.innerText = module.description;
        cardBody.appendChild(cardText);
        cardDeck[0].appendChild(card);
    });
}