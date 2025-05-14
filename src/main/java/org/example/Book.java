package org.example;

import java.util.List;

public class Book {
    private String title;
    private String author;
    private boolean isAvailable = true;
    private static int numOfBooks = 0;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        ++numOfBooks;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void markAsBorrowed() {
        this.isAvailable = false;
    }

    public void markAsReturned() {
        this.isAvailable = true;
    }

    public boolean isBorrowed() {
        return !this.isAvailable;
    }

    public static int countAvailableBooks(List<Book> bookList) {
        int count = 0;

        for(Book book : bookList) {
            if (book.isAvailable()) {
                ++count;
            }
        }

        return count;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Book)) {
            return false;
        } else {
            Book book = (Book)o;
            return this.title.equals(book.title) && this.author.equals(book.author);
        }
    }

    public int hashCode() {
        return this.title.hashCode() + this.author.hashCode();
    }

    public String toString() {
        return this.title + " by " + this.author + (this.isAvailable ? " (Available)" : " (NOT Available)");
    }
}
