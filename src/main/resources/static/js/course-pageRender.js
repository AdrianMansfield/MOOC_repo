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


fetch('http://localhost:8095/security/isAnonymous')
    .then(status)
    .then(json)
    .then(function (data) {
        if (data) {
            fetch('http://localhost:8095/module/find' + courseIdParam)
                .then(status)
                .then(json)
                .then(function (data) {
                    drawCurrentCourseModule(data)
                }).catch(function (error) {
                console.log('Request failed', error);
            });
        } else {
            fetch('http://localhost:8095/user-to-module/modules-by-course' + courseIdParam)
                .then(status)
                .then(json)
                .then(function (data) {
                    drawCurrentCourseModule(data);
                    console.log(data)
                }).catch(function (error) {
                console.log('Request failed', error);
            });
        }
    }).catch(function (error) {
    console.log(error);
});


fetch('http://localhost:8095/course/find' + courseIdParam)
    .then(status)
    .then(json)
    .then(function (data) {
        drawCourseTitleAndAuthor(data)
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
        if (module.hasOwnProperty("status")) {
            let moduleStatus = document.createElement('span');
            if (module.status === 'finished') {
                moduleStatus.setAttribute('class', 'badge badge-success badge-pill d-inline');
                moduleStatus.innerText = 'finished';
            } else if (module.status === "not_started") {
                moduleStatus.setAttribute('class', 'badge badge-danger badge-pill d-inline');
                moduleStatus.innerText = 'not started';
            } else {
                moduleStatus.setAttribute('class', 'badge badge-primary badge-pill d-inline');
                moduleStatus.innerText = "in process";
            }
            cardBody.appendChild(moduleStatus);
        }
        let cardText = document.createElement('p');
        cardText.setAttribute('class', 'card-text');
        cardText.innerText = module.description;
        cardBody.appendChild(cardText);
        let goToModuleLink = document.createElement('a');
        goToModuleLink.setAttribute('class', 'btn btn-sm btn-primary');
        goToModuleLink.setAttribute('href', '/lesson-page?moduleId=' + module.moduleId);
        goToModuleLink.innerText = 'go to module';
        cardBody.appendChild(goToModuleLink);
        cardDeck[0].appendChild(card);
    });
}
