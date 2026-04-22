package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {

    private Book book;
    private int quantity;

    @Autowired
    public Order(Book book) {
        this.book = book;
        this.quantity = 1;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return book.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Order{bookTitle='" + book.getTitle() +
               "', author='" + book.getAuthor() +
               "', quantity=" + quantity +
               ", totalPrice=" + String.format("%.2f", getTotalPrice()) + "}";
    }
}
