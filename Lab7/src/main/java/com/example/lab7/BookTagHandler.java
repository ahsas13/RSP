package com.example.lab7;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;

public class BookTagHandler extends TagSupport {
    private String pageURL;
    private String bookId;
    private String name;
    private String author;
    private int price;
    private int quantity; // Новое поле для количества экземпляров

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();

            out.print("<form action=\"" + pageURL + "\" method=\"post\">");
            out.print("<tr>");
            out.print("<td>" + bookId + "</td>");
            out.print("<input type=\"hidden\" name=\"bookId\" value=\"" + bookId + "\">");
            out.print("<td>" + name + "</td>");
            out.print("<td>" + author + "</td>");
            out.print("<td>" + price + "</td>");
            out.print("<input type=\"hidden\" name=\"bookPrice\" value=\"" + price + "\">");

            // Добавляем поле для указания количества экземпляров книги
            out.print("<td><input type=\"number\" name=\"quantity\" value=\"" + quantity + "\" min=\"1\"></td>");

            out.print("<td><input type=\"submit\" value=\"Добавить в корзину\"></td>");
            out.print("</tr>");
            out.print("</form>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
