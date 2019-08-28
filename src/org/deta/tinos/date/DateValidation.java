package org.deta.tinos.date;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
//refer www.bjtime.com 第 16，17，18行 共三行
//注意如果bjtime 网站关闭了这个功能，该函数将无效，请再互联网搜索其他提供时间校验的网址。
public class DateValidation{
	public static boolean currentSystemTimeCheck(long offsetUTC8) throws IOException {
		URL url= new URL("http://www.bjtime.cn");
		URLConnection uRLConnection= url.openConnection();
		uRLConnection.connect();
		long bjtime= uRLConnection.getDate();
		long system= currentSystemTimeToUTC(offsetUTC8);
		if(60000< Math.abs(bjtime- system)) {
			return false;
		}
		return true;	
	}

	public static long currentSystemTimeToUTC(long offsetUTC8) {
		return new Date().getTime()+ offsetUTC8;
	}
}