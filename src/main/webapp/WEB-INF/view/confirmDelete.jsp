<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Confirm</title>
    <link rel="stylesheet" href="/WEB-INF/view/css/index.css">
</head>
<body>
<header>
    <%@include file="js/header.jsp" %>
</header>
            <h3 id="cd">Confirm Delete</h3>
            <p>
                <a href="delete/${id}">YES</a><br>
                <a href="/">NO</a>
            </p>
</body>
</html>
