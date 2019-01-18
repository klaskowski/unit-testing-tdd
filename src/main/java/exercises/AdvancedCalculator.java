package exercises;

import java.util.List;
import java.util.function.Function;

public class AdvancedCalculator {

    public int silnia(int x){ // TODO: wyrazić używając klasy IntStream oraz metod range i reduce
        if(x < 0){
            throw new IllegalArgumentException("Silnia jest policzalna tylko dla liczb dodatnich");
        }

        int wynik = 1;
        for (int i=1; i<=x; i++){
            wynik *= i;
        }

        return wynik;
    }

    public double potega(int podstawa, int wykladnik) {
//        double wynik = 1.0;
//        for(int i = 0; i < potega; i++) {
//            wynik *= podstawa;
//        }
//        return wynik;
        return Math.pow(podstawa, wykladnik);
    }

    public Function<Double, Double> funkcjaLiniowa(List<Double> ciagLiczb) {
        double b = ciagLiczb.get(0);
        double a = ciagLiczb.get(1) - ciagLiczb.get(0);
        return x -> a * x + b;
    }

}
