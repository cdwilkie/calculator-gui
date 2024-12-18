package gui;

import javax.swing.*;
import java.awt.*;

public class FunctionPanel {
    //-------------------- Vars
    private JPanel funcPanel;
    private JButton butPlus, butMinus, butTimes,
                    butDiv, butEq, butPlusMin,
                    butDel, butClr, butLP, butRP;
    


    //-------------------- Constructor

    public FunctionPanel() {
        initPanel();
        createAndAddButtons();
    }

    //-------------------- Getters & Seters

    public JPanel getFuncPanel() {
        return this.funcPanel;
    }

    public void setFuncPanel(JPanel funcPanel) {
        this.funcPanel = funcPanel;
    }

    public JButton getButPlus() {
        return this.butPlus;
    }

    public void setButPlus(JButton newButton) {
        this.butPlus = newButton;
    }

    public JButton getButMinus() {
        return this.butMinus;
    }

    public void setButMinus(JButton newButton) {
        this.butMinus = newButton;
    }

    public JButton getButTimes() {
        return this.butTimes;
    }

    public void setButTimes(JButton newButton) {
        this.butTimes = newButton;
    }

    public JButton getButDiv() {
        return this.butDiv;
    }

    public void setButDiv(JButton newButton) {
        this.butDiv = newButton;
    }

    public JButton getButEq() {
        return this.butEq;
    }

    public void setButEq(JButton newButton) {
        this.butEq = newButton;
    }

    public JButton getButPlusMin() {
        return this.butPlusMin;
    }

    public void setButPlusMin(JButton newButton) {
        this.butPlusMin = newButton;
    }

    public JButton getButDel() {
        return this.butDel;
    }

    public void setButDel(JButton newButton) {
        this.butDel = newButton;
    }

    public JButton getButClr() {
        return this.butClr;
    }

    public void setButClr(JButton newButton) {
        this.butClr = newButton;
    }

    public JButton getButLP() {
        return this.butLP;
    }

    public void setButLP(JButton butLP) {
        this.butLP = butLP;
    }

    public JButton getButRP() {
        return this.butRP;
    }

    public void setButRP(JButton butRP) {
        this.butLP = butRP;
    
    }

    //-------------------- Functionality


    //-------------------- Logic & Helpers
    private void initPanel() {
        funcPanel = new JPanel();
        funcPanel.setLayout(new GridLayout(5, 2));
        
    }

    
    private void createAndAddButtons() {
        JButton newButton = new JButton();
        String[] operButs = {"+", "-", "*", "/", "=", "+/-", "Clr", "\u232B", "(", ")"};
        for (String symbol : operButs) {
            switch (symbol) {
                case "+":
                    newButton = new JButton("+");
                    newButton.setName("+");
                    newButton.setActionCommand("+");
                    setButPlus(newButton);
                    funcPanel.add(newButton);
                    break;
                case "-":
                    newButton = new JButton("-");
                    newButton.setName("-");
                    newButton.setActionCommand("-");
                    setButMinus(newButton);
                    funcPanel.add(newButton);
                    break;
                case "*":
                    newButton = new JButton("*");
                    newButton.setName("*");
                    newButton.setActionCommand("*");
                    setButTimes(newButton);
                    funcPanel.add(newButton);
                    break;
                case "/":
                    newButton = new JButton("/");
                    newButton.setName("/");
                    newButton.setActionCommand("/");
                    setButDiv(newButton);
                    funcPanel.add(newButton);
                    break;
                case "=":
                    newButton = new JButton("=");
                    newButton.setName("=");
                    newButton.setActionCommand("=");
                    setButEq(newButton);
                    funcPanel.add(newButton);
                    break;
                case "+/-":
                    newButton = new JButton("+/-");
                    newButton.setName("+/-");
                    newButton.setActionCommand("+/-");
                    setButPlusMin(newButton);
                    funcPanel.add(newButton);
                    break;
                case "Clr":
                    newButton = new JButton("Clr");
                    newButton.setName("Clr");
                    newButton.setActionCommand("Clr");
                    setButClr(newButton);
                    funcPanel.add(newButton);
                    break;
                case "\u232B":
                    newButton = new JButton("\u232B");
                    newButton.setName("del");
                    newButton.setActionCommand("del");
                    setButDel(newButton);
                    funcPanel.add(newButton);
                    break;
                case "(":
                    newButton = new JButton("(");
                    newButton.setName("(");
                    newButton.setActionCommand("(");
                    setButLP(newButton);
                    funcPanel.add(newButton);
                    break;
                case ")":
                    newButton = new JButton(")");
                    newButton.setName(")");
                    newButton.setActionCommand(")");
                    setButRP(newButton);
                    funcPanel.add(newButton);
                    break;
            }
        }
    }
}
