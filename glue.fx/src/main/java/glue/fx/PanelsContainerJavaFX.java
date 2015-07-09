package glue.fx;

import glue.fx.OutlineViewJavaFX.ActionOnTree;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.Pane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PanelsContainerJavaFX implements PanelsContainer, OutlineViewJavaFX.Listener {

  private static final Logger LOG = LoggerFactory.getLogger(PanelsContainerJavaFX.class);
  
  private final TabPane gluefxPanelsContainer;
  
  public PanelsContainerJavaFX(TabPane gluefxPanelsContainer) {
    this.gluefxPanelsContainer = gluefxPanelsContainer;
    this.gluefxPanelsContainer.setTabClosingPolicy(TabClosingPolicy.ALL_TABS);
  }

  @Override
  public void onAction(ActionOnTree action) {
    ObservableList<Tab> tabs = gluefxPanelsContainer.getTabs();
    String label = action.getLabel();
    Tab tab = findTabNamed(tabs, label);
    if (tab == null) {
      LOG.debug("no tab found with label '{}', creating a new one...", label);
      tab = new Tab(label);
      try {
        Pane parent = FXMLLoader.load(getClass().getResource(action.getFxmlInClasspath()));
        tab.setContent(parent);
        gluefxPanelsContainer.widthProperty().addListener(new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            parent.setPrefWidth(newValue.doubleValue());
          }
        });
        gluefxPanelsContainer.heightProperty().addListener(new ChangeListener<Number>() {
          @Override
          public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            parent.setPrefHeight(newValue.doubleValue());
          }
        });
        
        tabs.add(tab);
      } catch (IOException e) {
        throw new RuntimeException("unexpected behavior", e);
      }
    }

    LOG.debug("... selecting tab {}", tab);
    gluefxPanelsContainer.getSelectionModel().select(tab);
  }

  private Tab findTabNamed(ObservableList<Tab> tabs, String label) {
    for (Tab tab : tabs) {
      if (tab.getText().equals(label)) {
        return tab;
      }
    }
    return null;
  }

}
