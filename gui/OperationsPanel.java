package gui;

import java.util.*;
import javax.swing.*;
import java.awt.*;

public class OperationsPanel {
    //-------------------- Vars
    private final String[] buttonNames = {
        "!"
    };
    private JPanel mainPanel;


    private HashMap<String, JButton> buttonMap;

    //-------------------- Constructors
    public OperationsPanel() {
        initPanel();
        populateMap();
        populatePanel();
    }

    //-------------------- Getters & Setters

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
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
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 4));
    }

    private JButton buildButton(String buttonName) {
        JButton newButton = new JButton(buttonName);
        newButton.setActionCommand(buttonName);
        newButton.setName(buttonName);

        return newButton;
    }//end buildButtons()

    private void populateMap() {
        JButton newButton = null;
        for (String buttonName : this.buttonNames) {
            switch(buttonName) {
                case "exponent":
                    break;
                default:
                    newButton = buildButton(buttonName);
                    buttonMap.put(buttonName, newButton);
            }
        }
    }
    
    private void populatePanel() {
        for (String buttonName : this.buttonMap.keySet()) {
            mainPanel.add(buttonMap.get(buttonName));
        }
    }
}
