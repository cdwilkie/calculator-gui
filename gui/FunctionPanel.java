package gui;

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * <code>FunctionPanel</code> creates a GUI panel that
 * displays buttons for common arithmetic operations.<p>
 * <code>JButton</code>s are stored within a <code>HashMap</code>
 * to pair names and button objects together.<p>
 * <code>FunctionPanel</code> object initializes each component
 * and is contained within a <code>JPanel</code>. Function panel GUI
 * can be acesed with <code>getFuncPanel()</code>
 */
public class FunctionPanel {
    //-------------------- Vars
    private static final String[] buttonNames = { // Buttons placed in this order
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
    /**
     * Initializes <code>JPanel</code> and sets layout manager
     */
    private void initPanel() {
        funcPanel = new JPanel();
        funcPanel.setLayout(new GridLayout(5, 2));
    }//end initPanel()

    /**
     * Builds a <code>JButton</code> using arguments.
     * @param buttonName String containing desired button name
     * @return <code>JButton</code> using <code>buttonName</code>
     */
    private JButton buildButton (String buttonName) {
        JButton newButton = new JButton(buttonName);
        newButton.setActionCommand(buttonName);
        newButton.setName(buttonName);

        return newButton;
    }//end buildButton()

    /**
     * <code>populateMap()</code> iterates through the <code>String</code>array
     * of button names to style and create <code>JButtons</code> for each entry.<p>
     * Each <code>JButton</code> is then added to the <code>HashMap</code> of buttons
     */
    private void populateMap() {
        JButton newButton = null;
        for (String buttonName : buttonNames) {
            newButton = buildButton(buttonName);
            switch(buttonName) {
                case "butPlus":                 // Addition Button
                    newButton.setText("+");
                    break;
                case "butMinus":                // Subtraction Button
                    newButton.setText("-");
                    break;
                case "butTimes":                // Multiplication Button
                    // multiplcation x
                    newButton.setText("\u00D7");
                    break;
                case "butDiv":                  // Division Button
                    // the obelus
                    newButton.setText("\u00F7");
                    break;
                case "butEq":                   // Equals Button
                    newButton.setText("=");
                    break;
                case "butDel":                  // Backspace/Delete Button
                    // Delete arrow
                    newButton.setText("\u232B");
                    break;
                case "butClr":                  // Clear Button
                    newButton.setText("Clr");
                    break;
                case "butRP":                   // Right Parenthesis Button
                    newButton.setText(")");
                    break;
                case "butLP":                   // Left Parenthesis Button
                    newButton.setText("(");
                    break;
                      
            }//end switch(buttonName)
            buttonMap.put(buttonName, newButton);
        }//end for each buttonName
    }//end populateMap()

    /**
     * Iterates through <code>buttonNames</code> array
     * and adds each found button name to function <code>JPanel</code>
     */
    private void populatePanel() {
        for (String buttonName : buttonNames) {
            funcPanel.add(buttonMap.get(buttonName));
        }//end for
    }//end populatePanel()

}//end FunctionPanel class
