package pl.polsl.model;

/** Class which defines application's specific exception.
 * @version 4.0
 * @author Kamil Szota
 */
public class MyException extends Exception {
    /**
     * This is MyException class constructor. Used to throw the exception
     * with an appriopriate message.
     * @param errorMessage String type message describing the problem occurred.
     */
    public MyException(String errorMessage)
    {
        super(errorMessage);
    }
}
