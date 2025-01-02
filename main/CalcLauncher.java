package main;

import javax.swing.SwingUtilities;

import src.*;

public class CalcLauncher {
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            CalcApp newCalc = new CalcApp();
            newCalc.startApp();
        });

       
    }
}
