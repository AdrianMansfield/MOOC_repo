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

fetch('http://localhost:8095/course/three-latest')
    .then(status)
    .then(json)
    .then(function (data) {
        drawThreeLastCourse(data)
    }).catch(function (error) {
    console.log('Request failed', error);
});

function drawThreeLastCourse(jsonData) {
    let cardDeck = document.getElementsByClassName('card-deck');
    jsonData.forEach(function (course) {
        let card = document.createElement('div');
        card.setAttribute('class', 'card bg-dark');
        let cardHeader = document.createElement('div');
        cardHeader.setAttribute('class', 'card-header text-light font-weight-bold text-center');
        cardHeader.innerHTML = course.title;
        let cardBody = document.createElement('div');
        cardBody.setAttribute('class', 'card-body text-light text-center');
        let cardAuthor = document.createElement('p');
        cardAuthor.setAttribute('class', 'card-text');
        cardAuthor.innerHTML = course.creator.userName;
        let goToCourseLink = document.createElement('a');
        goToCourseLink.setAttribute('class', 'btn btn-sm btn-primary');
        goToCourseLink.setAttribute('href', 'course-page.html?courseId=' + course.id);
        goToCourseLink.innerText = 'go to course';
        cardBody.appendChild(cardAuthor);
        cardBody.appendChild(goToCourseLink);
        card.appendChild(cardHeader);
        card.appendChild(cardBody);
        cardDeck[0].appendChild(card);
    });
}