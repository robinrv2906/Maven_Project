package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Data {
	private static void write_Data() throws IOException {
		File f=new File("C:\\Users\\ELCOT\\Desktop\\Book.xlsx");
		FileInputStream fis =new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		
//		 Sheet createSheet = wb.createSheet("Sample");
//		 Row createRow = createSheet.createRow(0);
//		 Cell createCell = createRow.createCell(0);
//		 createCell.setCellValue("Username");
		
		wb.createSheet("Sample").createRow(0).createCell(0).setCellValue("Username");
		wb.getSheet("Sample").getRow(0).createCell(1).setCellValue("Email");
		wb.getSheet("Sample").getRow(0).createCell(2).setCellValue("Password");
		wb.getSheet("Sample").createRow(1).createCell(0).setCellValue("Prabu");
		wb.getSheet("Sample").getRow(1).createCell(1).setCellValue("prabudon8@gmail.com");
		wb.getSheet("Sample").getRow(1).createCell(2).setCellValue("prabu@123");
		
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		
		//System.exit(0);
		System.out.println("write successfully");
		wb.close();
		
	}
	public static void main(String[] args) throws IOException {
		write_Data();
	}
}
