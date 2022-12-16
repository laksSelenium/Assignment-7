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

public class Assignment7_Task3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		WebElement userName = driver.findElement(By.xpath("//label[contains(text(),'User')]//following::input[1]"));
		WebElement passWord = driver.findElement(By.xpath("//label[contains(text(),'Pass')]//following::input"));

		// enter username and password
		userName.sendKeys("admin");
		passWord.sendKeys("mukesh");

		// click login button to understand required fields
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(5000);

		WebElement invalidCredential = driver.findElement(By.xpath("//div[contains(@class,'alert')]//p"));

		boolean invalidCredentialMsg = invalidCredential.isDisplayed();
		
		String actualinvalidCredentialMsg = invalidCredential.getText();
		

		if (invalidCredentialMsg&&(actualinvalidCredentialMsg.contains("Invalid credentials"))) {
			System.out.println("Credentials are incorrect and hence invalid credentials msg is displayed");
		}

		driver.quit();

	}

}
