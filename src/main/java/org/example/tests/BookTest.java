package org.example.tests;

import java.util.ArrayList;
import java.util.List;
import org.example.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {
    @Test
    void testBookCreationAndAvailability() {
        Book book = new Book("ЦікаваКнига", "Віталік Бутерін");
        Assertions.assertTrue(book.isAvailable());
        Assertions.assertEquals("ЦікаваКнига", book.getTitle());
    }

    @Test
    void testMarkAsBorrowed() {
        Book book = new Book("Титан", "Арсенал");
        book.markAsBorrowed();
        Assertions.assertFalse(book.isAvailable());
    }

    @Test
    void testCountAvailableBooks() {
        List<Book> books = new ArrayList();
        books.add(new Book("Ничона", "Тичина"));
        books.add(new Book("Понеділок", "Тиждень"));
        Book borrowed = new Book("114", "Крістіна");
        borrowed.markAsBorrowed();
        books.add(borrowed);
        int count = Book.countAvailableBooks(books);
        Assertions.assertEquals(2, count);
    }
}
