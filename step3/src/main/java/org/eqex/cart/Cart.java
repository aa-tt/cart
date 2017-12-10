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
	// Tax on the cart items
	float tax;

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
		float sum = 0.00f;
		for (Product item : items) {
			sum += item.getPrice();
		}
		return sum;
	}
	
	// Overloaded method to calculate total when items are taxed
	public float calculateTotal(float tax) {
		float sum = 0.00f;
		for (Product item : items) {
			sum += item.getPrice();
		}
		return sum + tax;
	}
	
	public float getTax(float rate) {
		tax = Math.round(calculateTotal() * (rate/100));
		return tax;
	}
	
	public List<Product> getItems() {
		return items;
	}

}
