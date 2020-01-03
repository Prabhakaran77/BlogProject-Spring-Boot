<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<style>
    <%@include file="css/index.css"%>
</style>
<body>
<form action="newUser" style="border:1px solid #ccc" method="post" modelAttribute="user">
    <div class="container">
        <h2>${exist}</h2>
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Email" id="username" name="username" required>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" id="email" name="email" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" required>

        <div class="clearfix">
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
    </div>
</form>
<sec:csrfInput />
</body>
</html>
