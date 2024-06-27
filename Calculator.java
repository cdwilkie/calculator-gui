import javax.swing.*;
import java.awt.*;


public class Calculator extends JPanel {
    // main panel
    // components of main calcualtor gui
    private NumbersPanel numbersPanel;
    //private OperationsPanel operationsPanel;
    //private DisplayPanel displayPanel;
    //private FunctionsPanel functionsPanel;

    public Calculator() {
        numbersPanel = new NumbersPanel();

        this.setLayout(new GridBagLayout());

        GridBagConstraints layoutConstraints = new GridBagConstraints();
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

        this.add(numbersPanel, layoutConstraints);
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
    }

}

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
    }

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
        
    }

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
    }

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
    }

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
    }

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
    }

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
    }

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
    }

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
    }
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
    }

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
    }

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
    }

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
    }
}
/* 
class OperationsPanel extends JPanel {

}

class DisplayPanel extends JPanel {

}

class FunctionsPanel extends JPanel {

}*/