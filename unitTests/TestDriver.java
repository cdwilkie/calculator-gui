package unitTests;

public class TestDriver {

    // Textcolor Modifiers for Console Output
    // Example: System.out.println(RED + "This is red text" + RESET);
    public static final String GREEN = "\033[0;32m";
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[0;33m";

    public static void main(String[] args) {
        ModelTest mt = new ModelTest();
        mt.test();
    }
    
    
}
