package org.deta.tinos.date;
import java.util.Date;
@SuppressWarnings("deprecation")
public class DateSwap{
	public static String dateToGMTString(Date date) {	
		return date.toGMTString();
	}
	
	public static String dateToYYYYMMDD(Date date) {	
		return ""+ date.getYear()+ ":"+ date.getMonth()+ ":"+ date.getDay();
	}
	
	public static String dateToHHMMSS(Date date) {	
		return ""+ date.getHours()+ ":"+ date.getMinutes()+ ":"+ date.getSeconds();
	}
	
	public static String dateToMiliSeconds(Date date) {	
		return ""+ date.getTime();
	}
	
	public static String getCurrentMiliSeconds(Date date) {	
		return ""+ new Date().getTime();
	}
}