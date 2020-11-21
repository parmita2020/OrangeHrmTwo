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

public class PremierLeagueTable {

	public static void main(String[] args) throws Throwable {
//			1. Go to https://www.premierleague.com/tables
//			2. Capture all name from the table into excel doc (Apache POI)
//			3. Delete few names from excel 
//			4. Compare names from excel to webpage
//			5. Print missing names to console

		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.premierleague.com/tables");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

//		driver.findElement(By.xpath("//*[@id=\"advertClose\"]")).click();
		driver.findElement(By.xpath("/html/body/section/div/div")).click();

		List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr/td[3]/a/span[2]"));
		
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\parmi\\Desktop\\PremierLeague.xls"));
		
		HSSFWorkbook wb=new HSSFWorkbook(fis);
		HSSFSheet sheet=wb.getSheetAt(0);
		for (int i =0;i<teams.size();i++) {
			
			 System.out.println(teams.get(i).getText().trim());
			 sheet.getRow(i).getCell(0).setCellValue(teams.get(i).getText().trim());
			 FileOutputStream fso= new FileOutputStream("C:\\Users\\parmi\\Desktop\\PremierLeague.xls");
			 wb.write(fso);
		
			 driver.close();
	}

}}