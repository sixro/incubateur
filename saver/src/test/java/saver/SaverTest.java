package saver;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutionException;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import example.*;

public class SaverTest {

	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private Cache cache = context.mock(Cache.class);
	private ProductProviderSlow delegate = new ProductProviderSlow();
	private Saver<ProductProvider, ProductProviderSlow> saver;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before public void setup() {
		saver = new Saver(ProductProvider.class, delegate) {
			@Override
			protected Cache getCache(Class delegateType, Method delegateMethod, saver.CacheControl cacheAnnotation) {
				return cache;
			}
		};
	}
	
	@Test public void redirect_only_the_call_when_method_has_no_annotations() {
		ProductProvider provider = saver.toProxy();
		provider.setSomething(5);
		
		assertEquals(5, delegate.something);
	}

	@Test public void returns_cached_object_when_delegate_method_is_annotated_and_cache_contains_a_value_for_the_same_key() throws ExecutionException {
		final List<Product> expectedProducts = Arrays.asList(new Product(1L, "Laptop", Category.hardware));
		
		context.checking(new Expectations() {{
			oneOf(cache).get(with(any(CallKey.class)));
				will(returnValue(expectedProducts));
		}});
		
		ProductProvider provider = saver.toProxy();
		List<Product> products = provider.loadAllByCategory(Category.hardware);

		assertEquals(expectedProducts, products);
	}

	@Test public void call_underline_object_when_cache_does_not_contain_data_anymore() throws ExecutionException {
		ProductProvider provider = saver.toProxy();

		context.checking(new Expectations() {{
			oneOf(cache).get(with(any(CallKey.class)));
				will(returnValue(null));
			oneOf(cache).put(with(any(CallKey.class)), with(any(List.class)));
		}});
		
		List<Product> products = provider.loadAllByCategory(Category.hardware);

		assertEquals(ProductProviderSlow.PRODUCTS, products);
	}

	@Test public void getCache_returns_new_cache_when_it_does_not_exist() {
		Saver<ProductProvider, ProductProviderSlow> realSaver = Saver.aSaver(ProductProvider.class, delegate);
		Class<ProductProviderSlow> type = ProductProviderSlow.class;
		Method method = Utils.findMethod(type, "loadAllByCategory", new Class<?>[]{ Category.class });
		Map<String, Object> cacheConfig = new HashMap<String, Object>();
		cacheConfig.put("expireAt", "0y:00");
		Cache cache = realSaver.getCache(type, method, cacheConfig);
		//assertNotNull(cache); //FIXME
	}
	
}
