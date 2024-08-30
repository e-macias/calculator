package com.example.calculator.operations;

import org.springframework.stereotype.Component;

@Component
public class DivideStrategy implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return num1.doubleValue() / num2.doubleValue();
    }
}