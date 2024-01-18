package com.example.lab08;

import org.apache.derby.jdbc.ClientDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(urlPatterns = "/addEmployee", name = "AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получение параметров нового сотрудника
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String designation = request.getParameter("designation");
        String phone = request.getParameter("phone");

        // Добавление сотрудника в базу данных
        ClientDataSource ds = new ClientDataSource();
        ds.setDatabaseName("Lab08DB");
        ds.setCreateDatabase("create");
        ds.setUser("root");
        ds.setPassword("root");
        ds.setServerName("localhost");
        ds.setPortNumber(1527);

        try (Connection connection = ds.getConnection()) {
            String insertSQL = "INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, DESIGNATION, PHONE) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, designation);
                preparedStatement.setString(4, phone);

                preparedStatement.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        }

        // Перенаправление на главную страницу
        response.sendRedirect("index.jsp");
    }
}
