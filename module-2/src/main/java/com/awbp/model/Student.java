package com.awbp.model;

import java.util.List;

/**
 * Модель студента со списком книг.
 */
public record Student(String name, List<Book> books) {
    public Student {
        books = List.copyOf(books);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
