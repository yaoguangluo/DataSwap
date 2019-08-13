package org.deta.tinos.array;
import com.google.gson.Gson;
public class ArraySwap{
	public static String arrayToJson(Gson gson, Object[] object) {	
		return gson.toJson(object);
	}
}