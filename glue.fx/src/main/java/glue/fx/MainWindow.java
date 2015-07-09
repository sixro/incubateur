package glue.fx;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Represents the main window.
 */
public interface MainWindow {

  /**
   * Set the title.
   * 
   * @param title a title
   */
  void setTitle(String title);
  
  /**
   * Set the logo using specified image and using specified 
   * background color for parts not covered by the image.
   * 
   * <p>
   * The specified image will be used also as the minimal width of the
   * left part (the part containing logo and outline view).<br>
   * When the divider of the split pane is moved and the image is too
   * small, the background color should mantain a pleasant result.
   * </p>
   * 
   * @param image an image
   * @param backgroundColor a color
   */
  void setLogo(Image image, Color backgroundColor);
  
  /**
   * Show the main window.
   */
  void show();

  /**
   * Returns the {@link OutlineView} of this main window.
   * 
   * @return the {@link OutlineView}
   */
  OutlineView getOutlineView();
  
  /**
   * Returns the {@link PanelsContainer} of this main window.
   * 
   * @return the {@link PanelsContainer}
   */
  PanelsContainer getPanelsContainer();
  
}
