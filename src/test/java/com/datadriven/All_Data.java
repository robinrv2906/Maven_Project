package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class All_Data {

	private static void all_data() throws IOException {
		File f = new File("C:\\Users\\ELCOT\\Desktop\\Book.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		int NumberOfRows = sheetAt.getPhysicalNumberOfRows();

		for (int i = 0; i < NumberOfRows; i++) {
			Row row = sheetAt.getRow(i);
			
			int NumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < NumberOfCells; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				
				if (cellType.equals(CellType.STRING)) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				} else if (cellType.equals(CellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					int data = (int) numericCellValue;
					System.out.println(data);
				}
			}
		}
		wb.close();
	}
	public static void main(String[] args) throws IOException {
		all_data();
	}

}
