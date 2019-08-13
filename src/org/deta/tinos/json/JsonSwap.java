package org.deta.tinos.json;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class JsonSwap{
	public static Map<String, Object> jsonObjectToMap(Gson gson, JSONObject jSONObject){
		return gson.fromJson(jSONObject.toString()
				, new TypeToken<Map<String, Object>>(){}.getType());
	}

	public static List<Object> jsonArrayToList(JSONArray jSONArray) {
		List<Object> list= new ArrayList<>();
		for(int i= 0; i< jSONArray.length(); i++){		
			Object object= jSONArray.get(i);
			if(object instanceof JSONObject){
				list.add(jsonObjectToMap(new Gson(),jSONArray.getJSONObject(i)));
			}else if(object instanceof String){
				list.add(String.valueOf(object));
			}else if(object instanceof JSONArray){
				list.add(jsonArrayToList(jSONArray.getJSONArray(i)));
			}
		}
		return list;	
	}
}