package pl.polsl.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import pl.polsl.model.Database;
import pl.polsl.view.DataView;

/**
 * Servlet which dislpay all database from database file.
 * @author Kamil Szota
 * @version 4.0
 */
@WebServlet("/Display")
public class DisplayDatabase extends HttpServlet {
    
   @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        Database database = (Database) session.getAttribute("database");
        DataView dataView = new DataView(out);
        
        dataView.displayData(database);
        }
}
        
        
 
