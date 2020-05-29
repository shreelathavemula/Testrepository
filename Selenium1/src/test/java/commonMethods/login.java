package commonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.mylearning;

public class login {
	
	
	public void logins(WebDriver driver)
	{
		WebElement username =driver.findElement(mylearning.username);
		username.sendKeys("shreelathavemula@gmail.com");
		
		WebElement paswrd =driver.findElement(mylearning.password);
		paswrd.sendKeys("shree");
		WebElement loginbtn = driver.findElement(mylearning.loginbtn);
		loginbtn.click();
	}

}
