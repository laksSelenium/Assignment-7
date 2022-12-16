//Open below application
//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login//
//Click on login button (No need to enter login details)//
//Verify required fields present for username and password//
//Verify that username and password have border of 1px.
//Note- use getCssProperty to fetch css details

package assignment_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7_Task1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		// click login button to understand required fields
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(3000);

		WebElement userName = driver.findElement(By.xpath("//label[contains(text(),'User')]//following::input[1]"));
		WebElement passWord = driver.findElement(By.xpath("//label[contains(text(),'Pass')]//following::input"));

		boolean userNameRequired = driver
				.findElement(By.xpath("//label[contains(text(),'User')]//following::span[contains(@class,'error')][1]"))
				.isDisplayed();

		boolean passWordRequired = driver
				.findElement(By.xpath("//label[contains(text(),'Pass')]//following::span[contains(@class,'error')]"))
				.isDisplayed();

		String userNameBorder = userName.getCssValue("border");
		boolean userNameBorderStatus = userNameBorder.contains("1px");
		
		

		String passWordBorder = passWord.getCssValue("border");
		boolean passWordBorderStatus = passWordBorder.contains("1px");
		
		if(userNameRequired&&passWordRequired) {
			System.out.println("Required fields are username and password");
		}
		
		if(userNameBorderStatus&&passWordBorderStatus) {
			System.out.println("Both username and password fields has a border of 1px");
		}
		
		driver.quit();

	}

}
