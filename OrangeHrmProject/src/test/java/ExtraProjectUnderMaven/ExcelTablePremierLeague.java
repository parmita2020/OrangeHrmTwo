package ExtraProjectUnderMaven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelTablePremierLeague {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.premierleague.com/tables");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/section/div/div")).click();

		List<WebElement> teams = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[1]/div[5]/div/div/div/table"));
		
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\parmi\\Desktop\\SeleniumPractice\\PremierLeague.xls"));
		
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sheet=wb.getSheetAt(0);
		for (int i =0;i<teams.size();i++) {
			
			 System.out.println(teams.get(i).getText().trim());
			 sheet.getRow(i).getCell(0).setCellValue(teams.get(i).getText().trim());
			 FileOutputStream fso= new FileOutputStream("C:\\Users\\parmi\\Desktop\\SeleniumPractice\\PremierLeague.xls");
			 wb.write(fso);
			}
			
		}
		
	}
