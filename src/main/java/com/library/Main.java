package com.library;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Library library = context.getBean(Library.class);

        // Display all books
        System.out.println("Books in Library:");
        library.getBooks().forEach(b -> System.out.println("  - " + b));

        System.out.println("\nInitial Category Counts: " + library.getCategoryCount());

        // Borrow 3 Fiction books (should succeed, remaining = 7)
        int result1 = library.borrowBooks("Fiction", 3);
        System.out.println("\nBorrowing 3 Fiction books -> Remaining: " + result1);

        // Borrow 5 Science books (should succeed, remaining = 3)
        int result2 = library.borrowBooks("Science", 5);
        System.out.println("Borrowing 5 Science books -> Remaining: " + result2);

        // Borrow 20 History books (exceeds availability, error code -1)
        int result3 = library.borrowBooks("History", 20);
        System.out.println("Borrowing 20 History books -> Result: " + result3);

        // Borrow from non-existent category (error code -2)
        int result4 = library.borrowBooks("Poetry", 2);
        System.out.println("Borrowing 2 Poetry books -> Result: " + result4);

        System.out.println("\nFinal Category Counts: " + library.getCategoryCount());

        context.close();
    }
}
