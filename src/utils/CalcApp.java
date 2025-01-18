package src.utils;

public class CalcApp {
    //-------------------- Vars
    private CalcModel calcModel;
    private CalcView calcGUI;
    private CalcController calcControl;
    
    //-------------------- Constructors
    public CalcApp() {
        calcModel = new CalcModel();
        calcGUI = new CalcView();
        calcControl = new CalcController(calcGUI, calcModel);
    }
    //-------------------- Getters & Setters

    //-------------------- Functionality
    public void startApp() {
        calcControl.getCalcView().runDemo();
    }

    //-------------------- Logic & Helpers

   
    
}