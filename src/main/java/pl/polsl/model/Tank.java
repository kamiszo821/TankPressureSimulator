package pl.polsl.model;
/** Class which defines application's tank object.
 * @version 4.0
 * @author Kamil Szota
 */
public class Tank {
    /**
     * Tank's input value
     */ 
    private String input;
    /**
     * Tank's output value
     */
    private String output;
    /**
     * Tank's pressure value
     */
    private Double pressure;
    /**
     * Tank's empty constructor.
     */
    public Tank() {
        
    }

    /**
     * Tank's constructor.
     * @param input input value
     * @param output output value
     * @param pressure pressure value
     */
    public Tank(String input, String output,Double pressure) {
        this.input = input;
        this.output = output;
        this.pressure=pressure;
    }
 
    /**
      * Input's value getter.
      * @return input value
    */
    public String getInput() {
        return input;
    }
    /**
      * Output's value getter.
      * @return output value
    */
    public String getOutput() {
        return output;
    }
    /**
      * Pressure's value getter.
      * @return pressure value
    */
    public Double getPressure()
    {
        return pressure;
    }         
}