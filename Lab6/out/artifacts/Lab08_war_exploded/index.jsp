<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList" %>
<%@page import="com.example.lab08.Employee" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Поиск и просмотр сотрудников</title>
</head>
<body>
<form action="employee">
    Фамилия сотрудника
    <input type="text" name="lastname">
    <input type="submit" value="поиск">
</form>

<a href="addEmployee.jsp">Добавить нового сотрудника</a>

<%
    // Получение значения параметра employeesFound
    ArrayList employees = (ArrayList) request.getAttribute("employeesFound");
    // Если параметр задан, начинаем обработку
    if (employees != null) {
        if (employees.isEmpty()) {
            out.print("Сотрудники не найдены");
        } else {
            out.print("<TABLE border=\"1\">");
            out.print("<TR><TD>Id</TD><TD>Имя</TD><TD>Фамилия</TD>" +
                    "<TD>Должность</TD><TD>Телефон</TD></TR>");
            for (int i = 0; i < employees.size(); i++) {
                Employee emp = (Employee) employees.get(i);
                out.print("<TR>");
                out.print("<TD>" + emp.getId() + "</TD>");
                out.print("<TD>" + emp.getFirstName() + "</TD>");
                out.print("<TD>" + emp.getLastName() + "</TD>");
                out.print("<TD>" + emp.getDesignation() + "</TD>");
                out.print("<TD>" + emp.getPhone() + "</TD>");
                out.print("</TR>");
            }
            out.print("</TABLE>");
        }
    }
%>
</body>
</html>
