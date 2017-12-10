package org.eqex.cart;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author aa-tt
 * 
 * Sole purpose of this class is to serve as an entry point for JUnit
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = {"html:target/step2-report"})
public class CartApplicationTDD {

}
