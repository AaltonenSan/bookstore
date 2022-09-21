package hh.swd02.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryid;
	
	private String name;
	
	// Constructors
	public Category(String name) {
		super();
		this.name = name;
	}
	public Category() {}
	
	// Setters
	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Getters
	public long getCategoryid() {
		return categoryid;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
}
