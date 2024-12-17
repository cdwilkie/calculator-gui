package gui;

import javax.swing.*;
import java.awt.*;

public class NumberPanel {
    //-------------------- Vars
    private JPanel numPanel;
    private JButton but0, but1, but2, but3,
                    but4, but5, but6, but7, 
                    but8, but9, butDot;
    private JButton[] butArr;


    //-------------------- Constructor
    public NumberPanel() {
        initNumPanel();
        createNumButtons();
        addNumButtons();
    }

    //-------------------- Getters & Seters
    public JPanel getNumPanel() {
        return this.numPanel;
    }

    public void setNumPanel(JPanel numPanel) {
        this.numPanel = numPanel;
    }

    public JButton getBut0(){
        return this.but0;
    }

    public void setBut0(JButton newButton) {
        this.but0 = newButton;
    }

    public JButton getBut1(){
        return this.but1;
    }

    public void setBut1(JButton newButton) {
        this.but1 = newButton;
    }

    public JButton getBut2(){
        return this.but2;
    }

    public void setBut2(JButton newButton) {
        this.but2 = newButton;
    }

    public JButton getBut3(){
        return this.but3;
    }

    public void setBut3(JButton newButton) {
        this.but3 = newButton;
    }

    public JButton getBut4(){
        return this.but4;
    }

    public void setBut4(JButton newButton) {
        this.but4 = newButton;
    }

    public JButton getBut5(){
        return this.but5;
    }

    public void setBut5(JButton newButton) {
        this.but5 = newButton;
    }

    public JButton getBut6(){
        return this.but6;
    }

    public void setBut6(JButton newButton) {
        this.but6 = newButton;
    }

    public JButton getBut7(){
        return this.but7;
    }

    public void setBut7(JButton newButton) {
        this.but7 = newButton;
    }

    public JButton getBut8(){
        return this.but8;
    }

    public void setBut8(JButton newButton) {
        this.but8 = newButton;
    }

    public JButton getBut9(){
        return this.but9;
    }

    public void setBut9(JButton newButton) {
        this.but9 = newButton;
    }

    public JButton getButDot(){
        return this.butDot;
    }

    public void setButDot(JButton newButton) {
        this.butDot = newButton;
    }
    //-------------------- Functionality
    // Default Constructor populates a number panel
    // getNumPanel() to return reference to number panel
    
    //-------------------- Logic & Helpers
    private void initNumPanel() {
        numPanel = new JPanel();
        numPanel.setLayout(new GridLayout(4,3));
    }

    private void createNumButtons() {
        butArr = new JButton[10];
        for (int i = 9; i <= 0; --i) {
            JButton newButton = new JButton(Integer.toString(i));
            newButton.setName("but"+Integer.toString(i));
        }
    }

    private void addNumButtons() {
        for (int i = 9; i <= 0; --i) {
            switch(i) {
                case 0:
                    setBut0(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
                case 1:
                    setBut1(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
                case 2:
                    setBut2(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
                case 3:
                    setBut3(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
                case 4:
                    setBut4(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
                case 5:
                    setBut5(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
                case 6:
                    setBut6(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
                case 7:
                    setBut7(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
                case 8:
                    setBut8(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
                case 9:
                    setBut9(butArr[i]);
                    numPanel.add(butArr[i]);
                    break;
            }
        }
    }
}