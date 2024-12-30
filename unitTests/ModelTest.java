
package unitTests;

import src.CalcModel;

public class ModelTest {

    // Textcolor Modifiers for Console Output
    // Example: System.out.println(RED + "This is red text" + RESET);
    public static final String GREEN = "\033[0;32m";
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[0;33m";

    String testName;
    String testInput;
    double theResults;
    CalcModel testCalc;

    public ModelTest() {
        testName = null;
        testInput = null;
        theResults = 0.0;
        testCalc = new CalcModel();
    }

    public void test() {

        try {
            testName = "Test #1";
            testInput = "1 + 2";
            System.out.print("\n" + testName + " with " + testInput + ": ");
            theResults = 0.0;
            theResults = testCalc.calculateResults(testInput);
            if (theResults == 3.0) {
                System.out.println(GREEN + "PASS" + RESET);
            }//end if
            else {
                System.out.println(RED + "FAIL" + RESET);
            }//end else
        }
        catch(Exception e) {
            System.out.println(testName + " " + e.getMessage());
        }//end catch


        // Test Case #2 a - b
        try {
            testName = "Test #2";
            testInput = "3 - 2";
            System.out.print("\n" + testName + " with " + testInput + ": ");
            theResults = 0.0;
            theResults = testCalc.calculateResults(testInput);
            if (theResults == 1.0) {
                System.out.println(GREEN + "PASS" + RESET);
            }//end if
            else {
                System.out.println(RED + "FAIL" + RESET);
            }//end else
        }
        catch(Exception e) {
            System.out.println(testName + " " + e.getMessage());
        }//end catch


        // Test Case #3 b - a
        try {
            testName = "Test #3";
            testInput = "2 - 3";
            System.out.print("\n" + testName + " with " + testInput + ": ");
            theResults = 0.0;
            theResults = testCalc.calculateResults(testInput);
            if (theResults == -1.0) {
                System.out.println(GREEN + "PASS" + RESET);
            }//end if
            else {
                System.out.println(RED + "FAIL" + RESET);
            }//end else
        }
        catch(Exception e) {
            System.out.println(testName + " " + e.getMessage());
        }//end catch


        // Test Case #4 a * b
        try {
            testName = "Test #4";
            testInput = "1 * 2";
            System.out.print("\n" + testName + " with " + testInput + ": ");
            theResults = 0.0;
            theResults = testCalc.calculateResults(testInput);
            if (theResults == 2.0) {
                System.out.println(GREEN + "PASS" + RESET);
            }//end if
            else {
                System.out.println(RED + "FAIL" + RESET);
            }//end else
        }
        catch(Exception e) {
            System.out.println(testName + " " + e.getMessage());
        }//end catch


        // Test Case #5 a / b
        try {
            testName = "Test #5";
            testInput = "1 / 2";
            System.out.print("\n" + testName + " with " + testInput + ": ");
            theResults = 0.0;
            theResults = testCalc.calculateResults(testInput);
            if (theResults == 0.5) {
                System.out.println(GREEN + "PASS" + RESET);
            }//end if
            else {
                System.out.println(RED + "FAIL" + RESET);
            }//end else
        }
        catch(Exception e) {
            System.out.println(testName + " " + e.getMessage());
        }//end catch


        // Test Case #6 b / a
        try {
            testName = "Test #6";
            testInput = "2 / 1";
            System.out.print("\n" + testName + " with " + testInput + ": ");
            theResults = 0.0;
            theResults = testCalc.calculateResults(testInput);
            if (theResults == 2.0) {
                System.out.println(GREEN + "PASS" + RESET);
            }//end if
            else {
                System.out.println(RED + "FAIL" + RESET);
            }//end else
        }
        catch(Exception e) {
            System.out.println(testName + " " + e.getMessage());
        }//end catch


        // Test Case #7 a / 0
        try {
            testName = "Test #7";
            testInput = "1 / 0";
            System.out.print("\n" + testName + " with " + testInput + ": ");
            theResults = 0.0;
            theResults = testCalc.calculateResults(testInput);
            if (theResults == Double.POSITIVE_INFINITY) {
                System.out.println(GREEN + "PASS" + RESET);
            }//end if
            else {
                System.out.println(RED + "FAIL" + RESET);
            }//end else
        }
        catch(Exception e) {
            System.out.println(YELLOW + "ERROR! " + RESET +
             testName + " " + e.getMessage());
        }//end catch


        // Test Case #8 0 / a
        try {
            testName = "Test #8";
            testInput = "0 / 1";
            System.out.print("\n" + testName + " with " + testInput + ": ");
            theResults = 0.0;
            theResults = testCalc.calculateResults(testInput);
            if (theResults == 0.0) {
                System.out.println(GREEN + "PASS" + RESET);
            }//end if
            else {
                System.out.println(RED + "FAIL" + RESET);
            }//end else
        }
        catch(Exception e) {
            System.out.println(YELLOW + "ERROR! " + RESET +
             testName + " " + e.getMessage());
        }//end catch 
        
        
        // Test Case #9 a * ( b + c )
        // CalcModel expects space-separated significant tokens
        try {
            testName = "Test #9";
            testInput = "1 * ( 2 + 3 )";
            System.out.print("\n" + testName + " with " + testInput + ": ");
            theResults = 0.0;
            theResults = testCalc.calculateResults(testInput);
            if (theResults == 5.0) {
                System.out.println(GREEN + "PASS" + RESET);
            }//end if
            else {
                System.out.println(RED + "FAIL" + RESET);
            }//end else
        }
        catch(Exception e) {
            System.out.println(testName + " " + e.getMessage());
        }//end catch

    }
    
}
