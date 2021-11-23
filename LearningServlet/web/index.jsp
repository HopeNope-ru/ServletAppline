<%@page import = "logic.Model" %>
<%--
  Created by IntelliJ IDEA.
  User: Hopenope
  Date: 19.11.2021
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <h1>Домашняя страница по работе с пользователями</h1>
    Введите ID пользователя (0 - для вывода списка всех пользовтелей)
    <br/>
    Доступно:
    <%
      Model model = Model.getInstance();
      out.print(model.getUserFromList().size());
    %>
    <form method="get" action="get">
      <label>ID:
        <input type="text" name="ID"><br/>
      </label>
      <button type="submit">Поиск</button>
    </form>

    <a href="addUser.html">Создать нового пользователя</a>
  </body>
</html>
