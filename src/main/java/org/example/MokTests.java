package org.example;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MokTests {
    private Library library;

    @BeforeEach
    void setUp() {
        this.library = new Library();
    }

    @Test
    void testExportBooksToFile_withMockedWriter() throws IOException {
        Book book1 = new Book("Title1", "Author1");
        Book book2 = new Book("Title2", "Author2");
        this.library.addBook(book1);
        this.library.addBook(book2);
        FileWriter writer = (FileWriter)Mockito.mock(FileWriter.class);
        Library libSpy = (Library)Mockito.spy(this.library);
        ((FileWriter)Mockito.doNothing().when(writer)).write(Mockito.anyString());
        ((Library)Mockito.doReturn(writer).when(libSpy)).createBookFileWriter();
        libSpy.exportBooksToFile();
        ((FileWriter)Mockito.verify(writer, Mockito.atLeastOnce())).write(Mockito.anyString());
    }

    @Test
    void testImportBooksFromFile_withMockedReader() throws IOException {
        String mockData = "Book1;Author1;true\nBook2;Author2;false";
        BufferedReader reader = new BufferedReader(new StringReader(mockData));
        Library libSpy = (Library)Mockito.spy(this.library);
        ((Library)Mockito.doReturn(reader).when(libSpy)).createBookFileReader();
        libSpy.importBooksFromFile();
        List<Book> books = libSpy.getAllBooks();
        Assertions.assertEquals(2, books.size());
        Assertions.assertEquals("Book1", ((Book)books.get(0)).getTitle());
        Assertions.assertFalse(((Book)books.get(1)).isAvailable());
    }

    @Test
    void testImportReadersFromFile_withMockedReader() throws IOException {
        String mockData = "Женя;1\nВіка;2";
        BufferedReader reader = new BufferedReader(new StringReader(mockData));
        Library libSpy = (Library)Mockito.spy(this.library);
        ((Library)Mockito.doReturn(reader).when(libSpy)).createReaderFileReader();
        libSpy.importReadersFromFile();
        List<Reader> readers = libSpy.getAllReaders();
        Assertions.assertEquals(2, readers.size());
        Assertions.assertEquals("Женя", ((Reader)readers.get(0)).getName());
    }
}
