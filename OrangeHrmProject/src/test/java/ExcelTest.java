

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws Throwable {
		
		System.out.println("hello java");
//		How to read any Row/Column from Excel File
		FileInputStream fis = new FileInputStream(new File("C:/Test/ParmitaExcel.xls"));
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(0);

		String value = sheet.getRow(2).getCell(0).getStringCellValue();
		System.out.println(value);

//		How to write in any Row/Column in Excel File
		sheet.getRow(2).getCell(0).setCellValue("Jahid");
		FileOutputStream fso = new FileOutputStream("C:/Test/ParmitaExcel.xls");
		wb.write(fso);

		String Value2 = sheet.getRow(2).getCell(0).getStringCellValue();
		System.out.println(Value2);

	}

}
