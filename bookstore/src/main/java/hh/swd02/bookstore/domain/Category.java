package hh.swd02.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private List<Book> books;
	
	// Constructors
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	// Setters
	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	// Getters
	public long getCategoryid() {
		return categoryid;
	}
	public String getName() {
		return name;
	}
	public List<Book> getBooks() {
		return books;
	}
	
	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
}
