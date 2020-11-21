import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackandForward {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[id=\"nav-xshop\"]/a[6]")).click();

		Thread.sleep(5000);
		
		driver.navigate().back();

		Thread.sleep(5000);
		
		driver.navigate().forward();

	}

}
