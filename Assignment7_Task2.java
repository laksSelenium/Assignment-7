//Open below application
//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login//
//Enter username as admin and password as mukesh and click on the login button //
//Capture error message and verify message contains Invalid credentials


package assignment_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7_Task2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);

		// enter username
		WebElement userName = driver.findElement(By.xpath("//label[contains(text(),'User')]//following::input[1]"));
		userName.sendKeys("admin");

		// click login button to understand required fields
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(3000);

		boolean passWordRequired = driver
				.findElement(By.xpath("//label[contains(text(),'Pass')]//following::span[contains(@class,'error')]"))
				.isDisplayed();

		if (passWordRequired) {
			System.out.println("Required field message is shown for password");
		}

		driver.quit();

	}

}
