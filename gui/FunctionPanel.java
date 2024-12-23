package gui;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class FunctionPanel {
    //-------------------- Vars
    private static final String[] buttonNames = {
        "butPlus", "butMinus", "butTimes",
        "butDiv", "butEq", "butDel", "butClr",
        "butLP", "butRP"};
    private HashMap<String, JButton> buttonMap;
    private JPanel funcPanel;

    /* 
    Deprecated
    private JButton butPlus, butMinus, butTimes,
                    butDiv, butEq,
                    butDel, butClr, butLP, butRP;
    */


    //-------------------- Constructor

    public FunctionPanel() {
        buttonMap = new HashMap<String, JButton>();
        initPanel();
        populateMap();
        populatePanel();

        //createAndAddButtons();
    }

    //-------------------- Getters & Seters

    public JPanel getFuncPanel() {
        return this.funcPanel;
    }

    public void setFuncPanel(JPanel funcPanel) {
        this.funcPanel = funcPanel;
    }

    public HashMap<String, JButton> getButtonMap() {
        return this.buttonMap;
    }

    public void setButtonMap(HashMap<String, JButton> buttonMap) {
        this.buttonMap = buttonMap;
    }

    public JButton getButton(String buttonName) {
        return this.buttonMap.get(buttonName);
    }

    public void setButton(String buttonName) {
        JButton newButton = buildButton(buttonName);
        buttonMap.put(buttonName, newButton);
    }

    /* 
    * Deprecated
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
        this.butRP = butRP;
    
    }
    */
    //-------------------- Functionality


    //-------------------- Logic & Helpers
    private void initPanel() {
        funcPanel = new JPanel();
        funcPanel.setLayout(new GridLayout(5, 2));
    }

    private JButton buildButton (String buttonName) {
        JButton newButton = new JButton(buttonName);
        newButton.setActionCommand(buttonName);
        newButton.setName(buttonName);

        return newButton;
    }

    private void populateMap() {
        JButton newButton = null;
        for (String buttonName : buttonNames) {
            newButton = buildButton(buttonName);
            switch(buttonName) {
                case "butPlus":
                    newButton.setText("+");
                    break;
                case "butMinus":
                    newButton.setText("-");
                    break;
                case "butTimes":
                    newButton.setText("\u00D7");
                    break;
                case "butDiv":
                    // the obelus
                    newButton.setText("\u00F7");
                    break;
                case "butEq":
                    newButton.setText("=");
                    break;
                case "butDel":
                    newButton.setText("\u232B");
                    break;
                case "butClr":
                    newButton.setText("Clr");
                    break;
                case "butRP":
                    newButton.setText(")");
                    break;
                case "butLP":
                    newButton.setText("(");
                    break;
                      
            }
            buttonMap.put(buttonName, newButton);
        }
    }

    private void populatePanel() {
        for (String buttonName : this.buttonMap.keySet()) {
            funcPanel.add(buttonMap.get(buttonName));
        }
    }

    /*
    * Deprecated
    private void createAndAddButtons() {
        JButton newButton = new JButton();
        String[] operButs = {"+", "-", "*", "/", "(", ")", "Clr", "\u232B", "="};
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
    */
    
}//end FunctionPanel class
