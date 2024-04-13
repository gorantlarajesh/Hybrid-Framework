package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
	static FileInputStream  fis;
	static XSSFWorkbook  xw;
	
    public static HashMap<String, String> getDataFromExcel(String testcase) {
    	try {
			 fis = new FileInputStream("C:\\New folder/Adactin test-cases.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  try {
			xw =new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  XSSFSheet xs =xw.getSheet("Sheet1");
    	  ArrayList<Row> testCaseRows = getTestData(xs, testcase);
    	  HashMap<String, String>  allDataAll = new HashMap<String, String>();
    	  for(int i=0; i<testCaseRows.size();i++) {
    	Row	 finalrows = testCaseRows.get(i);
    	for(int j=1; j<finalrows.getLastCellNum();j++) {
    		allDataAll.put(testCaseRows.get(0).getCell(j).getStringCellValue(), testCaseRows.get(1).getCell(j).getStringCellValue());
    	}
    	  }
		return allDataAll ;
    	    
    }

	private static ArrayList<Row> getTestData(XSSFSheet xs, String testcase) {
		ArrayList<Row> allrows = new ArrayList<Row>();
		for(int i=0; i<=xs.getLastRowNum();i++) {
			if(xs.getRow(i)!=null) {
				allrows.add(xs.getRow(i));
			}
		}
		 ArrayList<Row> testCaseRows = new ArrayList<Row>();
		 for(int i=0; i<allrows.size();i++) {
			 if(allrows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testcase)) {;
			 testCaseRows.add(allrows.get(i));
		 }
	
	}
		return testCaseRows;
	
	}
}