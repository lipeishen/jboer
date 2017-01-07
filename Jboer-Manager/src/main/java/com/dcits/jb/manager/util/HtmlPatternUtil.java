package com.dcits.jb.manager.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 替换健康资讯内容中的图片路径
 * @author cuiwt
 *
 */
public class HtmlPatternUtil {

	public static String[] getImgs(String content) {
		String img = "";
		Pattern p_image;
		Matcher m_image;
		String str = "";
		String[] images = null;
		String regEx_img = "(<img.*src\\s*=\\s*(.*?)[^>]*?>)";
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(content);
		while (m_image.find()) {
			img = m_image.group();
			Matcher m = Pattern.compile("src\\s*=\\s*'?(.*?)('|>|\\s+)").matcher(img);
			while (m.find()) {
				String tempSelected = m.group(1);
				if ("".equals(str)) {
					str = tempSelected;
				} else {
					String temp = tempSelected;
					str = str + "," + temp;
				}
			}
		}
		if (!"".equals(str)) {
			images = str.split(",");
		}
		return images;
	}
//	public static void main(String[] args) {
//		String htmlStr = "<p>文章内容图片<img alt='图片' src='http://aa.com'>文章内涵图<img alt='图片' src='http://bb.com.cn'><img alt='图片' src='http://cc.com'><img alt='图片' src='http://dd.com'></p>";
//		String[] imgs = getImgs(htmlStr);
//		for (int i = 0; i < imgs.length; i++) {
//			System.out.println(imgs[i]);
//			htmlStr = htmlStr.replace(imgs[i], imgs[i].toUpperCase(Locale.ENGLISH));
//		}
//		System.out.println(htmlStr);
//	}
}
