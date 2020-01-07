<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<style>
    <%@include file="css/index.css"%>
</style>
<body>
<form action="newCat" style="border:1px solid #ccc" method="post" modelAttribute="user">
    <div class="container">
        <h2>${exist}</h2>
        <h1>New Category</h1>
        <hr>
        <label for="catname"><b>Category name</b></label>
        <input type="text" placeholder="Enter Category" id="catname" name="catname" required>
        <div class="clearfix">
            <button type="submit" class="signupbtn">Add</button>
        </div>
    </div>
</form>
<sec:csrfInput />
</body>
</html>
