package com.testautomation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementLocators {

	public static Map<String, List<String>> mapOfLocators = new HashMap<String, List<String>>();
	
	public ElementLocators () {
		mapOfLocators.put("iFrameOptionMenu", Arrays.asList("cssSelector", "iframe.doorway-notification-frame"));
		
		mapOfLocators.put("scheduleTour", Arrays.asList("xpath", "//button[text()='Schedule a Tour']"));
		
		mapOfLocators.put("iFrameBookingOptions", Arrays.asList("cssSelector", "iframe.doorway-plugin-frame"));
		
		mapOfLocators.put("datePicker", Arrays.asList("cssSelector", "input#date"));
		
		mapOfLocators.put("selectTime", Arrays.asList("cssSelector", "div.doorway-date-selector select"));
		
		mapOfLocators.put("firstName", Arrays.asList("cssSelector", "input.doorway-input-bordered[placeholder='First name']"));
		
		mapOfLocators.put("lastName", Arrays.asList("cssSelector", "input.doorway-input-bordered[placeholder='Last name']"));
		
		mapOfLocators.put("email", Arrays.asList("cssSelector", "input.doorway-input-bordered[placeholder='Email']"));
		
		mapOfLocators.put("phone", Arrays.asList("cssSelector", "input.doorway-input-bordered[placeholder='Phone']"));
		
		mapOfLocators.put("message", Arrays.asList("cssSelector", "div.doorway-textarea [placeholder='Add your message']"));
		
		mapOfLocators.put("selectBed", Arrays.asList("cssSelector", "div.doorway-contact-form select"));
		
		mapOfLocators.put("bookTour", Arrays.asList("xpath", "//button[text()='Book tour!']"));
		
		mapOfLocators.put("confirmation", Arrays.asList("cssSelector", "div.doorway-plugin-header span"));
		
		
		
		
	}

}
