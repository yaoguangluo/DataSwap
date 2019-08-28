package org.deta.tinos.list;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ListValidation{
	public static boolean ListSetsCheck(List<Object> list, String setsType) {
		Iterator<Object> iterator= list.iterator();
		while(iterator.hasNext()) {
			Object object= iterator.next();
			if(setsType.equalsIgnoreCase("double")) {
				if(!(object instanceof Double)) {
					return false;
				}	
			}
			if(setsType.equalsIgnoreCase("int")) {
				if(!(object instanceof Integer)) {
					return false;
				}	
			}
			if(setsType.equalsIgnoreCase("float")) {
				if(!(object instanceof Float)) {
					return false;
				}	
			}
			if(setsType.equalsIgnoreCase("string")) {
				if(!(object instanceof String)) {
					return false;
				}	
			}
			if(setsType.equalsIgnoreCase("short")) {
				if(!(object instanceof Short)) {
					return false;
				}	
			}
			if(setsType.equalsIgnoreCase("boolean")) {
				if(!(object instanceof Boolean)) {
					return false;
				}	
			}
			if(setsType.equalsIgnoreCase("long")) {
				if(!(object instanceof Long)) {
					return false;
				}	
			}
			if(setsType.equalsIgnoreCase("byte")) {
				if(!(object instanceof Byte)) {
					return false;
				}	
			}
		}
		return true;	
	}

	public static List<Object> ListSetsFix(List<Object> list, String setsType) {
		List<Object> output= new ArrayList<>();
		Iterator<Object> iterator= list.iterator();
		while(iterator.hasNext()) {
			Object object= iterator.next();
			if(setsType.equalsIgnoreCase("double")) {
				if(!(object instanceof Double)) {
					output.add((double)0.00);
				}else {
					output.add(object);
				}

			}
			if(setsType.equalsIgnoreCase("int")) {
				if(!(object instanceof Integer)) {
					output.add((int)0);
				}else {
					output.add(object);
				}
			}
			if(setsType.equalsIgnoreCase("float")) {
				if(!(object instanceof Float)) {
					output.add((float)0.0);
				}else {
					output.add(object);
				}
			}
			if(setsType.equalsIgnoreCase("string")) {
				if(!(object instanceof String)) {
					output.add("");
				}else {
					output.add(object);
				}
			}
			if(setsType.equalsIgnoreCase("short")) {
				if(!(object instanceof Short)) {
					output.add((short)0);
				}else {
					output.add(object);
				}
			}
			if(setsType.equalsIgnoreCase("boolean")) {
				if(!(object instanceof Boolean)) {
					output.add(false);
				}else {
					output.add(object);
				}
			}
			if(setsType.equalsIgnoreCase("long")) {
				if(!(object instanceof Long)) {
					output.add((long)(0));
				}else {
					output.add(object);
				}
			}
			if(setsType.equalsIgnoreCase("byte")) {
				if(!(object instanceof Byte)) {
					output.add((byte)0);
				}else {
					output.add(object);
				}
			}
		}
		return output;	
	}
}