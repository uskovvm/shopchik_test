package shopchik.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import shopchik.domain.Category;
import shopchik.domain.Product;

public interface ProductRepository extends Repository<Product, Long>{

	List<Product> findAll();
	Optional<Product> findById(long id);
	List<Product> findByNameContainsAllIgnoreCase(String namePart, Pageable pageRequest);
	List<Product> findByNameAndCategoryNameContainsAllIgnoreCase(String namePart, String categoryNamePart, Pageable pageRequest);
	void deleteById(long id);
	Product save(Product product);
	List<Product> findByCategoryId(Long valueOf);
}

