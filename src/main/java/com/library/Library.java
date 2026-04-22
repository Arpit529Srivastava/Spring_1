package com.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Library {

    private final List<Book> books;
    private final Map<String, Integer> categoryCount;

    @Autowired
    public Library(List<Book> books,
                   @Value("#{${library.categoryCount}}") Map<String, Integer> categoryCount) {
        this.books = books;
        this.categoryCount = new HashMap<>(categoryCount);
    }

    public int borrowBooks(String category, int count) {
        if (!categoryCount.containsKey(category)) {
            return -2; // Book category does not exist
        }
        int available = categoryCount.get(category);
        if (count > available) {
            return -1; // Requested number of books exceeds availability
        }
        categoryCount.put(category, available - count);
        return categoryCount.get(category);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Map<String, Integer> getCategoryCount() {
        return categoryCount;
    }
}
