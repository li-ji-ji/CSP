package cn.lhj.csp.authority.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import cn.lhj.csp.authority.po.Student;



public class ExcelUtil implements Serializable {
	
	public List<Student> importXLS(String filePath) {
		List<Student> list = new java.util.ArrayList<Student>();
		int rowlen = 0;
		try {
			// 1、获取文件输入流
			InputStream inputStream = new FileInputStream(filePath);
			// 2、获取Excel工作簿对象
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			// 3、得到Excel工作表对象
			HSSFSheet sheetAt = workbook.getSheetAt(0);
			System.out.println(sheetAt);
			// 4、循环读取表格数据
			int len = 0;
			for (Row row : sheetAt) {
				// 首行（即表头）不读取
				if (row.getRowNum() == 0) {
					continue;
				}
				// 读取当前行中单元格数据，索引从0开始
//				0
				HSSFCell cell0 = (HSSFCell) row.getCell(0);
				cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
				String sn = cell0.getStringCellValue();
//				1
				String name = row.getCell(1).getStringCellValue();
//				2
				String dormitoryAdd = row.getCell(2).getStringCellValue();
				
//				3
//				String phone = String.valueOf((int)Math.round(row.getCell(3).getNumericCellValue()));
				/**
				 * POI读取Excel文件时，对纯数字单元格的处理
				 */
				HSSFCell cell3 = (HSSFCell) row.getCell(3);
				cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
				String phone = cell3.getStringCellValue();
//				4
				String email = row.getCell(4).getStringCellValue();
				String college = row.getCell(5).getStringCellValue();
				String classes = row.getCell(6).getStringCellValue();
				HSSFCell cell7 = (HSSFCell) row.getCell(7);
				cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
				String grade = cell7.getStringCellValue();
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
				student.setGrade(grade);
				student.setMajor(major);
				student.setFamillyAdd(famillyAdd);
				list.add(student);
				len += 1;
				rowlen += 1;
			}
			// 5、关闭流
			System.out.println("表的长度="+len);
			
			//workbook.close();
		
		} catch (IOException e) {
System.out.println("表内对象在"+rowlen+"行出现了问题！");
	        	e.printStackTrace();
		}
		System.out.println(rowlen);
		System.out.println("list长度=="+list.size());
		return list;
	}
}
