package com.freddyzhounyc.databaseDemo.repositories;

import com.freddyzhounyc.databaseDemo.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
