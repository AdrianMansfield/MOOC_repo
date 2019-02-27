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

let courseId = new URL(window.location.href).searchParams.get('courseId');

fetch('http://localhost:8095/modules/get-modules-by-course/' + courseId)
    .then(status)
    .then(json)
    .then(function (data) {
        drawCurrentCourseModule(data)
    }).catch(function (error) {
    console.log('Request failed', error);
});

function drawCurrentCourseModule(jsonData) {
    let cardDeck = document.getElementsByClassName('card-columns');
    jsonData.forEach(function (module) {
        let card = document.createElement('div');
        card.setAttribute('class', 'card bg-dark');
        let moduleImg = document.createElement('img');
        moduleImg.setAttribute('class', 'card-img-top');
        moduleImg.setAttribute('src', '../static/logo-img.jpg');
        card.appendChild(moduleImg);
        let cardBody = document.createElement('div');
        cardBody.setAttribute('class', 'card-body text-light');
        card.appendChild(cardBody);
        let cardTitle = document.createElement('h5');
        cardTitle.setAttribute('class', 'card-title');
        cardTitle.innerText = module.title;
        cardBody.appendChild(cardTitle);
        let cardText = document.createElement('p');
        cardText.setAttribute('class', 'card-text');
        cardText.innerText = module.description;
        cardBody.appendChild(cardText);
        let goToModuleLink = document.createElement('a');
        goToModuleLink.setAttribute('class', 'btn btn-sm btn-primary');
        goToModuleLink.setAttribute('href', 'lesson-page.html?moduleId=' + module.id);
        goToModuleLink.innerText = 'go to module';
        cardBody.appendChild(goToModuleLink);
        cardDeck[0].appendChild(card);
    });
}
