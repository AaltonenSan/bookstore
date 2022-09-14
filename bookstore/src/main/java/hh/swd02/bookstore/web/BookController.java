package hh.swd02.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd02.bookstore.domain.BookRepository;

@Controller
public class BookController {
@Autowired
private BookRepository repository;

	@GetMapping("/index")
	public String getBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookstore";
	}
}
