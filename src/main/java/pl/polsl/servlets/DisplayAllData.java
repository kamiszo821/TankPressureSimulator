/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.model.Database;
import pl.polsl.view.DataView;

/**
 * Servlet which display all data
 *Servlet which is used 
 * @author Kamil Szota
 * @version 4.0
 */
@WebServlet(name = "DisplayAllData", urlPatterns = {"/DisplayAllData"})
public class DisplayAllData extends HttpServlet {
    
   @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        Database database = (Database) session.getAttribute("database");
        DataView dataView = new DataView(out);
        dataView.displayDatabase(database.getDatabaseFile());
        }
}

