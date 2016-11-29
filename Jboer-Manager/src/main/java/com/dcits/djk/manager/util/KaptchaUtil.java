package com.dcits.djk.manager.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;

public class KaptchaUtil {
	public static boolean validateKaptcha(HttpServletRequest req,String validateCode){
		HttpSession session = req.getSession();
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(code == null || code.equals("")){
        	return false;
        }
        boolean flag = false;
        if(validateCode != null && !validateCode.equals("")){
        	if(validateCode.equalsIgnoreCase(code)){
            	flag = true;
            }
        }
        return flag;
	}
}
