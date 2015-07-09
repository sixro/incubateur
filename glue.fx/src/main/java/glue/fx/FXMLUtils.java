package glue.fx;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 * Represents a set of utilities to work with {@link FXML}.
 */
public class FXMLUtils {

  private static final Logger LOG = LoggerFactory.getLogger(FXMLUtils.class);
  
  private FXMLUtils() { }
  
  /**
   * Return a {@link Node} representing specified {@link FXML} resource found in classpath.
   * 
   * @param classpathResource a resource in classpath
   * @return a {@link Node}
   */
  public static Node load(String classpathResource) {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(FXMLUtils.class.getResource(classpathResource));
      Node node = fxmlLoader.load();
      return node;
    } catch (IOException e) {
      throw new FXMLUtils.NoSuchFXMLException("unable to load FXML '" + classpathResource + "'", e);
    }
  }

  /**
   * Return a {@link Node} representing specified {@link FXML} resource found in classpath using specified controller.
   * 
   * @param classpathResource a resource in classpath
   * @param controller a controller to use with specified {@link FXML}
   * @return a {@link Node}
   */
  public static Node load(String classpathResource, Object controller) {
    try {
      LOG.debug("loading FXML using resource '" + classpathResource + "' and controller " + controller + "...");
      
      FXMLLoader fxmlLoader = new FXMLLoader(FXMLUtils.class.getResource(classpathResource));
      fxmlLoader.setController(controller);
      Node node = fxmlLoader.load();

      LOG.debug("... returning " + node);
      return node;
    } catch (IOException e) {
      throw new FXMLUtils.NoSuchFXMLException("unable to load FXML '" + classpathResource + "'", e);
    }
  }

  /**
   * Thrown when no such {@link FXML} is found.
   * 
   * @see FXMLUtils#load(String)
   * @see FXMLUtils#load(String, Object)
   */
  public static class NoSuchFXMLException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoSuchFXMLException(String message, Throwable cause) {
      super(message, cause);
    }

    public NoSuchFXMLException(String message) {
      super(message);
    }

    public NoSuchFXMLException(Throwable cause) {
      super(cause);
    }
    
  }
  
}
