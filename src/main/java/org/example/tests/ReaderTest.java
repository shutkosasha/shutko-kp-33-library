package org.example.tests;

import org.example.Reader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReaderTest {
    @Test
    void testReaderCreation() {
        Reader reader = new Reader("Ivan", 1);
        Assertions.assertEquals("Ivan", reader.getName());
        Assertions.assertEquals(1, reader.getId());
    }

    @Test
    void testUpdateName() {
        Reader reader = new Reader("Oleh", 2);
        reader.updateName("Ma");
        Assertions.assertEquals("Ma", reader.getName());
    }

    @Test
    void testReaderInfo() {
        Reader reader = new Reader("Ana", 3);
        String info = reader.getReaderInfo();
        Assertions.assertTrue(info.contains("Ana"));
        Assertions.assertTrue(info.contains("3"));
    }
}
