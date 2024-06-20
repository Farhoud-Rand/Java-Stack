import java.awt.ItemSelectable;
import java.util.*;

public class CoffeeKiosk {
	// Attributes  	
	ArrayList<Item> menu;
	ArrayList<Order> orders;
	
	// Constructor 
	public CoffeeKiosk() {
		menu = new ArrayList<Item>();
		orders = new ArrayList<Order>();		
	}
	
	// Methods
	// Function to add new item for the menu	
	public void addMenuItem(String name, double price ) {
		Item newItem = new Item(name,price);
		menu.add(newItem);
		newItem.setIndex(menu.size()-2);
	}
	
	// Function to display the menu's items
	public void displayMenu() {
		
	}
	
	
	
	
}
