import java.util.Scanner;

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
    private double calcResults; // might should be string for future functionality
    private ArithmeticParser mathParser;
    

    // Constructors
    public CalcModel() {
        calcInput = null;
        calcResults = 0.0;
        mathParser = null;
    }

    public CalcModel(String calcInput) {
        this.calcInput = calcInput;
        this.calcResults = 0.0;
        mathParser = null;
    }

    // setters & getters
    public void setInput(String calcInput) {
        this.calcInput = calcInput;
    }

    public String getInput() {
        return this.calcInput;
    }

    public double getResults() {
        return this.calcResults;
    }

    public void setResults(double calcResults) {
        this.calcResults = calcResults;
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

    // All-in-one function for user operability.
    public double calculateResults(String calcInput) {
        setInput(calcInput);
        parseAndCalculate();
        double theResults = getResults();
        return theResults;
    }

    public void calculateAndPrint(String calcInput) {
        setInput(calcInput);
        parseAndCalculate();
        double theResults = getResults();
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
 *  <term> ->   <factor>
 *              | <term> * <factor>
 *              | <term> / <factor>
 * 
 *  <factor> -> Number
 *              | ( <expression> )
 *              | unkown
 */
class ArithmeticParser {
    // Vars
    private String inputString;
    private double calculationResults;
    private Scanner scnr;
    private String currentToken;

    // Constructors
     
    public ArithmeticParser() {
        inputString = null;
        calculationResults = 0.0;
        scnr = null;
        currentToken = null;
    }
    
    
    public ArithmeticParser(String inputString) {
        this.inputString = inputString;
        calculationResults = 0.0;
        initilaizeScanner();
        currentToken = null;
    }

    //-------------------- Getters & Setters
    public String getInputString() {
        return inputString;
    }//end getInputString()

    public double getResults() {
        return calculationResults;
    }//end getResults()

    public String getCurrentToken() {
        return currentToken;
    }//end getCurrentToken()

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }//end setInputString()

    public void setResults(double calculationResults) {
        this.calculationResults = calculationResults;
    }//end setResults()

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }//end setCurrentToken()


    //-------------------- Functionality
    public void runParse() {
        initilaizeScanner();
        double parseResults = 0.0;
        parseResults = expression();
        setResults(parseResults);
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

    private double expression() {
        double expressionResults = 0.0;
        try {
        expressionResults = term();
        while (this.currentToken.equals("+")
                || this.currentToken.equals("-")) {
            String currentOperation = this.currentToken;
            double expressionOperand = term();

            if (currentOperation.equals("+")) {
                expressionResults += expressionOperand;
            }//end if +
            else if (currentOperation.equals("-")) {
                expressionResults -= expressionOperand;
            }//end else if -
        }//end while +|-
        /* 
        if (currentToken.equals("(") || currentToken.equals(")")){
            throw new Exception("Improper expression format");
        }
            */
        }
        catch (Exception e) {
            System.out.println("Error - " + e.getMessage());
            expressionResults = Double.NaN;
            return expressionResults;
        }

        return expressionResults;
    }//end expression()

    private double term() throws Exception {
        double termResults = factor();
    
        while (this.currentToken.equals("*")
                || this.currentToken.equals("/")) {

            String currentOperation = this.currentToken;
            double termOperand = factor();

            if (currentOperation.equals("*")) {
                termResults *= termOperand;
            }//end if
            else if (currentOperation.equals("/")) {
                    if (termOperand == 0) {
                        throw new Exception("Cannot divide by zero");
                    }
                    termResults /= termOperand;
                
            }//end else if
        }//end while 

        return termResults;
    }//end term()

    private double factor() throws Exception {
        double factorResults = 0.0;
        getNextToken();

        if (this.currentToken.equals("(")) {
            factorResults = expression();
            if (this.currentToken.equals(")")) {
                getNextToken();
            }//end if ")"
        }//end if "("
        else if (isNumber(this.currentToken)) {
            factorResults = Double.valueOf(this.currentToken);
            getNextToken();
        }//end else if number
        else {
            throw new Exception("Unknown or unexpected token encountered: "
             + this.currentToken);
        }//end else unknown

        return factorResults;
    }//end factor()

    // Helper returns true if String can be parsed as number
    private boolean isNumber(String calcToken) {
        String numberPattern = "-?\\d*\\.?\\d*";
        boolean isNumber;
        if (calcToken.matches(numberPattern)) {
            isNumber = true;
        }//end if
        else {
            isNumber = false;
        }//end else
        return isNumber;
    }//end isNumber()

    

}//end ArithmeticParser
