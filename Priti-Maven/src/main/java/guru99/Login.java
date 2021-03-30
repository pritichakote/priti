package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	
	@ Test(dataProvider="getData")
	 public void verifydata(String username, String password)
	 {
		System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\Guru99Practice\\drivers\\geckodriver\\geckodriver.exe");
		//WebDriver driver;
	   FirefoxDriver driver= new FirefoxDriver();
	   driver.get("http://www.demo.guru99.com/v4/");
	  driver.findElement(By.name("uid")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("btnLogin")).click();
	 }
	
	@DataProvider()
	 public Object[][] getData()
	 {
		Object data[][]= new Object[3][2];
		data[0][0]= "mngr311945";
		data[0][1]="dAdUher";
		data[1][0]="test1";
		data[1][1]= "password1";
		data[2][0]="test2";
		data[2][1]="password2";
		return data;
	 }

}
