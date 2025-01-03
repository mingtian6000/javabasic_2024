package newfeatures;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


class MethodReferenceExample {
    public static int stringLength(String s) {
        return s.length();
    }
    public static void showMeOptional(){
        Optional<String> optional = Optional.ofNullable(null);

        String result = optional
                .map(String::toUpperCase)
                .orElse("default value");

        System.out.println(result);
    }
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "world", "java");
        showMeOptional();
        strings.stream()
                .map(s -> s.length())
                .forEach(System.out::println);

        // below shows Method-reference
        strings.stream()
                .map(MethodReferenceExample::stringLength)
                .forEach(System.out::println);
    }
}
