package com.order;

import org.springframework.stereotype.Component;

@Component
public class Book {

    private String title;
    private String author;
    private double price;

    public Book() {
        this.title = "Spring in Action";
        this.author = "Craig Walls";
        this.price = 45.99;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', price=" + price + "}";
    }
}
