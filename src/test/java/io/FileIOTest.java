package io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {

    @Test
    void testReadFile_validFile() {
        FileIO fileIO = new FileIO();
        int[] numbers = fileIO.readFile("src/test/resources/grades_valid.txt");
        assertArrayEquals(new int[]{3, 9, 0, 2, 10, 9, 3, 8, 0, 3}, numbers);
    }

    @Test
    void testReadFile_withInvalidNumbers() {
        FileIO fileIO = new FileIO();
        int[] numbers = fileIO.readFile("src/test/resources/grades_invalid.txt");
        assertArrayEquals(new int[]{3, 9, 2, 10, 8, 0, 3}, numbers);  // Skips invalid lines
    }

    @Test
    void testReadFile_emptyFile() {
        FileIO fileIO = new FileIO();
        assertThrows(IllegalArgumentException.class, () -> fileIO.readFile("src/test/resources/empty_file.txt"));
    }

    @Test
    void testReadFile_nonexistentFile() {
        FileIO fileIO = new FileIO();
        assertThrows(IllegalArgumentException.class, () -> fileIO.readFile("nonexistent.txt"));
    }
}
