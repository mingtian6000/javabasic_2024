package org.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class DemoWithCustomObj {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("name", "Alice");
        context.setVariable("age", 30);

        String expression = "#name + ' is ' + #age"; // 使用 # 访问变量
        String result = parser.parseExpression(expression).getValue(context, String.class);
        System.out.println(result);

    }
}
