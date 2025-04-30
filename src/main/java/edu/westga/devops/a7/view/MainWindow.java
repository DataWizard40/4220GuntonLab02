package edu.westga.devops.a7.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import edu.westga.devops.a7.model.Item;

/**
 * CodeBehind To Handle Processing for the MainWindow
 *
 * @author	DevOps
 * @version Spring 2025
 */
public class MainWindow {

    @FXML
    private Button addItemButton;

    @FXML
    private ListView<?> itemListView;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField quantityTextField;

    @FXML
    private Button removeItemButton;

    @FXML
    private Button updateQuantityButton;

    @FXML
    void addItem(ActionEvent event) {

    }

    @FXML
    void removeItem(ActionEvent event) {

    }

    @FXML
    void updateQuantity(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert addItemButton != null : "fx:id=\"addItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert itemListView != null : "fx:id=\"itemListView\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert quantityTextField != null : "fx:id=\"quantityTextField\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert removeItemButton != null : "fx:id=\"removeItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert updateQuantityButton != null : "fx:id=\"updateQuantityButton\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }
}
