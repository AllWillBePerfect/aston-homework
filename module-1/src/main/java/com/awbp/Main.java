package com.awbp;


import com.awbp.immutable.ImmutableBook;
import com.awbp.immutable.ImmutableBookRecord;
import com.awbp.mutable.Author;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        sampleFirst();
        sampleSecond();
    }

    /**
     * Пример с обычным классом [ImmutableBook]
     */
    static void sampleFirst() {
        Author author = new Author("Лев", "Толстой");
        List<String> genres = new ArrayList<>(
                List.of("Роман", "Классика")
        );

        ImmutableBook book = new ImmutableBook(
                "Война и мир",
                1869,
                author,
                genres
        );

        System.out.println(book);

        // Пытаемся изменить объекты, переданные в конструктор
        author.setFirstName("Иван");
        genres.add("Фантастика");

        System.out.println("После изменения исходных объектов:");
        System.out.println(book);

        // Пытаемся изменить Author, полученного из книги
        Author receivedAuthor = book.getAuthor();
        receivedAuthor.setFirstName("Александр");

        System.out.println("После изменения Author:");
        System.out.println(book);

    }

    /**
     * Пример с record классом [ImmutableBookRecord]
     */
    static void sampleSecond() {
        Author author = new Author("Лев", "Толстой");
        List<String> genres = new ArrayList<>(List.of("Роман", "Классика"));

        ImmutableBookRecord bookRecord = new ImmutableBookRecord(
                "Война и мир",
                1869,
                author,
                genres
        );

        System.out.println(bookRecord);

        // Изменяем исходные объекты
        author.setFirstName("Иван");
        genres.add("Фантастика");

        // Состояние record не изменилось
        System.out.println(bookRecord);

        // Изменяем копию автора
        bookRecord.author().setFirstName("Александр");

        // Состояние снова не изменилось
        System.out.println(bookRecord);
    }
}
