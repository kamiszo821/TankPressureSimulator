package pl.polsl.model;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the application's Model class which stores ArrayList with Tank objects.
 * @version 4.0
 * @author Kamil Szota
 */
public class Database {

 /**
 * This is ArrayList with Tank objects.
 * It contains all data
 */ 
    private ArrayList<Tank> dataArrayList;
    
    
 /**
 * Database file name.
 * It contains name of database file
 */   
    
    private String databaseFile= "C:\\Users\\kamil\\OneDrive\\Pulpit\\PressureWebApp\\src\\main\\webapp\\database\\database.txt";
    
 /**
 * This is Database constructor.
 * It makes dataArrayList
 */   
    public Database() {
        dataArrayList = new ArrayList<>();    
    }
    
 /**
 * This is Database constructor.
 * @return array list with data
 */     
    public ArrayList<Tank> getDataArrayList()
    {
        return dataArrayList;
    }
    
    
 /**
 * This is getter to database file name.
 * @return data array list name
 */    
    public String getDatabaseFile()
    {
        return databaseFile;
    }
    
   
 /**
 * This is method which allows add Data to ArrayList.
 * It makes dataArrayList
 * @param tank object with data: input,output, and mesured pressure
 * @throws MyException 
 */   
    
    public void addData(Tank tank) throws MyException {
        if(dataArrayList.size()>10000 || dataArrayList.stream().anyMatch(t->t.equals(t.getPressure()<0)))
            throw new MyException("Size of data is to big!");
        dataArrayList.add(tank);
    }

 /**
 * This is method which allows to save data
 * It also prevent memory leak
 * @param file File to save data
 * @throws java.io.IOException
 */    
    
    public void saveData(File file) throws IOException {
            String save_data = "";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                for(Tank var:dataArrayList)
                    save_data = var.getInput() + ", " + var.getOutput()+ ", " +var.getPressure();
            if(file.length()!=2)
            {
                bufferedWriter.write(save_data);
                bufferedWriter.newLine();
            }  
            bufferedWriter.close();
    } 
}
