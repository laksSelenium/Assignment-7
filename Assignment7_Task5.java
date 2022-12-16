//Open below application
// Run all the above tests in Chrome, Firefox, Edge Browser
package assignment_7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment7_Task5 {

	public static void main(String[] args) throws InterruptedException {

		// Run tests using chrome
		WebDriver chdriver = new ChromeDriver();
		System.out.println("Working in chrome browser");

		executeRequiredFieldTest(chdriver);
		executeVerifyPasswordTest(chdriver);
		executeInvalidCredentialsTest(chdriver);
		executeloginLogoutTest(chdriver);

		// Run tests in firefox
		WebDriver gedriver = new FirefoxDriver();
		System.out.println("========================");
		System.out.println("Working in Firefox browser");
		executeRequiredFieldTest(gedriver);
		executeVerifyPasswordTest(gedriver);
		executeInvalidCredentialsTest(gedriver);
		executeloginLogoutTest(gedriver);

		// Run tests in Edge
		WebDriver eddriver = new EdgeDriver();
		System.out.println("========================");
		System.out.println("Working in Edge browser");
		executeRequiredFieldTest(eddriver);
		executeVerifyPasswordTest(eddriver);
		executeInvalidCredentialsTest(eddriver);
		executeloginLogoutTest(eddriver);

	}

	public static void executeRequiredFieldTest(WebDriver driver) throws InterruptedException {

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

		if (userNameRequired && passWordRequired) {
			System.out.println("Required fields are username and password");
		}

		if (userNameBorderStatus && passWordBorderStatus) {
			System.out.println("Both username and password fields has a border of 1px");
		}

	}

	public static void executeVerifyPasswordTest(WebDriver driver) throws InterruptedException {

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

	}

	public static void executeInvalidCredentialsTest(WebDriver driver) throws InterruptedException {

		WebElement userName = driver.findElement(By.xpath("//label[contains(text(),'User')]//following::input[1]"));
		WebElement passWord = driver.findElement(By.xpath("//label[contains(text(),'Pass')]//following::input"));

		// enter username and password
		userName.clear();
		userName.sendKeys("admin");
		passWord.sendKeys("mukesh");

		// click login button to understand required fields
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(5000);

		WebElement invalidCredential = driver.findElement(By.xpath("//div[contains(@class,'alert')]//p"));

		boolean invalidCredentialMsg = invalidCredential.isDisplayed();

		String actualinvalidCredentialMsg = invalidCredential.getText();

		if (invalidCredentialMsg && (actualinvalidCredentialMsg.contains("Invalid credentials"))) {
			System.out.println("Credentials are incorrect and hence invalid credentials msg is displayed");
		}

	}

	public static void executeloginLogoutTest(WebDriver driver) throws InterruptedException {

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
				System.out
						.println("User has successfully logged out of the application and the url has the text login");
			}
		}

		driver.quit();
	}

}
