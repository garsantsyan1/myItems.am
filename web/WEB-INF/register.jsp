<%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 28.02.2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="../css/register.css" >
</head>
<body>
<form action="/register" method="post" style="border:1px solid #ccc">
    <div class="container">
        <h1>Welcome</h1>
        <hr>
        <input type="text" placeholder="Name" name="name">
        <input type="text" placeholder="Surname " name="surname">
        <input type="text" placeholder="Email" name="email">
        <input type="password" placeholder="Password" name="password">

        <div class="clearfix">
            <button type="submit" class="signupbtn">Sign in</button>
        </div>
    </div>
</form>
</body>
</html>
