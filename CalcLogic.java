import java.util.ArrayList;

public class CalcLogic {
    // Basic Calculator
    // arithmetic operations
    // add, subtract, divide, multiply
    // Takes operands
    // performs calculation
    // store operands in array list
    // store operands in array list
    private ArrayList<Integer>userOperands;
    private ArrayList<String>userOperations;

    public CalcLogic() {
        userOperands = new ArrayList<Integer>();
        userOperations = new ArrayList<String>();
    }


    public void addOperand(int userNumber) {
        userOperands.add(userNumber);
    }

    public Integer getOperand() {
        if (userOperands.size() > 0) {
            Integer operand = userOperands.get(0);
            userOperands.remove(0);
            return operand;
        }
        else {
            return null;
        }
    }

    public void addOperation(String userOperation) {
        userOperations.add(userOperation);
    }

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
}
