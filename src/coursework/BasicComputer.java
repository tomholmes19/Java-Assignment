/*
Coursework for: 5020B Programming for non-Specialists

BasicComputer class

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public class BasicComputer {

    // Fields ==================================================================
    /**
     * @param make Manufacturer of the computer
     * @param model Specific model of the computer
     * @param clockRate CPU clock rate (GHz)
     * @param memory RAM capacity (GB)
     * @param storage HDD/SSD storage space (GB)
     * @param power Power usage (W)
     */
    private final String make; //  Pre-set to N/A for custom-built computers
    private final String model;
    private double clockRate;
    private double memory;
    private int storage;
    private int power;
    /* Would be nice to have power as a function of components
       but that would increase complexity
     */


    // Getters =================================================================
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public double getClockRate() {
        return clockRate;
    }
    public double getMemory() {
        return memory;
    }
    public int getStorage() {
        return storage;
    }
    public int getPower() {
        return power;
    }


    // Setters =================================================================
    /* Make and model will not change, but other fields could change if
       components are changed
     */
    public void setClockRate(double clockRate) {
        CompUtils.checkLessThanEqZero(clockRate);
        this.clockRate = clockRate;
    }
    public void setMemory(double memory) {
        CompUtils.checkLessThanEqZero(memory);
        this.memory = memory;
    }
    public void setStorage(int storage) {
        CompUtils.checkLessThanEqZero(storage);
        this.storage = storage;
    }
    public void setPower(int power) {
        CompUtils.checkLessThanEqZero(power);
        this.power = power;
    }


    // Constructors ============================================================
    public BasicComputer(String make, String model, double clockRate, double memory, int storage, int power) {
        this.make = make;
        this.model = model;
        this.setClockRate(clockRate);
        this.setMemory(memory);
        this.setMemory(storage);
        this.setPower(power);
    }

    // Overloaded for custom-built computers (no make/model)
    public BasicComputer(double clockRate, double memory, int storage, int power) {
        this.make = "N/A";
        this.model = "N/A";
        this.setClockRate(clockRate);
        this.setMemory(memory);
        this.setMemory(storage);
        this.setPower(power);
    }


    // Methods =================================================================
    /**
     * Checks whether an object has the same field values as this instance of
     * BasicComputer
     * @param obj BasicComputer to be compared to
     * @return True if all fields are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BasicComputer that = (BasicComputer) obj;
        return Double.compare(that.clockRate, clockRate) == 0 &&
               Double.compare(that.memory, memory) == 0 &&
               storage == that.storage &&
               power == that.power &&
               make.equals(that.make) &&
               model.equals(that.model);
    }

    public String toString() {
        return "Make:\t\t\t" + make + "\n" +
               "Model:\t\t\t" + model + "\n" +
               "Clock Rate:\t\t" + clockRate + "GHz\n" +
               "Memory:\t\t\t" + memory + "GB\n" +
               "Storage:\t\t" + storage + "GB\n" +
               "Power Usage:\t" + power + "W\n" +
               "---------------------------";
    }
}
