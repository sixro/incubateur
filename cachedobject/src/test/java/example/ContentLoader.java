package example;

/**
 * Represents a ContentLoader.
 *
 * NOTE: this is only an example provided for cachedobject and do not represents a design pattern on "how to handle resources"...
 */
public interface ContentLoader {

    public String readContent(String resourceID);

}
