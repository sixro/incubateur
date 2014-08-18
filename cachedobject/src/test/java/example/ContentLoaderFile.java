package example;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Represents a "slow" implementation of ContentLoader.
 */
public class ContentLoaderFile implements ContentLoader {

    @Override
    public String readContent(String resourceID) {
        try {
            return IOUtils.toString(getClass().getResourceAsStream(resourceID));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
