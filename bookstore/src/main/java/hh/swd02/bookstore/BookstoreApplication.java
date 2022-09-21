package hh.swd02.bookstore;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd02.bookstore.domain.Book;
import hh.swd02.bookstore.domain.BookRepository;
import hh.swd02.bookstore.domain.Category;
import hh.swd02.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	// Database testing, remove spring.jpa.show-sql=true on application.properties to disable Hibernate logs
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Save some sample categories");
			crepository.save(new Category("Crime"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Science"));
			
			log.info("Save some sample books");
			repository.save(new Book("If It's Smart, It's Vulnerable", "Mikko Hyppönen", 2022, "9781119895183", 23.50));
			repository.save(new Book("No Longer Human", "Osamu Dazai", 1973, "9780811204811", 16.80));
			repository.save(new Book("Sheriffi", "Reijo Mäki", 2013, "9789511272298", 8.10));
			
			log.info("Fetch all the categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
			log.info("Fetch all the books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	};

}
