package tasks;
import java.util.*;
import java.math.BigInteger;


public class Problem3 {

    public static List<BigInteger> getFirst100Fibonacci() {
        List<BigInteger> fibList = new ArrayList<>(100);

        fibList.add(BigInteger.ZERO);
        fibList.add(BigInteger.ONE); 

        for (int i = 2; i < 100; i++) {
            BigInteger nextFib = fibList.get(i - 1).add(fibList.get(i - 2));
            fibList.add(nextFib);
        }

        return fibList;
    }

    public static void main(String[] args) {
        List<BigInteger> result = getFirst100Fibonacci();
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + ": " + result.get(i));
        }
    }
}