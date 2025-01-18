package src.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

/**
 * <code>DisplayPanel</code> contains the components to 
 * create an input and output display. <p>
 * <code>DisplayPanel</code> utilizes a <code>JTextField</code>
 * to display user input and <code>JTextArea</code> to display
 * user output, all contained within a <code>JPanel</code>.<p>
 * Constructor will initliaze all components. The
 * display <code>JPanel</code> can be retrieved with a call to
 * <code>getDisplayPanel()</code>
 */
public class DisplayPanel {
    //-------------------- Vars
    private JPanel dispPanel;                   // Holds all components
    private JTextField inputField;
    private JTextArea outputArea;
    private JScrollPane outputScroll;           

    //-------------------- Constructors
    /**
     * Default constructor initliazes the <code>JPanel</code> and
     * components.
     */
    public DisplayPanel() {
        initPanel();
        createAndAddComponents();
    }//end DisplayPanel()

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
    /**
     * Initalizes and sets Layout of the <code>JPanel</code> that 
     * will hold the display components. 
     */
    private void initPanel() {
        dispPanel = new JPanel();
        dispPanel.setLayout(new BoxLayout(dispPanel, BoxLayout.Y_AXIS));
    }//end initPanel()

    /**
     * Helper function initializes the <code>JTextField</code> input
     * field and intiializes the <code>JTextArea</code> for ouput history.
     */
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
    }//end createAndAddComponents()
}//end DisplayPanel class