package org.deta.tinos.date;
import java.sql.Timestamp;
import java.util.Date;
@SuppressWarnings({"deprecation", "static-access"})
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

	public static Timestamp dateToTimeStamp(Date date) {
		long utc= date.UTC(date.getYear(), date.getMonth(), date.getDay()
				, date.getHours(), date.getMinutes(), date.getSeconds());
		return new Timestamp(utc);
	}
	
	public static long timeStampToMiliSeconds(Timestamp timestamp) {
		return timestamp.getTime();
	}
	
	public static String dateStringToMiliSeconds(String string) {
		return ""+ new Date(string).getTime();
	}
	
	
	
}