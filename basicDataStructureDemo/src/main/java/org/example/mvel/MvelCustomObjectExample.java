package org.example.mvel;

import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;

public class MvelCustomObjectExample {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        String expression = "person.introduce()";
        //again: you cannot use this..
        Map<String, Object> context = new HashMap<>();
        context.put("person", person);
        String introduction = (String) MVEL.eval(expression, context);
        System.out.println(introduction); // Output: Hello, my name is Alice and I am 30 years old.
    }

    private static void customObjectWithParams(String param, Person person) {
        //suppose you get params somewhere, just simple put it in expression..
        String expression = "person.introduce(" + param + ")";
        Map<String, Object> context = new HashMap<>();
        context.put("person", person);
        String introduction = (String) MVEL.eval(expression, context);
        System.out.println(introduction);
    }
}
