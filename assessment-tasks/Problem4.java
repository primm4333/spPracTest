package tasks;
import java.util.*;

public class Problem4 {

    public static String largestNumber(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "0";
        }

        String[] strNums = new String[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            strNums[i] = String.valueOf(numbers.get(i));
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(50, 2, 1, 9);
        System.out.println("Largest formed number: " + largestNumber(list));
    }
}