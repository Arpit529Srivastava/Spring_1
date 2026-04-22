package com.order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the autowired Order bean
        Order order = context.getBean(Order.class);

        // Set quantity and print details
        order.setQuantity(3);
        System.out.println("Order Details:");
        System.out.println("  Book Title: " + order.getBook().getTitle());
        System.out.println("  Author: " + order.getBook().getAuthor());
        System.out.println("  Quantity: " + order.getQuantity());
        System.out.println("  Total Price: $" + String.format("%.2f", order.getTotalPrice()));

        // Update attributes dynamically
        order.getBook().setTitle("Clean Code");
        order.getBook().setAuthor("Robert Martin");
        order.getBook().setPrice(39.99);
        order.setQuantity(5);

        System.out.println("\nUpdated Order Details:");
        System.out.println("  Book Title: " + order.getBook().getTitle());
        System.out.println("  Author: " + order.getBook().getAuthor());
        System.out.println("  Quantity: " + order.getQuantity());
        System.out.println("  Total Price: $" + String.format("%.2f", order.getTotalPrice()));

        context.close();
    }
}
