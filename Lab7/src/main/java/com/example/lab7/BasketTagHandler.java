package com.example.lab7;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.Map;
import java.util.Iterator;

public class BasketTagHandler extends TagSupport {
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            HttpSession session = pageContext.getSession();
            Map<String, Integer> booksBasket = (Map<String, Integer>) session.getAttribute("booksBasket");

            if (booksBasket == null || booksBasket.isEmpty()) {
                out.print("Ваша корзина пуста");
            } else {
                out.print("<table border='1'>");
                out.print("<tr><td>Название</td><td>Количество</td><td>Сумма</td><td>Удалить</td></tr>");

                Iterator<Map.Entry<String, Integer>> iterator = booksBasket.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator.next();
                    String bookId = entry.getKey();
                    int total = entry.getValue();
                    out.print("<tr>");
                    out.print("<td>" + bookId + "</td>");
                    out.print("<td>1</td>"); // Здесь нужно уточнить, откуда брать количество для отображения
                    out.print("<td>" + total + "</td>");
                    out.print("<td><form action=\"RemoveBookServlet\" method=\"post\">"); // Изменим action
                    out.print("<input type=\"hidden\" name=\"deleteBookId\" value=\"" + bookId + "\">");
                    out.print("<input type=\"submit\" value=\"Удалить\"></form></td>");
                    out.print("</tr>");
                }

                out.print("</table>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
