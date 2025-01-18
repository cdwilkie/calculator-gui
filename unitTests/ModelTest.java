
package unitTests;

import java.math.BigDecimal;
import java.util.HashMap;

import src.utils.CalcModel;

public class ModelTest {

    // Textcolor Modifiers for Console Output
    // Example: System.out.println(RED + "This is red text" + RESET);
    public static final String GREEN = "\033[0;32m";
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[0;33m";

    String testName;
    String testInput;
    String theResults;
    CalcModel testCalc;

    public ModelTest() {
        testName = null;
        testInput = null;
        theResults = "0.0";
        testCalc = new CalcModel();
    }

    public void runTest() {
        testAddition();
        testSubtraction();
        testMultiply();
        testDivision();
        testExponent();
        testParenthesis();
    }

    private void testSubtraction() {
        System.out.println("\n------------------- Subtraction");
        HashMap <String, String> testCases = new HashMap<String, String>();
        setSubTests(testCases);
        testEachInput(testCases);
    }

    private void testMultiply() {
        System.out.println("\n------------------- Multiplication");
        HashMap <String, String> testCases = new HashMap<String, String>();
        setMultTests(testCases);
        testEachInput(testCases);
    }

    private void testDivision() {
        System.out.println("\n------------------- Division");
        HashMap <String, String> testCases = new HashMap<String, String>();
        setDivTests(testCases);
        testEachInput(testCases);
    }

    private void testExponent() {
        System.out.println("\n------------------- Exponentation");
        HashMap <String, String> testCases = new HashMap<String, String>();
        setExpTests(testCases);
        testEachInput(testCases);
    }

    private void testParenthesis() {
        System.out.println("\n------------------- Parenthesis and Grouping");
        HashMap <String, String> testCases = new HashMap<String, String>();
        setParenthesisTest(testCases);
        testEachInput(testCases);
    }

    private void testAddition() {
        System.out.println("\n------------------- Addition");
        HashMap <String, String> testCases = new HashMap<String, String>();
        setAddTests(testCases);
        testEachInput(testCases);
        
    }
    private void setAddTests(HashMap<String, String> testCases) {
        testCases.put("2 + 3", "5");
        testCases.put("2 + 0", "2");
        testCases.put("0 + 2", "2");
        testCases.put("-5 + -3", "-8");
        testCases.put("10 + -5", "5");
        testCases.put("-5 + 10", "5");
        testCases.put("10000000000 + 10000000000", "20000000000");
        testCases.put("0.0000000001 + 0.0000000001", "0.0000000002");
        testCases.put("0.1 + 0.2", "0.3");
        testCases.put("5 + -5", "0");
    }//end setAddTests()

    private void setSubTests(HashMap<String, String> testCases) {
        testCases.put("5 - 3", "2");
        testCases.put("10 - 4", "6");
        testCases.put("3 - 5", "-2");
        testCases.put("0 - 10", "-10");
        testCases.put("5 - 0", "5");
        testCases.put("0 - 5", "-5");
        testCases.put("0 - 0", "0");
        testCases.put("5.5 - 2.2", "3.3");
        testCases.put("10.0 - 0.1", "9.9");
        testCases.put("-5 - 3", "-8");
        testCases.put("5 - -3", "8");
        testCases.put("-5 - -3", "-2");
        testCases.put("1000000000 - 1", "999999999");
        testCases.put("-1000000000 - -1", "-999999999");
        testCases.put("999999999999999999 - 1", "999999999999999998");
        testCases.put("0.3333 - 0.1111", "0.2222");
        testCases.put("1.9999 - 0.9999", "1.0");
        testCases.put("-0 - 0", "0");
        testCases.put("1 - -0", "1");
        testCases.put("0.0 - 0.0", "0.0");
    }

    private void setMultTests(HashMap<String, String> testCases) {
        // Basic multiplication
        testCases.put("5 * 3", "15");
        testCases.put("10 * 4", "40");

        // Multiplication with zero
        testCases.put("5 * 0", "0");
        testCases.put("0 * 10", "0");
        testCases.put("0 * 0", "0");

        // Multiplication with one
        testCases.put("5 * 1", "5");
        testCases.put("1 * 10", "10");
        testCases.put("1 * 1", "1");

        // Negative numbers
        testCases.put("-5 * 3", "-15");
        testCases.put("5 * -3", "-15");
        testCases.put("-5 * -3", "15");

        // Decimal multiplication
        testCases.put("5.5 * 2.2", "12.1");
        testCases.put("10.0 * 0.1", "1.0");
        testCases.put("0.333 * 3", "0.999");

        // Large numbers
        testCases.put("1000000000 * 10", "10000000000");
        testCases.put("-1000000000 * -1", "1000000000");
        testCases.put("999999999999999 * 999999999999999", "999999999999998000000000000001");

        // Special edge cases
        testCases.put("-0 * 5", "0");
        testCases.put("1 * -0", "0");
        testCases.put("0.0 * 0.0", "0.0");

        // Commutativity
        testCases.put("3 * 5", "15"); // Matches "5 * 3" for commutative property
        testCases.put("0.1 * 0.2", "0.02"); // Decimal check, commutative

        // Rounding considerations
        testCases.put("0.3333 * 3", "0.9999");
        testCases.put("1.9999 * 0.5", "0.99995");


    }

    private void setDivTests(HashMap<String, String> testCases) {
        // Basic division
        testCases.put("10 / 2", "5");
        testCases.put("20 / 5", "4");

        // Division with 1
        testCases.put("10 / 1", "10");
        testCases.put("1 / 1", "1");

        // Division resulting in decimals
        testCases.put("1 / 2", "0.5");
        testCases.put("5 / 3", "1.6666666666666667");

        // Negative numbers
        testCases.put("-10 / 2", "-5");
        testCases.put("10 / -2", "-5");
        testCases.put("-10 / -2", "5");

        // Division by small numbers
        testCases.put("1 / 0.5", "2");
        testCases.put("10 / 0.1", "100");

        // Large numbers
        testCases.put("1000000000 / 2", "500000000");
        testCases.put("999999999999999 / 3", "333333333333333");

        // Division by itself
        testCases.put("10 / 10", "1");
        testCases.put("0.5 / 0.5", "1");

        // Division by zero (Error expected)
        testCases.put("10 / 0", "Error"); 
        testCases.put("0 / 0", "Error"); 

        // Division with zero numerator
        testCases.put("0 / 10", "0");
        testCases.put("0 / 0.0001", "0");

        // Rounding considerations
        testCases.put("1 / 3", "0.3333333333333333");
        testCases.put("2 / 3", "0.6666666666666666");

        // Special cases
        testCases.put("-0 / 5", "0");
        testCases.put("1 / -0", "Error"); 
        testCases.put("0.0 / 0.0", "Error"); 

    }

    private void setExpTests(HashMap<String, String> testCases) {
        // Basic exponentiation
        testCases.put("2 ^ 3", "8");
        testCases.put("5 ^ 2", "25");

        // Exponent of 1
        testCases.put("5 ^ 1", "5");
        testCases.put("1 ^ 1", "1");

        // Base of 1
        testCases.put("1 ^ 5", "1");
        testCases.put("1 ^ 100", "1");

        // Exponent of 0
        testCases.put("5 ^ 0", "1");
        testCases.put("0 ^ 0", "1"); 
        testCases.put("1 ^ 0", "1");

        // Base of 0
        testCases.put("0 ^ 5", "0");
        testCases.put("0 ^ 100", "0");

        // Negative exponents
        testCases.put("2 ^ -2", "0.25");
        testCases.put("5 ^ -1", "0.2");

        // Negative bases
        testCases.put("-2 ^ 2", "4");  // Even exponent
        testCases.put("-2 ^ 3", "-8"); // Odd exponent
        testCases.put("-2 ^ -2", "0.25"); // Negative exponent

        // Decimal bases
        testCases.put("2.5 ^ 2", "6.25");
        testCases.put("0.5 ^ 3", "0.125");

        // Decimal exponents
        testCases.put("9 ^ 0.5", "3"); // Square root

        // Large exponents
        testCases.put("2 ^ 30", "1073741824");
        testCases.put("10 ^ 10", "10000000000");

        // Small exponents
        testCases.put("2 ^ 0.001", "1.0006933874625803");
        testCases.put("0.001 ^ 2", "0.000001");

        // Special cases
        testCases.put("-1 ^ 0", "1");
        testCases.put("-1 ^ 1", "-1");
        testCases.put("-1 ^ 2", "1");
        testCases.put("-1 ^ 3", "-1");
    }

    private void setParenthesisTest(HashMap<String, String> testCases) {
        // Basic precedence without parentheses
        testCases.put("2 + 3 * 4", "14");
        testCases.put("2 * 3 + 4", "10");

        // Parentheses overriding precedence
        testCases.put("( 2 + 3 ) * 4", "20");
        testCases.put("2 * ( 3 + 4 )", "14");

        // Nested parentheses
        testCases.put("( 2 + ( 3 * 4 ) )", "14");
        testCases.put("( ( 2 + 3 ) * ( 4 + 5 ) )", "45");

        // Multiple levels of nesting
        testCases.put("( ( 2 + 3 ) * ( 4 + ( 1 * 2 ) ) )", "30");
        testCases.put("( ( 1 + 2 ) * ( 3 + ( 4 * ( 5 - 2 ) ) ) )", "45");

        // Parentheses around a single number
        testCases.put("( 5 )", "5");
        testCases.put("( ( 5 ) )", "5");

        // Parentheses with negative numbers
        testCases.put("( -5 + 3 )", "-2");
        testCases.put("( -5 + ( 3 * 2 ) )", "1");
        testCases.put("( ( 3 - 5 ) * -2 )", "4");

        // Parentheses with decimals
        testCases.put("( 2.5 + 3.5 ) * 2", "12");
        testCases.put("2 * ( 1.5 + 0.5 )", "4");

        // Parentheses with exponents
        testCases.put("( 2 + 3 ) ^ 2", "25");
        testCases.put("2 ^ ( 3 + 2 )", "32");

        // Complex mixed operations
        testCases.put("( ( 2 + 3 ) * 4 ) + 5", "25");
        testCases.put("5 + ( ( 2 + 3 ) * 4 )", "25");
        testCases.put("( ( 2 + ( 3 * 4 ) ) - 5 ) ^ 2", "81");

        // Large expressions
        testCases.put("( 10 + 20 ) * ( 30 / ( 5 + 5 ) )", "90");
        testCases.put("( 10 / ( 2 + 3 ) ) * ( 6 - 4 )", "4");

        // Parentheses ensuring addition before multiplication
        testCases.put("2 * ( 3 + 4 * ( 5 - 2 ) )", "30");
        testCases.put("( 2 * ( 3 + 4 ) ) * ( 5 - 2 )", "42");

        // Parentheses with zero
        testCases.put("( 0 + 3 ) * 5", "15");
        testCases.put("0 * ( 3 + 5 )", "0");

    }

    private void printTestName(int testNumber, String testInput) {
        testName = "Test #" + testNumber;
        System.out.print(testName + " with " + testInput + ": ");
    }//end printTest

    private void testEachInput(HashMap<String, String> testCases) {
        int testNumber = 0;
        for (String testInput : testCases.keySet()) {
            testNumber++;
            printTestName(testNumber, testInput);
            String expectedResults = testCases.get(testInput);
            theResults = testCalc.calculateResults(testInput);
            testResults(theResults, expectedResults);
        }
    }

    private void testResults(String testResults, String expectedResults) {
        if (testResults.equals("Error") ) {
            if (expectedResults.equals("Error")) {
                System.out.println(GREEN + "PASS" + RESET);
            }
            else {
                System.out.println(RED + "FAIL" + RESET);
            }
            
        }
        else{
        double epsilonError = 0.0000001;
        BigDecimal theResults = new BigDecimal(testResults);
        BigDecimal resultDifference = theResults.subtract(new BigDecimal(expectedResults));
        resultDifference = resultDifference.abs();
        boolean passedTest = resultDifference.compareTo(new BigDecimal(epsilonError)) < 0 ? true : false;

        if (passedTest) {
            System.out.println(GREEN + "PASS" + RESET);
        }
        else {
            System.out.println(RED + "FAIL" + RESET);
        }
    }
    }//end testResults()
    
}
