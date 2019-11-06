package org.deta.tinos.string;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.deta.tinos.array.LYG4DWithDoubleQuickSort4D;
public class LYG4DWithMixObjectSort7D{
	public List<Object> sortMapToListByDoubleKey(Map<Double, Object> objects, int leftPosition
			, int rightPosition, int scale, Map<String, String> map, int range){
		Iterator<Double> iterator= objects.keySet().iterator();
		double[] doubles= new double[objects.size()];
		int i= 0;
		while(iterator.hasNext()) {
			doubles[i++]= iterator.next();
		}	
		new LYG4DWithDoubleQuickSort4D().sort(doubles);
		List<Object> lists= new ArrayList<>();
		for(double set: doubles) {
			lists.add(objects.get(set));
		}
		return lists;
	}
	
	public List<Object> sortMapToList(Map<String, Object> objects, int leftPosition
			, int rightPosition, int scale, Map<String, String> map, int range){
		Iterator<String> iterator= objects.keySet().iterator();
		String[] strings= new String[objects.size()];
		int i= 0;
		while(iterator.hasNext()) {
			strings[i++]= iterator.next();
		}	
		new LYG4DWithChineseMixStringSort7D().quick4DChineseStringArray(strings, leftPosition
				, rightPosition, scale, map, range);
		List<Object> lists= new ArrayList<>();
		for(String string: strings) {
			lists.add(objects.get(string));
		}
		return lists;
	}

	public Object[] sortMapToObjectArray(Map<String, Object> objects, int leftPosition
			, int rightPosition, int scale, Map<String, String> map, int range){
		Iterator<String> iterator= objects.keySet().iterator();
		String[] strings= new String[objects.size()];
		int i= 0;
		while(iterator.hasNext()) {
			strings[i++]= iterator.next();
		}	
		new LYG4DWithChineseMixStringSort7D().quick4DChineseStringArray(strings, leftPosition
				, rightPosition, scale, map, range);
		Object[] objectArray= new Object[strings.length];
		i= 0;
		for(String string: strings) {
			objectArray[i++]= objects.get(string);
		}
		return objectArray;
	}
	
	public List<Object> sortStringArrayToList(String[] strings, int leftPosition
			, int rightPosition, int scale, Map<String, String> map, int range){
		new LYG4DWithChineseMixStringSort7D().quick4DChineseStringArray(strings, leftPosition
				, rightPosition, scale, map, range);
		List<Object> lists= new ArrayList<>();
		for(String string: strings) {
			lists.add(string);
		}
		return lists;
	}

	public String[] sortListToStringArray(List<String> list, int leftPosition
			, int rightPosition, int scale, Map<String, String> map, int range){
		String[] strings= new String[list.size()];
		Iterator<String> iterator= list.iterator();
		int i= 0;
		while(iterator.hasNext()) {
			strings[i++]= iterator.next();
		}	
		new LYG4DWithChineseMixStringSort7D().quick4DChineseStringArray(strings, leftPosition
				, rightPosition, scale, map, range);
		return strings;
	}

	public List<String> sortListToList(List<String> list, int leftPosition
			, int rightPosition, int scale, Map<String, String> map, int range){
		String[] strings= new String[list.size()];
		Iterator<String> iterator= list.iterator();
		int i= 0;
		while(iterator.hasNext()) {
			strings[i++]= iterator.next();
		}	
		new LYG4DWithChineseMixStringSort7D().quick4DChineseStringArray(strings, leftPosition
				, rightPosition, scale, map, range);		
		List<String> lists= new ArrayList<>();
		for(String string: strings) {
			lists.add(string);
		}
		return lists;
	}
}