package com.freddyzhounyc.databaseDemo.repositories;

import com.freddyzhounyc.databaseDemo.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
