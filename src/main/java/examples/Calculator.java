package examples;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public static boolean isTwoNumberConstantPartSame(double x, double y){
        if(Double.isNaN(x) || Double.isNaN(y)) {
            throw new IllegalArgumentException("X and Y must not be NaN.");
        }
        return (long) x == (long) y;
    }
}
