saver
=======

__**PAY ATTENTION**: this is a work in progress__

## Summary

  1. [Description](#description)
  1. [Tutorial](#tutorial)
  1. [How it works](#how_it_works)
  1. [Usage](#usage)
  1. [Where to get help](#where_to_get_help)
  1. [Contribution guidelines](#contribution_guidelines)
  1. [Contributor list](#contributor_list)
  1. [Credits, Inspiration, Alternatives](#credits_inspiration_alternatives)

## <a name="description"/>Description

**saver** is a way to create quickly a cache.   
The aim of the library is to use an annotation to dictate the expiration of
data returned by an object.   

## <a name="tutorial"/>Tutorial

Create an interface:

```java
    public interface ProductProvider {
		List<Product> loadAllByCategory(Category category);
	}
```

... and a slow implementation:

```java
    public class ProductProviderSlow implements ProductProvider {
		public ProductProviderSlow(...) {
			...
		}

		@CacheControl(expireAt="0 30 7 * * *")
		public List<Product> loadAllByCategory(Category category) {
		    ...
			return products;
		}
	}
```

... now you can use `ProductProviderSlow` with cache support calling:

```java
	ProductProvider productProvider = Saver.aSaver(
		ProductProvider.class,
		new ProductProviderSlow(...)
	).toProxy();
```

## <a name="how_it_works"/>How it works

**saver** returns a proxy called `Saver` that is able to intercept each
call done on returned interface.   
If the method has a `@CacheControl` annotation, the data returned by annotated object
are put in a cache and that data will be returned at every next call till
expiration time occur.   
The key used to cache data is the concatenation of the name of the class, the
method and all parameters value. There's no way to use only one parameter of the
listed one, however you can create one method only with that parameter. The
reason is that I believe, too many possibilities are error prone.   
In order to evict data, you can do something similar to:

```java
    public class ProductProviderSlow implements ProductProvider {
		...

		// ... this will be injected by **saver**
		private Saver<ProductProvider, ProductProviderSlow> saver;

		public void updateAllProductsOfCategory(Category category, List<Product> products) { 
			... // e.g. a multiple update on database

			saver.evict("loadAllByCategory", category);
		}

		...
	}
```

You don't need always to declare a `Saver` field. It's needed only to evict.

## <a name="usage"/>Usage

TODO

## <a name="where_to_get_help"/>Where to get help

TODO

## <a name="contribution_guidelines"/>Contribution guidelines

TODO

## <a name="contributor_list"/>Contributor list

  * [Sixro](http://github.com/sixro)

## <a name="credits_inspiration_alternatives"/>Credits, Inspiration, Alternatives

TODO

