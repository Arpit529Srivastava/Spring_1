package com.gold;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        GoldRateInfo goldRateInfo = context.getBean(GoldRateInfo.class);

        // Display available gold rates
        goldRateInfo.displayRates();

        // Prompt user for input
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter carat value (18K/22K/24K): ");
        String caratValue = scanner.nextLine().trim();

        System.out.print("Enter weight in grams: ");
        double weight = scanner.nextDouble();

        // Calculate and display total price
        double totalPrice = goldRateInfo.calculateTotalPrice(caratValue, weight);

        if (totalPrice >= 0) {
            System.out.printf("%nTotal Gold Price for %.2f grams of %s gold: Rs.%.2f%n",
                    weight, caratValue, totalPrice);
        }

        scanner.close();
        context.close();
    }
}
