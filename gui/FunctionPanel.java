package gui;

import javax.swing.*;
import java.awt.*;

public class FunctionPanel {
    //-------------------- Vars
    private JPanel funcPanel;
    private JButton butPlus, butMinus, butTimes,
                    butDiv, butEq, butPlusMin,
                    butDel, butClr;
    


    //-------------------- Constructor

    public FunctionPanel() {

    }

    //-------------------- Getters & Seters

    public JPanel getFuncPanel() {
        return this.funcPanel;
    }

    public void setFuncPanel(JPanel funcPanel) {
        this.funcPanel = funcPanel;
    }
    //-------------------- Functionality

    //-------------------- Logic & Helpers
}
