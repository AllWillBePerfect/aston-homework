package com.awbp.immutable;


import com.awbp.mutable.Author;

import java.util.List;
import java.util.Objects;

public record ImmutableBookRecord(
        String title,
        int publicationYear,
        Author author,
        List<String> genres
) {

    public ImmutableBookRecord {
        Objects.requireNonNull(title);
        Objects.requireNonNull(author);
        Objects.requireNonNull(genres);

        author = new Author(author);
        genres = List.copyOf(genres);
    }

    @Override
    public Author author() {
        return new Author(author);
    }
}
