/*
Coursework for: 5020B Programming for non-Specialists

Utility class containing methods for consistent line management in
.toString() methods and methods for input sanitization

Student ID  : -
Date        : 22/04/2020


 */

package coursework;

public final class CompUtils {
    // Fields ==================================================================
    // Utilities class so no fields


    // Constructors ============================================================
    //Private constructor so can not be instantiated outside class
    private CompUtils() {
    }


    // Methods =================================================================
    /**
     * Allows for consistent length separator line in .toString() methods between
     * all classes
     * @return Separator line
     */
    public static String createLine() {
        return "--------------------------------";
    }

    /**
     * Replaces separator line from output of .toString() methods with blank line
     * @param str .toString() method output of some object
     * @return .toString() method output of some object without separator line
     */
    public static String removeLine(String str) {
        String out;
        try {
            out = str.substring(0,str.lastIndexOf("\n"));
            out += "\n";
            /* Would never use this method without also needing a new line so this
               avoids repeating '+"\n"' everywhere
             */
        }
        catch (Exception e) {
            System.out.println("String passed to CompUtils.removeLine did not contain a line");
            // Logging is only set up within Main and I don't want to break anything
            out = str;
        }

        return out;
    }

    /**
     * Checks if an argument is null and throws exception if it is
     * @param obj Object to be checked if it is null
     */
    public static void checkNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null object passed to method");
            /* Could change this to print an error message
               and return false if desired
             */
        }
    }

    /**
     * Checks if an argument is less than or equal to zero
     * and throws exception if it is
     * @param num Proposed numerical field of some object
     */
    /* double num is suitable for now since we only use int and double
       for fields of components, but that could change and if it does then
       change the parameter data type

       Throwing an exception is suitable since it tells the developer that
       there was an error and stops the program, though if the scope of the
       project changed and required user input then modifying that input
       data or requiring a new input instead would be more suitable
     */
    public static void checkLessThanEqZero(double num) {
        if (Double.compare(num, 0) <= 0) {
            throw new IllegalArgumentException("Argument <= 0, check input");
        }
    }

    /**
     * Checks if a parameter is less than zero and throws exception if it is
     * @param num Proposed numerical field of some object
     */
    public static void checkLessThanZero(double num) {
        if (Double.compare(num, 0) < 0) {
            throw new IllegalArgumentException("Argument < 0, check input");
        }
    }
}
