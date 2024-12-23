package gui;

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class FunctionPanel {
    //-------------------- Vars
    private static final String[] buttonNames = {
        "butClr", "butDel", "butLP", "butRP",
        "butPlus", "butMinus", "butTimes",
        "butDiv", "butEq"};
    private HashMap<String, JButton> buttonMap;
    private JPanel funcPanel;

    //-------------------- Constructor
    public FunctionPanel() {
        buttonMap = new HashMap<String, JButton>();
        initPanel();
        populateMap();
        populatePanel();
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
        for (String buttonName : buttonNames) {
            funcPanel.add(buttonMap.get(buttonName));
        }
    }

}//end FunctionPanel class
