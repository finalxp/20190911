package com.xskj.controller;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import org.springframework.boot.CommandLineRunner;

import com.xskj.utils.POIUtil;

public class posttips implements CommandLineRunner  {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------------开始执行-------------");
		
		Cell cell = null;
		Cell cell2 = null;

		// String fileToBeRead = "C:\\licensetips.xlsx";

		String fileToBeRead = "\\\\192.168.18.210\\xiaosheng\\公用\\声纹引擎许可期限文档.xlsx";

		Workbook workbook;

		StringBuffer sb = new StringBuffer();

		try {

			int indexOf = fileToBeRead.indexOf(".xlsx");
			System.out.println(indexOf);

			if (fileToBeRead.indexOf(".xlsx") > -1) {
				workbook = new XSSFWorkbook(new FileInputStream(fileToBeRead));
			} else {
				workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
			}

			Sheet sheet = workbook.getSheet("Sheet1"); // 创建对工作表的引用
			int rows = sheet.getPhysicalNumberOfRows();// 获取表格的行数
			int columns = 0;
			for (int r = 0; r < rows; r++) { // 循环遍历表格的行
				if (r == 0) {
					// 在第一行标题行计算出列宽度,因为数据行中可能会有空值
					columns = sheet.getRow(r).getLastCellNum();// 列
					continue;
				}

				Row row = sheet.getRow(r); // 获取单元格中指定的行对象
				if (row != null) {
					// int cells = row.getPhysicalNumberOfCells();// 获取一行中的单元格数

					// int cells = row.getLastCellNum();// 获取一行中最后单元格的编号（从1开始）

					/*
					 * for (short c = 0; c < columns; c++) { // 循环遍历行中的单元格 Cell
					 * cell = row.getCell((short) c); if (cell != null) { //
					 * value += getCellValue(cell) + ",";
					 * sb.append(POIUtil.getCellValue(cell)).append(" "); } }
					 */
					cell = row.getCell((short) 0);
					cell2 = row.getCell((short) 2);

				}
				// String[] str = value.split(",");
				// System.out.println(sb.toString());

				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println(dateFormat.format(date));

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date d1 = df.parse(POIUtil.getCellValue(cell2));
				Date d2 = df.parse(df.format(new Date()));
				System.out.println(d2);
				long diff = d1.getTime() - d2.getTime();// 这样得到的差值是微秒级别
				long days = diff / (1000 * 60 * 60 * 24);

				System.out.println("days------->" + days);

				if (days == 30 || days == 29 || days == 31) {
					sb.append(cell).append(",许可期限剩余 一个月。");

				}

				if (days == 7 || days == 8 || days == 6) {
					sb.append(cell).append(",许可期限剩余 一星期。");
				}

				if (days < 15 && days > 0) {
					sb.append(cell).append(",许可期限剩余：").append(days + "天。");
				}

				// test
				/*
				 * if (days > 0) {
				 * sb.append(cell).append(",引擎许可期限剩余天数：").append(
				 * days).append("\r");
				 * 
				 * }
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (sb.length() != 0) {
				JFrame jFrame = new JFrame();

				JPanel jPanel = new JPanel();
				String string = new String();
				string = sb.toString();

				JLabel jLabel = new JLabel(string);
				jPanel.add(jLabel);
				jFrame.add(jPanel);

				jFrame.setLayout(new FlowLayout(1));
				jFrame.setTitle("引擎许可期限提醒");
				jFrame.setSize(550, 100);
				jFrame.setVisible(true);
				jFrame.setDefaultCloseOperation(3);
				jFrame.setLocationRelativeTo(null);

				// System.out.println(sb);
			}
		} catch (HeadlessException e) {

			e.printStackTrace();
		}
		
	}

}
