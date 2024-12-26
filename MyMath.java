import java.util.*;
/**
 * MyMath reimplements a portion of functionality
 * of the Java Math class {@link java.lang.Math}<p>
 * Functions include
 * @see java.lang.Math
 */
public class MyMath {
    /**Pi representation for MyMath class */
    static final double PI = 3.141592653589793d;
    static final double RADIANS_IN_DEGREE = PI / 180; //One Radian
    static final double DEGREES_IN_RADIAN = 180 / PI; //One Degree

    /**
     * toDegrees() takes a double value representing an angle
     * expressed in radians and returns that same angle's representation
     * in degrees.<p>Calculated using ratio 360 degrees = 2 * pi radians,
     * where pi has value {@value #PI}.
     * @param angleRadians Double value representing angle in radians
     * @return Double primitive value of angle expressed in degrees
     */
    public static double toDegrees(double angleRadians) {
        return DEGREES_IN_RADIAN * angleRadians;
    }//end toDegrees()

    /**
     * toRadians() accepts a double representing the measured degrees
     * of an angle. Value is converted into radians using the ratio:<p>
     * 360 degrees = 2 * pi radians<p>Where pi is represented as {@value #PI}
     * @param angleDegree Primitive double that represents the degrees of an angle
     * @return Primitive double that represents the radians of converted degrees.
     */
    public static double toRadians(double angleDegree) {
        return RADIANS_IN_DEGREE * angleDegree;
    }//end toRadians()

    /**
     * absoluteValue() accepts as input a double that represents
     * any arbitrary value. The absolute value is returned as a double.
     * @param inputValue Double primitive representing any arbitrary value
     * @return Double primitive representing the absolute value of the input.
     */
    public static double absoluteValue(double inputValue) {
        if (inputValue < 0) {
            return inputValue * (-1);
        }//end if value negative
        else {
            return inputValue;
        }//end else absolute = input
    }//end absoluteValue()

    /**
     * minium() accepts as parameters two arbitrary double values and then
     * returns the smaller value of the two as a double. If the values are the
     * same, the first parameter is returned.
     * @param inputValue1 Primative double representing any arbitrary value
     * @param inputValue2 Primative double representing any arbitrary value
     * @return Primative double that is the minium of the passed parameters.
     */
    public static double minimum(double inputValue1, double inputValue2) {
        if (inputValue1 <= inputValue2) {
            return inputValue1;
        }//end if inputValue1 Smallest
        else {
            return inputValue2;
        }//end else inputValue2 smallest
    }//end minimum()

    /**
     * maximum() accepts any two arbitrary double values and returns the
     * larger value of the two, as a double. If the values are the same,
     * the first parameter is returned.
     * @param inputValue1 Primative double representing any arbitrary value
     * @param inputValue2 Any arbitrary double value.
     * @return Maximum value of two passed parameters, as a double.
     */
    public static double maximum(double inputValue1, double inputValue2) {
        if (inputValue1 >= inputValue2) {
            return inputValue1;
        }//end if inputValue 1 max
        else {
            return inputValue2;
        }//end else inputValue2 max
    }//end maximum()

    /**
     * power() accepts a baseInput double and an int
     * xponenetInput to calculate the exponential value of 
     * the base raised to the exponent. 
     * @param baseInput Primative double representing the base of an
     * exponential calculation
     * @param exponentInput Primative int representing the 
     * exponent in an exponential calculation
     * @return Primative double representing the calculated exponential
     * value of the baseInput and exponentInput.
     */
    public static double power(double baseInput, int exponentInput) {
        double powerResults = 1;
        //a^0 = 1
        //a^1 = a
        //loop through to calculate results
        // a^b. for loop 0 -> size
        //TODO: Implement faster algorithm
        /*
         * while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= currentBase;
            }
            currentBase *= currentBase;
            exponent /= 2;
        }
         */
        for (int i = 1; i <= absoluteValue(exponentInput); ++i) {
            powerResults *= baseInput;
        }//for iterating to exponentInput
        if (exponentInput >= 0) {
            return powerResults;
        }//if exponent is positive
        else {
            return (1 / powerResults);
        }//else exponent negative
    }//end power()

    /**
     * root() accepts a double radicandInput and an int
     * rootInput to determin the root of the radicand.
     * Recursively calculates probable root using
     * Newton's Method
     * <p>Utilizes {@link #newtonsRecursion(double, int, double)} helper
     * to calculate the estimated root value.
     * @param radicandInput Primitive double that holds the base radicand
     * @param rootInput Primitive int that holds the root value
     * @return Primitive double holding the root solution
     */
    public static double root(double radicandInput, int rootInput) {
        //g' = g(1) -  ((g(1) ^ root) - radicand  /  rootInput * g(1) ^ (rootInput - 1)))
        double initialGuess = 1;
        double estimatedRoot = newtonsRecursion(radicandInput, rootInput, initialGuess);
        return estimatedRoot;
    }//end root()

    /**
     * newtonsRecursion drives the recursion in implementing
     * Newton's Method to estimate root values.<p>Calls Helper methods
     * {@link #newtonsHelper(double, int, double)} and {@link #newtonsChecker(double, double)}
     * @param radicandInput Primitive double holding base radicand value
     * @param rootInput Primitive int holding root index value
     * @param currentGuess Primitive double holding current estimated root
     * @return Primitive double holding the current esitmated root
     */
    private static double newtonsRecursion(double radicandInput, int rootInput, double currentGuess) {
        double estimatedRoot = newtonsHelper(radicandInput, rootInput, currentGuess);
        boolean rootFound = newtonsChecker(currentGuess, estimatedRoot);
        if (rootFound) {
            return estimatedRoot;
        }//if root found
        else {
            return newtonsRecursion(radicandInput, rootInput, estimatedRoot);
        }//else root not found - recurse
    }//end newtonsRecursion()

    /**
     * newtonsHelper() performs the essential calculation to implement 
     * Newton's Method. Calculates the number for the sequence of convergence
     * to determine the value of the desired root.
     * @param radicandInput Primitive double value holding base radicand
     * @param rootInput Primitive int value holding root index
     * @param currentGuess Primitive double value holding the current guess for root
     * @return Primitive double holding the calculated guess for the root
     */
    private static double newtonsHelper(double radicandInput, int rootInput, double currentGuess) {
        double topNumber, bottomNumber, calculatedGuess;
        topNumber = power(currentGuess, rootInput) - radicandInput;
        bottomNumber = rootInput * power(currentGuess, (rootInput - 1));
        calculatedGuess = currentGuess - (topNumber / bottomNumber);
        return calculatedGuess;
    }//end newtonsHelper()

    /**
     * newtonsChecker() performs the boolean check to determine
     * if the estimated root is significantly close to the
     * current guess.
     * @param currentGuess Primitive double that holds the current root guess
     * @param estimatedRoot Primitive double that holds the current
     * calculated root estimate
     * @return Boolean whether estimatedRoot is significantly close to
     * currentGuess
     */
    private static boolean newtonsChecker(double currentGuess, double estimatedRoot) {
        if (absoluteValue(estimatedRoot - currentGuess) < power(10, -10)){
            return true;
        }//end if estimated root likely
        else {
            return false;
        }//end else estimated root unlikely
    }//end newtonsChecker()

    /**
     * gcd() accepts two arbitrary int values to determine
     * the greatest common divisor.<p>If one parameter is zero,
     * other parameter is returned. Recursively calculates
     * the gcd(value2, value1%value2)
     * @param value1 Primitive int holding arbitrary value
     * @param value2 Primitive int holding arbitrary value
     * @return Primitive int holding greatest common divisor
     */
    public static int gcd(int value1, int value2) {
        if (value2 == 0){
            return value1;
        }//end if value1 is gcd
        else if (value1 == 0) {
            return value2;
        }//end elses if value2 is gcd
        else {
            return gcd(value2, value1 % value2);
        }//else recurse
    }//end gcd()

    /**
     * lcm() method accepts two ints representing any arbitrary
     * value. Calculates the least common multiple my determining the
     * greatest common divisor of the two values and then dividing the
     * product of value1 and value2 by the gcd.
     * @see #gcd(int, int)
     * @param value1 Primitive int that represents any arbitrary value
     * @param value2 Primative int that represents any arbritrary value
     * @return primitive int representing the calculated least common
     * multiple of value1 and value2.
     */
    public static int lcm(int value1, int value2) {
        //lcm(a,b) = (ab)/(gcd(a,b));
        return ((value1 * value2) / gcd(value1, value2));
    }//end lcm()

    /**
     * sine() accepts a primitive double value representing amount of
     * radians in some angle. If the value is between -{@value #PI}
     * and {@value #PI}, the sine value is approximated through
     * summation.
     * @see #sineHelper(double)
     * @param angleRadians Primitive double value represnting an angle in radians
     * @return Primitive double representing the approximate sine value
     */
    public static double sine(double angleRadians) {
        // angleRadians must be between -PI_CONSTANT and PI_CONSTANT
        while (angleRadians < -PI) {
            angleRadians += (2 * PI);
        }//while angleRadians too small
        while (angleRadians > PI) {
            angleRadians -= (2 * PI);
        }//while angleRadians too large

        double sineValue = sineHelper(angleRadians);
        return sineValue;
    }//end sine()

    /**
     * sineHelper() accepts a primitive double value angleRadians
     * and calculates the summation to obtain the approximate
     * sine value of the angleRadians parameter.
     * @param angleRadians Primitive double representing an angle in radians
     * @return Primitive double representing the approximate sine value
     */
    private static double sineHelper(double angleRadians) {
        double currentTerm = angleRadians;
        ArrayList<Double> sineSum = new ArrayList<Double>();
        int counter = 0;
        sineSum.add(currentTerm);
        while (absoluteValue(currentTerm) > power(10, -10)) {
            double nextTerm = currentTerm * ((-(power(angleRadians,2))) / (((2 * counter) + 3) * ((2 * counter) + 2)));
            sineSum.add(nextTerm);
            currentTerm = nextTerm;
            counter++;
        }
        double sineValue = sineHelperCalc(sineSum);
        return sineValue;
    
        /* 
        double currentTerm, nextTerm, totalSum;
        double denomNum;
        int counter = 0;
        currentTerm = nextTerm = angleRadians;
        totalSum = angleRadians;
        while (absoluteValue(nextTerm) > power(10, -10)) {
            denomNum = ((2 * counter) + 3) * ((2 * counter) + 2);
            nextTerm = (currentTerm) * ((-power(angleRadians,2)) / denomNum); 
            totalSum += nextTerm;
            currentTerm = nextTerm;
            counter++;
        }//while final term too large
        return totalSum;
        */
    }//end sineHelper()

    private static double sineHelperCalc(ArrayList<Double> sineSumation) {
        double sineValue = 0;
        for (Double value : sineSumation ) {
            
            sineValue += value;
        }
        return sineValue;
    }    

    public static double cosine(double angleRadians) {
        
        // angleRadians must be between -PI_CONSTANT and PI_CONSTANT
        while (angleRadians < -PI) {
            angleRadians += (2 * PI);
        }//while angleRadians too small
        while (angleRadians > PI) {
            angleRadians -= (2 * PI);
        }//while angleRadians too large

        double cosineValue = cosineHelper(angleRadians);

        return cosineValue;

    }

    private static double cosineHelper(double angleRadians) {
        double currentTerm, nextTerm, totalSum;
        double denomNum;
        int counter = 0;
        currentTerm = nextTerm = 1;
        totalSum = 1;
        while (absoluteValue(nextTerm) > power(10, -10)) {
            denomNum = ((2 * counter) + 2) * ((2 * counter) + 1);
            nextTerm = (currentTerm) * ((-power(angleRadians,2)) / denomNum); 
            totalSum += nextTerm;
            currentTerm = nextTerm;
            counter++;
        }//while final term too large
        return totalSum;
    }

    /**
     * tangent() accepts a double primitive value representing
     * an angle in radians. Calculates the tangent ratio of the sine()
     * and cosine() values for the angle in radians. Returns
     * the calculated ratio result
     * @param angleRadians Primitive double representing an angle in radians
     * @return Primitive double represnting the tangent of the angle.
     */
    public static double tangent(double angleRadians) {
        double tangentValue = sine(angleRadians) / cosine(angleRadians);
        return tangentValue;
    }//end tangent()

    public static double factorial(double inputNumber) {
        double theResult = 1;
        for (int i = (int)inputNumber; i > 0; --i) {
            theResult *= i;
        }

        return theResult;
    }
}//end MyMath