package Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://helloskillio.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By closeBtnelement = By.xpath("//a[@class='dialog-close-button dialog-lightbox-close-button']");
		WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeBtnelement));
		closeBtn.click();
		
		WebElement freeResource = driver.findElement(By.xpath("//a[text()='Free Resources']"));
		Actions action = new Actions(driver);
		action.moveToElement(freeResource).perform();
		By assignmentlocator = By.xpath("(//a[contains(text(),'Assignment')])[2]");
		WebElement assignment = wait.until(ExpectedConditions.visibilityOfElementLocated(assignmentlocator));
		assignment.click();
		
		//action.scrollByAmount(0, 500).perform();
		WebElement dropdownBtn = driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-f3df3c3 elementor-widget elementor-widget-heading']"));
		action.scrollToElement(dropdownBtn).pause(Duration.ofSeconds(1)).perform();
		//dropdownBtn = wait.until(ExpectedConditions.elementToBeClickable(dropdownBtn));
		dropdownBtn.click();
		driver.quit();
		
	}

}
