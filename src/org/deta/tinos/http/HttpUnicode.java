package org.deta.tinos.http;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpUnicode{
	//这个函数在作者去年开发股市分析软件的时候从雪球等网站采样抓数据，发现有GBK 
	//utf-8 gb2312 ascii 等格式数据比较混乱，于是进行统一格式处理。
	public String getJson(String urlString, String jsonString) throws IOException{
		String code= "";
		URL url= new URL(urlString);
		HttpURLConnection connection= (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-type", "application/json;charset=UTF-8"); 
		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		StringBuffer sbuffer= new StringBuffer();
		sbuffer.append(jsonString);
		OutputStream os= connection.getOutputStream();
		os.write(sbuffer.toString().getBytes());
		os.flush(); 
		StringBuilder stringBuilder= new StringBuilder();
		BufferedReader bufferedReader= null;
		try {
			InputStream inputStream= connection.getInputStream();
			int caherset_size= connection.getHeaderFields().size();
			for(int i= 0;i< caherset_size;i++) {
				String temp= connection.getHeaderField(i);
				if(temp.contains("charset")) {
					if(temp.contains("GBK")|| temp.contains("gbk")) {
						code= "GBK";
					}	
					if(temp.contains("UTF-8")|| temp.contains("utf-8")
							|| temp.contains("UTF8")|| temp.contains("utf8")) {
						code= "UTF-8";
					}
					if(temp.contains("GB2312")|| temp.contains("gb2312")) {
						code= "GB2312";
					}
					if(temp.contains("ASCII")|| temp.contains("ascii")) {
						code= "ASCII";
					}
					if(temp.contains("Unicode")|| temp.contains("UNICODE")
							|| temp.contains("unicode")) {
						code= "UNICODE";
					}
					if(temp.contains("ISO-8859-1")|| temp.contains("iso-8859-1")
							|| temp.contains("Iso-8859-1")) {
						code= "ISO-8859-1";
					}
				}
			}
			if (null!= inputStream) {
				bufferedReader=  new BufferedReader(new InputStreamReader(inputStream, code));   
				String lines;
				while ((lines= bufferedReader.readLine()) != null) {
					stringBuilder.append(lines); 	
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			//throw ex;
		} finally {
			if (null!= bufferedReader) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					//throw ex;
				}
			}
		}
		return new String(stringBuilder.toString().getBytes(),"UTF-8");	
	}

	public String postXML(String urlString,String XMLString) throws IOException{
		URL url= new URL(urlString);
		HttpURLConnection connection= (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/xml");
		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		StringBuffer sbuffer= new StringBuffer();
		sbuffer.append(XMLString);
		OutputStream os= connection.getOutputStream();
		os.write(sbuffer.toString().getBytes());
		os.flush();
		String requestBody= "";
		StringBuilder stringBuilder= new StringBuilder();
		BufferedReader bufferedReader= null;
		try {
			InputStream inputStream= connection.getInputStream();
			if (null!= inputStream) {
				bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer= new char[128];
				int bytesRead= -1;
				while ((bytesRead= bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (null!= bufferedReader) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
		requestBody= stringBuilder.toString();
		return requestBody;
	}

	public String postJsonWithSercurity(String urlString
			, String jsonString) throws IOException{
		URL url= new URL(urlString);
		HttpURLConnection connection= (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		StringBuffer sbuffer= new StringBuffer();
		sbuffer.append(jsonString);
		OutputStream os= connection.getOutputStream();
		os.write(sbuffer.toString().getBytes());
		os.flush();
		String requestBody= "";
		StringBuilder stringBuilder= new StringBuilder();
		BufferedReader bufferedReader= null;
		try {
			InputStream inputStream= connection.getInputStream();
			if (null!= inputStream) {
				bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer= new char[128];
				int bytesRead= -1;
				while ((bytesRead= bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (null!= bufferedReader) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
		requestBody= stringBuilder.toString();
		return requestBody;
	}

	public String postXMLWithSercurity(String urlString, String XMLString)
			throws IOException{
		URL url= new URL(urlString);
		HttpURLConnection connection= (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/xml");
		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		StringBuffer sbuffer= new StringBuffer();
		sbuffer.append(XMLString);
		OutputStream os= connection.getOutputStream();
		os.write(sbuffer.toString().getBytes());
		os.flush();
		String requestBody= "";
		StringBuilder stringBuilder= new StringBuilder();
		BufferedReader bufferedReader= null;
		try {
			InputStream inputStream= connection.getInputStream();
			if (null!= inputStream) {
				bufferedReader= new BufferedReader
						(new InputStreamReader(inputStream));
				char[] charBuffer= new char[128];
				int bytesRead= -1;
				while ((bytesRead= bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (null!= bufferedReader) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}
		requestBody= stringBuilder.toString();
		return requestBody;
	}

	public String getStatusFromString(String response) {
		for(int i=0;i<response.length();i++){
		}
		// TODO Auto-generated method stub
		return null;
	}

	public String getHTML(String urlString, Object object) throws IOException {
		URL url= new URL(urlString);
		HttpURLConnection connection= (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		StringBuilder stringBuilder= new StringBuilder();
		BufferedReader bufferedReader= null;
		String code= "GB2312";
		try {
			InputStream inputStream= connection.getInputStream();
			int caherset_size= connection.getHeaderFields().size();
			for(int i= 0; i< caherset_size; i++) {
				String temp= connection.getHeaderField(i);
				if(temp.contains("charset")|| temp.contains("type") ) {
					if(temp.contains("GBK")|| temp.contains("gbk")) {
						code= "GBK";
					}	
					if(temp.contains("UTF-8")|| temp.contains("utf-8")
							|| temp.contains("UTF8")|| temp.contains("utf8")) {
						code= "UTF-8";
					}
					if(temp.contains("GB2312")|| temp.contains("gb2312")) {
						code= "GB2312";
					}
					if(temp.contains("ASCII")|| temp.contains("ascii")) {
						code= "ASCII";
					}
					if(temp.contains("Unicode")|| temp.contains("UNICODE")
							|| temp.contains("unicode")) {
						code= "UNICODE";
					}
					if(temp.contains("ISO-8859-1")|| temp.contains("iso-8859-1")
							|| temp.contains("Iso-8859-1")) {
						code= "ISO-8859-1";
					}
				}
			}
			if (null!= inputStream) {
				bufferedReader= new BufferedReader(new InputStreamReader(inputStream,code));   
				char[] charBuffer= new char[128];
				int bytesRead= -1;
				while ((bytesRead= bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}

		} catch (IOException ex) {
		} finally {
			if (null!= bufferedReader) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
				}
			}
		}
		String out= new String(stringBuilder.toString().getBytes(), "UTF-8");
		return out;	
	}
}