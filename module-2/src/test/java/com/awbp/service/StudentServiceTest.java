package com.awbp.service;

import com.awbp.model.Book;
import com.awbp.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentServiceTest {

    private final StudentService service = new StudentService();

    private final ByteArrayOutputStream output =
            new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void givenStudentsWithMatchingBooks_whenFindBookYear_thenPrintsBookYear() {
        List<Student> students = List.of(
                new Student(
                        "Иван",
                        List.of(
                                new Book("Book 1", "Author", 500, 2010),
                                new Book("Book 2", "Author", 300, 2020),
                                new Book("Book 3", "Author", 700, 2005)
                        )
                )
        );

        service.findBookYear(students);

        assertTrue(output.toString().contains("Год выпуска: 2020"));
    }

    @Test
    void givenStudentsWithoutMatchingBooks_whenFindBookYear_thenPrintsBookNotFound() {
        List<Student> students = List.of(
                new Student(
                        "Иван",
                        List.of(
                                new Book("Book 1", "Author", 500, 1990),
                                new Book("Book 2", "Author", 300, 2000),
                                new Book("Book 3", "Author", 700, 1995)
                        )
                )
        );

        service.findBookYear(students);

        assertTrue(output.toString().contains("Книга отсутствует"));
    }

    @Test
    void givenStudentsWithBooksOfDifferentPageCounts_whenFindBookYear_thenSelectsBookWithFewestPages() {
        List<Student> students = List.of(
                new Student(
                        "Иван",
                        List.of(
                                new Book("Large", "Author", 1000, 2010),
                                new Book("Small", "Author", 100, 2020)
                        )
                )
        );

        service.findBookYear(students);

        assertTrue(output.toString().contains("Год выпуска: 2020"));
    }

    @Test
    void givenStudentsWithDuplicateBooks_whenFindBookYear_thenIgnoresDuplicates() {
        Book duplicateBook =
                new Book("Book", "Author", 100, 2001);

        List<Student> students = List.of(
                new Student(
                        "Иван",
                        List.of(
                                duplicateBook,
                                new Book("Book 2", "Author", 200, 2002),
                                new Book("Book 3", "Author", 300, 2003)
                        )
                ),
                new Student(
                        "Петр",
                        List.of(duplicateBook)
                )
        );

        service.findBookYear(students);

        assertTrue(output.toString().contains("Год выпуска: 2001"));
    }
}