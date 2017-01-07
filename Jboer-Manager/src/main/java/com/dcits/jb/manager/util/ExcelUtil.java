package com.dcits.jb.manager.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;


public class ExcelUtil {
	/**
	 * 
	 * @param excelFile  excel文档对象
	 * @param titleList  标题list
	 * @param steetNum   所见sheet页
	 * @param startRowNum 从第几行开始 第一行为0
	 * @param lastNoCount 从后向前数 丢弃的行数
	 * @return
	 */
	public static List<Map<String,String>> getExcelInfoListByHssf(InputStream is,String[] titleList,int steetNum,int startRowNum,int lastNoCount){
		List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
		try{
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			HSSFSheet hSSFSheet = hssfWorkbook.getSheetAt(steetNum);
			if(hSSFSheet == null){
				return resultList;
			}
			for(int i = startRowNum;i <= hSSFSheet.getLastRowNum() - lastNoCount;i++){
				HSSFRow hssfRow = hSSFSheet.getRow(i);
				if(hssfRow == null){
					continue;
				}
				if(titleList == null){
					continue;
				}
				Map<String,String> recordMap = new HashMap<String,String>();
				for(int j = 0;j < titleList.length;j++){
					String title = titleList[j];
					HSSFCell hssfCell = hssfRow.getCell(j);
					if (hssfCell == null) { 
	                    continue; 
	                }
					String value = getValue(hssfCell);
					recordMap.put(title, value);
				}
				resultList.add(recordMap);
			}
			return resultList;
		}catch(Exception e){
			e.printStackTrace();
			return resultList;
		}
	}
	
	
	public static void getExcelStreamByHssf(String[] chineseTitleList,String[] englishTitleList,Integer[] widths,List<HashMap<String,String>> recordList,String sheetTitle,OutputStream out) throws Exception{
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet sheet = hssfWorkbook.createSheet(sheetTitle);
		for(int i = 0;i < widths.length;i++){
			int width = widths[i].intValue();
			sheet.setColumnWidth(i,width);
		}
		
		HSSFCellStyle titleStyle  = ExcelUtil.setStyleA(hssfWorkbook);
		HSSFCellStyle recordStyle  = ExcelUtil.setStyleB(hssfWorkbook);
		
		//生成标题行
		HSSFRow titleRow = sheet.createRow(0);
		for(int i = 0;i < chineseTitleList.length;i++){
			HSSFCell cell = titleRow.createCell(i);
			cell.setCellStyle(titleStyle);
			HSSFRichTextString text = new HSSFRichTextString(chineseTitleList[i]);
			cell.setCellValue(text);
		}
		
		//生成记录
		for(int i = 0;i < recordList.size();i++){
			HashMap<String,String> valueMap = recordList.get(i);
			HSSFRow recordRow = sheet.createRow(i+1);
			for(int j = 0;j < englishTitleList.length;j++){
				HSSFCell cell = recordRow.createCell(j);
				cell.setCellStyle(recordStyle);
				String key = englishTitleList[j];
				String value =valueMap.get(key);
				HSSFRichTextString text = new HSSFRichTextString(value);
				//System.out.println(key + ":"+ value);
				cell.setCellValue(text);
			}
		}
		hssfWorkbook.write(out);
	}
	
	
	private static String getValue(HSSFCell hssfCell) {
		int cellType = hssfCell.getCellType();
        if (cellType == HSSFCell.CELL_TYPE_BOOLEAN) { 
            // 返回布尔类型的值 
            return String.valueOf(hssfCell.getBooleanCellValue()); 
        }else if (cellType == HSSFCell.CELL_TYPE_NUMERIC) { 
            // 返回数值类型的值 
        	double value = hssfCell.getNumericCellValue();
        	BigDecimal bigDecimal = new BigDecimal(value);
        	return String.valueOf(bigDecimal.toString()); 
        }else if (cellType == HSSFCell.CELL_TYPE_FORMULA) { 
            // 返回数值类型的值 
            return String.valueOf(hssfCell.getCellFormula()); 
        }else { 
            // 返回字符串类型的值 
            return String.valueOf(hssfCell.getStringCellValue()); 
        } 
    }
	
	
	private static HSSFCellStyle setStyle(HSSFWorkbook hssfWorkbook){//底色蓝，全居中，加粗
		HSSFCellStyle style = hssfWorkbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平对齐方式
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直方向对齐方式
		style.setBorderBottom(CellStyle.BORDER_THIN);//底边框
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setBorderRight(CellStyle.BORDER_THIN);//右边框
		style.setRightBorderColor(HSSFColor.BLACK.index);
		style.setBorderTop(CellStyle.BORDER_THIN);//头边框
		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setWrapText(true);
		
		HSSFFont font = hssfWorkbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("微软雅黑");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 11);
		
		style.setFont(font);
		return style;
	}
	
	
	public static HSSFCellStyle setStyleA(HSSFWorkbook hssfWorkbook){//底色蓝，全居中，加粗
		HSSFCellStyle style = hssfWorkbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);//底色
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);//填充方式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平对齐方式
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直方向对齐方式
		style.setBorderBottom(CellStyle.BORDER_THIN);//底边框
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setBorderRight(CellStyle.BORDER_THIN);//右边框
		style.setRightBorderColor(HSSFColor.BLACK.index);
		style.setBorderTop(CellStyle.BORDER_THIN);//头边框
		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setWrapText(true);
		
		HSSFFont font = hssfWorkbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("微软雅黑");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 11);
		style.setFont(font);
		return style;
	}
	
	/**
	 * 字体：11号，微软雅黑，加粗，黑色
	 * 底色百，靠左，细边框
	 */
	public static HSSFCellStyle setStyleB(HSSFWorkbook hssfWorkbook){//底色蓝，全居中，加粗
		HSSFCellStyle style = hssfWorkbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.WHITE.index);//底色
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);//填充方式
		style.setAlignment(CellStyle.ALIGN_LEFT);//水平对齐方式
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直方向对齐方式
		style.setBorderBottom(CellStyle.BORDER_THIN);//底边框
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setBorderRight(CellStyle.BORDER_THIN);//右边框
		style.setRightBorderColor(HSSFColor.BLACK.index);
		style.setBorderTop(CellStyle.BORDER_THIN);//头边框
		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setWrapText(true);
		
		HSSFFont font = hssfWorkbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("微软雅黑");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		font.setFontHeightInPoints((short) 11);
		style.setFont(font);
		return style;
	}
	
	/**
	 * 字体：11号，黑色
	 * 居中，细边框，黑色
	 */
	private static HSSFCellStyle setStyleC(HSSFWorkbook hssfWorkbook){//底色蓝，全居中，加粗
		HSSFCellStyle style = hssfWorkbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平对齐方式
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直方向对齐方式
		style.setBorderBottom(CellStyle.BORDER_THIN);//底边框
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setBorderRight(CellStyle.BORDER_THIN);//右边框
		style.setRightBorderColor(HSSFColor.BLACK.index);
		style.setBorderTop(CellStyle.BORDER_THIN);//头边框
		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setWrapText(true);
		
		HSSFFont font = hssfWorkbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 11);
		
		style.setFont(font);
		return style;
	}
	
	/**
	 * 字体：20号，黑色，加粗
	 * 居中，黑色细边框
	 */
	private static HSSFCellStyle setStyleD(HSSFWorkbook hssfWorkbook){//底色蓝，全居中，加粗
		HSSFCellStyle style = hssfWorkbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平对齐方式
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直方向对齐方式
		style.setBorderBottom(CellStyle.BORDER_THIN);//底边框
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setBorderRight(CellStyle.BORDER_THIN);//右边框
		style.setRightBorderColor(HSSFColor.BLACK.index);
		style.setBorderTop(CellStyle.BORDER_THIN);//头边框
		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setWrapText(true);
		
		HSSFFont font = hssfWorkbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 20);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
		style.setFont(font);
		return style;
	}
	
	
	private static HSSFCellStyle setStyleE(HSSFWorkbook hssfWorkbook){
		HSSFCellStyle style = hssfWorkbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//水平对齐方式
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直方向对齐方式
		style.setBorderBottom(CellStyle.BORDER_THIN);//底边框
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setBorderRight(CellStyle.BORDER_THIN);//右边框
		style.setRightBorderColor(HSSFColor.BLACK.index);
		style.setBorderTop(CellStyle.BORDER_THIN);//头边框
		style.setTopBorderColor(HSSFColor.BLACK.index);
		style.setWrapText(true);
		
		HSSFFont font = hssfWorkbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontName("微软雅黑");
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short) 11);
		
		style.setFont(font);
		return style;
	}
	public static void getExcelStreamByHssfNotify(String[] chineseTitleList,String[] englishTitleList,Integer[] widths,List<HashMap<String,String>> recordList,Map<String,String> map,String sheetTitle,OutputStream out) throws Exception{
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet sheet = hssfWorkbook.createSheet(sheetTitle);
		for(int i = 0;i < widths.length;i++){
			int width = widths[i].intValue();
			sheet.setColumnWidth(i,width);
		}
		
		HSSFCellStyle titleStyle  = ExcelUtil.setStyleA(hssfWorkbook);
		HSSFCellStyle recordStyle  = ExcelUtil.setStyleB(hssfWorkbook);
		
		//生成标题行
		HSSFRow titleRow = sheet.createRow(1);
		for(int i = 0;i < chineseTitleList.length;i++){
			HSSFCell cell = titleRow.createCell(i);
			cell.setCellStyle(titleStyle);
			HSSFRichTextString text = new HSSFRichTextString(chineseTitleList[i]);
			cell.setCellValue(text);
		}
		
		//生成记录
		for(int i = 0;i < recordList.size();i++){
			HashMap<String,String> valueMap = recordList.get(i);
			HSSFRow recordRow = sheet.createRow(i+2);
			for(int j = 0;j < englishTitleList.length;j++){
				HSSFCell cell = recordRow.createCell(j);
				cell.setCellStyle(recordStyle);
				String key = englishTitleList[j];
				String value =valueMap.get(key);
				HSSFRichTextString text = new HSSFRichTextString(value);
				//System.out.println(key + ":"+ value);
				cell.setCellValue(text);
			}
		}
			HSSFRow recordRow = sheet.createRow(0);
			String length = map.get("length");
			String sbf = map.get("sbf");
			CellRangeAddress region = new CellRangeAddress(0, 0, 0, Integer.parseInt(length)-1);
			sheet.addMergedRegion(region);
			HSSFCell cell = recordRow.createCell(0);
			HSSFCellStyle style = hssfWorkbook.createCellStyle();
			HSSFFont font = hssfWorkbook.createFont();
			font.setColor(HSSFColor.RED.index);
			font.setFontName("微软雅黑");
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setFontHeightInPoints((short) 13);
			
			style.setFont(font);
			HSSFRichTextString text = new HSSFRichTextString(sbf);
			//System.out.println(key + ":"+ value);
			cell.setCellValue(text);
			cell.setCellStyle(style);
			hssfWorkbook.write(out);
	}
}
