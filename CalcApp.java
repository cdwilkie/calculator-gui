public class CalcApp {

    public static void main(String[] args) {
        CalcView testCalc = new CalcView();
        CalcModel testModel = new CalcModel();
        CalcController calcController = new CalcController(testCalc, testModel);
        calcController.getCalcView().runDemo();
    }
    
}
