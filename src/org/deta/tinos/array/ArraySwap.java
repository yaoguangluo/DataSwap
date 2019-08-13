package org.deta.tinos.array;
import com.google.gson.Gson;
public class ArraySwap{
	public static String ArrayToJson(Gson gson, Object[] object) {	
		return gson.toJson(object);
	}
}