package com.freddyzhounyc.databaseDemo.dao;

import com.freddyzhounyc.databaseDemo.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);
    Optional<Author> findOne(long authorId);
}
