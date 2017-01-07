package com.dcits.jb.util;

import java.util.List;

import com.huaban.analysis.jieba.JiebaSegmenter;

public class splitUtil {
	
/*	public static void main(String[] args) {
		   String text = "前任拉甘送苏宁首败落后恒大6分争冠难了";
	      cutString(text);
		
	}*/
  
	public static List<String> cutString(String in){
		List<String> str1=null;
		   JiebaSegmenter segmenter = new JiebaSegmenter();
		   str1=segmenter.sentenceProcess(in);
	       System.out.println(str1);
		return str1;
	}

}
