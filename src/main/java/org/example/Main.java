package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        library.importBooksFromFile();
        library.importReadersFromFile();
        boolean running = true;

        while(running) {
            System.out.println("\n=== Меню Бібліотеки ===");
            System.out.println("1. Додати книгу");
            System.out.println("2. Додати читача");
            System.out.println("3. Взяти книгу");
            System.out.println("4. Повернути книгу");
            System.out.println("5. Переглянути інформацію про бібліотеку");
            System.out.println("6. Переглянути всіх читачів");
            System.out.println("7. Імпортувати книги та читачів з файлів");
            System.out.println("0. Вийти");
            System.out.print("Оберіть опцію: ");
            switch (scanner.nextLine()) {
                case "1":
                    System.out.print("Введіть назву книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введіть автора книги: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Книгу додано!");
                    break;
                case "2":
                    System.out.print("Введіть ім'я читача: ");
                    String name = scanner.nextLine();
                    System.out.print("Введіть ID читача: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    library.addReader(new Reader(name, id));
                    System.out.println("Читача додано!");
                    break;
                case "3":
                    System.out.print("Введіть назву книги для взяття: ");
                    String borrowTitle = scanner.nextLine();
                    System.out.print("Введіть автора книги: ");
                    String borrowAuthor = scanner.nextLine();
                    if (library.borrowBook(borrowTitle, borrowAuthor)) {
                        System.out.println("Книгу успішно взято.");
                    } else {
                        System.out.println("Книга недоступна або не знайдена.");
                    }
                    break;
                case "4":
                    System.out.print("Введіть назву книги для повернення: ");
                    String returnTitle = scanner.nextLine();
                    System.out.print("Введіть автора книги: ");
                    String returnAuthor = scanner.nextLine();
                    if (library.returnBook(returnTitle, returnAuthor)) {
                        System.out.println("Книгу успішно повернено.");
                    } else {
                        System.out.println("Книгу не знайдено або вона вже повернена.");
                    }
                    break;
                case "5":
                    library.printLibraryInfo();
                    break;
                case "6":
                    Reader.printAllReaderNames();
                    break;
                case "7":
                    library.importBooksFromFile();
                    library.importReadersFromFile();
                    System.out.println("Імпорт завершено.");
                    break;
                case "0":
                    running = false;
                    System.out.println("Завершення програми...");
                    break;
                default:
                    System.out.println("Невірна опція. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}
