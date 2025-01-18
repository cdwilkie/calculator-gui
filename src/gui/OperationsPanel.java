package src.gui;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class OperationsPanel {
    //-------------------- Vars
    private static final String[] buttonNames = {
        "!", "ln", "exponent", "squareroot",
        "eulersNum", "pi", "mem"};

    private JPanel opPanel;
    private HashMap<String, JButton> buttonMap;

    //-------------------- Constructors
    public OperationsPanel() {
        buttonMap = new HashMap<String, JButton>();
        initPanel();
        populateMap();
        populatePanel();
    }

    //-------------------- Getters & Setters

    public JPanel getOpPanel() {
        return opPanel;
    }

    public void setOpPanel(JPanel opPanel) {
        this.opPanel = opPanel;
    }

    public HashMap<String, JButton> getButtonMap() {
        return this.buttonMap;
    }

    public void setButtonMap(HashMap<String, JButton> buttonMap) {
        this.buttonMap = buttonMap;
    }

    public JButton getButton(String buttonName) {
        return buttonMap.get(buttonName);
    }

    public void setButton(String buttonName) {
        JButton newButton = new JButton(buttonName);
        buttonMap.put(buttonName, newButton);
    }
    //-------------------- Functionality

    //-------------------- Logic & Helpers

    private void initPanel() {
        this.opPanel = new JPanel();
        opPanel.setLayout(new GridLayout(2, 4));
    }

    private JButton buildButton(String buttonName) {
        JButton newButton = new JButton(buttonName);
        newButton.setActionCommand(buttonName);
        newButton.setName(buttonName);

        return newButton;
    }//end buildButtons()

    private void populateMap() {
        JButton newButton = null;
        for (String buttonName : buttonNames) {
            switch(buttonName) {
                case "exponent":
                    newButton = buildButton(buttonName);
                    newButton.setText("<html>x<sup>y</sup></html>");
                    buttonMap.put(buttonName, newButton);
                    break;
                case "squareroot":
                    newButton = buildButton(buttonName);
                    newButton.setText("\u221A");
                    buttonMap.put(buttonName, newButton);
                    break;
                case "eulersNum":
                    newButton = buildButton(buttonName);
                    newButton.setText("\uD835\uDC52");
                    buttonMap.put(buttonName, newButton);
                    break;
                case "pi":
                    newButton = buildButton(buttonName);
                    newButton.setText("\u03C0");
                    buttonMap.put(buttonName, newButton);
                    break;
                default:
                    newButton = buildButton(buttonName);
                    buttonMap.put(buttonName, newButton);
            }
        }
    }
    
    private void populatePanel() {
        for (String buttonName : buttonNames) {
            opPanel.add(buttonMap.get(buttonName));
        }
    }
}
