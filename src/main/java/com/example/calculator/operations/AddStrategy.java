package com.example.calculator.operations;

import org.springframework.stereotype.Component;

@Component
public class AddStrategy implements OperationStrategy {
    @Override
    public Number execute(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
}