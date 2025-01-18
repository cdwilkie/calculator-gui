package src;

import javax.swing.SwingUtilities;

import utils.CalcApp;

public class CalcLauncher {
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            CalcApp newCalc = new CalcApp();
            newCalc.startApp();
        });

       
    }
}
