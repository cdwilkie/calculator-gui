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
        
        calcView.getNumberPanel().getBut0().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getBut1().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getBut2().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getBut3().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getBut4().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getBut5().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getBut6().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getBut7().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getBut8().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getBut9().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        calcView.getNumberPanel().getButDot().addActionListener(event->{
            String entryText = calcView.getDisplayPanel().getInputField().getText();
            entryText = entryText + event.getActionCommand();
            calcView.getDisplayPanel().getInputField().setText(entryText);
        });

        // TODO FIX ME
        calcView.getNumberPanel().getButNeg().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            currentInput = currentInput + "-";
            calcView.getDisplayPanel().getInputField().setText(currentInput);
        });
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
                        currentInput = currentInput.substring(0, currentInput.length()-1);
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
