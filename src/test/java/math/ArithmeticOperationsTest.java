package math;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    void testDivide_valid() {
        ArithmeticOperations operations = new ArithmeticOperations();
        assertEquals(2.0, operations.divide(10, 5));
    }

    @Test
    void testDivide_byZero() {
        ArithmeticOperations operations = new ArithmeticOperations();
        assertThrows(ArithmeticException.class, () -> operations.divide(10, 0));
    }

    @Test
    void testMultiply_positiveNumbers() {
        ArithmeticOperations operations = new ArithmeticOperations();
        assertEquals(20, operations.multiply(4, 5));
    }

    @Test
    void testMultiply_withZero() {
        ArithmeticOperations operations = new ArithmeticOperations();
        assertEquals(0, operations.multiply(5, 0));
    }

    @Test
    void testMultiply_largeNumbers() {
        ArithmeticOperations operations = new ArithmeticOperations();
        assertThrows(IllegalArgumentException.class, () -> operations.multiply(100000, 30000));  // Exceeds Integer.MAX_VALUE
    }

    @Test
    void testMultiply_negativeNumber() {
        ArithmeticOperations operations = new ArithmeticOperations();
        assertThrows(IllegalArgumentException.class, () -> operations.multiply(5, -2));
    }
}
