package com.account;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve Account 1
        Account account1 = context.getBean("account1", Account.class);
        System.out.println("Account 1 Details:");
        System.out.println("  Account Holder: " + account1.getAccountHolderName());
        System.out.println("  Balance: " + account1.getBalance());
        System.out.println("  Loan Type: " + account1.getLoan().getLoanType());
        System.out.println("  Loan Amount: " + account1.getLoan().getLoanAmount());

        // Retrieve Account 2
        Account account2 = context.getBean("account2", Account.class);
        System.out.println("\nAccount 2 Details:");
        System.out.println("  Account Holder: " + account2.getAccountHolderName());
        System.out.println("  Balance: " + account2.getBalance());
        System.out.println("  Loan Type: " + account2.getLoan().getLoanType());
        System.out.println("  Loan Amount: " + account2.getLoan().getLoanAmount());

        // Retrieve Account 3
        Account account3 = context.getBean("account3", Account.class);
        System.out.println("\nAccount 3 Details:");
        System.out.println("  Account Holder: " + account3.getAccountHolderName());
        System.out.println("  Balance: " + account3.getBalance());
        System.out.println("  Loan Type: " + account3.getLoan().getLoanType());
        System.out.println("  Loan Amount: " + account3.getLoan().getLoanAmount());

        context.close();
    }
}
