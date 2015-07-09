package glue.fx;

import javafx.fxml.FXML;

/**
 * Represents the outline view where user can select &quot;actions&quot;.
 */
public interface OutlineView {

  /**
   * Add an {@link ActionGroup} to this {@link OutlineView} and returns it.
   * 
   * @param label a label for the new {@link ActionGroup}
   * @return an {@link ActionGroup}
   * 
   * @see ActionGroup#addAction(String, String)
   */
  OutlineView.ActionGroup addActionGroup(String label);

  /**
   * Represents a group of {@link Action}(s).
   */
  public static interface ActionGroup {
    
    /**
     * Add an {@link Action} with specified label to this {@link ActionGroup} and returns it.
     * 
     * @param label a label
     * @param fxmlInClasspath a {@link FXML} in classpath representing the view to show when this {@link Action} is selected
     * @return an {@link Action}
     */
    OutlineView.Action addAction(String label, String fxmlInClasspath);
    
  }
  
  /**
   * Represents an {@link Action}.
   * 
   * <p>
   * When an {@link Action} is selected from the {@link OutlineView}, a {@link Panel} containing
   * {@link FXML} associated to this {@link Action} will be opened into the {@link PanelsContainer}.
   * </p>
   */
  public static interface Action {
    
  }
  
}
