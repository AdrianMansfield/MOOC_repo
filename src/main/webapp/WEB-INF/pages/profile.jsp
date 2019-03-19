<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title><sec:authentication property="principal.username"/></title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body class="bg-color">
<nav class="navbar navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand mb-0 h1" href="/">MOOC-project</a>
        <div class="text-right">
            <sec:authorize access="isAuthenticated()">
                <span class="text-light"><sec:authentication property="principal.username"/></span>
                <a class="btn btn-outline-light btn-sm text-light" href="/logout">Log out</a>
            </sec:authorize>
        </div>
    </div>
</nav>
<div class="container user-info">
    <div class="row">
        <div class="col-sm-4">
            <table class="table table-borderless text-center user-data">
                <tr>
                    <img src='/picture/user-img.jpg' alt="test" class="rounded-circle user-img"/>
                </tr>
                <tr>
                    <td>
                        <p class="user-data-caption">user name</p>
                        <p id="userName"></p>
                    </td>
                </tr>
                <tr>

                    <td>
                        <p class="user-data-caption">first name</p>
                        <p id="firstName"></p>
                    </td>
                </tr>
                <tr>

                    <td>
                        <p class="user-data-caption">last name</p>
                        <p id="lastName"></p>
                    </td>
                </tr>
                <tr>

                    <td>
                        <p class="user-data-caption">email</p>
                        <p id="email"></p>
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-sm-8">
            <div class="text-center">
                <h1 class="align-center">user courses</h1>
            </div>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">course</th>
                    <th scope="col">status</th>
                </tr>
                </thead>
                <tbody id="userCourses">

                </tbody>
            </table>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="/js/profile-pageRender.js"></script>
</body>
</html>