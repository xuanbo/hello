<%--
  Created by IntelliJ IDEA.
  User: xuan
  Date: 16-1-2
  Time: 下午5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/assets/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="/assets/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/assets/custom/login/login.css">
    <script type="text/javascript" src="/assets/custom/login/login.js"></script>
    <title>用户登录</title>
</head>
<body>
    <div class="container">
        <p>LOGIN</p>

        <c:if test="${not empty msg}">
            <div class="alert alert-danger" role="alert">
                ${msg}
            </div>
        </c:if>

        <br>
        <div class="form-group">
            <div class="input-group">
                <label for="name" class="input-group-addon">
                    <span class="glyphicon glyphicon-user"></span>
                </label>
                <input id="name" type="text" class="form-control" name="name" placeholder="username:">
            </div>
            <br>
            <div class="input-group">
                <label for="password" class="input-group-addon">
                    <span class="glyphicon glyphicon-lock"></span>
                </label>
                <input id="password" type="password" class="form-control" name="password" placeholder="password:">
            </div>
        </div>
        <br>
        <div class="form-group">
            <button id="signIn" class="btn btn-default">
                Sign In
            </button>
        </div>
    </div>
</body>
</html>
