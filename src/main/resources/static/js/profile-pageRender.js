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

fetch('http://localhost:8095/user/get-user-info')
    .then(status)
    .then(json)
    .then(function (data) {
        fetch('http://localhost:8095/user-to-course/all-courses?userId=' + data.id)
            .then(status)
            .then(json)
            .then(function (data) {
                drawUserCourses(data);
            }).catch(function (error) {
            console.log(error);
        });
        drawUserInfo(data);
    }).catch(function (error) {
    console.log(error);
});

function drawUserInfo(jsonData) {
    document.getElementById('userName').innerText = jsonData.userName;
    document.getElementById('firstName').innerText = jsonData.firstName;
    document.getElementById('lastName').innerText = jsonData.lastName;
    document.getElementById('email').innerText = jsonData.email;
}

function drawUserCourses(jsonData) {
    let userCourses = document.getElementById('userCourses');
    jsonData.forEach(function (course) {
        let tableRow = document.createElement('tr');
        let courseName = document.createElement('td');
        courseName.innerText = course.title;
        tableRow.appendChild(courseName);
        let courseStatus = document.createElement('td');
        courseStatus.innerText = course.status;
        tableRow.appendChild(courseStatus);
        userCourses.appendChild(tableRow);
    })
}