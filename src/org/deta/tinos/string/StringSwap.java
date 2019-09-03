package org.deta.tinos.string;
import org.json.XML;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.deta.tinos.json.JsonSwap;
import com.google.gson.reflect.TypeToken;
@SuppressWarnings("deprecation")
public class StringSwap{
	public static String stringToJsonObject(Gson gson, String string){
		return gson.toJson(string);
	}

	public static String stringToXml(Gson gson, String string){
		JSONObject jSONObject= new JSONObject(gson.toJson(string));
		return XML.toString(jSONObject);	
	}

	public static String[] stringToArray(String stopBy, String string){
		String[] strings= string.split(stopBy); 
		return strings;	
	}

	public static List<Object> stringToList(Gson gson, String string
			, String key){
		JSONArray jSONArray= XML.toJSONObject(string).getJSONArray(key);
		List<Object> list= new ArrayList<>();
		for(int i= 0; i< jSONArray.length(); i++){		
			Object object= jSONArray.get(i);
			if(object instanceof JSONObject){
				list.add(new Gson().fromJson(jSONArray
						.getJSONObject(i).toString(), new TypeToken<Map<String
						, Object>>(){}.getType()));
			}else if(object instanceof String){
				list.add(String.valueOf(object));
			}else if(object instanceof JSONArray){
				list.add(JsonSwap.jsonArrayToList(jSONArray.getJSONArray(i)));
			}
		}
		return list;	
	}

	public static Map<String, Object> stringToMap(Gson gson, String string){
		JSONObject jSONObject= new JSONObject(gson.toJson(string));
		return gson.fromJson(jSONObject.toString()
				, new TypeToken<Map<String, Object>>(){}.getType());
	}

	public static String stringToURIencode(String string){
		return java.net.URLEncoder.encode(string);
	}

	public static String URIencodeToURIdecode(String string){
		return java.net.URLDecoder.decode(string);
	}
	
	public static String charsetSwap(String string,String inputCharset
			, String outputCharset)
			throws UnsupportedEncodingException{
		String output= new String(string.getBytes(inputCharset), outputCharset); 
		return output;
	}
	
	public static double stringDoubleToDouble(String stringDouble) {
		double output= Double.valueOf(stringDouble);
		return output;
	}
	
//	//DEMO
//	public static void main(String[] argv) throws UnsupportedEncodingException {
//		double v= 0.000000001/1000000000;
//		double v1= 1000000000/0.000000001/1000000000;
//		System.out.println(v);
//		System.out.println(stringDoubleToDouble(""+v));
//	}
	
//	//DEMO
//	public static void main(String[] argv) throws UnsupportedEncodingException {
//		String testValue= "ยÞัþนโ";//GBK
//		testValue= new String(testValue.getBytes(), "unicode");//ENCODE
//		System.out.println(testValue);
//		testValue= charsetSwap(testValue,"unicode" , "GBK");//DECODE
//		System.out.println(testValue);
//		testValue= charsetSwap(testValue,"UTF8" , "UTF8");//SWAP CODE
//		System.out.println(testValue);
//	}
}