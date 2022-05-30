package com.pwc.stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.pwc.utilities.ProjectConfiguration;

public class Basic {
	
	public String url;
	public String testDataPath;
	public String testSheet;

	public void dataReadFromConfigFile() {

		url  = ProjectConfiguration.loadProperties("url");
		testDataPath  = ProjectConfiguration.loadProperties("testDataPath");
		testSheet  = ProjectConfiguration.loadProperties("testSheet");
		
	}
	
	
	protected Map<String, Object> readDataFromExcel(String keyword, String testDataPath, String testSheet) {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		HSSFWorkbook hfsswrkBook;
		try {
			hfsswrkBook = new HSSFWorkbook( new FileInputStream(testDataPath));
			HSSFSheet hssfSheet = hfsswrkBook.getSheet(testSheet);
			
			for (Row row:hssfSheet) {
				if(row.getCell(0).getStringCellValue().trim().equals(keyword)) {
					for (Cell cell: row) {
						returnMap.put(hssfSheet.getRow(0).getCell(cell.getColumnIndex()).getStringCellValue(), cell);
					}
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		System.out.println(returnMap);
		
		return returnMap;
	}
	
	
	public void takeScreenshoot(int counter, WebDriver driver) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshotFile = new File ("Screenshot/step"+counter+".jpg");
		FileUtils.copyFile(src, screenshotFile);
		
		
		
	}
	

	protected void closeBrowser(WebDriver driver) {
		if(driver  !=null) {
			driver.quit();
		}

		
	}


}
