package shopchik.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import shopchik.domain.Category;
import shopchik.domain.Product;
import shopchik.exceptions.CategoryNotFoundException;
import shopchik.exceptions.ProductNotFoundException;
import shopchik.repositories.ProductRepository;
import shopchik.services.CategoryService;
import shopchik.services.ProductService;

@RestController
public class AppController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;

	@GetMapping("/categories")
	public List<Category> retrieveAllCategories() {
		return categoryService.findAll();
	}
	
	@GetMapping("/category/{id}")
	public Category retrieveCategory(@PathVariable long id) {
		Optional<Category> category = categoryService.findById(id);

		if (!category.isPresent())
			throw new CategoryNotFoundException("id-" + id);

		return category.get();
	}

	@GetMapping("/categories/{name}/{page}/{size}")
	public List<Category> retriveCategoriesByPage(@PathVariable String name, @PathVariable Integer page,
			@PathVariable Integer size) {
		return categoryService.retriveCategoriesByPage(name, page, size);
	}

	@GetMapping("/categories/{name}/{parentname}/{page}/{size}")
	public List<Category> retriveCategoriesByPage(@PathVariable String name, @PathVariable String parentname, @PathVariable Integer page,
			@PathVariable Integer size) {
		List<Category> categories = categoryService.retriveCategoriesByPage(name,parentname, page, size);
		return categories;
	}

	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable long id) {
		categoryService.deleteById(id);
	}

	@PostMapping("/category")
	public ResponseEntity<Object> createCategory(@RequestBody Category category) {
		Category savedCategory = categoryService.save(category);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCategory.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/category/{id}")
	public ResponseEntity<Object> updateCategory(@RequestBody Category category, @PathVariable long id) {

		Optional<Category> categoryOptional = categoryService.findById(id);

		if (!categoryOptional.isPresent())
			return ResponseEntity.notFound().build();

		category.setId(id);

		categoryService.save(category);

		return ResponseEntity.noContent().build();
	}

//Product routes
	@GetMapping("/products")
	public List<Product> retrieveAllProducts() {
		return productService.findAll();
	}

	@GetMapping("/product/{id}")
	public Product retrieveProduct(@PathVariable long id) {
		Optional<Product> product = productService.findById(id);

		if (!product.isPresent())
			throw new ProductNotFoundException("id-" + id);

		return product.get();
	}

	@GetMapping("/products/{name}/{page}/{size}")
	public List<Product> retriveProductsByPage(@PathVariable String name, @PathVariable Integer page,
			@PathVariable Integer size) {
		return productService.retriveProductsByPage(name, page, size);
	}

	@GetMapping("/products/{name}/{categoryname}/{page}/{size}")
	public List<Product> retriveProductesByPage(@PathVariable String name, @PathVariable String categoryname, @PathVariable Integer page,
			@PathVariable Integer size) {
		List<Product> products = productService.retriveProductesByPage(name,categoryname, page, size);
		return products;
	}

	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteById(id);
	}

	@PostMapping("/product")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		Product savedProduct = productService.save(product);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable long id) {

		Optional<Product> productOptional = productService.findById(id);

		if (!productOptional.isPresent())
			return ResponseEntity.notFound().build();

		product.setId(id);

		productService.save(product);

		return ResponseEntity.noContent().build();
	}
}
