package hh.swd02.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd02.bookstore.domain.Book;
import hh.swd02.bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
	@Test // Test save()-method by saving one Test book
	@Order(1)
	public void createNewBook() {
		Book book = new Book("Test", "Jii Unit", 2022, "9789511433194", 24.95, null);
		repository.save(book);
		assertNotNull(book.getId());
	}
	
	@Test // Test search methods
	@Order(2)
	public void findBookByAuthor() {
		List<Book> books = repository.findByTitle("Test");
		assertThat(books).hasSizeGreaterThanOrEqualTo(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Jii Unit");
	}

	@Test // Test deleteById()-method by deleting the Test book
	@Order(3)
	public void deleteBook() {
		List<Book> books = repository.findByTitle("Test");
		if (books.size() < 1) {
			fail("Book not in repository");
		} else {
			repository.deleteById(books.get(0).getId());
		}
		assertNotEquals(books.size(), repository.findByTitle("Test").size());
	}
	
}