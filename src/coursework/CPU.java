/*
Coursework for: 5020B Programming for non-Specialists

CPU class

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public class CPU extends Component {
    // Fields ==================================================================
    /**
     * @param clockRate Speed of the CPU (GHz)
     */
    private double clockRate;


    // Getters =================================================================
    public double getClockRate() {
        return clockRate;
    }


    // Setters =================================================================
    // CPUs can be overclocked
    public void setClockRate(double clockRate) {
        CompUtils.checkLessThanEqZero(clockRate);
        this.clockRate = clockRate;
    }


    // Constructors ============================================================
    public CPU(String make, String model, double clockRate) {
        super(make, model);
        this.setClockRate(clockRate);
    }


    // Methods =================================================================
    @Override
    public String toString() {
        return CompUtils.removeLine(super.toString()) +
               "CPU Clock Rate:\t\t" + clockRate + "GHz\n" +
               CompUtils.createLine();
    }
}
