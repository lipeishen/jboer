package com.dcits.jb.manager.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.UIManager;

/**
 * @author xingyxa
 * @date 创建时间：2016年3月3日 上午10:18:18
 * @version 1.0
 * @since 1.8
 */
public class DownFileUtil {

	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
			chooser.setDialogTitle("选择保存路径");
			chooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " + chooser.getSelectedFile().getPath());
			}
		} catch (Exception e) {
		}

	}

	/**
	 * 下载远程文件并保存到本地
	 * 
	 * @param remoteFilePath
	 *            远程文件路径
	 * @param localFilePath
	 *            本地文件路径
	 */
	public void downloadFile(String remoteFilePath, String localFilePath) {
		URL urlfile = null;
		HttpURLConnection httpUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		File f = new File(localFilePath);
		try {
			urlfile = new URL(remoteFilePath);
			httpUrl = (HttpURLConnection) urlfile.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(f));
			int len = 2048;
			byte[] b = new byte[len];
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (httpUrl!=null) {
					httpUrl.disconnect();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
