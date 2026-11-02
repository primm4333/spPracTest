package tasks;
import java.util.*;

public class Problem2 {

    public static <T> List<T> combineAlternating(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        int maxLength = Math.max(list1.size(), list2.size());

        for (int i = 0; i < maxLength; i++) {
            if (i < list1.size()) {
                result.add(list1.get(i));
            }
            if (i < list2.size()) {
                result.add(list2.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Object> list1 = Arrays.asList("a", "b", "c");
        List<Object> list2 = Arrays.asList(1, 2, 3);

        List<Object> combined = combineAlternating(list1, list2);
        System.out.println("Combined list: " + combined);
    }
}