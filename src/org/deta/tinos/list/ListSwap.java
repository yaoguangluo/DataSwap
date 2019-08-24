package org.deta.tinos.list;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class ListSwap{
	public static String listToJsonString(Gson gson, List<Object> list){
		return gson.toJson(list);
	}

	public static Object stringListToJsonString(Gson gson, List<String> list) {
		return gson.toJson(list);
	}

	public static String listToXml(Gson gson, List<Object> list){
		return XML.toString(new JSONObject(gson.toJson(list)));
	}

	public static String listToMap(Gson gson, List<Object> list){
		return gson.fromJson(new JSONObject(gson.toJson(list)).toString()
				, new TypeToken<Map<String, Object>>(){}.getType());
	}

	public static Object[] listToObjectArray(Gson gson, List<Object> list){
		Object[] object= new Object[list.size()];
		Iterator<Object> iterator= list.iterator();
		int i=0;
		while(iterator.hasNext()) {
			object[i++]= iterator.next();
		}
		return object;
	}

	public static Iterator<Object> listToIterator(Gson gson, List<Object> list){
		return list.iterator();
	}
}