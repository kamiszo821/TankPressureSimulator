/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.model.Database;

/**
 * Servlet which allows init database
 * @author Kamil Szota
 * @version 4.0
 */
@WebServlet(name = "InitiateDatabase", urlPatterns = {"/InitiateDatabase"})
public class InitiateDatabase extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html; charset=ISO-8859-2");
        HttpSession session = request.getSession(true);
        Database database = new Database();        
        session.setAttribute("database", database);
        response.sendRedirect("/PressureWebApp");
    }
}
