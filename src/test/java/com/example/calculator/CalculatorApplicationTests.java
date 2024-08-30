package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.example.calculator.operations.Operation;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.LinkedHashMap;

@SpringBootTest
@ContextConfiguration(classes = CalculatorConfig.class)
class CalculatorApplicationTests {

	@Autowired
    private Calculator calculator;

    @Test
    public void testBasicOperations() {
        assertEquals(5, calculator.calculate(Operation.ADD, 2, 3).doubleValue(), 0.001);
        assertEquals(-1, calculator.calculate(Operation.SUBTRACT, 2, 3).doubleValue(), 0.001);
        assertEquals(6, calculator.calculate(Operation.MULTIPLY, 2, 3).doubleValue(), 0.001);
        assertEquals(2, calculator.calculate(Operation.DIVIDE, 6, 3).doubleValue(), 0.001);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(Operation.DIVIDE, 1, 0));
    }

	@Test
    public void testChainOperation1() {
        Map<Operation, Number> operations = new LinkedHashMap<>();
        operations.put(Operation.ADD, 3);
        operations.put(Operation.MULTIPLY, 2.2);
        operations.put(Operation.SUBTRACT, 4);

        assertEquals(13.6, calculator.chainOperations(5, operations).doubleValue(), 0.001);
    }

    @Test
    public void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(null, 1, 1));
    }

}
