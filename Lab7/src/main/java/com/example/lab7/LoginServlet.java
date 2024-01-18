package com.example.lab7;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("user");
        String password = request.getParameter("password");

        if ("a".equals(username) && "b".equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);
            // Изменение: проверка на наличие атрибута корзины, если нет - создаем новую
            if (session.getAttribute("booksBasket") == null) {
                session.setAttribute("booksBasket", new HashMap<String, Integer>());
            }

            String deleteBookId = request.getParameter("deleteBookId");
            if (deleteBookId != null) {
                // Изменение: обработка удаления товара из корзины
                Map<String, Integer> booksBasket = (Map<String, Integer>) session.getAttribute("booksBasket");
                booksBasket.remove(deleteBookId);
            }

            // Перенаправляем запрос на страницу выбора товаров
            response.sendRedirect(request.getContextPath() + "/bookStore.jsp");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/bookStore.jsp");
            rd.forward(request, response);
        }
    }
}
