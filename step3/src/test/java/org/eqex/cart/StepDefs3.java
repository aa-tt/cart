package org.eqex.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.stream.Collectors;
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
public class StepDefs3 {
	
	Cart cart;
	Product item1, item2;
	float taxRate;
	
	@Given("^An empty shopping cart$")
	public void initializer1() {
		cart = new Cart();
		assertNotNull(cart);
	}
	
	@And("^a product, (.*) with a unit price of (\\d+\\.\\d+)$")
	public void initializer2(String name, float price) {
		
		item1 = new Product(name, price);
		assertEquals(name, item1.getName());
		assertEquals(price, item1.getPrice(), 0.01);		
	}
	
	@And("^another product, (.*) with a unit price of (\\d+\\.\\d+)$")
	public void initializer3(String name, float price) {
		
		item2 = new Product(name, price);
		assertEquals(name, item2.getName());
		assertEquals(price, item2.getPrice(), 0.01);		
	}
	
	@And("^a tax rate of (\\d+\\.\\d+)%$")
	public void initializer4(float rate) {
		
		taxRate = rate;	
	}
	
	@When("^The user adds (\\d+) Dove Soaps to the shopping cart$")
	public void operation1(int qty) {
		
		Stream.of(new Integer[qty])
			.forEach(q -> cart.items.add(item1));	
	}
	
	@And("^then adds (\\d+) Axe Deo’s to the shopping cart$")
	public void operation2(int qty) {
		
		Stream.of(new Integer[qty])
			.forEach(q -> cart.items.add(item2));	
	}
	
	@Then("^The shopping cart should contain (\\d+) (.*)s each with a unit price of (\\d+\\.\\d+)$")
	public void output1(int qty, String itemName, float price) {
		
		assertEquals(
				qty, 
				cart.getItems().stream()
							.filter( itm -> itm.getName().equals(itemName) )
							.collect(Collectors.toList())
							.size()
					);
		cart.getItems().stream()
			.filter( itm -> itm.getName().equals("Dove Soap"))
			.forEach(item -> {
				assertEquals(price, item.getPrice(), 0.01);			
		});
		
	}
	
	@And("^the shopping cart should contain (\\d+) (.*)'s each with a unit price of (\\d+\\.\\d+)$")
	public void output2(int qty, String itemName, float price) {
		
		assertEquals(
				qty, 
				cart.getItems().stream()
				.filter( itm -> itm.getName().equals(itemName) )
				.collect(Collectors.toList())
				.size()
				);
		cart.getItems().stream()
		.filter( itm -> itm.getName().equals("Axe Deo"))
		.forEach(item -> {
			assertEquals(price, item.getPrice(), 0.01);			
		});
		
	}
	
	@And("^the total tax amount should equal (\\d+\\.\\d+)$")
	public void output3(float tax) {

		assertEquals(tax, cart.getTax(taxRate), 0.01);
		
	}
	
	@And("^the shopping cart’s total price should equal (\\d+\\.\\d+)$")
	public void output4(float totalPrice) {
		
		assertEquals(totalPrice, cart.calculateTotal(cart.getTax(taxRate)), 0.01);
	}

}
