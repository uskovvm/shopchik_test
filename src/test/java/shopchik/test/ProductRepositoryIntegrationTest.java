package shopchik.test;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import shopchik.domain.Category;
import shopchik.domain.Product;
import shopchik.repositories.CategoryRepository;
import shopchik.repositories.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	// write test cases here
	@Test
	public void testAddProduct() {
		// given
		Product product = new Product(Long.valueOf(2),"Пирожок","Оч. свежий");
		productRepository.save(product);

		Optional<Product> found = productRepository.findById(product.getId());

		// then
		Assert.assertSame(product.getName(), found.get().getName());
	}

	@Test
	public void testUpdateProduct() {
		// given
		Product product = productRepository.findById(Long.valueOf(2)).get();
		product.setName("Молоко updated");
		productRepository.save(product);
		Product founded = productRepository.findById(product.getId()).get();
		
		// then
		Assert.assertSame(product.getName(), founded.getName());
	}

	@Test
	public void testDeleteProduct() {
		// given
		productRepository.deleteById(Long.valueOf(2));
		Optional<Product> optional = productRepository.findById(Long.valueOf(3));		
		// then
		Assert.assertTrue(optional.isPresent() == false);
	}

}
