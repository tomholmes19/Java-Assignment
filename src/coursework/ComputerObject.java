/*
Coursework for: 5020B Programming for non-Specialists

ComputerObject class for objects relating to computers

This wasn't asked for but it made sense to refactor the classes this way to
avoid a lot of repetition

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

import static coursework.CompUtils.createLine;

public abstract class ComputerObject {
    // Fields ==================================================================
    /**
     * @param make Manufacturer of the object
     * @param model Particular model of the object
     */
    private final String make;
    private final String model;


    // Getters =================================================================
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }

    // Setters =================================================================
    // No setters since neither make nor model will change for a given object


    // Constructors ============================================================
    public ComputerObject(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // Overloaded for no make or model (makes sense for custom-built computers)
    public ComputerObject() {
        this.make = "N/A";
        this.model = "N/A";
    }


    // Methods =================================================================

    
    /**
     * Modified .toString() method for better formatting in subclasses
     * @return Sensible output of fields with name of class (if requested)
     * @param displayClassName True if we want to display class name in .toString(),
     *                         False if we do not
     * @param numTabs Number of tabs for formatting in display
     */
    public String toString(boolean displayClassName, int numTabs) {
        String type;
        if (displayClassName) {
            type = this.getClass().getSimpleName();
            type += " ";
        } else {
            type = "";
        }

        return type + "Make:" + "\t".repeat(numTabs) + make + "\n" +
               type + "Model:" + "\t".repeat(numTabs) + model + "\n";
    }

    /* So that we still override .toString() method in Object,
       though I don't think this would ever be used
     */
    public String toString() {
        return "Make:\t\t\t" + make + "\n" +
               "Model:\t\t\t" + model + "\n" +
               createLine();
    }
}
