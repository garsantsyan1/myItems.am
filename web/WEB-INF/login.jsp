<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 28.02.2022
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<%@include file="/css/login.css"%>/web/css/login.css">
</head>
<body>
<form action="/login" method="post">
    <div class="inputBox">
        <input type="email" name="email" value="">
        <label>Username</label>
    </div>
    <div class="inputBox">
        <input type="password" name="password" value="">
        <label>Password</label>
    </div>
    <input type="submit" name="sign-in" value="Sign In">
</form>
</body>
</html>
