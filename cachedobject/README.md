#cachedobject

A small library to create __caching objects__.

## Example

Imagine an interface like this:

```java
public interface ContentLoader {

    public String readContent(String resourceID);

}
```

and a slow implementation:

```java
public class ContentLoaderSlow implements ContentLoader {

    @Override
    public String readContent(String resourceID) {
	...
    }

}
```

you can cache values obtained by slow implementation annotating operations with ```@Cache```. Like this:

```java

import cachedobject.Cache;


public class ContentLoaderSlow implements ContentLoader {

    @Cache(maxAge=5 * 60)
    @Override
    public String readContent(String resourceID) {
        ...
    }

}
```

and passing the result of:

```java
    CachingObjectFactory.newCachingObject(ContentLoader.class, new ContentLoaderSlow())
```
everywhere you need a ```ContentLoader```.
