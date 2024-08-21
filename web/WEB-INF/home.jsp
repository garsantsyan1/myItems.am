<%@ page import="model.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Martin
  Date: 24.02.2022
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="<%@include file="/css/style.css" %>/web/css/style.css">
</head>
<body>
<div class="login">
    <a href="/login">Вход</a>
    <a href="/register">Регистрация</a>
</div>
<div class="menu">
    <ul>
        <li>Главная</li>
        <li>Автомобили</li>
        <li>Дома</li>
        <li>Комерция</li>
        <li>Мебель</li>
    </ul>
</div>

<% List<Item> items = (List<Item>) request.getAttribute("items"); %>

<% for(Item item : items) {%>
    <div>
        <h1><%=item.getTitle()%></h1>
        <div>
            <img src="/image?path=<%=item.getPicUrl()%>" width="200" />
        </div>
        <p><%=item.getPrice()%></p>
    </div>
<%} %>

</body>
</html>
