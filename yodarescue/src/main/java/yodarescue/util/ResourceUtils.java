package yodarescue.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class ResourceUtils {

  private ResourceUtils() { }
  
  public static String loadText(String textInClasspath) {
    InputStream stream = null;
    try {
      stream = ResourceUtils.class.getResourceAsStream(textInClasspath);
      return IOUtils.toString(stream);
    } catch (IOException e) {
      throw new RuntimeException("unable to load text resource '" + textInClasspath + "'", e);
    } finally {
      IOUtils.closeQuietly(stream);
    }
  }
  
}
