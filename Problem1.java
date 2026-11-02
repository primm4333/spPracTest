package tasks;
import java.util.*;

public class Problem1 {

    public static int sumWithForLoop(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static int sumWithWhileLoop(List<Integer> list) {
        int sum = 0;
        int i = 0;
        while (i < list.size()) {
            sum += list.get(i);
            i++;
        }
        return sum;
    }

    public static int sumWithRecursion(List<Integer> list) {
        return sumRecursiveHelper(list, 0);
    }

    private static int sumRecursiveHelper(List<Integer> list, int index) {
        if (index >= list.size()) {
            return 0;
        }
        return list.get(index) + sumRecursiveHelper(list, index + 1);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("For-loop sum: " + sumWithForLoop(numbers));
        System.out.println("While-loop sum: " + sumWithWhileLoop(numbers));
        System.out.println("Recursion sum: " + sumWithRecursion(numbers));
    }
}