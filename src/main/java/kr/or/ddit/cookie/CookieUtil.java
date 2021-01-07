package kr.or.ddit.cookie;

import javax.servlet.http.Cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	/**
	 * Method : getCookieValue
	 * 작성자 : PC-14
	 * 변경이력 :
	 * @param cookieStr
	 * @param cookieName
	 * @return
	 * Method 설명 : cookieStr에서 cookieName에 해당하는 쿠키 값을 조회
	 */
	
	//cookieStr : "userid=brown; rememberme=Y; test=test"
	//cookieName : userid, rememberme
	//return : brown, Y
	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);
	public static String getCookieValue(String cookieStr,String cookieName) {
		
		String[] cookies = cookieStr.split("; ");
//		String[] cn = cookieStr.split("= ");
		for(String cookieString : cookies) {
			logger.debug(cookieString);
			
			String [] cookie = cookieString.split("=");
			//cookie[0] = 쿠키이름
			//cookie[1] = 쿠키이름
			
			//찾고자 하는 쿠키 이름인지 확인
			if(cookie[0].equals(cookieName)) {
				return cookie[1];
			}
			
		}
		//cookies[0] = userid=brown
		//cooikes[1] = rememberme=Y
		//cooikes[2] = test=testcookie
		
		return "";
	}
}
