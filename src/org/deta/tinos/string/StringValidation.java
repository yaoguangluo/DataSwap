package org.deta.tinos.string;

public class StringValidation{
	public static String stringCodeFilter(String string, String swapSymbol, String collection){
		StringBuilder stringBuilder= new StringBuilder();
		for(int i= 0; i< string.length(); i++) {
			if(collection.contains(""+ string.charAt(i))){
				stringBuilder.append(swapSymbol);
			}else {
				stringBuilder.append(string.charAt(i));
			}
		}
		return string;
	}
}