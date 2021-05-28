/*
Coursework for: 5020B Programming for non-Specialists

RAM class

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public class RAM extends Component {

    // Fields ==================================================================
    /**
     * @param memory Memory capacity (GB)
     */
    private final double memory; // Could have 0.5GB for example


    // Getters =================================================================
    public double getMemory() {
        return memory;
    }


    // Setters =================================================================
    /* No setters since memory will not change for a given unit of RAM (RAM does
       have a clock speed which can be overclocked but not included in this project)
     */


    // Constructors ============================================================
    public RAM(String make, String model, double memory) {
        super(make, model);

        CompUtils.checkLessThanEqZero(memory);
        this.memory = memory;
    }


    // Methods =================================================================
    @Override
    public String toString() {
        return CompUtils.removeLine(super.toString()) +
               "Memory:\t\t\t" + memory + "GB\n" +
               CompUtils.createLine();
    }
}
