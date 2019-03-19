<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>course page</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body class="bg-color">

<nav class="navbar navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand mb-0 h1" href="/">MOOC-project</a>
        <div class="text-right">
            <sec:authorize access="isAuthenticated()">
                <a class="text-light" href="/profile"><sec:authentication property="principal.username"/></a>
                <a class="btn btn-outline-light btn-sm text-light" href="/logout">Log out</a>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <a class="btn btn-outline-light btn-sm text-light" href="/login">Log in</a>
            </sec:authorize>
        </div>
    </div>
</nav>

<div class="container mt-3 mb-3" id="Course header">

    <h1 class="course-name text-center" id="course-title"></h1>
    <hr>
    <h2 class="course-author text-center" id="course-author"></h2>

    <sec:authorize access="isAuthenticated()">
        <div class="text-center mb-3" id="courseActionButton"></div>
    </sec:authorize>

    <div class="card-columns text-center"></div>
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
<script src="/js/course-preview-pageRender.js"></script>
</body>
</html>
