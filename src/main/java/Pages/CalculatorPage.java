package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorPage {
	
	WebDriver driver;
	NgWebDriver NG_driver;
	JavascriptExecutor jsDriver;
	
	
	ByAngularModel first = ByAngular.model("first");
	ByAngularModel second = ByAngular.model("second");
	ByAngularModel operator = ByAngular.model("operator");
	ByAngularButtonText go = ByAngular.buttonText("Go!");
	
	By result = By.tagName("h2");
	
	
	public CalculatorPage() {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		jsDriver = (JavascriptExecutor)driver;
		driver.get("http://localhost:3456/");
		NG_driver = new NgWebDriver(jsDriver);
	}
	
	
	public String sum(String v1 , String v2) {
		
		driver.findElement(first).clear();
		driver.findElement(first).sendKeys("v1");
		
		driver.findElement(second).clear();
		driver.findElement(second).sendKeys("v2");
		
		
		driver.findElement(operator).sendKeys("+");
		driver.findElement(go).click();
		NG_driver.waitForAngularRequestsToFinish();
		
		System.out.println(driver.findElement(result).getText());
		return driver.findElement(result).getText();
		
	}
	
}	

		

	
	
	

