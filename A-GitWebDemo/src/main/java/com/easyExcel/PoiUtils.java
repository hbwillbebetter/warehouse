package com.easyExcel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;


public class PoiUtils {
    /* 
     * 列头单元格样式
     */    
    public static CellStyle getColumnTopStyle(Workbook workbook) {

	// 设置字体
	Font font = workbook.createFont();
	//设置字体大小
	font.setFontHeightInPoints((short)12);
	//字体加粗
	font.setBold(true);
	//设置字体名字 
	font.setFontName("宋体");
	//设置样式; 
	CellStyle style = workbook.createCellStyle();
	//设置底边框; 
	style.setBorderBottom(BorderStyle.THIN);
	//设置底边框颜色;  
	style.setBottomBorderColor((short) 0);
	//设置左边框;   
	style.setBorderLeft(BorderStyle.THIN);
	//设置左边框颜色; 
	style.setLeftBorderColor((short) 0);
	//设置右边框; 
	style.setBorderRight(BorderStyle.THIN);
	//设置右边框颜色; 
	style.setRightBorderColor((short) 0);
	//设置顶边框; 
	style.setBorderTop(BorderStyle.THIN);
	//设置顶边框颜色;  
	style.setTopBorderColor((short) 0);
	//在样式用应用设置的字体;  
	style.setFont(font);
	//设置自动换行; 
	style.setWrapText(false);
	//设置水平对齐的样式为居中对齐;  
	style.setAlignment(HorizontalAlignment.CENTER);
	//设置垂直对齐的样式为居中对齐; 
	style.setVerticalAlignment(VerticalAlignment.CENTER);

	return style;

    }
    /* 
     * 字段样式
     */    
    public static CellStyle getColumnStyle(Workbook workbook) {

	// 设置字体
	Font font = workbook.createFont();
	//设置字体大小
	font.setFontHeightInPoints((short)10);
	//字体加粗
	font.setBold(true);
	//设置字体名字 
	font.setFontName("宋体");
	//设置样式; 
	CellStyle style = workbook.createCellStyle();
	//设置底边框; 
	style.setBorderBottom(BorderStyle.THIN);
	//设置底边框颜色;  
	style.setBottomBorderColor((short) 0);
	//设置左边框;   
	style.setBorderLeft(BorderStyle.THIN);
	//设置左边框颜色; 
	style.setLeftBorderColor((short) 0);
	//设置右边框; 
	style.setBorderRight(BorderStyle.THIN);
	//设置右边框颜色; 
	style.setRightBorderColor((short) 0);
	//设置顶边框; 
	style.setBorderTop(BorderStyle.THIN);
	//设置顶边框颜色;  
	style.setTopBorderColor((short) 0);
	//在样式用应用设置的字体;  
	style.setFont(font);
	//设置自动换行; 
	style.setWrapText(true);
	//设置水平对齐的样式为居中对齐;  
	style.setAlignment(HorizontalAlignment.CENTER);
	//设置垂直对齐的样式为居中对齐; 
	style.setVerticalAlignment(VerticalAlignment.CENTER);
	//背景色
	style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());// 设置背景色  
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	return style;

    }

    /*  
     * 列数据信息单元格样式
     */  
    public static CellStyle getStyle(Workbook workbook) {
	// 设置字体
	Font font = workbook.createFont();
	//设置字体大小
	font.setFontHeightInPoints((short)9);
	//字体加粗
	//font.setBold(true);
	//设置字体名字 
	font.setFontName("宋体");
	//设置样式; 
	CellStyle style = workbook.createCellStyle();
	//设置底边框; 
	style.setBorderBottom(BorderStyle.THIN);
	//设置底边框颜色;  
	style.setBottomBorderColor((short) 0);
	//设置左边框;   
	style.setBorderLeft(BorderStyle.THIN);
	//设置左边框颜色; 
	style.setLeftBorderColor((short) 0);
	//设置右边框; 
	style.setBorderRight(BorderStyle.THIN);
	//设置右边框颜色; 
	style.setRightBorderColor((short) 0);
	//设置顶边框; 
	style.setBorderTop(BorderStyle.THIN);
	//设置顶边框颜色;  
	style.setTopBorderColor((short) 0);
	//在样式用应用设置的字体;  
	style.setFont(font);
	//设置自动换行; 
	style.setWrapText(false);
	//设置水平对齐的样式为居中对齐;  
	style.setAlignment(HorizontalAlignment.LEFT);
	//设置垂直对齐的样式为居中对齐; 
	style.setVerticalAlignment(VerticalAlignment.CENTER);

	return style;
    }
}
