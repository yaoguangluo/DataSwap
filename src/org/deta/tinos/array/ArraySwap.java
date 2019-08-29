package org.deta.tinos.array;
import org.json.XML;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import org.json.JSONObject;
import com.google.gson.Gson;
public class ArraySwap{
	public static String arrayToJson(Gson gson, Object[] object) {	
		return gson.toJson(object);
	}

	public static String arrayToXml(Gson gson, Object[] object) {	
		return XML.toString(new JSONObject(gson.toJson(object)));
	}

	public static Map<String, Object> arrayToMap(Gson gson
			, Object[] objects) {	
		Map<String, Object> map= new HashMap<>();
		int i= 0;
		for(Object object: objects) {
			map.put(""+ i++, object);
		}		
		return map;
	}

	public static Vector<Object> arrayToVector(Gson gson
			, Object[] objects) {	
		Vector<Object> vector= new Vector<>();
		for(Object object: objects) {
			vector.add(object);
		}		
		return vector;
	}

	public static List<Object> arrayToList(Object[] objects) {	
		List<Object> list= new ArrayList<>();
		for(Object object: objects) {
			list.add(object);
		}		
		return list;
	}

	public static Iterator<Object> arrayToIterator(Object[] objects) {	
		List<Object> list= new ArrayList<>();
		for(Object object: objects) {
			list.add(object);
		}		
		return list.iterator();
	}

	public static Set<Object> arrayToSet(Object[] objects) {	
		Set<Object> sets= new TreeSet<>();
		for(Object object: objects) {
			sets.add(object);
		}		
		return sets;
	}
}