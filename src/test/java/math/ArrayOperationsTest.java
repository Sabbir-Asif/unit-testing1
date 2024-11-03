package math;

import io.FileIO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArrayOperationsTest {

    @Test
    void testFindPrimesInFile_withPrimesAndNonPrimes() {
        FileIO fileIO = mock(FileIO.class);
        MyMath myMath = mock(MyMath.class);

        when(fileIO.readFile("testfile.txt")).thenReturn(new int[]{2, 3, 4, 5, 6});
        when(myMath.isPrime(2)).thenReturn(true);
        when(myMath.isPrime(3)).thenReturn(true);
        when(myMath.isPrime(4)).thenReturn(false);
        when(myMath.isPrime(5)).thenReturn(true);
        when(myMath.isPrime(6)).thenReturn(false);

        ArrayOperations arrayOperations = new ArrayOperations();
        int[] primes = arrayOperations.findPrimesInFile(fileIO, "testfile.txt", myMath);
        assertArrayEquals(new int[]{2, 3, 5}, primes);
    }

    @Test
    void testFindPrimesInFile_noPrimes() {
        FileIO fileIO = mock(FileIO.class);
        MyMath myMath = mock(MyMath.class);

        when(fileIO.readFile("testfile.txt")).thenReturn(new int[]{4, 6, 8});
        when(myMath.isPrime(anyInt())).thenReturn(false);

        ArrayOperations arrayOperations = new ArrayOperations();
        int[] primes = arrayOperations.findPrimesInFile(fileIO, "testfile.txt", myMath);
        assertArrayEquals(new int[]{}, primes);
    }
}
