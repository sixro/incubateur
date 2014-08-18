/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logviewer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import logviewer.util.FontAwesome;

/**
 * FXML Controller class
 *
 * @author rsimoni
 */
public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private SplitPane splitPane;

    @FXML
    private TreeView<String> tree;

    @FXML
    private TabPane tabPane;

    @FXML
    private ToggleButton btnExample;

    private transient boolean treeShown = true;
    private transient double dividerPositionBackup = -1;

    @FXML
    void initialize() {
        assert tree != null : "fx:id=\"tree\" was not injected: check your FXML file 'main.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file 'main.fxml'.";

        btnExample.setText(FontAwesome.HEART_EMPTY);
        btnExample.setFont(FontAwesome.font());
        btnExample.setSelected(treeShown);
        
        TreeItem<String> rootItem = new TreeItem<String> ("Inbox");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String> ("Message" + i);            
            rootItem.getChildren().add(item);
        }
        tree.setRoot(rootItem);
    }

    @FXML
    void onExampleButtonClick(ActionEvent event) {
        toggleTree();
    }
    
    public void toggleTree() {
//        double[] dividerPositions = splitPane.getDividerPositions();
//        System.out.println("dividerPositions: " + Arrays.toString(dividerPositions));

        if (treeShown)
            hideTree();
        else
            showTree();
        
        btnExample.setSelected(treeShown);
    }

    private void showTree() {
        splitPane.setDividerPosition(0, dividerPositionBackup);
        treeShown = true;
    }
    
    private void hideTree() {
        dividerPositionBackup = splitPane.getDividerPositions()[0];
        splitPane.setDividerPosition(0, 0);
        treeShown = false;
    }

}
