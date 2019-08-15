package org.deta.tinos.vector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class VectorSwap{
	public static Map<String, Object> vectorToMap(Gson gson, Vector<Object> vector){
		return gson.fromJson(gson.toJson(vector), new TypeToken<Map<String, Object>>(){}.getType());
	}

	public static List<Object> vectorToList(Gson gson, Vector<Object> vector){
		List<Object> list= new ArrayList<>();
		Iterator<Object> iterator= vector.iterator();
		while(iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}

	public static Object[] vectorToArray(Gson gson, Vector<Object> vector){
		Iterator<Object> iterator= vector.iterator();
		Object[] objects= new Object[vector.size()];
		int i= 0;
		while(iterator.hasNext()) {
			objects[i++]= iterator.next();
		}
		return objects;
	}
}