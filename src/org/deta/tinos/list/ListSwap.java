package org.deta.tinos.list;
import java.util.List;
import com.google.gson.Gson;
public class ListSwap{
	public static String listToJsonString(Gson gson, List<Object> list){
		return gson.toJson(list);
	}
	
	public static Object stringListToJsonString(Gson gson, List<String> list) {
		return gson.toJson(list);
	}
}