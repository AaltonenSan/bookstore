package hh.swd02.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	// Automatically generate id for new objects
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title, author, isbn;
	private Double price;
	private Integer year;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	@JsonIgnoreProperties("books")
	private Category category;
	
	// Constructors
	public Book(String title, String author, Integer year, String isbn, Double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	public Book() {}
	
	// Setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	// Getters
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Integer getYear() {
		return year;
	}
	public String getIsbn() {
		return isbn;
	}
	public Double getPrice() {
		return price;
	}
	public Category getCategory() {
		return category;
	}
	
	@Override
	public String toString() {
		if (this.category != null) {
			return "Book id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + ", category=" + this.getCategory() + "]";
		} else {
			return "Book id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price;
		}
	}
}
