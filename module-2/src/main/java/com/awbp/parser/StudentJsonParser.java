package com.awbp.parser;

import com.awbp.model.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Читает и парсит студентов из json файла.
 */
public class StudentJsonParser {

    private final ObjectMapper objectMapper;

    public StudentJsonParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Student> parse(Path path) throws IOException {
        try (InputStream inputStream = Files.newInputStream(path)) {
            return objectMapper.readValue(
                    inputStream,
                    new TypeReference<>() {
                    }
            );
        }
    }
}
