package com.freddyzhounyc.databaseDemo;

import com.freddyzhounyc.databaseDemo.domain.Author;
import com.freddyzhounyc.databaseDemo.domain.Book;

public final class TestDataUtil {
    private TestDataUtil() {
    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author_id(1L)
                .build();
    }
}
