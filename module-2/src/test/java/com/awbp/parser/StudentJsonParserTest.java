package com.awbp.parser;

import com.awbp.model.Book;
import com.awbp.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentJsonParserTest {

    private final StudentJsonParser parser =
            new StudentJsonParser(new ObjectMapper());

    private final Path path =
            Path.of("src/test/resources/students.json");

    @Test
    void givenValidJson_whenParse_thenReturnsFiveStudents() throws IOException {
        List<Student> students = parser.parse(path);

        assertEquals(5, students.size());
    }

    @Test
    void givenValidJson_whenParse_thenEachStudentHasAtLeastFiveBooks() throws IOException {
        List<Student> students = parser.parse(path);

        assertTrue(
                students.stream()
                        .allMatch(student -> student.books().size() >= 5)
        );
    }

    @Test
    void givenValidJson_whenParse_thenBookFieldsAreParsedCorrectly() throws IOException {
        List<Student> students = parser.parse(path);

        Student student = students.getFirst();

        assertEquals("Иван Иванов", student.name());

        Book book = student.books().getFirst();

        assertEquals("Clean Code", book.title());
        assertEquals("Robert Martin", book.author());
        assertEquals(464, book.pages());
        assertEquals(2008, book.year());
    }

    @Test
    void givenBookWithInvalidYear_whenCreate_thenThrowsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Book(
                        "Clean Code",
                        "Robert Martin",
                        464,
                        0
                )
        );
    }

    @Test
    void givenBookWithInvalidPages_whenCreate_thenThrowsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Book(
                        "Clean Code",
                        "Robert Martin",
                        0,
                        2008
                )
        );
    }

    @Test
    void givenBookWithoutYear_whenCreate_thenThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> new Book(
                        "Clean Code",
                        "Robert Martin",
                        464,
                        null
                )
        );
    }

}