package com.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.library")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public List<Book> bookList() {
        return List.of(
            new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction"),
            new Book("A Brief History of Time", "Stephen Hawking", "Science"),
            new Book("Sapiens", "Yuval Noah Harari", "History"),
            new Book("1984", "George Orwell", "Fiction"),
            new Book("The Selfish Gene", "Richard Dawkins", "Science")
        );
    }
}
