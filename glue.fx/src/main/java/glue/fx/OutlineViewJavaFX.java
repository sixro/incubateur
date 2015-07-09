package glue.fx;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class OutlineViewJavaFX implements OutlineView, ChangeListener<TreeItem<String>> {

  private static final Logger LOG = LoggerFactory.getLogger(OutlineViewJavaFX.class);
  
  private final TreeView<String> gluefxOutlineTreeView;
  private final TreeItem<String> rootOfTreeItems;
  private final Map<TreeItem<String>, ActionOnTree> treeItemsToAction;
  private final List<OutlineViewJavaFX.Listener> listeners;

  public OutlineViewJavaFX(TreeView<String> gluefxOutlineTreeView) {
    this.gluefxOutlineTreeView = gluefxOutlineTreeView;
    this.rootOfTreeItems = new TreeItem<String>();
    this.treeItemsToAction = new LinkedHashMap<TreeItem<String>, OutlineViewJavaFX.ActionOnTree>();
    this.listeners = new LinkedList<OutlineViewJavaFX.Listener>();
    
    this.gluefxOutlineTreeView.setRoot(rootOfTreeItems);
    this.gluefxOutlineTreeView.setShowRoot(false);
    this.gluefxOutlineTreeView.setCellFactory(tv ->  new TextFieldTreeCell<String>() {      
      @Override
      public void updateItem(String item, boolean empty) {
          super.updateItem(item, empty);

          if (isAnAction(getTreeItem()))
            getStyleClass().add("leaf");
      }
    });
    
    this.gluefxOutlineTreeView.getSelectionModel().selectedItemProperty().addListener(this);
  }

  public void addListener(OutlineViewJavaFX.Listener listener) {
    this.listeners.add(listener);
  }
  
  @Override
  public ActionGroup addActionGroup(String label) {
    ActionGroupOnTree actionGroup = new OutlineViewJavaFX.ActionGroupOnTree(label);
    actionGroup.addTo(rootOfTreeItems);
    return actionGroup;
  }

  public boolean isAnAction(TreeItem<String> treeItem) {
    if (treeItem == null)
      return false;
    
    final ActionOnTree actionOnTree = treeItemsToAction.get(treeItem);
    return actionOnTree != null;
  }
  
  @Override
  public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
    TreeItem<String> selectedTreeItem = (TreeItem<String>) newValue;
    if (! isAnAction(selectedTreeItem))
      return;

    ActionOnTree action = treeItemsToAction.get(selectedTreeItem);
    fireOnAction(action);
  }

  private void fireOnAction(ActionOnTree action) {
    for (OutlineViewJavaFX.Listener listener : listeners) {
      fireOnAction(action, listener);
    }
  }

  private void fireOnAction(ActionOnTree action, Listener listener) {
    try { listener.onAction(action); } 
    catch (Throwable t) {
      LOG.error("Unable to notify listener " + listener + " of action " + action + " due to a " + t.getClass().getName() + " with message '" + t.getMessage() + "'", t);
    }
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

  
  public class ActionGroupOnTree implements ActionGroup{

    @SuppressWarnings("unused")
    private final String label;
    private final TreeItem<String> treeItem;

    public ActionGroupOnTree(String label) {
      this.label = label;
      this.treeItem = new TreeItem<String>(label);
      this.treeItem.setExpanded(true);
    } 

    public void addTo(TreeItem<String> parentItem) {
      parentItem.getChildren().add(treeItem);
    }

    @Override
    public Action addAction(String label, String fxmlInClasspath) {
      ActionOnTree action = new OutlineViewJavaFX.ActionOnTree(label, fxmlInClasspath);
      action.addTo(treeItem);
      return action;
    }

  }

  public class ActionOnTree implements Action {

    private final String label;
    private final String fxmlInClasspath;
    private final TreeItem<String> treeItem;

    public ActionOnTree(String label, String fxmlInClasspath) {
      this.label = label;
      this.fxmlInClasspath = fxmlInClasspath;
      this.treeItem = new TreeItem<String>(label);
    }

    public void addTo(TreeItem<String> parentItem) {
      parentItem.getChildren().add(treeItem);
      OutlineViewJavaFX.this.treeItemsToAction.put(treeItem, this);
    }

    public String getLabel() {
      return label;
    }
    
    public String getFxmlInClasspath() {
      return fxmlInClasspath;
    }

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

  }

  public static interface Listener {
    
    void onAction(ActionOnTree action);
    
  }
  
}
