import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcController {
    //-------------------- Vars
    private CalcView calcView;
    private CalcModel calcModel;

    //-------------------- Constructors
    public CalcController(CalcView calcView, CalcModel calcModel) {
        this.calcView = calcView;
        this.calcModel = calcModel;
        setNumberListeners();
        setFuncListeners();
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
    }

    private void setFuncListeners() {

        calcView.getFunctionPanel().getButLP().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            currentInput += " ( ";
            calcView.getDisplayPanel().getInputField().setText(currentInput);
        });

        calcView.getFunctionPanel().getButRP().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            currentInput += " ) ";
            calcView.getDisplayPanel().getInputField().setText(currentInput);
        });
        
        calcView.getFunctionPanel().getButPlus().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            currentInput = currentInput + " + ";
            calcView.getDisplayPanel().getInputField().setText(currentInput);
        });

        calcView.getFunctionPanel().getButMinus().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            currentInput = currentInput + " - ";
            calcView.getDisplayPanel().getInputField().setText(currentInput);
        });

        calcView.getFunctionPanel().getButTimes().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            currentInput = currentInput + " * ";
            calcView.getDisplayPanel().getInputField().setText(currentInput);
        });

        calcView.getFunctionPanel().getButDiv().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            currentInput = currentInput + " / ";
            calcView.getDisplayPanel().getInputField().setText(currentInput);
        });

        calcView.getFunctionPanel().getButEq().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            double theResults = calcModel.calculateResults(currentInput);
            String currentHistory = calcView.getDisplayPanel().getOutputArea().getText();
            currentHistory = (currentHistory + Double.toString(theResults) + "\n");
            calcView.getDisplayPanel().getOutputArea().setText(currentHistory);
            calcView.getDisplayPanel().getInputField().setText("");
        });

        // TODO FIX ME
        calcView.getFunctionPanel().getButPlusMin().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            currentInput = currentInput + " +/- ";
            calcView.getDisplayPanel().getInputField().setText(currentInput);
        });

        calcView.getFunctionPanel().getButDel().addActionListener(e->{
            String currentInput = calcView.getDisplayPanel().getInputField().getText();
            currentInput = currentInput.substring(0, currentInput.length()-1);
            calcView.getDisplayPanel().getInputField().setText(currentInput);
        });

        calcView.getFunctionPanel().getButClr().addActionListener(e->{
            
            calcView.getDisplayPanel().getOutputArea().setText("");
            calcView.getDisplayPanel().getInputField().setText("");
        });
    }

}
