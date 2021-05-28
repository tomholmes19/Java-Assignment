/*
Coursework for: 5020B Programming for non-Specialists

GamingComputer Class

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public class GamingComputer extends AdvancedComputer {
    // Fields ==================================================================
    /**
     * @param gpu GPU of the gaming computer
     */
    private GPU gpu;


    // Getters =================================================================
    public GPU getGPU() {
        return gpu;
    }


    // Setters =================================================================
    // GPU field could change if the component is changed
    public void setGPU(GPU gpu) {
        this.gpu = gpu;
    }


    // Constructors ============================================================
    public GamingComputer(String make, String model, CPU cpu, RAM ram, HDD hdd, GPU gpu) {
        super(make, model, cpu, ram, hdd);
        this.setGPU(gpu);
    }

    // Overloaded for custom-built computers (no make/model)
    public GamingComputer(CPU cpu, RAM ram, HDD hdd, GPU gpu) {
        super(cpu, ram, hdd);
        this.setGPU(gpu);
    }


    // Methods =================================================================
    /**
     * Checks whether the GamingComputer can run a given piece of software
     * @param software The software we are checking system requirements for
     * @return True if all relevant component fields are greater than or equal
     * to the system requirements of the software
     */
    @Override
    public boolean canRun(Software software) {
        CompUtils.checkNull(software);
        return Double.compare(gpu.getClockRate(), software.getReqGPUSpeed()) >= 0 &&
               Double.compare(gpu.getVRAM(), software.getReqVRAM()) >= 0 &&
               Double.compare(getCPU().getClockRate(), software.getReqCPUSpeed()) >= 0 &&
               Double.compare(getRAM().getMemory(), software.getReqMemory()) >= 0 &&
               Double.compare(getHDD().getCapacity(), software.getReqSpace()) >= 0;
    }

    @Override
    public String toString() {
        return CompUtils.removeLine(super.toString()) +
               CompUtils.removeLine(gpu.toString()) +
               CompUtils.createLine();
    }
}
