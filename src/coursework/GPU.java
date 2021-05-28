/*
Coursework for: 5020B Programming for non-Specialists

GPU class

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public class GPU extends Component {
    // Fields ==================================================================
    /**
     * @param clockRate Speed of the GPU (MHz)
     * @param vram Video memory of the GPU (GB)
     */
    private int clockRate;
    private final double vram;


    // Getters =================================================================
    public int getClockRate() {
        return clockRate;
    }
    public double getVRAM() {
        return vram;
    }


    // Setters =================================================================
    // GPUs can be overclocked, but VRAM can not change
    public void setClockRate(int clockRate) {
        CompUtils.checkLessThanEqZero(clockRate);
        this.clockRate = clockRate;
    }


    // Constructors ============================================================
    public GPU(String make, String model, int clockRate, double vram) {
        super(make, model);
        this.setClockRate(clockRate);

        CompUtils.checkLessThanEqZero(vram);
        this.vram = vram;
    }


    // Methods =================================================================
    @Override
    public String toString() {
        return CompUtils.removeLine(super.toString()) +
               "GPU Clock Rate:\t\t" + clockRate + "MHz\n" +
               "Video Memory:\t\t" + vram + "GB\n" +
                CompUtils.createLine();
    }
}
