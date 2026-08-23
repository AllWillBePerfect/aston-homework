package com.awbp.service;

import com.awbp.model.Book;
import com.awbp.model.Student;

import java.util.Comparator;
import java.util.List;

/**
 * Обрабатывает студентов и книги с помощью stream api.
 */
public class StudentService {

    public void findBookYear(List<Student> students) {
        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.books().stream())
                .sorted(Comparator.comparingInt(Book::pages))
                .distinct()
                .filter(book -> book.year() > 2000)
                .limit(3)
                .map(Book::year)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска: " + year),
                        () -> System.out.println("Книга отсутствует")
                );
    }
}
