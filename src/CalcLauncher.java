package src;

import javax.swing.SwingUtilities;

public class CalcLauncher {
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            CalcApp newCalc = new CalcApp();
            newCalc.startApp();
        });
    }
}
