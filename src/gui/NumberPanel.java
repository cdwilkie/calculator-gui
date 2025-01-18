package src.gui;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class NumberPanel {
    //-------------------- Vars
    private static final String[] buttonNames = {
        "but7", "but8", "but9",
        "but4", "but5", "but6",
        "but1", "but2", "but3",
        "butDot", "but0", "butNeg"
    };
    private HashMap<String, JButton> buttonMap;
    private JPanel numPanel;

    //-------------------- Constructor
    public NumberPanel() {
        this.buttonMap = new HashMap<String, JButton>();
        initNumPanel();
        populateMap();
        populatePanel();

    }

    //-------------------- Getters & Seters
    public JPanel getNumPanel() {
        return this.numPanel;
    }

    public void setNumPanel(JPanel numPanel) {
        this.numPanel = numPanel;
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

    //-------------------- Functionality
    // Default Constructor populates a number panel
    // getNumPanel() to return reference to number panel
    
    //-------------------- Logic & Helpers
    private void initNumPanel() {
        numPanel = new JPanel();
        numPanel.setLayout(new GridLayout(4,3));
    }

    private JButton buildButton(String buttonName) {
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
                case "but0":
                    newButton.setText("0");
                    break;
                case "but1":
                    newButton.setText("1");
                    break;
                case "but2":
                    newButton.setText("2");
                    break;
                case "but3":
                    newButton.setText("3");
                    break;
                case "but4":
                    newButton.setText("4");
                    break;
                case "but5":
                    newButton.setText("5");
                    break;
                case "but6":
                    newButton.setText("6");
                    break;
                case "but7":
                    newButton.setText("7");
                    break;
                case "but8":
                    newButton.setText("8");
                    break;
                case "but9":
                    newButton.setText("9");
                    break;
                case "butDot":
                    newButton.setText(".");
                    break;
                case "butNeg":
                    newButton.setText("(-)");
                    break;
            }
            buttonMap.put(buttonName, newButton);
        }
    }

    private void populatePanel() {
        for (String buttonName : buttonNames) {
            numPanel.add(buttonMap.get(buttonName));
        }
    }
    
}