package math;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    @Test
    void testFactorial_validInputs() {
        MyMath myMath = new MyMath();
        assertEquals(1, myMath.factorial(0));
        assertEquals(1, myMath.factorial(1));
        assertEquals(120, myMath.factorial(5));
    }

    @Test
    void testFactorial_largeInput() {
        MyMath myMath = new MyMath();
        assertEquals(479001600, myMath.factorial(12));
    }

    @Test
    void testFactorial_invalidNegativeInput() {
        MyMath myMath = new MyMath();
        assertThrows(IllegalArgumentException.class, () -> myMath.factorial(-1));
    }

    @Test
    void testFactorial_invalidLargeInput() {
        MyMath myMath = new MyMath();
        assertThrows(IllegalArgumentException.class, () -> myMath.factorial(13));
    }

    @Test
    void testIsPrime_withPrimes() {
        MyMath myMath = new MyMath();
        assertTrue(myMath.isPrime(2));
        assertTrue(myMath.isPrime(3));
        assertTrue(myMath.isPrime(5));
        assertTrue(myMath.isPrime(13));
    }

    @Test
    void testIsPrime_withNonPrimes() {
        MyMath myMath = new MyMath();
        assertFalse(myMath.isPrime(4));
        assertFalse(myMath.isPrime(9));
        assertFalse(myMath.isPrime(15));
    }

    @Test
    void testIsPrime_invalidInput() {
        MyMath myMath = new MyMath();
        assertThrows(IllegalArgumentException.class, () -> myMath.isPrime(1));
    }
}
