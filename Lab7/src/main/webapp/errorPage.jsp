<%--
  Created by IntelliJ IDEA.
  User: Даниил
  Date: 14.12.2023
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ошибка</title>
</head>
<body>
<h2>
    <%-- exception содержит ссылку на возникшее исключение --%>
    <%-- Выводим тип исключительной ситуации --%>
    <%= exception.getClass().getName() %>
    :
    <%-- Выводим текст сообщения исключительной ситуации --%>
    <%= exception.getMessage() %>
</h2>
<% exception.printStackTrace(); %>
</body>
</html>