package shopchik.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import shopchik.domain.Category;
import shopchik.repositories.CategoryRepository;
import shopchik.repositories.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryIntegrationTest {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	// write test cases here
	@Test
	public void testAddCategory() {
		// given
		Category category = new Category(Long.valueOf(3),"Пирожок","Оч. свежий");
		categoryRepository.save(category);

		Optional<Category> found = categoryRepository.findById(category.getId());

		// then
		Assert.assertSame(category.getName(), found.get().getName());
	}

	@Test
	public void testUpdateCategory() {
		// given
		Category category = categoryRepository.findById(Long.valueOf(3)).get();
		category.setName("Хлебобулочные продукты");
		categoryRepository.save(category);
		Category founded = categoryRepository.findById(category.getId()).get();
		
		// then
		Assert.assertSame(category.getName(), founded.getName());
	}

	@Test
	public void testDeleteCategory() {
		// given
		categoryRepository.deleteById(Long.valueOf(3));
		Optional<Category> optional = categoryRepository.findById(Long.valueOf(3));		
		// then
		Assert.assertTrue(optional.isPresent() == false);
	}

}
