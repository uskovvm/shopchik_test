package shopchik.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable=true)
	@JsonBackReference
	private Category category;
	
	public Product() {
		super();
	}

	public Product(Long id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.description = passportNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
		
}
