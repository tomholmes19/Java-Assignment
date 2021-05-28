/*
Coursework for: 5020B Programming for non-Specialists

AdvancedComputer class

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public class AdvancedComputer extends ComputerObject {
    // Fields ==================================================================
    /**
     * @param cpu CPU of the computer
     * @param ram RAM of the computer
     * @param hdd HDD of the computer
     * @param numTabs Number of tabs for formatting in superclass
     */
    private CPU cpu;
    private RAM ram;
    private HDD hdd;


    // Getters =================================================================
    public CPU getCPU() {
        return cpu;
    }
    public RAM getRAM() {
        return ram;
    }
    public HDD getHDD() {
        return hdd;
    }


    // Setters =================================================================
    // Components could be changed
    public void setCPU(CPU cpu) {
        this.cpu = cpu;
    }
    public void setRAM(RAM ram) {
        this.ram = ram;
    }
    public void setHDD(HDD hdd) {
        this.hdd = hdd;
    }


    // Constructors ============================================================
    public AdvancedComputer(String make, String model, CPU cpu, RAM ram, HDD hdd) {
        super(make, model);
        this.setCPU(cpu);
        this.setRAM(ram);
        this.setHDD(hdd);
    }

    // Overloaded for custom-built computers (no make/model)
    // super() is implicitly called by Java if not implicitly called
    public AdvancedComputer(CPU cpu, RAM ram, HDD hdd) {
        this.setCPU(cpu);
        this.setRAM(ram);
        this.setHDD(hdd);
    }


    // Methods =================================================================
    /**
     * Checks whether the AdvancedComputer can run a given piece of software
     * @param software The software we are checking system requirements for
     * @return True if no GPU requirements and all relevant component fields
     * are greater than or equal to the system requirements of the software
     */
    public boolean canRun(Software software) {
        CompUtils.checkNull(software);
        return software.getReqGPUSpeed() == 0 &&
               software.getReqVRAM()     == 0 &&
               Double.compare(cpu.getClockRate(), software.getReqCPUSpeed()) >= 0 &&
               Double.compare(ram.getMemory(), software.getReqMemory()) >= 0 &&
               Double.compare(hdd.getCapacity(), software.getReqSpace()) >= 0;
    }

    /**
     * Formats .toString() of each component
     * @return .toString() output of each component concatenated with separator
     *         lines removed
     */
    private String formatComponents() {
        String out = "";

        Object[] tempArray = new Object[] {cpu, ram, hdd};
        for (Object eachEl: tempArray) {
            out += eachEl.toString();
            out = CompUtils.removeLine(out);
        }

        return out;
    }

    // Will never want class name in front of Make and Model for computers
    @Override
    public String toString() {
        int numTabs = 3;
        return super.toString(false, numTabs) +
               this.formatComponents() +
               CompUtils.createLine();
    }
}
