package org.eqex.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.stream.Stream;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author aa-tt
 * 
 * Steps to match the user criteria given in the problem statement.
 * The feature file in src/test/resources also corresponds to this problem statement. 
 */
public class StepDefs2 {
	
	Cart cart;
	Product item;
	
	@Given("^An empty shopping cart$")
	public void initializer1() {
		cart = new Cart();
		assertNotNull(cart);
	}
	
	@And("^a product, (.*) with a unit price of (\\d+\\.\\d+)$")
	public void initializer2(String name, float price) {
		
		item = new Product(name, price);
		assertEquals(name, item.getName());
		assertEquals(price, item.getPrice(), 0.01);
		
	}
	
	@When("^The user adds (\\d+) Dove Soaps to the shopping cart$")
	public void operation1(int qty) {
		
		Stream.of(new Integer[qty])
			.forEach(q -> cart.items.add(item));	
	}
	
	@And("^then adds another (\\d+) Dove Soaps to the shopping cart$")
	public void operation2(int qty) {
		
		Stream.of(new Integer[qty])
		.forEach(q -> cart.items.add(item));	
	}
	
	@Then("^The shopping cart should contain (\\d+) Dove Soaps each with a unit price of (\\d+\\.\\d+)$")
	public void output1(int qty, float price) {
		
		assertEquals(qty, cart.getItems().size());
		cart.getItems().forEach(item -> {
			assertEquals(item.getPrice(), 39.99, 0.01);			
		});
		
	}
	
	@And("^the shopping cart’s total price should equal (\\d+\\.\\d+)$")
	public void output2(float totalPrice) {
		
		assertEquals(totalPrice, cart.calculateTotal(), 0.01);
	}

}
