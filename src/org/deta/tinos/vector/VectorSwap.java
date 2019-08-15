package org.deta.tinos.vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
public class VectorSwap{
	public static Map<String, Object> vectorToMap(Vector<Object> vector){
		Map<String, Object> map= new HashMap<>();
		Iterator<Object> iterator= vector.iterator();
		int i= 0;
		while(iterator.hasNext()) {
			map.put(""+ i++, iterator.next());
		}
		return map;
	}

	public static List<Object> vectorToList(Vector<Object> vector){
		List<Object> list= new ArrayList<>();
		Iterator<Object> iterator= vector.iterator();
		while(iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}

	public static Object[] vectorToArray(Vector<Object> vector){
		Iterator<Object> iterator= vector.iterator();
		Object[] objects= new Object[vector.size()];
		int i= 0;
		while(iterator.hasNext()) {
			objects[i++]= iterator.next();
		}
		return objects;
	}
}