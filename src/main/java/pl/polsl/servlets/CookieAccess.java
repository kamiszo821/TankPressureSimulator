
package pl.polsl.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import pl.polsl.view.DataView;
/**
 * Main class of the servlet which represent last acces using cookies.
 * @author Kamil Szota
 * @version 4.0
 */
@WebServlet("/CookieAccess")
public class CookieAccess extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        DataView dataView = new DataView(out);    
        Cookie[] cookies = request.getCookies();
        String lastModified = "never";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lastModified")) {
                lastModified = cookie.getValue();
                break;
            }
        }            
        dataView.displayCookieAccess(lastModified);
    }
}