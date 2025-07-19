package com.freddyzhounyc.databaseDemo.repositories;

import com.freddyzhounyc.databaseDemo.TestDataUtil;
//import com.freddyzhounyc.databaseDemo.dao.AuthorDao;
import com.freddyzhounyc.databaseDemo.domain.Author;
import com.freddyzhounyc.databaseDemo.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {
    private AuthorRepository authorRepository;
    private BookRepository underTest;

    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest, AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorRepository.save(author);
        Book book = TestDataUtil.createTestBookA(author);
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }
    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorRepository.save(author);

        Book bookA = TestDataUtil.createTestBookA(author);
        Book bookB = TestDataUtil.createTestBookB(author);
        Book bookC = TestDataUtil.createTestBookC(author);

        underTest.save(bookA);
        underTest.save(bookB);
        underTest.save(bookC);

        Iterable<Book> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(bookA, bookB, bookC);
    }
    @Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataUtil.createTestAuthorA();
        authorRepository.save(author);
        Book bookA = TestDataUtil.createTestBookA(author);
        underTest.save(bookA);

        bookA.setTitle("UPDATED");
        underTest.save(bookA);
        Optional<Book> result = underTest.findById(bookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookA);
    }
    @Test
    public void testThatBookCanBeDeleted() {
        Author author = TestDataUtil.createTestAuthorA();
        authorRepository.save(author);
        Book book = TestDataUtil.createTestBookA(author);
        underTest.save(book);

        underTest.deleteById(book.getIsbn());
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isEmpty();
    }
}
