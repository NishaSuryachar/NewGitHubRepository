package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExternalFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		//step1: open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\AdvanceSeleniumVTigerApplicationTestDataFile.xlsx");
		
		//step 2: create a workBook
	    Workbook wb=WorkbookFactory.create(fis);
	    
	    //step3 : Navigate to required sheet
	    Sheet sheet = wb.getSheet("Contacts");
	    
	    
	    //step4: Navigate to required row
	    Row rw = sheet.getRow(1);
	    
	    //step5: Navigate to required cell
	    Cell cl = rw.getCell(2);
	    
	    //step6: capture the data
	    String value = cl.getStringCellValue();
	    System.out.println(value);
	    
	    //step7:close the workbook
	    wb.close();
	 }
}
//