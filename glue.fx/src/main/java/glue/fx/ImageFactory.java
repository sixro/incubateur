package glue.fx;

import java.io.InputStream;

import javafx.scene.image.Image;

/**
 * Represents an {@link Image} factory.
 */
public class ImageFactory {

  private ImageFactory() { }
  
  /**
   * Returns an {@link Image} loading specified resource from the classpath.
   * @param imageInClasspath an image in the classpath
   * @return an {@link Image}
   */
  public static Image newImage(String imageInClasspath) {
    InputStream stream = ImageFactory.class.getResourceAsStream(imageInClasspath);
    if (stream == null)
      throw new IllegalArgumentException("Unable to find an image in classpath '" + imageInClasspath + "'");
    return new Image(stream);
  }
  
}
