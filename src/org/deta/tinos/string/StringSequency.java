package org.deta.tinos.string;
public class StringSequency{
	public static String stringToSequency(String string){
		char[] chars= string.toCharArray();
		for(int i= 0; i< chars.length; i++) {
			for(int j= 0; j< chars.length; j++) {
				if(chars[i]< chars[j]) {
					char temp= chars[i];
					chars[i]= chars[j];
					chars[j]= temp;
				}
			}
		}	
		return String.valueOf(chars);	
	}
	
	public static String[] stringToSequencyArray(String[] string, int scale){
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
		for(int k= 1; k< scale; k++) {
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
	//			//DEMO
	public static void main(String[] argv) {
		//1
		String testValue[]= new String[5];
		testValue[0]= "ba罗cded";
		testValue[1]= "瑶aBcedd";
		testValue[2]= "瑶Ab罗cd";
		testValue[3]= "bCaef";
		testValue[4]= "BCaef";
		testValue= stringToSequencyArray(testValue, 6);	
		System.out.println(testValue[0]);
		System.out.println(testValue[1]);
		System.out.println(testValue[2]);
		System.out.println(testValue[3]);	
		System.out.println(testValue[4]);
		//2			
		////				String value= "AabusahudBDHDbuHgfUiGgfj";
		////				System.out.println(stringToSequency(value));
	}
}