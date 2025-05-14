package org.example.tests;

import org.example.Book;
import org.example.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LibraryTest {
    @Test
    void testAddAndGetBooks() {
        Library library = new Library();
        Book book = new Book("Test", "Author");
        library.addBook(book);
        Assertions.assertEquals(1, library.getAllBooks().size());
        Assertions.assertEquals(book, library.getAllBooks().get(0));
    }

    @Test
    void testBorrowBookSuccess() {
        Library library = new Library();
        library.addBook(new Book("Book1", "Author1"));
        boolean borrowed = library.borrowBook("Book1", "Author1");
        Assertions.assertTrue(borrowed);
        Assertions.assertFalse(((Book)library.getAllBooks().get(0)).isAvailable());
    }

    @Test
    void testReturnBookSuccess() {
        Library library = new Library();
        Book book = new Book("Book2", "Author2");
        book.markAsBorrowed();
        library.addBook(book);
        boolean returned = library.returnBook("Book2", "Author2");
        Assertions.assertTrue(returned);
        Assertions.assertTrue(book.isAvailable());
    }
}
