<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>lesson</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body class="bg-secondary">

<nav class="navbar navbar-dark bg-dark">
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
<div class="row m-auto">
    <div class="col-sm-3" id="lessonContainer">
        <ul class="list-group list-group-flush text-light">
            <li class="list-group-item active">
                first lesson name
                <span class="badge badge-success badge-pill">done</span>

            </li>
            <li class="list-group-item">
                second lesson name
                <span class="badge badge-success badge-pill">done</span>

            </li>
            <li class="list-group-item">
                third lesson name
                <span class="badge badge-primary badge-pill">in progress</span>

            </li>
            <li class="list-group-item">
                fourth lesson name
                <span class="badge badge-danger badge-pill">not finished</span>

            </li>
            <li class="list-group-item">
                fifth module name
                <span class="badge badge-danger badge-pill">not finished</span>
            </li>
        </ul>
    </div>
    <div class="col-sm-9">
        <div class="text-center">
            <h1 class="text-light">lesson list</h1>
        </div>

        <ul class="list-group list-group-flush text-light">
            <li class="list-group-item">
                first lesson item name
                <span class="badge badge-success badge-pill">done</span>

            </li>
            <li class="list-group-item">
                second lesson item name
                <span class="badge badge-success badge-pill">done</span>

            </li>
            <li class="list-group-item">
                third lesson item name
                <span class="badge badge-success badge-pill">done</span>

            </li>
            <li class="list-group-item">
                fourth lesson item name
                <span class="badge badge-success badge-pill">done</span>

            </li>
        </ul>

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
<script src="/js/lesson-pageRender.js"></script>

</body>
</html>