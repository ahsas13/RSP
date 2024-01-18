package com.example.lab7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/RemoveBookServlet")
public class RemoveBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String, Integer> booksBasket = (Map<String, Integer>) session.getAttribute("booksBasket");

        if (booksBasket != null) {
            String bookIdToRemove = request.getParameter("deleteBookId");
            booksBasket.remove(bookIdToRemove);
        }

        // После удаления перенаправляем пользователя обратно на страницу корзины
        response.sendRedirect(request.getContextPath() + "/basket.jsp");
    }
}
