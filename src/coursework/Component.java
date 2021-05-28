/*
Coursework for: 5020B Programming for non-Specialists

Component class

This wasn't asked for but it made sense to refactor the classes this way to
avoid a lot of repetition

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public abstract class Component extends ComputerObject {
    // Fields ==================================================================
    // No new fields


    // Constructors ============================================================
    public Component(String make, String model) {
        super(make, model);
    }


    // Methods =================================================================
    public String toString() {
        int numTabs = 2;
        return super.toString(true, numTabs);
    }

    /**
     * Allows for alternative number of tabs for when a new subclass is
     * introduced which requires less tabs e.g. motherboard
     * @param altNumTabs Number of tabs to format with
     * @return Usual .toString() method with a specified number of tabs
     */
    public String toString(int altNumTabs) {
        return super.toString(true, altNumTabs);
    }
}
