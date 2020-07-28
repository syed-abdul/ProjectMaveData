package org.read;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class B extends Execution  {
	
	@Test(dataProvider="pro",dataProviderClass=Execution.class)
	public void launch(String s1,String s2) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ragavboom\\eclipse-workspace\\MavenData1\\div\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys(s1);
		driver.findElement(By.id("pass")).sendKeys(s2);
		driver.findElement(By.id("loginbutton")).click();
		
	}
	
	

	
}

