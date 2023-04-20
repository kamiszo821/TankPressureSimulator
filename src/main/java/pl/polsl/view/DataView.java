package pl.polsl.view;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import pl.polsl.model.Database;
import pl.polsl.model.Tank;

/**
 *Data view class.
 * @author Kamil Szota
 * @version 4.0
 */
public class DataView {
    
    /**
    *PrintWriter object.
    */
    private PrintWriter writer;
    
    /**
    *Data View constructror
    * @param writer It allows to display data on page.
    */
    public DataView(PrintWriter writer) {
        this.writer = writer;
    }
    /**
    *Method which allows display actualy modified data on page.
    *@param database Database object
    */
    public void displayData(Database database) {
        
        writer.println("<html>\n<body>\n<h1>Pressure: </h1>\n");
        writer.println("<table border=1><tr>" + "<th>Input</th>" + "<th>Output</th>" + "<th>Pressure</th>" + "</tr>");
        writer.println("<tr>");

        for (Tank n : database.getDataArrayList()) {
            writer.println("<td>" + n.getInput() + "</td>");
            writer.println("<td>" + n.getOutput() + "</td>");
            writer.println("<td>" + n.getPressure() + "</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("</body>\n</html>");
    }
    
    
    /**
    *Method which allows display Data on page.
    *@param lastModified it contins data when database was modified last time.
    */
    public void displayCookieAccess(String lastModified)
    {
        writer.println("<html>\n<body>\n<h1>Last modified was: " + lastModified + "</h1> \n");
    }
    
    
    /**
    *Method which allows display Data from database.
    * @param file name of database file
    * @throws java.io.FileNotFoundException
    */
    public void displayDatabase(String file) throws FileNotFoundException, IOException
    {
        writer.println("<html>\n<body>\n<h1>Pressure: </h1>\n");
        writer.println("<table border=1><tr>" + "<th>Input</th>" + "<th>Output</th>" + "<th>Pressure</th>" + "</tr>");
        writer.println("<tr>");
        BufferedReader br= new BufferedReader(new FileReader(file));
        String[] parts;
        String st,in,out,p;
        while ((st = br.readLine()) != null)
        {
            st=st.replaceAll("\\s", "");
            parts=st.split(",");
            in=parts[0];
            writer.println("<td>" + in+ "</td>");
            out=parts[1];
            writer.println("<td>" + out + "</td>");
            p=parts[2];
            writer.println("<td>" + p + "</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("</body>\n</html>");
    }     
        
} 
    
