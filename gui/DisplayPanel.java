package gui;
import javax.swing.*;
import java.awt.*;

public class DisplayPanel {
    //-------------------- Vars
    private JPanel dispPanel;
    private JTextField inputField;
    private JTextArea outputArea;
    private JScrollPane outputScroll;

    //-------------------- Constructors
    public DisplayPanel() {
        initPanel();
        createAndAddComponents();;
    }

    //-------------------- Getters & Setters
    public JPanel getDisplayPanel() {
        return this.dispPanel;
    }

    public void setDisplayPanel(JPanel dispPanel) {
        this.dispPanel = dispPanel;
    }

    public JTextField getInputField() {
        return this.inputField;
    }

    public void setInputField(JTextField inputField) {
        this.inputField = inputField;
    }

    public JTextArea getOutputArea() {
        return this.outputArea;
    }

    public void setOutputArea(JTextArea outputArea) { 
        this.outputArea = outputArea;
    }

    //-------------------- Functionality

    //-------------------- Logic & Helpers
    private void initPanel() {
        dispPanel = new JPanel();
        dispPanel.setLayout(new BoxLayout(dispPanel, BoxLayout.Y_AXIS));
    }

    private void createAndAddComponents() {
        // Text Field holds current input
        inputField = new JTextField(20);
        inputField.setEditable(false);
        inputField.setName("input");
        dispPanel.add(inputField);

        // Scrolling Output
        outputArea = new JTextArea(3,20);
        outputArea.setEditable(false);
        outputArea.setName("output");
        outputScroll = new JScrollPane(outputArea);
        dispPanel.add(outputScroll);
    }
}