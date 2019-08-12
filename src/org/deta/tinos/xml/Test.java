package org.deta.tinos.xml;
import org.json.XML;
import java.util.Map;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Test{
	public static JSONObject XmlToJsonObject(String string){
		return XML.toJSONObject(string);
	}

	public static Map<String, Object> XmlToMap(Gson gson,String string){
		return gson.fromJson(XML.toJSONObject(string).toString()
				, new TypeToken<Map<String, Object>>(){}.getType());
	}
}