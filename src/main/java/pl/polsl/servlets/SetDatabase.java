/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pl.polsl.servlets;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import pl.polsl.model.Database;
import pl.polsl.model.MyException;
import pl.polsl.model.Tank;

/**
 *Servlet setting database
 * @author Kamil Szota
 * @version 4.0
 */
@WebServlet("/SetDatabase")
public class SetDatabase extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        response.setContentType("text/html; charset=ISO-8859-2");
        HttpSession session = request.getSession(true);
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        Database database = (Database) session.getAttribute("database");
        String db=database.getDatabaseFile(); 
        Double q1,q2;
        q1=Double.valueOf(firstName);
        q2=Double.valueOf(lastName); 
        Double p=1013.25;
            while(p<30000 && p>=0.0)
            {
                if(q1>q2){
                    p=p+((q1-q2)/0.0024);
                }
                else
                    p=p-((q2-q1)/0.0024); 
                       
            try {
                database.addData(new Tank(firstName, lastName,p));
            } catch (MyException ex) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
            }
                    database.saveData(new File(db));    
            }
        Cookie lastModifiedCookie = new Cookie("lastModified", new java.util.Date().toString());
        response.addCookie(lastModifiedCookie);
        response.sendRedirect("/PressureWebApp");
    }

}
