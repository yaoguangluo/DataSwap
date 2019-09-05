package org.deta.tinos.string;

import java.io.UnsupportedEncodingException;

public class StringSequency{
	public static String[] stringToSequency(String[] string, int scale){
		//比较头
		for(int i= 0; i< string.length; i++) {
			for(int j= 0; j< string.length; j++) {
				if(string[i].charAt(0)< string[j].charAt(0)) {
					String temp= string[i].toString();
					string[i]= string[j].toString();
					string[j]= temp.toString();
				}
			}
		}	
		//比较身
		for(int k= 1; k< scale;k++) {
			for(int i= 0; i< string.length; i++) {
				for(int j= 0; j< string.length; j++) {
					if(string[i].length()> k&& string[j].length()> k) {
						if(string[i].charAt(k)< string[j].charAt(k)) {
							boolean find= true;
							for(int p= 0; p< k; p++) {
								if(string[i].charAt(p)!= string[j].charAt(p)) {
									find= false;
								}
							}
							if(find) {
								String temp= string[i].toString();
								string[i]= string[j].toString();
								string[j]= temp.toString();
							}
						}	
					}
				}
			}		
		}
		return string;
	}
		//DEMO
		public static void main(String[] argv) throws UnsupportedEncodingException {
			String testValue[]= new String[4];
			testValue[0]="bacded";
			testValue[2]="abcd";
			testValue[1]="abcedd";
			testValue[3]="bcaef";
			testValue= stringToSequency(testValue, 6);	
			System.out.println(testValue[0]);
			System.out.println(testValue[1]);
			System.out.println(testValue[2]);
			System.out.println(testValue[3]);	
		}
}