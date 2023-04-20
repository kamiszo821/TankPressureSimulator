/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.model.Database;
import pl.polsl.model.MyException;
import pl.polsl.model.Tank;

/**
 * Model test class.
 * @author Kamil Szota
 * @version 4.0
 */
public class ModelTest {    
    /**
     * Interface for managing Database
     */
    private Database database;
    @BeforeEach
    
    /**
     * Set up new Database object for testing
     */
    public void setUp()
    {
        database=new Database();
    }
    /**
     * Method to delete File if exist
     * @throws IOException
     */
    @AfterEach
    public void after() throws IOException {
        Files.deleteIfExists(new File("tmpFile.txt").toPath());
    }  

    /**
     * Test of setDatabase method of model class Database. Setting the filename
     * for database in model and checks if filename will be set correctly
     * @param filename Database's filename
     */
    
    @ParameterizedTest
    @ValueSource(strings = {"baza.txt","baza", "fileWithBadArguments.txt", "plik.png", "plik.txt"})
    public void testSaveData(String filename) throws IOException
    {
        File file = new File(filename);
        database.saveData(file);
        if (!file.exists()) {
            assertThrows(IOException.class, () -> database.saveData(file), "The exception hasn't been thrown, where it was expected");
        }
    }
    
    /**
     * Test of setDatabase method of model class Database. Setting the filename
     * for database in model and checks if filename will be set correctly.
     * @param filename Database's filename
     */
    @ParameterizedTest
    @ValueSource(strings = {"empty.txt"})
    public void saveData_shouldSaveEmptyFileForEmptyDataArray(String filename) throws IOException {
        //given
        Database database1 = new Database();
        File tmpFile = new File(filename);
        //when
        database1.saveData(tmpFile);
        //then
        assertEquals(2, tmpFile.length());
    }
     
    /**
     * Content to test's database.
     *  
     */
    private Database prepareDatabaseWithContent() throws MyException {
        Database database = new Database();
        database.addData(new Tank("input1", "output1", 0.2));
        return database;
    }
    
}
