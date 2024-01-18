package com.example.lab08;

import org.apache.derby.jdbc.ClientDataSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/employee", name = "EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Коллекция для хранения найденных сотрудников
        ArrayList<Employee> employees = new ArrayList<>();
        ClientDataSource ds = new ClientDataSource();
        ds.setDatabaseName("Lab08DB");
        ds.setCreateDatabase("create");
        ds.setUser("root");
        ds.setPassword("root");
        // The host on which Network Server is running
        ds.setServerName("localhost");
        // The port on which Network Server is listening
        ds.setPortNumber(1527);
        try {
            response.setContentType("text/html;charset=UTF-8");
            // Получение из http-запроса значения параметра lastname
            String lastName = request.getParameter("lastname");
            Connection connection = ds.getConnection();
            // Выполнение SQL-запроса
            String selectSQL = "SELECT ID, FIRST_NAME, LAST_NAME, DESIGNATION, PHONE " +
                    " FROM EMPLOYEE WHERE LAST_NAME LIKE '" + lastName + "'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectSQL);
            // Перечисление результатов запроса
            while (rs.next()) {
                // По каждой записи выборки формируется объект класса Employee.
                // Значения свойств заполняются из полей записи
                Employee emp = new Employee(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                // Добавление созданного объекта в коллекцию
                employees.add(emp);
            }
            // Закрываем выборку и соединение с БД
            rs.close();
            connection.close();

            // Помещение результатов в параметр запроса employeesFound
            request.setAttribute("employeesFound", employees);

            // Перенаправление http-запроса на страницу index.jsp
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        }
    }
}
