<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>user list</title>

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
<div class="container">
    <table class="table table-hover text-light w-100">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">user name</th>
            <th scope="col">first name</th>
            <th scope="col">last name</th>
            <th scope="col">email</th>
            <th scope="col">date of sign up</th>
            <th scope="col">number of actives courses</th>
            <th scope="col">delete</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td>MarkOtto</td>
            <td>Otto</td>
            <td>Mark</td>
            <td>motto@mail.com</td>
            <td>10.03.2018</td>
            <td>3</td>
            <td>
                <button class="btn btn-outline-danger btn-sm">delete</button>
            </td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>MarkOtto</td>
            <td>Otto</td>
            <td>Mark</td>
            <td>motto@mail.com</td>
            <td>10.03.2018</td>
            <td>3</td>
            <td>
                <button class="btn btn-outline-danger btn-sm">delete</button>
            </td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>MarkOtto</td>
            <td>Otto</td>
            <td>Mark</td>
            <td>motto@mail.com</td>
            <td>10.03.2018</td>
            <td>3</td>
            <td>
                <button class="btn btn-outline-danger btn-sm">delete</button>
            </td>
        </tr>
        <tr>
            <th scope="row">4</th>
            <td>MarkOtto</td>
            <td>Otto</td>
            <td>Mark</td>
            <td>motto@mail.com</td>
            <td>10.03.2018</td>
            <td>3</td>
            <td>
                <button class="btn btn-outline-danger btn-sm">delete</button>
            </td>
        </tr>
        <tr>
            <th scope="row">5</th>
            <td>MarkOtto</td>
            <td>Otto</td>
            <td>Mark</td>
            <td>motto@mail.com</td>
            <td>10.03.2018</td>
            <td>3</td>
            <td>
                <button class="btn btn-outline-danger btn-sm">delete</button>
            </td>
        </tr>
        <tr>
            <th scope="row">6</th>
            <td>MarkOtto</td>
            <td>Otto</td>
            <td>Mark</td>
            <td>motto@mail.com</td>
            <td>10.03.2018</td>
            <td>3</td>
            <td>
                <button class="btn btn-outline-danger btn-sm">delete</button>
            </td>
        </tr>
        <tr>
            <th scope="row">7</th>
            <td>MarkOtto</td>
            <td>Otto</td>
            <td>Mark</td>
            <td>motto@mail.com</td>
            <td>10.03.2018</td>
            <td>3</td>
            <td>
                <button class="btn btn-outline-danger btn-sm">delete</button>
            </td>
        </tr>
        <tr>
            <th scope="row">8</th>
            <td>MarkOtto</td>
            <td>Otto</td>
            <td>Mark</td>
            <td>motto@mail.com</td>
            <td>10.03.2018</td>
            <td>3</td>
            <td>
                <button class="btn btn-outline-danger btn-sm">delete</button>
            </td>
        </tr>
        </tbody>
    </table>
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