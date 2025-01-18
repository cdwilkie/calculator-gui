package utils;
import javax.swing.*;

import src.gui.*;

import java.awt.*;
import java.text.*;

public class CalcView {
    //-------------------- Vars
    private JPanel mainPanel;
    private NumberPanel numPanel;
    private FunctionPanel funcPanel;
    private DisplayPanel dispPanel;

    // new
    private OperationsPanel opPanel;
    


    //-------------------- Constructor
    public CalcView() {
        createMainPanel();
        initPanels();
        populatePanel();
    }

    //-------------------- Getters & Seters
    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public NumberPanel getNumberPanel() {
        return this.numPanel;
    }

    public void setNumberPanel(NumberPanel numPanel) {
        this.numPanel = numPanel;
    }

    public FunctionPanel getFunctionPanel() {
        return this.funcPanel;
    }

    public void setFunctionPanel(FunctionPanel funcPanel) {
        this.funcPanel = funcPanel;
    }

    public DisplayPanel getDisplayPanel() {
        return this.dispPanel;
    }

    public void setDisplayPanel(DisplayPanel dispPanel) {
        this.dispPanel = dispPanel;
    }

    // new stuff
    public String numberFormat(double theResults) {
        DecimalFormat deciFormat = new DecimalFormat("#,##0.********************");
        String formattedResults = deciFormat.format(theResults);
        
        return formattedResults;
    }
    
    public OperationsPanel getOperationsPanel() {
        return this.opPanel;
    }

    public void setOperationsPanel(OperationsPanel opPanel) {
        this.opPanel = opPanel;
    }

    public String getInput() {
        return this.getDisplayPanel().getInputField().getText();
    }

    public void setInput(String currentInput) {
        this.getDisplayPanel().getInputField().setText(currentInput);
    }

    public String getOutput() {
        return this.getDisplayPanel().getOutputArea().getText();
    }

    public void setOutput(String currentOutput) {
        this.getDisplayPanel().getOutputArea().setText(currentOutput);
    }


    //-------------------- Functionality
    public void runDemo() {
        initFrame();
    }

    //-------------------- Logic & Helpers
    private void initFrame() {
        JFrame mainFrame = new JFrame("Calculator");
        mainFrame.setLayout(new FlowLayout());
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setSize(455,475);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initPanels() {
        this.funcPanel = new FunctionPanel();
        this.numPanel = new NumberPanel();
        this.dispPanel = new DisplayPanel();

        // new stuff
        this.opPanel = new OperationsPanel();

    }

    private void createMainPanel() {
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }

    /**
     * Helper function adds each panel component to the
     * main JPanel
     */
    private void populatePanel() {
        // Add the Display Panel
        mainPanel.add(dispPanel.getDisplayPanel());
        
        // Combine Buttons into one panel and Add
        JPanel buttonGroup = new JPanel(new FlowLayout());
        buttonGroup.add(numPanel.getNumPanel());
        buttonGroup.add(funcPanel.getFuncPanel());
        mainPanel.add(buttonGroup);
        
        // new stuff
        mainPanel.add(opPanel.getOpPanel());

    }
    
}
