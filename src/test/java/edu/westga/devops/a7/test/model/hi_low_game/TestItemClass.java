package edu.westga.devops.a7.test.model.hi_low_game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.devops.a7.model.Item;

class TestItemClass {
	
	// Constructor tests
	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			Item item = new Item(null);
		});
	}
	
	@Test
    void testEmptyName() {
		assertThrows(IllegalArgumentException.class, () -> {
    		Item item = new Item("");
    	});
    }
	
	@Test
	void testValidConstructor() {
		Item item = new Item("Milk");
		assertEquals(item.getName(), "Milk");
		assertEquals(item.getQuantity(), 0);
	}
	
	//Tests for getters and setters
	@Test
	void testGetters() {
		Item item = new Item("Lemonade");
		assertEquals(item.getName(), "Lemonade");
		assertEquals(item.getQuantity(), 0);
	}
	
	@Test
	void testSetters() {
		Item item = new Item("Bread");
		item.setName("Ice Cream");
		item.setQuantity(2);
		assertEquals(item.getName(), "Ice Cream");
		assertEquals(item.getQuantity(), 2);
	}
	
	//Test for ToString method
	@Test
	void testToString() {
		Item item = new Item("Bread");
		item.setName("Ice Cream");
		item.setQuantity(2);
		assertEquals(item.toString(), "Ice Cream: 2");
	}
}