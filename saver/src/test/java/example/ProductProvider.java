package example;

import java.util.List;

public interface ProductProvider {

	List<Product> loadAllByCategory(Category category);
	
	void setSomething(int value);
	
}
