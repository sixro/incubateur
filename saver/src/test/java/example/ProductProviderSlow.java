package example;

import java.util.*;

import saver.CacheControl;

public class ProductProviderSlow implements ProductProvider {

	public static final List<Product> PRODUCTS = Arrays.asList(
			new Product(1L, "Laptop", Category.hardware),
			new Product(2L, "Linux", Category.software)
	);
	
	public int something;

	//@Cache(expireAfter = "5m")
	@CacheControl(expireAt = "0 30 7 * *")
	@Override
	public List<Product> loadAllByCategory(Category category) {
		// oh my god... I'm soooooo slooooooow to return this liiiiiiiiiiiiiiiiiiiiist...
		try { Thread.sleep(250); }
		catch (InterruptedException e) { }
		
		return PRODUCTS;
	}

	@Override
	public void setSomething(int value) {
		this.something = value;
	}
	
}
