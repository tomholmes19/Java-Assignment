/*
Coursework for: 5020B Programming for non-Specialists

HDD class

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public class HDD extends Component {
    // Fields ==================================================================
    /**
     * @param capacity Storage capacity of the HDD (GB)
     */
    private final int capacity;


    // Getters =================================================================
    public int getCapacity() {
        return capacity;
    }

    // Setters =================================================================
    // No setters since capacity can not change for a given HDD


    // Constructors ============================================================
    public HDD(String make, String model, int capacity) {
        super(make, model);

        CompUtils.checkLessThanEqZero(capacity);
        this.capacity = capacity;
    }


    // Methods =================================================================
    @Override
    public String toString() {
        return CompUtils.removeLine(super.toString()) +
               "Capacity:\t\t" + capacity + "GB\n" +
               CompUtils.createLine();
    }
}
