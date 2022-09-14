package hh.swd02.bookstore;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd02.bookstore.domain.Book;
import hh.swd02.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	// Database testing
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			log.info("Create and insert test objects to database");
			repository.save(new Book("Kirja", "Kirjailija", 1990, "5124", 44.95));
			repository.save(new Book("Aku Ankka", "Don Rosa", 1986, "313", 20.00));
			repository.save(new Book("Vares", "Reijo Mäki", 2007, "5678", 14.99));
			
			
			log.info("Select * from book");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}

}
