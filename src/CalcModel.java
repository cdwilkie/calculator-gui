package src;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * CalcModel is a CLI representation of an arithmetic
 * calculator. Parses input and calculates results.
 * 
 * How to use:
 * Instantiate (with or w/o string input); 
 * 
 * QuickStart:
 * calculateResults(String expressionInput); space-separated expression
 * returns double
 * 
 * Granular:
 * setInput (if needed); space-separated expression
 * calculateResults();
 * getResults; returns double
 * 
 */
public class CalcModel {
    private String calcInput;
    private String calcResults;
    private ArithmeticParser mathParser;
    private String calcMemory;
    

    // Constructors
    public CalcModel() {
        calcInput = null;
        calcResults = null;
        mathParser = null;
        calcMemory = null;
    }

    public CalcModel(String calcInput) {
        this.calcInput = calcInput;
        this.calcResults = "0";
        mathParser = null;
        calcMemory = null;
    }

    // setters & getters
    public void setInput(String calcInput) {
        this.calcInput = calcInput;
    }

    public String getInput() {
        return this.calcInput;
    }

    public String getResults() {
        return this.calcResults;
    }

    public void setResults(String calcResults) {
        this.calcResults = calcResults;
    }

    public String getMemory() {
        return this.calcMemory;
    }

    public void setMemory(String calcMemory) {
        this.calcMemory = calcMemory;
    }

    public ArithmeticParser getParser() {
        return this.mathParser;
    }

    public void setParser() {
        this.mathParser = new ArithmeticParser(this.calcInput);
    }


    //-------------------- Functionality
    // Runs parser on current stored input
    public void parseAndCalculate() {
        setParser();
        mathParser.runParse();
        setResults(mathParser.getResults());
        
    }

    public void storeResults(String calcResults) {
        if (!calcResults.equalsIgnoreCase("Error")) {
            setMemory(calcResults);
        };
    }
    

    // All-in-one function for user operability.
    public String calculateResults(String calcInput) {
        setInput(calcInput);
        parseAndCalculate();
        String theResults = getResults();
        storeResults(theResults);
        return theResults;
    }

    public void calculateAndPrint(String calcInput) {
        setInput(calcInput);
        parseAndCalculate();
        String theResults = getResults();
        System.out.println(theResults);
    }

}



/*
 * ArithmeticParser parses a string and executes the
 * specified calculations according to the following
 * grammar:
 *  <expression> -> <term>
 *                  | <expression> + <term>
 *                  | <xpression - <term>
 * 
 *  <term> ->       <factor>
 *                  | <term> * <factor>
 *                  | <term> / <factor>
 * 
 *  <power> ->      <factor>
 *                  | <factor> ^ <power>
 * 
 *  <factor> ->     Number
 *                  | ( <expression> )
 *                  | <function>
 * 
 *  <function> ->   FunctionName ( <expression> )
 */
class ArithmeticParser {
    // Vars
    private String inputString;
    private String calculationResults;
    private Scanner scnr;
    private String currentToken;

    // Constructors
    public ArithmeticParser() {
        inputString = null;
        calculationResults = null;
        scnr = null;
        currentToken = null;
    }
    
    public ArithmeticParser(String inputString) {
        this.inputString = inputString;
        calculationResults = "";
        initilaizeScanner();
        currentToken = null;
    }

    //-------------------- Getters & Setters
    public String getInputString() {
        return inputString;
    }//end getInputString()

    public String getResults() {
        return calculationResults;
    }//end getResults()

    public String getCurrentToken() {
        return currentToken;
    }//end getCurrentToken()

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }//end setInputString()

    public void setResults(String calculationResults) {
        this.calculationResults = calculationResults;
    }//end setResults()

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }//end setCurrentToken()


    //-------------------- Functionality
    public void runParse() {
        try {
            initilaizeScanner();
            BigDecimal parseResults = expression();
            setResults(parseResults.toPlainString());
        }
        catch (Exception e) {
            setResults("Error");
        }//end catch
    }
    
    //------------------- Logic & Helpers

    // Ensure scanner string isnt null
    private void initilaizeScanner() {
        if (inputString != null) {
            this.scnr = new Scanner(this.inputString);
        }
    }
    // Assign next token, if possible
    private void getNextToken() {
        if (this.scnr.hasNext()) {
            this.currentToken = this.scnr.next();
        }
        else {
            currentToken = "";
        }
    }//end getNextToken()

    private BigDecimal expression() throws Exception {
        BigDecimal expressionResults = new BigDecimal(0);
        
        expressionResults = term();
        while (this.currentToken.equals("+")
                || this.currentToken.equals("-")) {
            String currentOperation = this.currentToken;
            BigDecimal expressionOperand = term();

            if (currentOperation.equals("+")) {
                expressionResults = expressionResults.add(expressionOperand);
                //expressionResults += expressionOperand;
            }//end if +
            else if (currentOperation.equals("-")) {
                expressionResults = expressionResults.subtract(expressionOperand);
                //expressionResults -= expressionOperand;
            }//end else if -
        }//end while +|-
        
        

        return expressionResults;
    }//end expression()

    private BigDecimal term() throws Exception {
        //double termResults = factor();
        BigDecimal termResults = power();
    
        while (this.currentToken.equals("*")
                || this.currentToken.equals("\u00D7")
                || this.currentToken.equals("/")
                || this.currentToken.equals("\u00F7")) {

            String currentOperation = this.currentToken;
            BigDecimal termOperand = factor();

            if (currentOperation.equals("*")
                    || currentOperation.equals("\u00D7")) {
                termResults = termResults.multiply(termOperand);
            }//end if
            else if (currentOperation.equals("/")
                        || currentOperation.equals("\u00F7")) {
                    if (termOperand.compareTo(new BigDecimal(0)) == 0) {
                        throw new Exception("Cannot divide by zero");
                    }
                    termResults = termResults.divide(termOperand, 20, RoundingMode.HALF_UP);
                
            }//end else if
        }//end while 

        return termResults;
    }//end term()

    
    //TODO FIx power in MyMath to work with BigDecimals
    private BigDecimal power() throws Exception {
        BigDecimal powerResults = factor();
        while (currentToken.equals("^")) {
            BigDecimal exponentValue = factor();
            powerResults = new BigDecimal(Math.pow(powerResults.doubleValue(), exponentValue.doubleValue()));
        }

        return powerResults;
      
    }//end power()
     

    private BigDecimal factor() throws Exception {
        BigDecimal factorResults = new BigDecimal(0);
        
        getNextToken();

        if (this.currentToken.equals("(")) {
            factorResults = expression();
            if (this.currentToken.equals(")")) {
                getNextToken();
            }//end if ")"
        }//end if "("
        else if (isNumber(this.currentToken)) {
            if (isMathConst(currentToken)) {
                factorResults = getMathConst(currentToken);
            }
            else {
                factorResults = new BigDecimal(currentToken);
            }
            
            getNextToken();
        }//end else if number
        else if (isFunction(this.currentToken)){
            factorResults = function();
        }
        else{
            throw new Exception("Unknown or unexpected token encountered: "
             + this.currentToken);
        }//end else unknown

        return factorResults;
    }//end factor()

    private BigDecimal function() throws Exception{
        String currentFunction = this.currentToken;
        getNextToken();
        if (!this.currentToken.equals("(")) {
            throw new Exception("Error");
        }
        BigDecimal functionArgument = expression();
        BigDecimal functionResults = evaluateFunction(currentFunction, functionArgument);

        if (!this.currentToken.equals(")")) {
            throw new Exception ("Error");
        }

        getNextToken();
        
        return functionResults;
    }
   

    // Helper returns true if String can be parsed as number
    private boolean isNumber(String calcToken) {
        String numberPattern = "-?\\d*\\.?\\d*";
        boolean isNumber;
        if (calcToken.matches(numberPattern)) {
            isNumber = true;
        }//end if
        else if (isMathConst(calcToken)) {
            isNumber = true;
        }
        else {
            isNumber = false;
        }//end else
        return isNumber;
    }//end isNumber()

    private boolean isMathConst(String calcToken) {
        String eulerPattern = "\uD835\uDC52";
        String piPattern = "\u03C0";
        boolean isMathConst = false;
        if (calcToken.matches(eulerPattern)) {
            isMathConst = true;
        }
        else if (calcToken.matches(piPattern)) {
            isMathConst = true;
        }
        else {
            isMathConst = false;
        }

        return isMathConst;
    }
    private BigDecimal getMathConst(String calcToken) {
        String eulerPattern = "\uD835\uDC52";
        String piPattern = "\u03C0";
        BigDecimal mathConst = BigDecimal.ONE;
        if (calcToken.matches(eulerPattern) ) {
            mathConst = new BigDecimal(MyMath.EULERS_NUMBER);
        }
        else if(calcToken.matches(piPattern)) {
            mathConst = new BigDecimal(MyMath.PI);
        }

        return mathConst;
    }

    private boolean isFunction(String calcToken) {
        boolean isFunction = false;
        switch(calcToken) {
            case "ln":
                
            case "log":
                
            case "sin":
                
            case "cos":

            case "tan":

            case "sinh":

            case "cosh":

            case "tanh":

            case "factorial":
                isFunction = true;
                break;
            default:
                isFunction = false;
                break;

        }// end switch(calcToken)

        return isFunction;
    }

    private BigDecimal evaluateFunction(String calcToken, BigDecimal functionArgument) {
        BigDecimal theResults = new BigDecimal(0);
        switch(calcToken) {
            case "ln":
                theResults = MyMath.natLog(functionArgument);
                break;
            case "log":
                break;
            case "sin":
                break;
            case "cos":
                break;
            case "tan":
                break;
            case "sinh":
                break;
            case "cosh":
                break;
            case "tanh":
                break;
            case "factorial":
                //theResults = new BigDecimal(MyMath.factorial(functionArgument.doubleValue()));
                theResults = MyMath.bigFactorial(functionArgument);
                break;
            default:
                break;

        }// end switch(calcToken)

        return theResults;
    }

    

}//end ArithmeticParser
