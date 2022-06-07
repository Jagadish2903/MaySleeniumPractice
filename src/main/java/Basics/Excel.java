package Basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	
	public static Workbook book;
	public static Sheet sheet;
	public static void main(String[] args) {
		
		Object data[][]=null;
		
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\Jaggulav\\Desktop\\TestDataSample.xlsx");
			
			book=WorkbookFactory.create(ip);
			sheet=book.getSheet("LoginDetails");
			data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
					String testdata=sheet.getRow(i+1).getCell(j).toString();
					System.out.println(testdata);
					
				}
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			
			
		}
		

	}

}
