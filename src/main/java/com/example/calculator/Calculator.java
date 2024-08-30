package com.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.calculator.operations.Operation;
import com.example.calculator.operations.OperationStrategy;

import java.util.Map;

@Component
public class Calculator {

    private final Map<Operation, OperationStrategy> strategies;

    @Autowired
    public Calculator(Map<Operation, OperationStrategy> strategies) {
        this.strategies = strategies;
    }

    public Number calculate(Operation op, Number num1, Number num2) {
        OperationStrategy strategy = strategies.get(op);
        if (strategy == null) {
            throw new UnsupportedOperationException("Operation not supported: " + op);
        }
        return strategy.execute(num1, num2);
    }

    public Number chainOperations(Number initialValue, Map<Operation, Number> operations) {
        Number result = initialValue;
        for (Map.Entry<Operation, Number> entry : operations.entrySet()) {
            result = calculate(entry.getKey(), result, entry.getValue());
        }
        return result;
    }
}