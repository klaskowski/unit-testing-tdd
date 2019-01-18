package examples;

public class Fibonacci {
    public int calculateFor(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        else return calculateFor(x-1) + calculateFor(x-2);
    }
}
