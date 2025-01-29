package main.model;

import java.io.IOException;


public interface ICalculator {

    void readFromFile(String path) throws IOException;

    double evaluateExpression() throws IllegalArgumentException;
}
