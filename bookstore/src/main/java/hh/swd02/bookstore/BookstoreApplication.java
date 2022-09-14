package hh.swd02.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd02.bookstore.domain.Book;
import hh.swd02.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	// Database testing
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			// Test data
			Book test1 = new Book("Kirja", "Kirjailija", 1990, "5124", 44.95);
			Book test2 = new Book("Aku Ankka", "Don Rosa", 1986, "313", 20.00);
			Book test3 = new Book("Vares", "Reijo Mäki", 2007, "5678", 14.99);
			
			// Insert test rows to database
			repository.save(test1);
			repository.save(test2);
			repository.save(test3);
			
			// Select * from book
			repository.findAll();
		};
		
	}

}
