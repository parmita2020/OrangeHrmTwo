import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		WebElement acctBtn = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]"));
		
		Actions act =new Actions(driver);
		
		act.moveToElement(acctBtn).perform();

	}

}
