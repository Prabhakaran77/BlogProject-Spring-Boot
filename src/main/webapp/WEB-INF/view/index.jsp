
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<header>
    <%@include file="js/header.jsp" %>
</header>

<div class="topbox">
    <div class="row" id="top-box">
    <form id="post-filteration" action="/post">
        <div class="col-sm-3 col-lg-3">
        <div class="search">
            <div class="form-group">
                <label for="name"><h3>Search</h3></label>
                <input type="text" name="name" class="form-control" id="name" placeholder="Search by keywords"/>
            </div>
        </div>
        </div>
        <div class="sort">
            <div class="col-sm-3 col-lg-3">
            <div class="form-group">
                <label for="sort-by"><h3>Sort</h3></label>
                <select name="sort-by" class="form-control" id="sort-by">
                    <option value="empty" selected>--Select--</option>
                    <option value="crAsc">CreatedAt Asc</option>
                    <option value="crDesc">CreatedAt Desc</option>
                    <option value="upAsc">UpdatedAt Asc</option>
                    <option value="upDesc">UpdatedAt Desc</option>
                </select>
            </div>
        </div>
        </div>
            <div class="col-sm-3 col-lg-3">
        <div class="Filter">
            <div class="form-group">
                <label for="filter-by-auth"><h3>FilterBy Author</h3></label>
                <select name="filter-by-auth" class="form-control" id="filter-by-auth">
                    <option value="" selected>--Select--</option>
                        <c:forEach items="${al}" var="user">
                            <option value="${user.userId}">${user.name}</option>
                        </c:forEach>
                    </optgroup>
                </select>
            </div>
        </div>
            </div>
                <div class="col-sm-3 col-lg-3">
        <div class="Filter">
            <div class="form-group">
                <label for="filter-by-cat"><h3>FilterBy Category</h3></label>
                <select name="filter-by-cat" class="form-control" id="filter-by-cat">
                    <option value="" selected>--Select--</option>
                        <c:forEach items="${catList}" var="category">
                            <option value="${category.categoryId}">${category.name}</option>
                        </c:forEach>
                    </optgroup>
                </select>
            </div>
        </div>
<%--                <input type="hidden" name="pgNo" value="1">--%>
        <div class="submit-form">
            <button type="submit" class="btn btn-success">Apply</button>
        </div>
    </form>
</div>
</div>
</div>


<main class="main">
    <div class="container post-list">
        <br>
        <div class="container">
            <c:if test="${empty lists}">
                <p>No Post Found</p>
            </c:if>
            <c:forEach var="post" items="${lists}">
                <div class="row">
                    <h3>${post.title}</h3>
                    <p>
                            ${post.content}
                    </p>
                    <p>
                        <a href="read/${post.id}">
                            <b>Read More...</b>
                        </a>
                    </p>
                </div>
                <hr>
            </c:forEach>
        </div>
    </div>

    <div class="pages">
        <div class="row">
            <div class="page-button"></div>
        </div>
    </div>
    <c:forEach var="i" begin="1" end="${lastPageNo }" >

        <a href="../?pageNo=${i-1 }">${i }</a>&nbsp;&nbsp;&nbsp;&nbsp;	<!-- Displaying Page No -->
    </c:forEach>
    <c:forEach var="i" begin="1" end="${filterPageNo }" >

        <a href="../post?name=${presName}&pageNo=${i-1 }&sort-by=${presSortBy}&filter-by-auth=${presAuthId}&filter-by-cat=${presCatId}">${i }</a>&nbsp;&nbsp;&nbsp;&nbsp;	<!-- Displaying Page No -->
    </c:forEach>
</main>
</body>
</html>
<%--post?name=&pageNo=2&sort-by=&filter-by-auth=1&filter-by-cat=--%>