package shopchik.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import shopchik.domain.Category;
import shopchik.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> findAll() {
		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	public List<Category> retriveCategoriesByPage(String name, Integer page, Integer size) {
		return categoryRepository.findByNameContainsAllIgnoreCase(name,
				PageRequest.of(page, size, Sort.Direction.ASC, "name"));
	}

	public List<Category> retriveCategoriesByPage(String name, String parentname, Integer page, Integer size) {
		return categoryRepository.findByNameAndParentNameContainsAllIgnoreCase(name,parentname,
				PageRequest.of(page, size, Sort.Direction.ASC, "name"));
	}

	public Optional<Category> findById(long id) {
		return categoryRepository.findById(id);
	}

	public void deleteById(long id) {
		categoryRepository.deleteById(id);
	}

	public Category save(Category category) {
		return categoryRepository.save(category);
	}
}
