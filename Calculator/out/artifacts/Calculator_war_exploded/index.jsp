<%--
  Created by IntelliJ IDEA.
  User: Hopenope
  Date: 20.11.2021
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h3>Калькулятор</h3>
    <form method="post" action="add">
      <label>Переменная 1:
        <input type="text" name="x">
      </label>
      <label>Переменна 2:
        <input type="text" name="y">
      </label>
      <label>Операция:
        <input type="text" name="operation">
      </label>
      <button type="submit">Добавить</button>
    </form>
  </body>
</html>
