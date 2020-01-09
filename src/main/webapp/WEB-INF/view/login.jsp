
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<html>
<head>
    <title>Blog Home</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
        <%@include file="css/index.css"%>
    </style>
</head>
<body>
<a href="/">Home</a>
<form action="login" method="post">

    <div class="container">
        <h3>${errorMsg}</h3>
        <h3>${msg}</h3>
        <h1>LOGIN</h1>
        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" id="username" name="username" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" required>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Login</button><br>
        <a href="/register">new user?..goto sign up</a>
    </div>
</form>
<sec:csrfInput />
</body>
</html>
