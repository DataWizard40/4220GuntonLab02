package edu.westga.devops.a4.test.view.main_window;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import org.junit.jupiter.api.Test;

import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.api.FxAssert;
import org.testfx.matcher.control.TextInputControlMatchers;
import org.testfx.matcher.control.LabeledMatchers;

import edu.westga.devops.a7.Main;

public class TestShoppingList extends ApplicationTest  {
	
	@Override
	public void start(Stage stage) throws IOException {
		(new Main()).start(stage);
	}
	
	// Testing User Story #1
	@Test
	public void testInvalidItemNameForAddItemButton() {
		this.clickOn("#addItemButton");
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Please provide a valid item name."));
	}
	
	@Test
	public void testValidItemNameForAddItemButton() {
		this.clickOn("#nameTextField").write("Milk");
		this.clickOn("#addItemButton");
		ListView<String> listView = lookup("#itemsListView").queryAs(ListView.class);
		assertEquals(1, listView.getItems().size());
        assertEquals("Milk: 0", listView.getItems().get(0));
	}
	
	//Testing User Story #2
	@Test
	public void testRemoveButtonWithItemSelected() {
		ListView<String> listView = lookup("#itemsListView").queryAs(ListView.class);
		this.clickOn("#nameTextField").write("Milk");
		this.clickOn("#addItemButton");
		String firstItem = listView.getItems().get(0);
		this.clickOn(firstItem.toString());
		this.clickOn("#removeItemButton");
		assertEquals(0, listView.getItems().size());
	}
	
	@Test
	public void testRemoveButtonWithoutItemSelected() {
		this.clickOn("#removeItemButton");
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Please select an item to remove from the shopping list."));
	}
	
	// Testing User Story #3
	@Test
	public void testUpdateButtonWithItemSelectedAndPositiveNumericValue() {
		ListView<String> listView = lookup("#itemsListView").queryAs(ListView.class);
		this.clickOn("#nameTextField").write("Milk");
		this.clickOn("#addItemButton");
		String firstItem = listView.getItems().get(0);
		this.clickOn(firstItem.toString());
		this.clickOn("#quantityTextField").write("2");
		this.clickOn("#updateQuantityButton");
		assertEquals(1, listView.getItems().size());
		assertEquals("Milk: 2", listView.getItems().get(0));
	}
	
	@Test
	public void testUpdateButtonWithItemSelectedAndNonPositiveNumericValue() {
		ListView<String> listView = lookup("#itemsListView").queryAs(ListView.class);
		this.clickOn("#nameTextField").write("Milk");
		this.clickOn("#addItemButton");
		String firstItem = listView.getItems().get(0);
		this.clickOn(firstItem.toString());
		this.clickOn("#updateQuantityButton");
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Please provide a positive numeric value."));
	}
	
	@Test
	public void testUpdateButtonWithoutItemSelected() {
		ListView<String> listView = lookup("#itemsListView").queryAs(ListView.class);
		this.clickOn("#nameTextField").write("Milk");
		this.clickOn("#addItemButton");
		this.clickOn("#updateQuantityButton");
		FxAssert.verifyThat("#errorLabel", LabeledMatchers.hasText("Please select an item to modify from the shopping list."));
	}
}
