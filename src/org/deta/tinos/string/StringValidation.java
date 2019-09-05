package org.deta.tinos.string;
import java.util.Map;
import org.deta.tinos.stable.Stable;
public class StringValidation{
	public static String stringCodeFilter(String string, String swapSymbol
			, String collection){
		StringBuilder stringBuilder= new StringBuilder();
		for(int i= 0; i< string.length(); i++) {
			if(collection.contains(Stable.STRING_EMPTY+ string.charAt(i))){
				stringBuilder.append(swapSymbol);
			}else {
				stringBuilder.append(string.charAt(i));
			}
		}
		return stringBuilder.toString();
	}
	
	public static String stringCodeFilter(String string, String swapSymbol
			, Map<String, Boolean> collection){
		StringBuilder stringBuilder= new StringBuilder();
		for(int i= 0; i< string.length(); i++) {
			if(collection.containsKey(Stable.STRING_EMPTY+ string.charAt(i))){
				stringBuilder.append(swapSymbol);
			}else {
				stringBuilder.append(string.charAt(i));
			}
		}
		return stringBuilder.toString();
	}
}