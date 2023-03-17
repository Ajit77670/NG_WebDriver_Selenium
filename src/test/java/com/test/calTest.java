package com.test;

import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

import Pages.CalculatorPage;

public class calTest {
	
	
	CalculatorPage calPage;
	
	@BeforeTest
	public void setup() {
		
		calPage = new CalculatorPage();	
		
	}
	
	
	@Test()
	public void sumTest() {
		
	String res =calPage.sum("10", "20");
		Assert.assertEquals(res, "30");
	}
	
	

}
