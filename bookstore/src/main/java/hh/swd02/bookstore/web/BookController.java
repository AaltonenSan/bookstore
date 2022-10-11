package hh.swd02.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd02.bookstore.domain.Book;
import hh.swd02.bookstore.domain.BookRepository;
import hh.swd02.bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class BookController {
	
@Autowired
private BookRepository repository;
@Autowired
private CategoryRepository crepository;

	@GetMapping("/index")
	public String showIndex(Model model) {
		return "bookstore";
	}
	
	@GetMapping("/booklist")
	public String listBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	// REST to get all books
	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	//REST to get one book by id
	@GetMapping("/books/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}
	
	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@PreAuthorize(value="hasRole('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:/booklist";
	}
	
	@GetMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}
}
