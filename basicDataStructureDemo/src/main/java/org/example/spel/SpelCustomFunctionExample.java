package org.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelCustomFunctionExample {
    public static void main(String[] args) throws Exception {
        String expression = "customMax(a, b) + customMultiply(c, d)";

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        context.setVariable("a", 5);
        context.setVariable("b", 3);
        context.setVariable("c", 2);
        context.setVariable("d", 4);

        // Register custom functions
        context.registerFunction("customMax", CustomFunctions.class.getDeclaredMethod("max", int.class, int.class));
        context.registerFunction("customMultiply", CustomFunctions.class.getDeclaredMethod("multiply", int.class, int.class));

        try {
            Object result = parser.parseExpression(expression).getValue(context);
            System.out.println("Result: " + result); // Output: Result: 13 (5 + 8)
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }
}

// Helper class for custom functions
class CustomFunctions {
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}