package org.deta.tinos.vector;
import java.util.Map;
import java.util.Vector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class VectorSwap{
	public static Map<String, Object> vectorToMap(Gson gson, Vector<Object> vector){
		return gson.fromJson(gson.toJson(vector), new TypeToken<Map<String, Object>>(){}.getType());
	}
}