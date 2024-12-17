package old;
import javax.swing.*;
import java.awt.*;


public class Calculator extends JPanel {
    // main panel
    // components of main calcualtor gui
    private NumbersPanel numbersPanel;
    private OperationsPanel operationsPanel;
    private DisplayPanel displayPanel;
    //private FunctionsPanel functionsPanel;

    public Calculator() {
        numbersPanel = new NumbersPanel();
        operationsPanel = new OperationsPanel();
        displayPanel = new DisplayPanel();

        this.setLayout(new GridBagLayout());

        GridBagConstraints layoutConstraints = new GridBagConstraints();
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 1;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(numbersPanel, layoutConstraints);

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(operationsPanel, layoutConstraints);

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 2;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(displayPanel, layoutConstraints);
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runDemo();
            }
        });
        
    }

    public static void runDemo() {
        JFrame mainFrame = new JFrame("Calculator");
        mainFrame.add(new Calculator());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setSize(new Dimension(425, 500));
        mainFrame.setMinimumSize(new Dimension(425, 500));
    }

}

/**
 * Creates a JPanel filled with JButtons labled 0-9
 * and the decimal.
 */
class NumbersPanel extends JPanel {
    private JButton num0, num1, num2, num3,
        num4, num5, num6, num7, num8, num9, decimalButton;

    public NumbersPanel() {
        this.num0 = new JButton("0");
        this.num1 = new JButton("1");
        this.num2 = new JButton("2");
        this.num3 = new JButton("3");
        this.num4 = new JButton("4");
        this.num5 = new JButton("5");
        this.num6 = new JButton("6");
        this.num7 = new JButton("7");
        this.num8 = new JButton("8");
        this.num9 = new JButton("9");
        this.decimalButton = new JButton(".");

        this.setLayout(new GridBagLayout());
        GridBagConstraints layoutConstraints = new GridBagConstraints();

        this.addButtons(layoutConstraints);
    }// end constructor

    private void addButtons(GridBagConstraints layoutConstraints) {
        this.addButtonSev(layoutConstraints);
        this.addButtonEight(layoutConstraints);
        this.addButtonNine(layoutConstraints);

        this.addButtonFour(layoutConstraints);
        this.addButtonFive(layoutConstraints);
        this.addButtonSix(layoutConstraints);

        this.addButtonOne(layoutConstraints);
        this.addButtonTwo(layoutConstraints);
        this.addButtonThree(layoutConstraints);

        this.addButtonZero(layoutConstraints);
        this.addDecimalButton(layoutConstraints);
    }// end addButtons()

    private void addButtonSev(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num7, layoutConstraints);
    }//end addButtonSev()

    private void addButtonEight(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num8, layoutConstraints);
    }//end addButtonEight()

    private void addButtonNine(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num9, layoutConstraints);
    }//end addButtonNine()

    private void addButtonFour(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num4, layoutConstraints);
    }//end addButtonFour()

    private void addButtonFive(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 1;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num5, layoutConstraints);
    }//end addButtonFive()

    private void addButtonSix(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 1;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num6, layoutConstraints);
    }//end addButtonSix()

    private void addButtonOne(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 2;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num1, layoutConstraints);
    }//end addButtonOne()

    private void addButtonTwo(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 2;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num2, layoutConstraints);
    }//end addButtonTwo()

    private void addButtonThree(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 2;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num3, layoutConstraints);
    }//end addButtonThree()

    private void addButtonZero(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 3;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 2;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(num0, layoutConstraints);
    }//end addButtonZero()

    private void addDecimalButton(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 3;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(decimalButton, layoutConstraints);
    }//end addDecimalButton()
}


/**
 * Creates a JPanel filled with JButtons labaled with
 * operators
 */
class OperationsPanel extends JPanel {

    private JButton plusButton, minusButton, divideButton, multButton,
        modButton, percentButton, factButton, plusMinusButton;

        public OperationsPanel() {
            plusButton = new JButton("+");
            minusButton = new JButton("-");
            divideButton = new JButton("/");
            multButton = new JButton("x");
            modButton = new JButton("mod");
            percentButton = new JButton("%");
            factButton = new JButton("!");
            plusMinusButton = new JButton("+/-");

            GridBagConstraints layoutConstraints = new GridBagConstraints();
            this.setLayout(new GridBagLayout());

            addPlusButton(layoutConstraints);
            addMinusButton(layoutConstraints);
            addDivideButton(layoutConstraints);
            addMultButton(layoutConstraints);
            addModButton(layoutConstraints);
            addPercentButton(layoutConstraints);
            addFactButton(layoutConstraints);
            addPlusMinusButton(layoutConstraints);
        }

        private void addPlusButton(GridBagConstraints layoutConstraints) {
            layoutConstraints.gridx = 0;
            layoutConstraints.gridy = 0;
            layoutConstraints.fill = GridBagConstraints.BOTH;
            layoutConstraints.anchor = GridBagConstraints.BASELINE;
            layoutConstraints.weightx = 1.0;
            layoutConstraints.weighty = 1.0;
            layoutConstraints.insets = new Insets(10, 10, 10, 10);
            layoutConstraints.gridheight = 1;
            layoutConstraints.gridwidth = 1;
            layoutConstraints.ipadx = 0;
            layoutConstraints.ipady = 0;  

            this.add(plusButton, layoutConstraints);
        }//end addPlusButton()

        private void addMinusButton(GridBagConstraints layoutConstraints) {
            layoutConstraints.gridx = 0;
            layoutConstraints.gridy = 1;
            layoutConstraints.fill = GridBagConstraints.BOTH;
            layoutConstraints.anchor = GridBagConstraints.BASELINE;
            layoutConstraints.weightx = 1.0;
            layoutConstraints.weighty = 1.0;
            layoutConstraints.insets = new Insets(10, 10, 10, 10);
            layoutConstraints.gridheight = 1;
            layoutConstraints.gridwidth = 1;
            layoutConstraints.ipadx = 0;
            layoutConstraints.ipady = 0;

            this.add(minusButton, layoutConstraints);
        }//end addMinusButton()

        private void addDivideButton(GridBagConstraints layoutConstraints) {
            layoutConstraints.gridx = 0;
            layoutConstraints.gridy = 2;
            layoutConstraints.fill = GridBagConstraints.BOTH;
            layoutConstraints.anchor = GridBagConstraints.BASELINE;
            layoutConstraints.weightx = 1.0;
            layoutConstraints.weighty = 1.0;
            layoutConstraints.insets = new Insets(10, 10, 10, 10);
            layoutConstraints.gridheight = 1;
            layoutConstraints.gridwidth = 1;
            layoutConstraints.ipadx = 0;
            layoutConstraints.ipady = 0;

            this.add(divideButton, layoutConstraints);
        }//end addDivideButton()

        private void addMultButton(GridBagConstraints layoutConstraints) {
            layoutConstraints.gridx = 0;
            layoutConstraints.gridy = 3;
            layoutConstraints.fill = GridBagConstraints.BOTH;
            layoutConstraints.anchor = GridBagConstraints.BASELINE;
            layoutConstraints.weightx = 1.0;
            layoutConstraints.weighty = 1.0;
            layoutConstraints.insets = new Insets(10, 10, 10, 10);
            layoutConstraints.gridheight = 1;
            layoutConstraints.gridwidth = 1;
            layoutConstraints.ipadx = 0;
            layoutConstraints.ipady = 0;

            this.add(multButton, layoutConstraints);
        }//end addMultButton()

        private void addModButton(GridBagConstraints layoutConstraints) {
            layoutConstraints.gridx = 1;
            layoutConstraints.gridy = 0;
            layoutConstraints.fill = GridBagConstraints.BOTH;
            layoutConstraints.anchor = GridBagConstraints.BASELINE;
            layoutConstraints.weightx = 1.0;
            layoutConstraints.weighty = 1.0;
            layoutConstraints.insets = new Insets(10, 10, 10, 10);
            layoutConstraints.gridheight = 1;
            layoutConstraints.gridwidth = 1;
            layoutConstraints.ipadx = 0;
            layoutConstraints.ipady = 0;

            this.add(modButton, layoutConstraints);
        }//end addModButton()

        private void addPercentButton(GridBagConstraints layoutConstraints) {
            layoutConstraints.gridx = 1;
            layoutConstraints.gridy = 1;
            layoutConstraints.fill = GridBagConstraints.BOTH;
            layoutConstraints.anchor = GridBagConstraints.BASELINE;
            layoutConstraints.weightx = 1.0;
            layoutConstraints.weighty = 1.0;
            layoutConstraints.insets = new Insets(10, 10, 10, 10);
            layoutConstraints.gridheight = 1;
            layoutConstraints.gridwidth = 1;
            layoutConstraints.ipadx = 0;
            layoutConstraints.ipady = 0;

            this.add(percentButton, layoutConstraints);
        }//end addPercentButton()

        private void addFactButton(GridBagConstraints layoutConstraints) {
            layoutConstraints.gridx = 1;
            layoutConstraints.gridy = 2;
            layoutConstraints.fill = GridBagConstraints.BOTH;
            layoutConstraints.anchor = GridBagConstraints.BASELINE;
            layoutConstraints.weightx = 1.0;
            layoutConstraints.weighty = 1.0;
            layoutConstraints.insets = new Insets(10, 10, 10, 10);
            layoutConstraints.gridheight = 1;
            layoutConstraints.gridwidth = 1;
            layoutConstraints.ipadx = 0;
            layoutConstraints.ipady = 0;

            this.add(factButton, layoutConstraints);
        }//end addFactButton()

        private void addPlusMinusButton(GridBagConstraints layoutConstraints) {
            layoutConstraints.gridx = 1;
            layoutConstraints.gridy = 3;
            layoutConstraints.fill = GridBagConstraints.BOTH;
            layoutConstraints.anchor = GridBagConstraints.BASELINE;
            layoutConstraints.weightx = 1.0;
            layoutConstraints.weighty = 1.0;
            layoutConstraints.insets = new Insets(10, 10, 10, 10);
            layoutConstraints.gridheight = 1;
            layoutConstraints.gridwidth = 1;
            layoutConstraints.ipadx = 0;
            layoutConstraints.ipady = 0;

            this.add(plusMinusButton, layoutConstraints);
        }//end addPlusMinusButton()
}//end OperationsPanel

/**
 * Creates a JPanel that holds a JTextPanel(Area?) that will
 * display the results of all calculations
 */
class DisplayPanel extends JPanel {
    private JTextArea displayBox;
    private JScrollPane scrollPane;
    private JTextField entryBox;

    DisplayPanel() {
        entryBox = new JTextField();
        entryBox.setBackground(new Color(42, 78, 69));
        entryBox.setForeground(Color.WHITE);
        entryBox.setFont(new Font("Arial", Font.BOLD, 18));

        displayBox = new JTextArea();
        displayBox.setBackground(new Color(42,78,69));
        displayBox.setForeground(Color.WHITE);
        
        displayBox.setFont(new Font("Arial", Font.BOLD, 24));
        //displayBox.setEditable(false);
        scrollPane = new JScrollPane(displayBox);

        this.setLayout(new GridLayout(2,1));
        
        this.add(scrollPane);
        this.add(entryBox);
        /* 
        GridBagConstraints layoutConstraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        addDisplayBox(layoutConstraints);
        addEntryBox(layoutConstraints);
        */
    }

    private void addDisplayBox(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(scrollPane, layoutConstraints);
    }

    private void addEntryBox(GridBagConstraints layoutConstraints) {
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;
        layoutConstraints.ipadx = 0;
        layoutConstraints.ipady = 0;

        this.add(entryBox, layoutConstraints);
    }

}

class FunctionsPanel extends JPanel {

}