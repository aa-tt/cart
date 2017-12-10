package org.eqex.cart;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author aa-tt
 *
 * Cart class to hold cart states
 */
public class Cart {

	// List of items
	List<Product> items;

	public Cart(){
			this.items=new ArrayList<Product>();
		}

	public void addItem(Product item) {
		this.items.add(item);
	}

	public void removeItem(Product item) {
		this.items.remove(item);
	}

	public float calculateTotal() {
		float sum = 0.0f;
		for (Product item : items) {
			sum += item.getPrice();
		}
		return sum;
	}
	
	public List<Product> getItems() {
		return items;
	}

}
