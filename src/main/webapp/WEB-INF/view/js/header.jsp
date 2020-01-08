<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<nav class="navbar  navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                    <span class="heading">
<%--                        Blog--%>
                     </span>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-main">
                    <span class="sr-only"> Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse-main">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/">Home</a></li>
                    <li><a href="../addPost">Add Post</a></li>
                    <% Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                        if(authentication!= null && !("anonymousUser").equals(authentication.getName())) {  %>
                    <li><a id="logout" href="/logout">Logout</a></li>
                    <%  }
                    else {  %>
                    <li><a id="login" href="/login">Login</a></li>
                    <li><a href="/register">Sign Up</a></li>
                    <%  }   %>
                    <li><a href="/category">New Category</a></li>
                </ul>
            </div>
        </div>
    </nav>