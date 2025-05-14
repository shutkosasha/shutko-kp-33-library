//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList();
    private List<Reader> readers = new ArrayList();
    private static final String BOOKS_FILE = "D:/Lab1/books.txt";
    private static final String READERS_FILE = "D:/Lab1/readers.txt";

    public void addBook(Book book) {
        this.books.add(book);
        this.exportBooksToFile();
    }

    public void addReader(Reader reader) {
        this.readers.add(reader);
        this.exportReadersToFile();
    }

    public List<Book> getAllBooks() {
        return this.books;
    }

    public List<Reader> getAllReaders() {
        return this.readers;
    }

    public boolean borrowBook(String title, String author) {
        for(Book book : this.books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && book.isAvailable()) {
                book.setAvailable(false);
                this.exportBooksToFile();
                return true;
            }
        }

        return false;
    }

    public boolean returnBook(String title, String author) {
        for(Book book : this.books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author) && !book.isAvailable()) {
                book.setAvailable(true);
                this.exportBooksToFile();
                return true;
            }
        }

        return false;
    }

    public void printLibraryInfo() {
        System.out.println("    Книги в бібліотеці    ");

        for(Book book : this.books) {
            System.out.println(book);
        }

        System.out.println("\n   Зареєстровані читачі    ");

        for(Reader reader : this.readers) {
            System.out.println(reader);
        }

    }

    public void exportBooksToFile() {
        List<Book> sortedBooks = new ArrayList(this.books);
        sortedBooks.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        try (FileWriter writer = this.createBookFileWriter()) {
            for(Book book : sortedBooks) {
                String var10001 = book.getTitle();
                writer.write(var10001 + ";" + book.getAuthor() + ";" + book.isAvailable() + "\n");
            }

            System.out.println("експорт книг завершено.");
        } catch (IOException e) {
            System.out.println("помилка при експорті книг: " + e.getMessage());
        }

    }

    public void exportReadersToFile() {
        List<Reader> sortedReaders = new ArrayList(this.readers);
        sortedReaders.sort(Comparator.comparing(Reader::getName, String.CASE_INSENSITIVE_ORDER));

        try (FileWriter writer = this.createReaderFileWriter()) {
            for(Reader reader : sortedReaders) {
                String var10001 = reader.getName();
                writer.write(var10001 + ";" + reader.getId() + "\n");
            }

            System.out.println("експорт читачів завершено.");
        } catch (IOException e) {
            System.out.println("помилка при експорті читачів: " + e.getMessage());
        }

    }

    public void importBooksFromFile() {
        this.books.clear();

        try (BufferedReader reader = this.createBookFileReader()) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String title = parts[0];
                    String author = parts[1];
                    boolean isAvailable = Boolean.parseBoolean(parts[2]);
                    Book book = new Book(title, author);
                    book.setAvailable(isAvailable);
                    this.books.add(book);
                }
            }

            System.out.println("імпорт книг завершено.");
        } catch (IOException e) {
            System.out.println("помилка при імпорті книг: " + e.getMessage());
        }

    }

    public void importReadersFromFile() {
        this.readers.clear();
        Reader.allReaderNames.clear();

        try (BufferedReader reader = this.createReaderFileReader()) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    String name = parts[0];
                    int id = Integer.parseInt(parts[1]);
                    Reader r = new Reader(name, id);
                    this.readers.add(r);
                }
            }

            System.out.println("Імпорт читачів завершено.");
        } catch (IOException e) {
            System.out.println("Помилка при імпорті читачів: " + e.getMessage());
        }

    }

    protected FileWriter createBookFileWriter() throws IOException {
        return new FileWriter("D:/Lab1/books.txt");
    }

    protected FileWriter createReaderFileWriter() throws IOException {
        return new FileWriter("D:/Lab1/readers.txt");
    }

    protected BufferedReader createBookFileReader() throws IOException {
        return new BufferedReader(new FileReader("D:/Lab1/books.txt"));
    }

    protected BufferedReader createReaderFileReader() throws IOException {
        return new BufferedReader(new FileReader("D:/Lab1/readers.txt"));
    }
}
