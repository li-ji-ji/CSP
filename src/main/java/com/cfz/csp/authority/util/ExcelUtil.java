package com.cfz.csp.authority.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.cfz.csp.authority.po.Student;



public class ExcelUtil implements Serializable {
	
	public List<Student> importXLS(String filePath) {

		List<Student> list = new java.util.ArrayList<Student>();

		try {
			// 1、获取文件输入流
			InputStream inputStream = new FileInputStream(filePath);
			// 2、获取Excel工作簿对象
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			// 3、得到Excel工作表对象
			HSSFSheet sheetAt = workbook.getSheetAt(0);
			// 4、循环读取表格数据
			for (Row row : sheetAt) {
				// 首行（即表头）不读取
				if (row.getRowNum() == 0) {
					continue;
				}
				
				// 读取当前行中单元格数据，索引从0开始
				
				String sn = row.getCell(0).getStringCellValue();
				String name = row.getCell(1).getStringCellValue();
				String dormitoryAdd = row.getCell(2).getStringCellValue();
				/**
				 * POI读取Excel文件时，对纯数字单元格的处理
				 */
//				String phone = String.valueOf((int)Math.round(row.getCell(3).getNumericCellValue()));
				HSSFCell cell3 = (HSSFCell) row.getCell(3);
				cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
				String phone = cell3.getStringCellValue();
				String email = row.getCell(4).getStringCellValue();
				String college = row.getCell(5).getStringCellValue();
				String classes = row.getCell(6).getStringCellValue();
//				String grade = String.valueOf((int)row.getCell(7).getNumericCellValue());
				String major = row.getCell(8).getStringCellValue();
				String famillyAdd = row.getCell(9).getStringCellValue();
//				System.out.println(sn);
//				System.out.println(name);
//				System.out.println(dormitoryAdd);
//				System.out.println(phone);
//				System.out.println(email);
//				System.out.println(college);
//				System.out.println(classes);
//				System.out.println(grade);
//				System.out.println(major);
//				System.out.println(famillyAdd);
				Student student = new Student();
				student.setSn(sn);
				student.setName(name);
				student.setDormitoryAdd(dormitoryAdd);
				student.setPhone(phone);
				student.setEmail(email);
				student.setCollege(college);
				student.setClasses(classes);
//				student.setGrade(grade);
				student.setMajor(major);
				student.setFamillyAdd(famillyAdd);
				list.add(student);
			}
			// 5、关闭流
			workbook.close();

		} catch (IOException e) {
	        	e.printStackTrace();
		}
		return list;
	}
}
