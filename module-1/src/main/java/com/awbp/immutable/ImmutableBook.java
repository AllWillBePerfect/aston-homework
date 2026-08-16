package com.awbp.immutable;

import com.awbp.mutable.Author;

import java.util.List;
import java.util.Objects;

public final class ImmutableBook {

    private final String title;
    private final int publicationYear;
    private final Author author;
    private final List<String> genres;

    public ImmutableBook(
            String title,
            int publicationYear,
            Author author,
            List<String> genres
    ) {
        this.title = Objects.requireNonNull(title);
        this.publicationYear = publicationYear;
        this.author = new Author(
                Objects.requireNonNull(author)
        );
        this.genres = List.copyOf(
                Objects.requireNonNull(genres)
        );
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public Author getAuthor() {
        return new Author(author);
    }

    public List<String> getGenres() {
        return genres;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableBook that = (ImmutableBook) o;
        return publicationYear == that.publicationYear && Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(genres, that.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publicationYear, author, genres);
    }

    @Override
    public String toString() {
        return "ImmutableBook{" +
                "title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", author=" + author +
                ", genres=" + genres +
                '}';
    }
}