package hh.swd02.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd02.bookstore.domain.Category;
import hh.swd02.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test // Test save()-method by saving one Test category
	@Order(1)
	public void createCategory() {
		Category category = new Category("Test");
		repository.save(category);
		assertNotNull(category.getCategoryid());
	}
	
	@Test // Test search method
	@Order(2)
	public void findCategoryByName() {
		List<Category> categories = repository.findByName("Test");
		assertThat(categories).hasSize(1);
	}
	
	@Test // Test deleteById()-method by deleting Test category
	@Order(3)
	public void deleteCategory() {
		List<Category> categories = repository.findByName("Test");
		if (categories.size() < 1) {
			fail("Category not in repository");
		} else {
			repository.deleteById(categories.get(0).getCategoryid());
		}
		assertNotEquals(categories.size(), repository.findByName("Test").size());
	}
}
