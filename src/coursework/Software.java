/*
Coursework for: 5020B Programming for non-Specialists

Software Class

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public class Software {
    // Fields ==================================================================
    /**
     * @param name Name of the software
     * @param reqCPUSpeed CPU clock rate required (GHz)
     * @param reqMemory RAM capacity required (GB)
     * @param reqSpace Free HDD space required (GB)
     * @param reqGPUSpeed GPU clock rate required (MHz)
     * @param reqVRAM Video memory capacity required (GB)
     */
    private final String name;
    // All doubles since system requirements tend to be more precise values
    private double reqCPUSpeed;
    private double reqMemory;
    private double reqSpace;
    private double reqGPUSpeed = 0; // Defaulted to 0 for no GPU sys. reqs.
    private double reqVRAM = 0;


    // Getters =================================================================

    public String getName() {
        return name;
    }
    public double getReqCPUSpeed() {
        return reqCPUSpeed;
    }
    public double getReqMemory() {
        return reqMemory;
    }
    public double getReqSpace() {
        return reqSpace;
    }
    public double getReqGPUSpeed() {
        return reqGPUSpeed;
    }
    public double getReqVRAM() {
        return reqVRAM;
    }


    // Setters =================================================================
    /* No setters since for a published item of software, name will not change
       and any change in system requirements should be reflected by a change in
       version number in the name of a new instance of Software
     */


    // Constructors ============================================================
    // Overloaded for no GPU system requirements
    public Software(String name, double reqCPUSpeed, double reqMemory, double reqSpace) {
        this.name = name;

        CompUtils.checkLessThanEqZero(reqCPUSpeed);
        this.reqCPUSpeed = reqCPUSpeed;

        CompUtils.checkLessThanEqZero(reqMemory);
        this.reqMemory = reqMemory;

        CompUtils.checkLessThanEqZero(reqSpace);
        this.reqSpace = reqSpace;
    }

    public Software(String name, double reqCPUSpeed, double reqMemory, double reqSpace, double reqGPUSpeed, double reqVRAM) {
        this(name, reqCPUSpeed, reqMemory, reqSpace);

        CompUtils.checkLessThanZero(reqGPUSpeed);
        this.reqGPUSpeed = reqGPUSpeed;

        CompUtils.checkLessThanZero(reqVRAM);
        this.reqVRAM = reqVRAM;
    }


    // Methods =================================================================
    public String toString() {

        // If there are no GPU requirements then those lines do not get printed
        String temp = "";
        if (reqGPUSpeed > 0 && reqVRAM > 0) {
            temp =  "GPU Clock Rate:\t" + reqGPUSpeed + "MHz\n" +
                    "Video Memory:\t" + reqVRAM + "GB\n";
        }

        return "-- " + name + " System Requirements --\n" +
               "CPU Clock Rate:\t" + reqCPUSpeed + "GHz\n" +
               "Memory:\t\t\t" + reqMemory + "GB\n" +
               "Free HDD Space:\t" + reqSpace + "GB\n" +
               temp +
               CompUtils.createLine();
    }
}
