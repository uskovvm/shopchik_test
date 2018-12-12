package shopchik.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import shopchik.domain.Category;
import shopchik.domain.Product;

public interface CategoryRepository extends Repository<Category, Long>{

	List<Category> findAll();
	
	Optional<Category> findById(long id);
	
	List<Category> findByNameContainsAllIgnoreCase(String namePart, Pageable pageRequest);
	
	List<Category> findByNameAndParentNameContainsAllIgnoreCase(String namePart, String parentNamePart, Pageable pageRequest);

	void deleteById(long id);

	Category save(Category category);
}
