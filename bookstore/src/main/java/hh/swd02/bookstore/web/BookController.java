package hh.swd02.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd02.bookstore.domain.Book;
import hh.swd02.bookstore.domain.BookRepository;
import hh.swd02.bookstore.domain.CategoryRepository;

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
	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
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
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}
}
