package com.example.calculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.calculator.operations.AddStrategy;
import com.example.calculator.operations.DivideStrategy;
import com.example.calculator.operations.MultiplyStrategy;
import com.example.calculator.operations.Operation;
import com.example.calculator.operations.OperationStrategy;
import com.example.calculator.operations.SubtractStrategy;

import java.util.EnumMap;
import java.util.Map;

@Configuration
@ComponentScan("com.example.calculator")
public class CalculatorConfig {

    @Bean
    public Map<Operation, OperationStrategy> operationStrategies(
            AddStrategy addStrategy,
            SubtractStrategy subtractStrategy,
            MultiplyStrategy multiplyStrategy,
            DivideStrategy divideStrategy) {
        Map<Operation, OperationStrategy> strategies = new EnumMap<>(Operation.class);
        strategies.put(Operation.ADD, addStrategy);
        strategies.put(Operation.SUBTRACT, subtractStrategy);
        strategies.put(Operation.MULTIPLY, multiplyStrategy);
        strategies.put(Operation.DIVIDE, divideStrategy);
        return strategies;
    }
}