package org.example.spel;
import org.example.entity.Person;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("3 + 5");
        Integer result = expression.getValue(Integer.class);
        System.out.println("Result of 3 + 5: " + result);
        String res = parser.parseExpression("5 > 3 ? 'Greater' : 'Smaller'").getValue(String.class);
        System.out.println("Result: " + res);
        // access attr
        Person person = new Person("Alice", 30, null);
        String name = parser.parseExpression("name").getValue(person, String.class);
        System.out.println("Person's name: " + name); // Output: Alice

        // access method
        Calculator calculator = new Calculator();
        Integer sum = parser.parseExpression("add(10, 20)").getValue(calculator, Integer.class);
        System.out.println("Sum: " + sum);

        // access collections
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String firstName = parser.parseExpression("![0]").getValue(names, String.class);
        List<String> filteredNames = parser.parseExpression("?[startsWith('A')]").getValue(names, List.class);
        System.out.println("Filtered names: " + filteredNames);
    }
}
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}