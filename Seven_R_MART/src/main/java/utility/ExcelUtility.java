package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	static FileInputStream f; // to get details from file
	static XSSFWorkbook w; // to get details from workbook
	static XSSFSheet s; // to get details from sheet

	public static String getStringData(int a, int b, String sheet) throws IOException

	{
		String filepath = Constant.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();
	}

	public static String getIntegerData(int a, int b, String sheet) throws IOException {
		String filepath = Constant.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(a);
		XSSFCell c = r.getCell(b);
		int y = (int) c.getNumericCellValue();// type casting
		return String.valueOf(y);
	}

}