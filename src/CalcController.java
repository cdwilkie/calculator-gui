package src;
import java.math.*;
import java.text.DecimalFormat;

public class CalcController {
    //-------------------- Vars
    private CalcView calcView;
    private CalcModel calcModel;

    //-------------------- Constructors
    public CalcController(CalcView calcView, CalcModel calcModel) {
        this.calcView = calcView;
        this.calcModel = calcModel;
        setNumberListeners();
        setFunctionListeners();
        setOperationsListeners();
    }
    //-------------------- Getters & Setters
    public CalcView getCalcView() {
        return this.calcView;
    }

    public void setCalcView(CalcView calcView) {
        this.calcView = calcView;
    }

    public CalcModel getCalcModel() {
        return this.calcModel;
    }

    public void setCalcModel(CalcModel calcModel) {
        this.calcModel = calcModel;
    }

    //-------------------- Functionality

    //-------------------- Logic & Helpers
    private void setNumberListeners() {
        for (String buttonName : calcView.getNumberPanel().getButtonMap().keySet()) {
            calcView.getNumberPanel().getButton(buttonName).addActionListener(e -> {
                String currentInput = calcView.getInput();
                switch(buttonName) {
                    case "but0":
                    currentInput += "0";
                    break;
                case "but1":
                    currentInput += "1";
                    break;
                case "but2":
                    currentInput += "2";
                    break;
                case "but3":
                    currentInput += "3";
                    break;
                case "but4":
                    currentInput += "4";
                    break;
                case "but5":
                    currentInput += "5";
                    break;
                case "but6":
                    currentInput += "6";
                    break;
                case "but7":
                    currentInput += "7";
                    break;
                case "but8":
                    currentInput += "8";
                    break;
                case "but9":
                    currentInput += "9";
                    break;
                case "butDot":
                    currentInput += ".";
                    break;
                case "butNeg":
                    currentInput += "-";
                    break;
                }
                calcView.setInput(currentInput);
            });
        }
    }

    private void setFunctionListeners() {
        for (String buttonName : calcView.getFunctionPanel().getButtonMap().keySet()) {
            calcView.getFunctionPanel().getButton(buttonName).addActionListener(e -> {
                String currentInput = calcView.getInput();
                switch(buttonName) {
                    case "butLP":
                        currentInput += " ( ";
                        break;
                    case "butRP":
                        currentInput += " ) ";
                        break;
                    case "butPlus":
                        currentInput += " + ";
                        break;
                    case "butMinus":
                        currentInput += " - ";
                        break;
                    case "butTimes":
                        currentInput += " \u00D7 ";
                        break;
                    case "butDiv":
                        currentInput += " \u00F7 ";
                        break;
                    case "butEq":
                        String calcResults = calcModel.calculateResults(currentInput);
                        if (!calcResults.equals("Error")) {

                        
                        BigDecimal theResults = new BigDecimal(calcModel.calculateResults(currentInput));
                        DecimalFormat deciFormat = new DecimalFormat("#,##0.####################");
                        String formatted = deciFormat.format(theResults);
                        String currentHistory = calcView.getOutput();
                        currentHistory += (currentInput + " = " +
                                formatted + "\n");
                        calcView.setOutput(currentHistory);
                        currentInput = "";
                        }
                        else {
                            String currentHistory = calcView.getOutput();
                            currentHistory += (currentInput + " = " +
                                calcResults + "\n");
                            calcView.setOutput(currentHistory);
                            currentInput = "";
                        }
                        break;
                    case "butDel":
                        if (currentInput.length() > 0) {
                            for (int i = currentInput.length() - 1; i >= 0; --i) {
                                if (Character.isWhitespace(currentInput.charAt(i))) {
                                    continue;
                                }
                                else {
                                    currentInput = currentInput.substring(0,i);
                                    break;
                                }
                            }
                        }
                        break;
                    case "butClr":
                        currentInput = "";
                        calcView.setOutput("");
                        break;
                }//end switch(buttonName)
                calcView.setInput(currentInput);
            });//end addActionListener()
        }//end for each button name
    }//end setFuncListeners2()

   
    private void setOperationsListeners() {
        for (String buttonName : calcView.getOperationsPanel().getButtonMap().keySet()) {
            calcView.getOperationsPanel().getButton(buttonName).addActionListener(e -> {
                String currentInput = calcView.getInput();
                switch(buttonName) {
                    case "!":
                        
                        currentInput += "!";
                        BigDecimal theResults = new BigDecimal(MyMath.factorial(Double.valueOf(calcView.getInput())));
                        DecimalFormat deciFormat = new DecimalFormat("#,##0.00");
                        String formatted = deciFormat.format(theResults);
                        String currentHistory = calcView.getOutput();
                        currentHistory += (currentInput + " = " +
                                formatted + "\n");
                        calcView.setOutput(currentHistory);
                        currentInput = "";
                        
                        break;
                    case "log":
                        currentInput += "log";
                        break;
                    case "exponent":
                        currentInput += " ^ ";
                        break;
                    case "squareroot":
                        currentInput += "\u221A";
                        break;
                }
            calcView.setInput(currentInput);
            });
        }
        /* 
        calcView.getOperationsPanel().getButton("squareroot").addActionListener(e->{
            
            calcView.getDisplayPanel().getOutputArea().setText("\u221A");
            calcView.getDisplayPanel().getInputField().setText("");
        });
        */
    }

}
