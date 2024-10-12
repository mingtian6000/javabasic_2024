package org.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class DisableDangerousMethodsExample {
    public static void main(String[] args) {
        //String userInput = "2 + 3"; // 安全表达式
        String userInput = "(2 * 3 > 0) ? T(java.lang.Runtime).getRuntime().exec('calc') : 0";
        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();

        // 禁用访问某些类没没拦住？？
        context.setBeanResolver((context1, beanName) -> {
            System.out.println(beanName);
            if ("System".equals(beanName)) {
                throw new SecurityException("Access to System class is denied");
            }
            if ("Runtime".equals(beanName)) {
                throw new SecurityException("Access to Exec class is denied");
            }
            return null;
        });

        try {
            Object result = parser.parseExpression(userInput).getValue(context);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
