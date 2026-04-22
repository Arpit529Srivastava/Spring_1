package com.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("account1")
    public Account account1() {
        // Loan is configured as an inner bean - created inline, not as a separate @Bean
        Loan loan = new Loan("Home Loan", 500000.00);
        return new Account(1001, "Arpit Srivastava", 75000.00, loan);
    }

    @Bean("account2")
    public Account account2() {
        // Another inner Loan bean
        Loan loan = new Loan("Car Loan", 300000.00);
        return new Account(1002, "Rahul Sharma", 120000.00, loan);
    }

    @Bean("account3")
    public Account account3() {
        // Inner bean for education loan
        Loan loan = new Loan("Education Loan", 200000.00);
        return new Account(1003, "Priya Patel", 50000.00, loan);
    }
}
