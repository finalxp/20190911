package com.xskj.controller;

import java.io.FileInputStream;



import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;

import com.xskj.utils.POIUtil;


public class getExcell {

	/*public static void main(String[] args) {

		String fileToBeRead = "C:\\licensetips.xlsx";
        Workbook workbook;
        try {
        	
        	int indexOf = fileToBeRead.indexOf(".xlsx");
        	System.out.println(indexOf);
        	
            if (fileToBeRead.indexOf(".xlsx") > -1) {
                workbook = new XSSFWorkbook(new FileInputStream(fileToBeRead));
            } else {
                workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
            }
            // HSSFWorkbook workbook = new HSSFWorkbook(new
            // FileInputStream(fileToBeRead)); //2003 创建对Excel工作簿文件的引用
            // XSSFWorkbook workbook = new XSSFWorkbook(new
            // FileInputStream(fileToBeRead)); //2007,2010 创建对Excel工作簿文件的引用
            Sheet sheet = workbook.getSheet("Sheet1"); // 创建对工作表的引用
            int rows = sheet.getPhysicalNumberOfRows();// 获取表格的
            int columns = 0;
            for (int r = 0; r < rows; r++) { // 循环遍历表格的行
                if (r == 0) {
                    // 在第一行标题行计算出列宽度,因为数据行中可能会有空值
                    columns = sheet.getRow(r).getLastCellNum();
                    continue;
                }
                // String value = "";
                StringBuilder sb = new StringBuilder();
                Row row = sheet.getRow(r); // 获取单元格中指定的行对象
                if (row != null) {
                    // int cells = row.getPhysicalNumberOfCells();// 获取一行中的单元格数

                    // int cells = row.getLastCellNum();// 获取一行中最后单元格的编号（从1开始）
                    for (short c = 0; c < columns; c++) { // 循环遍历行中的单元格
                        Cell cell = row.getCell((short) c);
                        if (cell != null) {
                            // value += getCellValue(cell) + ",";
                            sb.append(POIUtil.getCellValue(cell)).append(" ");
                        }
                    }
                }
                // String[] str = value.split(",");
                System.out.println(sb.toString());
                
                
                Map<String, String> map = new HashMap<String, String>();
                
               
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	}*/

 

}
