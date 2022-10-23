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
import hh.swd02.bookstore.domain.User;
import hh.swd02.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	// Database testing
//	@Bean
//	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
//		return (args) -> {
//			log.info("Delete existing books and categories")
//			crepository.deleteAll();
//			urepository.deleteAll();
	
//			log.info("Save some sample categories");
//			crepository.save(new Category("Crime"));
//			crepository.save(new Category("Fiction"));
//			crepository.save(new Category("Science"));
//			
////			log.info("Save some sample books");
//			repository.save(new Book("If It's Smart, It's Vulnerable", "Mikko Hyppönen", 2022, "9781119895183", 23.50, crepository.findByName("Science").get(0)));
//			repository.save(new Book("No Longer Human", "Osamu Dazai", 1973, "9780811204811", 16.80, crepository.findByName("Fiction").get(0)));
//			repository.save(new Book("Sheriffi", "Reijo Mäki", 2013, "9789511272298", 8.10, crepository.findByName("Crime").get(0)));
//			repository.save(new Book("Hotel California", "Reijo Mäki", 2022, "9789511433194", 24.95, crepository.findByName("Crime").get(0)));
//			
//			// Passwords are same as usernames
//			log.info("Save some users");
//			urepository.save(new User("user", "$2a$10$uMW1kWBCVkGI27catUr2HOu1.YN17RxmdmtN1yG3.K9JJRLECp7ya", "user@email.com", "USER"));
//			urepository.save(new User("admin", "$2a$10$vQ.l4pvcZIvCusDEmbvvKOgLkcuDO0cxt2kJsrNY0PCf0P36JgKM2", "admin@bookstore.com", "ADMIN"));
//		};
//	};

}
