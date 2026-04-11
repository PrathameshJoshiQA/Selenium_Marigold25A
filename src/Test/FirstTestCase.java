package Test;

import java.nio.channels.SelectableChannel;
import java.time.Duration;
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

public class FirstTestCase {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new EdgeDriver();
		driver.get("https://helloskillio.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class=\"dialog-close-button dialog-lightbox-close-button\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Free Resources')]")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement assignment = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Assignments')])[2]"))
		);
		assignment.click();
		WebElement drpDown=driver.findElement((By.xpath("//a[contains (text(), 'DropDown List Assignment')]")));
		Actions action=new Actions(driver);
		action.scrollToElement(drpDown).pause(Duration.ofSeconds(1)).perform();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains (text(), 'DropDown List Assignment')]")));
		//Thread.sleep(2000);
		drpDown.click();
		WebElement monthDrpDown=driver.findElement(By.xpath("//select[@class=\"single-select\"]"));
		Select s=new Select(monthDrpDown);
		s.selectByValue("Feb");
		WebElement multiDrpDown=driver.findElement(By.xpath("//select[@class=\"multi-select\"]"));
		Select multiSelect=new Select(multiDrpDown);
		multiSelect.selectByVisibleText("Core Java");
		multiSelect.selectByVisibleText("Selenium WebDriver");
		List<WebElement> Options=multiSelect.getAllSelectedOptions();
		for (WebElement option : Options) {
			System.out.println(option.getText());			
		}
		driver.quit();		
	}

}
