package newfeatures;

import java.util.function.Function;

public class FucntionalInterface {
    public static void main(String[] args) {
        Function<String, Integer> stringToLength = String::length;
        int length = stringToLength.apply("Hello");
        System.out.println(length);
    }
}
