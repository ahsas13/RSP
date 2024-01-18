<%@page errorPage="errorPage.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ taglib uri="/WEB-INF/BookTagLib.tld" prefix="x" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
  if (session.getAttribute("user") == null) {
    throw new Exception("Ошибка аутентификации: неверное имя пользователя/пароль");
  }
%>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Книжный магазин</title>
</head>
<body>
<p><b>
  <%
    HashMap<String, Integer> booksBasket = (HashMap<String, Integer>) session.getAttribute("booksBasket");
    String bookId = request.getParameter("bookId");
    String bookPriceStr = request.getParameter("bookPrice");
    Integer bookPrice = bookPriceStr == null ? null : Integer.parseInt(bookPriceStr);
    int quantity = request.getParameter("quantity") == null ? 1 : Integer.parseInt(request.getParameter("quantity"));

    if (bookId != null && bookPrice != null) {
      booksBasket.put(bookId, bookPrice * quantity);
    }
    if (booksBasket.size() == 0) {
      out.print("Ваша корзина пуста");
    } else {
      int sum = 0;
      out.print("Количество товаров в корзине: " + booksBasket.size() + "<br>");
      out.print("На сумму: ");
      Iterator<Integer> iterator = booksBasket.values().iterator();
      while (iterator.hasNext()) {
        sum += iterator.next();
      }
      out.print(sum);
    }
  %>
</b></p>
<form action="<%= request.getRequestURI() %>" method="post">
  <table border=1>
    <tr>
      <td>Код товара</td>
      <td>Название</td>
      <td>Автор</td>
      <td>Цена</td>
      <td>Количество</td>
      <td>Добавить в корзину</td>
    </tr>
    <x:bookTagHandler pageURL="bookStore.jsp" bookId="001" name="Thinking in Java" author="Bruce Eckel" price="400" quantity="1"/>
    <x:bookTagHandler pageURL="bookStore.jsp" bookId="002" name="Bitter Java" author="Bruce Tate" price="300" quantity="1"/>
    <x:bookTagHandler pageURL="bookStore.jsp" bookId="003" name="Object-Oriented Design Patterns" author="Erich Gamma et al." price="500" quantity="1"/>
  </table>
</form>

<h2>Корзина</h2>
<!-- Добавляем кнопку для перехода на страницу корзины -->
<form action="basket.jsp" method="get">
  <input type="submit" value="Перейти в корзину">
</form>

</body>
</html>
