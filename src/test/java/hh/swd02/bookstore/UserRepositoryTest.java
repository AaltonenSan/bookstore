package hh.swd02.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd02.bookstore.domain.User;
import hh.swd02.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test // Test save()-method by saving test-user
	@Order(1)
	public void createUser() {
		User user = new User("test", "test", "test@test.com", "USER");
		repository.save(user);
		assertNotNull(user.getId());
	}
	
	@Test // Test search method
	@Order(2)
	public void findUserByUsername() {
		User user = repository.findByUsername("test");
		assertNotNull(user);
	}
	
	@Test // Test deleteById()-method by deleting test-user
	@Order(3)
	public void deleteUser() {
		User user = repository.findByUsername("test");
		if (user == null) {
			fail("User not in repository");
		} else {
			repository.deleteById(user.getId());
		}
		assertNull(repository.findByUsername("test"));
	}

}
