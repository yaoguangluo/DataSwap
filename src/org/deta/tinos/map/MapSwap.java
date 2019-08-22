package org.deta.tinos.map;
import org.json.XML;
import java.util.Map;
import org.json.JSONObject;
import com.google.gson.Gson;
public class MapSwap{
	public static String mapToJsonString(Gson gson, Map<String, Object> map){
		return gson.toJson(map);
	}
	
	public static String mapToXml(Gson gson, Map<String, Object> map){
		JSONObject jSONObject= new JSONObject(gson.toJson(map));
		return XML.toString(jSONObject);	
	}

}