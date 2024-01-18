<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.example.lab08.Employee" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавление нового сотрудника</title>
</head>
<body>
<h2>Добавление нового сотрудника</h2>
<form action="addEmployee" method="post">
    Имя: <input type="text" name="firstName" required><br>
    Фамилия: <input type="text" name="lastName" required><br>
    Должность: <input type="text" name="designation" required><br>
    Телефон: <input type="text" name="phone" required><br>
    <input type="submit" value="Добавить сотрудника">
</form>
</body>
</html>
