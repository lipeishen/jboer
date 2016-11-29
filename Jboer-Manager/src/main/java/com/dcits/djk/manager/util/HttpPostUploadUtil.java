package com.dcits.djk.manager.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.dcits.djk.manager.env.FileuploadEnv;

import net.sf.json.JSONObject;

/**
 * @author xingyxa
 * @date 创建时间：2016年3月8日 下午9:05:01
 * @version 1.0
 * @since 1.8
 */
public class HttpPostUploadUtil {
	/**
	 * 上传图片
	 * 
	 * @param urlStr
	 * @param textMap
	 * @param fileMap
	 * @return
	 */
	public static Map<String, Object> formUpload(Map<String, String> textMap, Map<String, String> fileMap) {
		String res = "";
		Map<String, Object> result = new HashMap<String, Object>();
		String urlStr = FileuploadEnv.getImgUploadUrlForServer();
		HttpURLConnection conn = null;
		DataInputStream in = null;
		OutputStream out = null;
		BufferedReader reader = null;
		FileInputStream fin  = null;
		String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
		InputStreamReader fs=null;
		try {
			URL url = new URL(urlStr + "html");
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

			out = new DataOutputStream(conn.getOutputStream());
			if (textMap != null) {
				StringBuffer strBuf = new StringBuffer();
				Iterator<Map.Entry<String, String>> iter = textMap.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry<String, String> entry = iter.next();
					String inputName = (String) entry.getKey();
					String inputValue = (String) entry.getValue();
					if (inputValue == null) {
						continue;
					}
					strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
					strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
					strBuf.append(inputValue);
				}
				out.write(strBuf.toString().getBytes());
			}
			// file
			if (fileMap != null) {
				Iterator<Map.Entry<String, String>> iter = fileMap.entrySet().iterator();
				while (iter.hasNext()) {
					try {
						Map.Entry<String, String> entry = iter.next();
						String inputName = (String) entry.getKey();
						String inputValue = (String) entry.getValue();
						if (inputValue == null) {
							continue;
						}
						File file = new File(inputValue);
						String filename = file.getName();
						String contentType = getMimeType(inputValue);

						StringBuffer strBuf = new StringBuffer();
						strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
						strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename
								+ "\"\r\n");
						strBuf.append("Content-Type:" + contentType + "\r\n\r\n");

						out.write(strBuf.toString().getBytes());
						fin  = new FileInputStream(file);
						in = new DataInputStream(fin);
						int bytes = 0;
						byte[] bufferOut = new byte[1024];
						while ((bytes = in.read(bufferOut)) != -1) {
							out.write(bufferOut, 0, bytes);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						safeClose(fin);
						safeClose(in);
					}
					
				}
			}

			byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
			out.write(endData);
			out.flush();

			// 读取返回数据
			StringBuffer strBuf = new StringBuffer();
			 fs=new InputStreamReader(conn.getInputStream());
			reader = new BufferedReader(fs);
			String line = null;
			while ((line = reader.readLine()) != null) {
				strBuf.append(line).append("\n");
			}
			res = strBuf.toString();

			result = toHashMap(res);
			System.out.println(result.get("original"));
			System.out.println(res);
		} catch (Exception e) {
			System.out.println("发送POST请求出错。" + urlStr);
			e.printStackTrace();
		} finally {
			safeClose(reader);
			reader = null;
			safeClose(out);
			safeClose(in);
			safeClose(fin);
			safeClose(fs);
			try{
				if (conn != null) {
					conn.disconnect();
					conn = null;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 根据文件路径得到文件类型
	 * 
	 * @author xingyxa
	 * @param fileUrl
	 * @return 文件类型
	 * @throws java.io.IOException
	 */
	public static String getMimeType(String fileUrl) throws java.io.IOException {
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String type = fileNameMap.getContentTypeFor(fileUrl);

		return type;
	}

	/**
	 * 将json格式的字符串解析成Map对象
	 * <li>json格式：{"name":"admin","retries":"3fff","testname"
	 * :"ddd","testretries":"fffffffff"}
	 */
	private static Map<String, Object> toHashMap(String object) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		// 将json字符串转换成jsonObject
		JSONObject jsonObject = JSONObject.fromObject(object);
		Iterator it = jsonObject.keys();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			data.put(key, value);
		}
		return data;
	}
	/**
	 * 安全的关闭可关闭对象，忽略异常
	 * 
	 * @param closeable
	 */
    public static final void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Exception ignore) {}
        }
    }
}
