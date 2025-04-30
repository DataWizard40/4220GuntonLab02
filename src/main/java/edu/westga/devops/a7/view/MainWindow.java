package edu.westga.devops.a7.view;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

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
    private ListView<String> itemsListView;

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
		if (this.nameTextField.getText() == null || this.nameTextField.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid Item Name");
			alert.setHeaderText(null);
			alert.setContentText("Please procide a valid item name.");
			alert.showAndWait();
		} else {
			String name = this.nameTextField.getText();
			Item item = new Item(name);
			this.itemsListView.getItems().add(item.toString());
		}
    }

    @FXML
    void removeItem(ActionEvent event) {
		if (this.itemsListView.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Item Not Selected");
			alert.setHeaderText(null);
			alert.setContentText("Please select an item to remove from the shopping list.");
			alert.showAndWait();
		} else {
			this.itemsListView.getItems().remove(this.itemsListView.getSelectionModel().getSelectedIndex());
			this.nameTextField.setText("");
			this.quantityTextField.setText("");
		}
    }
	
	@FXML
    void selectItem(MouseEvent event) {
		this.nameTextField.setText(this.getSubstringBefore(this.itemsListView.getSelectionModel().getSelectedItem()));
		this.quantityTextField.setText(this.getSubstringAfter(this.itemsListView.getSelectionModel().getSelectedItem()));
    }

    @FXML
    void updateQuantity(ActionEvent event) {
		if (this.itemsListView.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Item Not Selected");
			alert.setHeaderText(null);
			alert.setContentText("Please select an item to modify from the shopping list.");
			alert.showAndWait();
		} else if (this.quantityTextField.getText() == null || this.quantityTextField.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No Input");
			alert.setHeaderText(null);
			alert.setContentText("No input has been provided.");
			alert.showAndWait();
		} else if (this.containsNonNumericValues(this.quantityTextField.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Non-numeric Value Entered");
			alert.setHeaderText(null);
			alert.setContentText("Please provide a numeric value.");
			alert.showAndWait();
		} else if (Integer.parseInt(this.quantityTextField.getText()) <= 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Non-positive Numeric Value Entered");
			alert.setHeaderText(null);
			alert.setContentText("Please provide a positive numeric value.");
			alert.showAndWait();
		} else {
			this.itemsListView.getItems().remove(this.itemsListView.getSelectionModel().getSelectedIndex());
			Item item = new Item(this.nameTextField.getText());
			item.setQuantity(Integer.parseInt(this.quantityTextField.getText()));
			this.itemsListView.getItems().add(item.toString());
			
		}
    }

    @FXML
    void initialize() {
        assert addItemButton != null : "fx:id=\"addItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert itemsListView != null : "fx:id=\"itemsListView\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert quantityTextField != null : "fx:id=\"quantityTextField\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert removeItemButton != null : "fx:id=\"removeItemButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert updateQuantityButton != null : "fx:id=\"updateQuantityButton\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }
	
	private String getSubstringBefore(String str) {
		int index = str.indexOf(":");
		return str.substring(0, index);
	}
	
	private String getSubstringAfter(String str) {
		int index = str.indexOf(":");
		return str.substring(index + 1).trim();
	}
	
	private boolean containsNonNumericValues(String str) {
		for (char c : str.toCharArray()) {
			if (Character.isLetter(c) || !Character.isLetterOrDigit(c)) {
				return true;
			}
		}
		return false;
	}
}
