package org.example.mvel;

import org.mvel2.MVEL;

import java.util.*;
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

}
