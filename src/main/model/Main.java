package uvg.hdt2;

import main.model.PostfixCalculator;

public class Main {
    public static void main(String[] args) {
        PostfixCalculator calculator = new PostfixCalculator();
        try {
            calculator.readFromFile("datos.txt");
            double result = calculator.evaluateExpression();
            System.out.println("Resultado: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
