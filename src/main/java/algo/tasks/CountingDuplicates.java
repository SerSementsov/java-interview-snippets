package algo.tasks;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

public class CountingDuplicates {
    public static void main(String[] args) {
        String text = "aaabbb1121";

        System.out.println(countDuplicates(text));
    }


    private static int countDuplicates(String text) {
        Map<Integer, Long> map = text.toLowerCase().chars()
                .boxed()
                .collect(Collectors.groupingBy(identity(), counting()));

        return (int) map.keySet().stream()
                .filter(i -> map.get(i) > 1)
                .count();
    }
}
