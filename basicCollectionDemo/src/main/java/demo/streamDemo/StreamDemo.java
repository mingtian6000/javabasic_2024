package demo.streamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        streamFilterPredicated1();
        //streamSubGroup();
        uniqueSmallestNumber();
    }
    private static void streamFilterPredicated1(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Names starting with A: " + filteredNames);
    }
    private static void streamFilterChaining(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // Even numbers
                .filter(n -> n > 5)      // Greater than 5
                .collect(Collectors.toList());
        System.out.println("Filtered Numbers: " + filteredNumbers);
    }
    private static void streamFilterObjects(){

    }
    private static void streamSubGroup(){
        List<Integer> numbers = Arrays.asList(1, 1, 0, -3, -5);

        List<List<Integer>> sublists = new ArrayList<>();

        Stream.of(numbers)
                .flatMap(List::stream) // Flatten the list
                .collect(Collectors.groupingBy(
                        // Group by a custom key based on the conditions
                        n -> {
                            if (n > 0) return 1; // Positive group
                            if (n == 0) return 0; // Zero group
                            return -1; // Negative group
                        },
                        Collectors.toList()
                ))
                .forEach((key, value) -> {
                    if (!value.isEmpty()) {
                        sublists.add(value);
                    }
                });

        sublists.forEach(System.out::println);
    }

    private static void uniqueSmallestNumber(){
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 4, 2, 1, 3, 5);
        int n = 2; // Number of smallest unique elements to find
        List<Integer> smallestUniqueNumbers = numbers.stream()
                .distinct()
                .sorted()
                .limit(n)
                .collect(Collectors.toList());

        System.out.println("Smallest " + n + " unique numbers: " + smallestUniqueNumbers);
    }
}
