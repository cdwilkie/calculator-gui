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
                        currentInput += " * ";
                        break;
                    case "butDiv":
                        currentInput += " / ";
                        break;
                    case "butEq":
                        double theResults = calcModel.calculateResults(currentInput);
                        String currentHistory = calcView.getOutput();
                        currentHistory += (currentInput + " = " +
                                Double.toString(theResults) + "\n");
                        calcView.setOutput(currentHistory);
                        currentInput = "";
                        break;
                    case "butDel":
                    if (currentInput.length() > 0) {
                        if (currentInput.charAt(currentInput.length()-1) == ' ') {
                            currentInput = currentInput.substring(0, currentInput.length()-2);
                        }
                        else {
                            currentInput = currentInput.substring(0, currentInput.length()-1);
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
        calcView.getOperationsPanel().getButton("squareroot").addActionListener(e->{
            
            calcView.getDisplayPanel().getOutputArea().setText("\u221A");
            calcView.getDisplayPanel().getInputField().setText("");
        });
    }

}
