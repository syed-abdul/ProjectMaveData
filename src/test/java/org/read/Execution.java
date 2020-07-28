package org.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Execution {
	@DataProvider(name="pro",parallel=true)
	public Object[][] dataProvider() throws IOException {
		return getData();
		
	}

public Object[][] getData() throws IOException {
String data="";
	File f=new File("C:\\Users\\ragavboom\\eclipse-workspace\\MavenData1\\div\\Book2.xlsx");
	FileInputStream stream=new FileInputStream(f);
	Workbook w=new XSSFWorkbook(stream);
	
	Sheet s = w.getSheet("Sheet1");
	Row row = s.getRow(0);
	int getRows = s.getPhysicalNumberOfRows();
	int getCells = row.getPhysicalNumberOfCells();
	Object [][] obj=new Object[getRows][getCells];
	
for(int i=0;i<getRows;i++) {
	Row row2 = s.getRow(i);
	for(int j=0;j<getCells;j++) {
		Cell cell = row2.getCell(j);
		
		int type = cell.getCellType();
		
		if(type==1) {
		 data = cell.getStringCellValue();
		}
		else {
			double dou = cell.getNumericCellValue();
			long l=(long)dou;
			 data = String.valueOf(l);
		}
		obj[i][j]=data;
	}
	

}
return obj;
}
}