package com.awbp.model;

import java.util.List;
import java.util.Objects;

/**
 * Модель студента со списком книг.
 */
public record Student(String name, List<Book> books) {
    public Student {
        Objects.requireNonNull(name, "Имя студента не указано");
        Objects.requireNonNull(books, "Список книг не указан");

        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "Имя студента не может быть пустым"
            );
        }

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
