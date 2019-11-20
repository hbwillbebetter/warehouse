package com.easyExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.handler.WriteHandler;

public class Test {
	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void test() throws IOException{
		List<User> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			User user = new User();
			user.setName(UUID.randomUUID().toString());
			user.setAge("10");
			user.setSex("男");
			list.add(user);
		}
		OutputStream outputStream = new FileOutputStream("2007.xlsx");
		// 这里要把上面创建的样式类通过构造函数传入
		ExcelWriter writer = new ExcelWriter(null, outputStream,ExcelTypeEnum.XLSX, true, (WriteHandler) new AfterWriteHandlerImpl());
//		ExcelWriter writer = new ExcelWriter(null, outputStream,ExcelTypeEnum.XLSX, true);
		Sheet sheet1 = new Sheet(1, 1, User.class, "s1", null);
		// 设置列宽 设置每列的宽度
		Map columnWidth = new HashMap();
		columnWidth.put(0, 10000);
		columnWidth.put(1, 10000);
		columnWidth.put(2, 10000);
		columnWidth.put(3, 10000);
//		sheet1.setColumnWidthMap(columnWidth);
		// 或自适应宽度
		sheet1.setAutoWidth(true);

		writer.write(list, sheet1);
		writer.finish();
		outputStream.close();
	      
	}
	public void test1() throws IOException{
		List<User> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			User user = new User();
			user.setName(UUID.randomUUID().toString());
			user.setAge("10");
			user.setSex("男");
			list.add(user);
		}
		OutputStream outputStream = new FileOutputStream("2007文件.xlsx");
		// 这里要把上面创建的样式类通过构造函数传入
//		ExcelWriter writer = new ExcelWriter(null, outputStream,ExcelTypeEnum.XLSX, true, (WriteHandler) new StyleExcelHandler());
//		ExcelWriter writer = new ExcelWriter(null, outputStream,ExcelTypeEnum.XLSX, true);
		ExcelWriter writer = EasyExcelFactory.getWriterWithTempAndHandler(null, outputStream, ExcelTypeEnum.XLSX, true, (com.alibaba.excel.event.WriteHandler) new AfterWriteHandlerImpl());
		Sheet sheet1 = new Sheet(1, 1, User.class);
		sheet1.setSheetName("第一个sheet");
		// 设置列宽 设置每列的宽度
		Map columnWidth = new HashMap();
		columnWidth.put(0, 10000);
		columnWidth.put(1, 10000);
		columnWidth.put(2, 10000);
		columnWidth.put(3, 10000);
//		sheet1.setColumnWidthMap(columnWidth);
		// 或自适应宽度
		sheet1.setAutoWidth(true);
		
		writer.write(list, sheet1);
		writer.finish();
		outputStream.close();
		
	}
}





















