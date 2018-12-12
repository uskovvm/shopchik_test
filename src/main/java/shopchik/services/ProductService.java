package shopchik.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import shopchik.domain.Category;
import shopchik.domain.Product;
import shopchik.repositories.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> findAll() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	public List<Product> retriveProductsByPage(String name, Integer page, Integer size) {
		return productRepository.findByNameContainsAllIgnoreCase(name,
				PageRequest.of(page, size, Sort.Direction.ASC, "name"));
	}

	public List<Product> retriveProductesByPage(String name, String categoryname, Integer page, Integer size) {
		return productRepository.findByNameAndCategoryNameContainsAllIgnoreCase(name,categoryname,
				PageRequest.of(page, size, Sort.Direction.ASC, "name"));	}

	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}

	public void deleteById(long id) {
		productRepository.deleteById(id);
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}



}
