import java.util.ArrayList;
import java.util.Scanner;

public class CalcModel {
    // Basic Calculator
    // arithmetic operations
    // add, subtract, divide, multiply
    // Takes operands
    // performs calculation
    // store operands in array list
    // store operands in array list
    private ArrayList<Double>userOperands;
    private ArrayList<String>userOperations;
    private double displayResults;

    // ---------- Constructors
    // Default Constructor
    public CalcModel() {
        userOperands = new ArrayList<Double>();
        userOperations = new ArrayList<String>();
        displayResults = 0;
    }


    // ---------- Mutators & Accessors
    // Add Operand to list
    public void addOperand(double userNumber) {
        userOperands.add(userNumber);
    }

    // Pop first operand from list 
    public Double getOperand() {
        if (userOperands.size() > 0) {
            Double operand = userOperands.get(0);
            userOperands.remove(0);
            return operand;
        }
        else {
            return null;
        }
    }

    // Add operation to list
    public void addOperation(String userOperation) {
        userOperations.add(userOperation);
    }

    // Pop first operation from list
    public String getOperation() {
        if (userOperations.size() >0) {
            String currentOperation = userOperations.get(0);
            userOperations.remove(0);
            return currentOperation;
        }
        else {
            return null;
        }
    }

    // Set results
    public void setResults(int currentResults) {
        displayResults = currentResults;
    }

    // Get results
    public double getResults() {
        return displayResults;
    }

    // ----------------- Logic
    // parse input
    public void parseInput(String userInput) {
        Scanner scnr = new Scanner(userInput);

        scnr.close();
        
    }

    public double performCalculation(String userOperation) {
        double calculationResults = 0;
        switch (userOperation.charAt(0)) {
            case '+':
                if (userOperands.size() > 1) {
                    calculationResults = this.getOperand() + this.getOperand();
                }
            break;
        }

        return calculationResults;
    }
}
