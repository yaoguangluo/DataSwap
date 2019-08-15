package org.deta.tinos.string;
import org.json.XML;
import org.json.JSONObject;
import com.google.gson.Gson;
public class StringSwap{
	public static String stringToJsonObject(Gson gson, String string){
		return gson.toJson(string);
	}
	
	public static String stringToXml(Gson gson, String string){
		JSONObject jSONObject= new JSONObject(gson.toJson(string));
		return XML.toString(jSONObject);	
	}
	
	public static String[] stringToArray(String stopBy, String string){
		String[] strings= string.split(stopBy); 
		return strings;	
	}
}