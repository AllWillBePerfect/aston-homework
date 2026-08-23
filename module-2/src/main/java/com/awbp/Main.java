package com.awbp;


import com.awbp.parser.StudentJsonParser;
import com.awbp.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        StudentJsonParser parser = new StudentJsonParser(new ObjectMapper());
        StudentService service = new StudentService();

        try {
            service.findBookYear(parser.parse(getStudentsPath()));
        } catch (IOException e) {
            System.err.println(
                    "Не удалось прочитать students.json: " + e.getMessage()
            );
        }
    }


    /**
     * @return Путь к файлу с данными.
     */
    private static Path getStudentsPath() {
        try {
            return Paths.get(
                    Objects.requireNonNull(
                            Main.class.getClassLoader()
                                    .getResource("students.json")
                    ).toURI()
            );
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Не удалось получить путь к students.json", e);
        }
    }
}