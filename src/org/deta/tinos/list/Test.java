package org.deta.tinos.list;
import java.util.List;
import com.google.gson.Gson;
public class Test{
	public static String ListToJsonString(Gson gson, List<Object> list){
		return gson.toJson(list);
	}
	
	public static Object StringListToJsonString(Gson gson, List<String> list) {
		return gson.toJson(list);
	}
}