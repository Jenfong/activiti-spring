package com.casic.activiti.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;


public class URLUtil {
	public static final String ROOTURL = "rootURL";
	public static final String IMGURL = "imgURL";

	public static String getBasePath(HttpServletRequest request) throws IOException {

		

		String weburl = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		String Scheme = request.getScheme();
		String localAddr = request.getServerName();
		int port = request.getServerPort();
		if (port == 80) {
			weburl = Scheme + "://" + localAddr + weburl;
		} else {
			weburl = Scheme + "://" + localAddr + ":" + port + weburl;
		}
		return weburl + "/";
	}
	
	
	/**
	 * 获得工程绝对的路径
	 * @param request
	 * @return
	 */
	public static String getProjectRealPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("/");
	}

	public static void decoder(Object obj) {
		if (obj != null) {
			Field[] fls = obj.getClass().getDeclaredFields();
			for (Field fl : fls) {
				if (fl.getType().getName().equals("java.lang.String")) {
					fl.setAccessible(true);
					try {
						String value = (String) fl.get(obj);
						if (value != null) {
							try {
								fl.set(obj, URLDecoder.decode(value, "UTF-8"));
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				}
			}
		}

	}
}
