//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//Click on Admin Tab 
//Click on Add button 
//Type A in employee name and write XPath which matches all element in suggestions

package assignment_7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7_Task4 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);

		driver.findElement(By.xpath(" //input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(3000);

		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("dashboard")) {
			System.out
					.println("User has successfully logged into the application & the current url has text dashboard");
			driver.findElement(By.xpath("(//i[contains(@class,'bi-caret-down-fill')])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@role='menu']//a[contains(text(),'Logout')]")).click();
			Thread.sleep(2000);

			String loginUrl = driver.getCurrentUrl();
			if (loginUrl.contains("login")) {
				System.out.println("User has successfully logged out of the application and the url has the text login");
			}
		}

		driver.quit();

	}

}
