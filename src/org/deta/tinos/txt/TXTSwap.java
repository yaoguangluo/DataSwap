package org.deta.tinos.txt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class TXTSwap{
	//注意字节编码的读写正确
	public static Object[][] txtFileToObjectMatrix(String filePath, String stopBy) throws IOException {		
		Object[][] object= new Object[65535][];
		InputStream in= new FileInputStream(new File(filePath));
		BufferedReader cReader= new BufferedReader(new InputStreamReader(in));  
		String ctempString= null; 
		int i= 0;
		while ((ctempString= cReader.readLine())!= null) {  
			object[i++]=ctempString.split(stopBy);
		}
		cReader.close();
		return object;
	}

	public static List<String> txtFileToListString(String filePath) throws IOException {		
		List<String> list= new ArrayList<>();
		InputStream in= new FileInputStream(new File(filePath));
		BufferedReader cReader= new BufferedReader(new InputStreamReader(in));  
		String ctempString= null; 
		while ((ctempString= cReader.readLine())!= null) {  
			list.add(ctempString);
		}
		cReader.close();
		return list;
	}

	public static List<String[]> txtFileToListStringArray(String filePath, String stopBy) throws IOException {		
		List<String[]> list= new ArrayList<>();
		InputStream in= new FileInputStream(new File(filePath));
		BufferedReader cReader= new BufferedReader(new InputStreamReader(in));  
		String ctempString= null; 
		while ((ctempString= cReader.readLine())!= null) {  
			list.add(ctempString.split(stopBy));
		}
		cReader.close();
		return list;
	}
}