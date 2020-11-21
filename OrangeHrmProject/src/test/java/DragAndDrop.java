import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
		driver.manage().window().maximize();
		
		WebElement source = driver.findElement(By.xpath("//*[contains(text(),'Draggable 1')]"));
		WebElement target = driver.findElement(By.id("mydropzone"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(source,target).perform();
		
			

	}

}
