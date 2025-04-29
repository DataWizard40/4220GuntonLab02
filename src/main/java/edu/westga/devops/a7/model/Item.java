package edu.westga.devops.a7.model;

/** The Item class.
 * 
 * @author	Ellis Gunton
 * @version Spring 2025
 */
public class Item {
	private String name;
	private int quantity;
	
	public Item(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Item must have a valid name.");
		}
		this.name = name;
		this.quantity = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return this.name + ": " + this.quantity;
	}

}
