package com.dcits.djk.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DayUtil {
	public static void main(String[] args) throws ParseException {
		Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse("2016-03-22");
		Date fromDate = new Date();
		int i = DayUtil.dateDiff(fromDate, toDate);
		System.out.println(i);
	}
	/**
	 * 计算两个日期间的天数
	 * 
	 * @param fromDate
	 *            起始日期
	 * @param toDate
	 *            结束日期
	 * @return
	 * @throws ParseException
	 */
	public static int dateDiff(Date fromDate, Date toDate){
		int days = 0;
		try{
			long i = toDate.getTime() - fromDate.getTime();
			if(i<0){
				days = -1;
				return days;
			}
			int resultDay = (int) Math.abs((toDate.getTime() - fromDate.getTime()) % (24 * 60 * 60 * 1000));
			if(resultDay == 0){
				days = (int) Math.abs((toDate.getTime() - fromDate.getTime()) / (24 * 60 * 60 * 1000));
			}else{
				days = (int) Math.abs((toDate.getTime() - fromDate.getTime()) / (24 * 60 * 60 * 1000)) + 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return days;
	}
}
