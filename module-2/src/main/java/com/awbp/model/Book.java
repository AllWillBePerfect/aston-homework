package com.awbp.model;

import java.util.Objects;

/**
 * Модель книги.
 */
public record Book(
        String title,
        String author,
        Integer pages,
        Integer year
) {

    public Book {
        Objects.requireNonNull(title, "Название книги не указано");
        Objects.requireNonNull(author, "Автор книги не указан");
        Objects.requireNonNull(pages, "Количество страниц не указано");
        Objects.requireNonNull(year, "Год выпуска не указан");

        if (title.isBlank()) {
            throw new IllegalArgumentException(
                    "Название книги не может быть пустым"
            );
        }

        if (author.isBlank()) {
            throw new IllegalArgumentException(
                    "Автор книги не может быть пустым"
            );
        }

        if (pages <= 0) {
            throw new IllegalArgumentException(
                    "Количество страниц должно быть положительным"
            );
        }

        if (year <= 0) {
            throw new IllegalArgumentException(
                    "Год выпуска должен быть положительным"
            );
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                '}';
    }

}
