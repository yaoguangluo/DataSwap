package org.deta.tinos.xml;
import org.json.XML;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import org.deta.tinos.json.JsonSwap;
import com.google.gson.reflect.TypeToken;

public class XMLSwap{
	//  剔除个人著作权 申请范围
	//	public static JSONObject xmlToJsonObject(String string){
	//		return XML.toJSONObject(string);
	//	}

	public static List<Object> xmlToList(String string, String key) {
		JSONArray jSONArray= XML.toJSONObject(string).getJSONArray(key);
		List<Object> list= new ArrayList<>();
		for(int i= 0; i< jSONArray.length(); i++){		
			Object object= jSONArray.get(i);
			if(object instanceof JSONObject){
				list.add(new Gson().fromJson(jSONArray.getJSONObject(i).toString()
						, new TypeToken<Map<String, Object>>(){}.getType()));
			}else if(object instanceof String){
				list.add(String.valueOf(object));
			}else if(object instanceof JSONArray){
				list.add(JsonSwap.jsonArrayToList(jSONArray.getJSONArray(i)));
			}
		}
		return list;	
	}
	
	//  剔除个人著作权 申请范围
	//	public static Map<String, Object> xmlToMap(Gson gson, String string){
	//		return gson.fromJson(XML.toJSONObject(string).toString()
	//				, new TypeToken<Map<String, Object>>(){}.getType());
	//	}
}