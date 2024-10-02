package demo.streamDemo;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        streamFilterPredicated1();
        streamFilterChaining();
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
}
