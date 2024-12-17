import javax.swing.*;
import java.awt.*;
import gui.*;

public class CalcView {
    //-------------------- Vars
    private JPanel mainPanel;
    private NumberPanel numPanel;
    private FunctionPanel funcPanel;
    private DisplayPanel dispPanel;
    


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
        mainFrame.setSize(325,350);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initPanels() {
        this.funcPanel = new FunctionPanel();
        this.numPanel = new NumberPanel();
        this.dispPanel = new DisplayPanel();
    }

    private void createMainPanel() {
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }

    private void populatePanel() {
        JPanel panelUnit = null;
        panelUnit = dispPanel.getDisplayPanel();
        mainPanel.add(panelUnit);


        
        JPanel buttonGroup = new JPanel(new FlowLayout());
        panelUnit = numPanel.getNumPanel();
        buttonGroup.add(panelUnit);
        panelUnit = funcPanel.getFuncPanel();
        buttonGroup.add(panelUnit);
        mainPanel.add(buttonGroup);
        
    }
    
}
