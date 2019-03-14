<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>user profile page</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body class="bg-secondary">
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
    <div class="row text-light">
        <div class="col-sm-4">
            <table class="table table-borderless text-center user-data">
                <tr>
                    <img src="../resources/pictures/user-img.jpg" alt="test" class="rounded-circle user-img">
                </tr>
                <tr>

                    <td>
                        <p class="user-data-caption">user name</p>
                        MarkOtto
                    </td>
                </tr>
                <tr>

                    <td>
                        <p class="user-data-caption">first name</p>
                        Mark
                    </td>
                </tr>
                <tr>

                    <td>
                        <p class="user-data-caption">last name</p>
                        Otto
                    </td>
                </tr>
                <tr>

                    <td>
                        <p class="user-data-caption">email</p>
                        MOtto@mail.com
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-sm-8">
            <div class="text-center">
                <h1 class="align-center">user courses</h1>
            </div>

            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th scope="col">course</th>
                    <th scope="col">status</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Go programming</td>
                    <td>in progress</td>
                </tr>
                <tr>
                    <td>Java 8 course</td>
                    <td>finished</td>
                </tr>
                <tr>
                    <td>Spring boot starter course</td>
                    <td>in progress</td>
                </tr>
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
<script src="/js/indexRender.js"></script>
</body>
</html>