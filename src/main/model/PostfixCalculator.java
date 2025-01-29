package main.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PostfixCalculator implements IPostfixCalculator {
    private IStack<Double> stack;
    private String expression;

    public PostfixCalculator() {
        stack = new VectorStack<>();
    }

    @Override
    public void readFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            expression = br.readLine();
        }
    }

    @Override
    public double evaluateExpression() {
        StringTokenizer tokenizer = new StringTokenizer(expression);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.matches("\\d+")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":{  stack.push(a + b);}
                    case "-" : {stack.push(a - b);}
                    case "*" : { stack.push(a * b);}
                    case "/" : {
                        if (b == 0) throw new ArithmeticException("División por cero");
                        stack.push(a / b);
                    }
                    case "%" : {stack.push(a % b);}
                    default : {throw new IllegalArgumentException("Operador inválido: " + token);}
                }
            }
        }
        return stack.pop();
    }
}
