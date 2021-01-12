package com.testautomation;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// TODO: Auto-generated Javadoc
/**
 * This package contains implementation of generic step definitions to be used
 * by Cucumber feature file.
 * 
 * @author savya.rawat
 */
public class CommonStepDef {

		
	BasePage obj = new BasePage();
	ElementLocators locators = new ElementLocators();
	Map<String, List<String>> listOfLocators = ElementLocators.mapOfLocators;

	/**
	 * This method is used to click on specified element in ElementLocator class
	 * 
	 * -->Example: I click on "Login" button/element
	 * 
	 * -->Here "Login" is elementName, "button" is word, and "XyzPage" is
	 * PageName
	 * 
	 *
	 * @param buttonElement
	 *            the button element
	 * @param word
	 *            the word
	 * @param page
	 *            the page
	 * @throws InterruptedException
	 *             the interrupted exception
	 *
	 *             --Replaced findElement method by Explicit wait method
	 */
	@When("^I click on \"([^\"]*)\" button$")
	public void click_on_respective_button(String key)
			throws InterruptedException {
		obj.clickButton(obj.findElement(listOfLocators.get(key).get(0), listOfLocators.get(key).get(1)));
		System.out.println("clicked on button ");
		Thread.sleep(2000);
	}

	@And("^I enter text \"(.*?)\" on element \"(.*?)\"$")
	public void sendTextToAnELement(String text, String key)
			throws InterruptedException {
		
		obj.sendText(obj.findElement(listOfLocators.get(key).get(0), listOfLocators.get(key).get(1)), text);
		
		System.out.println("Entered Text");
		Thread.sleep(2000);
	}
	
	@And("^I enter email on element \"(.*?)\"$")
	public void sendTextEmailToAnELement(String key)
			throws InterruptedException {
		
		obj.sendTextEmail(obj.findElement(listOfLocators.get(key).get(0), listOfLocators.get(key).get(1)));
		
		System.out.println("Entered Email");
		Thread.sleep(2000);
	}
	
	
	@And("^I enter numeric data on element \"(.*?)\"$")
	public void sendTextPhoneToAnELement(String key)
			throws InterruptedException {
		
		obj.sendTextNumber(obj.findElement(listOfLocators.get(key).get(0), listOfLocators.get(key).get(1)));
		
		System.out.println("Entered Phone");
		Thread.sleep(2000);
	}
	
	@And("^I select tomorrow date on \"(.*?)\"$")
	public void sendDateToAnELement(String key)
			throws InterruptedException {
		obj.clickButton(obj.findElement(listOfLocators.get(key).get(0), listOfLocators.get(key).get(1)));
		obj.selectDate("xpath", "//td[contains(@class,'CalendarDay')][@aria-label='");
		System.out.println("Entered Date");
		Thread.sleep(2000);		                                           
	}

	@When("^I navigate to \"(.*?)\"$")
	public void navigate_to_respective_url(String url) throws IOException, InterruptedException {
		assertNotNull("Application URL is null", url);
		if (url.isEmpty() || url.contains("define") || url.contains("config"))
			url = System.getProperty("url");
		obj.navigate(url);
		System.out.println("Navigated to URL:" + url);
		Thread.sleep(3000);
	}

	@When("^I switch to frame \"([^\"]*)\"$")
	public void i_switch_to_frame(String key) throws InterruptedException {
		obj.SwitchtoFrameElement(obj.findElement(listOfLocators.get(key).get(0), listOfLocators.get(key).get(1)));
		Thread.sleep(2000);
	}
	
	@When("^I switch to default content$")
	public void i_switch_to_default() throws InterruptedException {
		obj.SwitchtoDefault();
		Thread.sleep(2000);
	}
	
	@When("^I select dropdown element \"([^\"]*)\" based on value \"([^\"]*)\"$")
	public void dropdownSelectorText(String key, String text) throws InterruptedException {
		obj.selectDropDownText(text,obj.findElement(listOfLocators.get(key).get(0), listOfLocators.get(key).get(1)));
		Thread.sleep(2000);
	}
	
	@When("^I select \"([^\"]*)\" index dropdown on \"([^\"]*)\"$")
	public void dropdownSelectorIndex(String index, String key) throws InterruptedException {
		obj.selectDropdownBasedOnIndex(listOfLocators.get(key).get(0), listOfLocators.get(key).get(1),Integer.parseInt(index));
		Thread.sleep(2000);
	}
	
	@Then("^I verify element \"([^\"]*)\" contains text \"([^\"]*)\"$")
	public void verifyText(String key, String text) throws InterruptedException {
		Assert.assertTrue("Test failed", obj.getText(obj.findElement(listOfLocators.get(key).get(0), listOfLocators.get(key).get(1))).contains(text));
		Thread.sleep(10000);
		obj.close();
		obj.quit();
	}

}
