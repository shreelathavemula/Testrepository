package pageObjects;

import org.openqa.selenium.By;

public class mylearning {
	
	public static By username =By.name("userName");
	
	public static By password=By.name("password");
	
	public static By loginbtn=By.name("login");
	
	public static By passenger=By.name("passCount");
	
	public static By departingfrom=By.name("fromPort");
	
	public static By onmonth=By.name("fromMonth");
	
	public static By onday=By.name("fromDay");
	
	public static By arrivingin=By.name("toPort");
	
	public static By returningmonth=By.name("toMonth");
	
	public static By returningday=By.name("toDay");
	
	public static By serviceclass=By.xpath("//body/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form[@name='findflight']/table/tbody/tr[9]/td[2]/font[1]");
	
	public static By airlines=By.name("airline");
	
	public static By continue1=By.name("findFlights");
	
	
	
	
	
}
