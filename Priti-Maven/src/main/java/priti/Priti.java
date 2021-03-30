package priti;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Priti {
	
	@Test (priority=0)
	 public static void VerifyLogin()
	 {
					
			ChromeDriver driver = new ChromeDriver();
	        driver.get("http://apps.qaplanet.in/hrm");
	        WebDriverWait mywait=new WebDriverWait(driver,10);
	        
	        //login
	        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("txtUserName")));
	        driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
	        //driver.findElement(By.name("txtUserName")).clear();
	        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("txtPassword")));
	        driver.findElement(By.name("txtPassword")).sendKeys("lab1");
	        mywait.until(ExpectedConditions.elementToBeClickable(By.name("Submit")));
	        driver.findElement(By.name("Submit")).click();
	        
	        //verify the page title
	        if(driver.getTitle().equals("OrangeHRM")) {
	        	System.out.println("TC passed");
	        }else {
	        	System.out.println("TC failed");
	        }
	        
	        //logout
	        driver.findElement(By.linkText("Logout")).click();
	        
	        driver.close();
	 }
	
@Test (priority=1)
 public static void AddEmp() throws InterruptedException
 {
	ChromeDriver driver= new ChromeDriver();
	driver.get("http://apps.qaplanet.in/hrm/login.php");
	WebElement login= driver.findElement(By.name("txtUserName"));
	WebElement password= driver.findElement(By.name("txtPassword"));
	WebElement button= driver.findElement(By.name("Submit"));
	
	Actions an= new Actions(driver);
	
	an.moveToElement(login).click().sendKeys("qaplanet1").perform();
	Thread.sleep(1000);
	an.moveToElement(password).click().sendKeys("lab1").moveToElement(button).click().perform();
	Thread.sleep(3000);		
	WebElement PIM= driver.findElement(By.id("pim"));
	WebElement add= driver.findElement(By.xpath("//*[@id=\"pim\"]/ul/li[2]/a/span"));
	an.moveToElement(PIM).moveToElement(add).click().perform();
	
	Thread.sleep(3000);
	driver.switchTo().frame("rightMenu");
			
	WebElement last= driver.findElement(By.name("txtEmpLastName"));
	WebElement first= driver.findElement(By.name("txtEmpFirstName"));
	WebElement save= driver.findElement(By.id("btnEdit"));
	an.moveToElement(last).click().keyDown(Keys.SHIFT).sendKeys("t").keyUp(Keys.SHIFT).sendKeys("estlast").perform();
	an.moveToElement(first).click().keyDown(Keys.SHIFT).sendKeys("t").keyUp(Keys.SHIFT).sendKeys("estfirst").perform();
	an.moveToElement(save).click().perform();
	
	Thread.sleep(2000);
	driver.close();
 }

@Test (priority=2)
 public static void editEmp() throws InterruptedException
 {
	System.out.println("edit employee");
 }
@Test (priority=3)
 public static void deleteEmp()
 {
	System.out.println("delete emp");
 }
 
}
