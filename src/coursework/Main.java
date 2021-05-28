/*
Coursework for: 5020B Programming for non-Specialists

Test Harness

Student ID  : -
Date        : 15/03/2020


 */

package coursework;
//DO NOT TOUCH THESE They are required for the logging commands to work
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        //DO NOT REMOVE OR MOVE THESE LINES
        PrintWriter log = null;
        try {
            log = new PrintWriter("LogFile.txt", "UTF-8");
            log.println("Coursework log printout to file");

            //==================================================================
            // ALL YOUR TEST CODE MUST GO BELOW HERE
            //==================================================================

            // Task 2 ==========================================================
            BasicComputer comp1 = new BasicComputer("Dell","Inspiron",4.2,8,1024,200);
            BasicComputer comp2 = new BasicComputer("Dell","Inspiron",4.2,8,1024,200);

            System.out.println(comp1 == comp2);
            log.println(comp1 == comp2);

            System.out.println(comp1.equals(comp2));
            log.println(comp1.equals(comp2));


            // Task 4 ==========================================================
            CPU[] cpuArray = new CPU[] {
                    new CPU("Intel","Core i5",3.2),
                    new CPU("Intel","Core i7",3.4),
                    new CPU("Intel","Core i9",3.6),
                    new CPU("AMD","Ryzen 5",3.6),
                    new CPU("AMD","Ryzen 7",3.9)
            };

            RAM[] ramArray = new RAM[] {
                    new RAM("Corsair","Vengeance",16),
                    new RAM("Corsair","Vengeance",32),
                    new RAM("Corsair","Value Select",8),
                    new RAM("Crucial","CT2K",16),
                    new RAM("Samsung","PC4",32)
            };

            HDD[] hddArray = new HDD[] {
                    new HDD("WD","Blue",1024),
                    new HDD("WD","Green",512),
                    new HDD("Seagate","BarraCuda",2048),
                    new HDD("Toshiba","P300",3072),
                    new HDD("WD","Black",4096)
            };

            /* Note that while formatting with tabs, behaviour was different
               between IntelliJ's console and the log file so I opted to format
               for the log file.
             */

            Component[][] polyArray = new Component[][] {cpuArray, ramArray, hddArray};

            for (Component[] eachArray: polyArray) {
                for (Component eachEl: eachArray) {
                    System.out.println(eachEl);
                    log.println(eachEl);
                }
            }


            // Task 6 ==========================================================
            AdvancedComputer advComp1 = new AdvancedComputer(
                    "Dell",
                    "Inspiron",
                    cpuArray[0],
                    ramArray[0],
                    hddArray[0]
            );

            AdvancedComputer advComp2 = new AdvancedComputer(
                    "HP",
                    "Envy",
                    cpuArray[1],
                    ramArray[1],
                    hddArray[1]
            );

            System.out.println(advComp1);
            log.println(advComp1);

            System.out.println(advComp2);
            log.println(advComp2);


            // Task 9 ==========================================================
            ArrayList<Software> softList = new ArrayList<Software>();
            softList.add(new Software("IntelliJ IDEA",1,2,3.5,0,0));
            softList.add(new Software("Google Chrome",1.3,16,0.1));
            softList.add(new Software("Audacity",0.45,0.5,0.02,0,0));
            softList.add(new Software("Celeste",2.5,2,1.2,350,1));
            softList.add(new Software("Crysis 3",2.6,2,20,2000,1));


            // Task 12 =========================================================
            // advComp1 variable re-used from Task 6
            advComp1.setRAM(ramArray[2]);
            System.out.println(advComp1);
            log.println(advComp1);

            GamingComputer gameComp = new GamingComputer(
                    cpuArray[2],
                    ramArray[1],
                    hddArray[4],
                    new GPU("nVidia","TITAN RTX",1350,24)
            );

            System.out.println(gameComp);
            log.println(gameComp);

            AdvancedComputer[] compArray = {advComp1, gameComp};

            for (AdvancedComputer eachComp: compArray) {
                for (Software eachSoft: softList) {
                    if (!eachComp.canRun(eachSoft)) { // If the computer can *not* run the software
                        if (eachComp.getMake() == "N/A" && eachComp.getModel() == "N/A") {
                            System.out.println("Custom-built computer can not run " + eachSoft.getName());
                            log.println("Custom-built computer can not run " + eachSoft.getName());
                        } else {
                            System.out.println(eachComp.getMake() + " " + eachComp.getModel() + " can not run " + eachSoft.getName());
                            log.println(eachComp.getMake() + " " + eachComp.getModel() + " can not run " + eachSoft.getName());
                        }
                    }
                }
            }


            //==================================================================
            // ALL YOUR CODE MUST GO ABOVE HERE
            //==================================================================

            //DO NOT REMOVE ANY OF THIS
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            log.close();
        }
    }
}
