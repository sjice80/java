//package test;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.LinkedTreeMap;

public class MyJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonElement jsonElement = JsonParser.parseString("{ \"key\":\"value\" }");
		System.out.println(jsonElement.toString());
		String nestedJSON = "{\"id\":\"1\",\"message\":\"web_didload\",\"content\":{\"success\":1}}";
		Gson gson = new Gson();
		LinkedTreeMap result = gson.fromJson(nestedJSON , LinkedTreeMap.class);
		System.out.println(result.get("content"));
		Map m2 = (Map)result.get("content");
		System.out.println(m2.get("success"));
		
		String jsonString = "{'header': {'alerts': [{'AlertID': '2', 'TSExpires': null, 'Target': '1', 'Text': 'woot', 'Type': '1'}, {'AlertID': '3', 'TSExpires': null, 'Target': '1', 'Text': 'woot', 'Type': '1'}], 'session': '0bc8d0835f93ac3ebbf11560b2c5be9a'}, 'result': '4be26bc400d3c'}";
		Map map = (Map)gson.fromJson(jsonString, Map.class);
		System.out.println(map.getClass().toString());
		System.out.println(map.get("header"));
		Map m1 = (Map)map.get("header");
		System.out.println(m1.get("alerts"));
		Map json = (Map) gson.fromJson(jsonString, Object.class);
		if(json.get("header") instanceof Map) {
		  Map field = (Map)json.get("header");
		} else if (json.get("header") instanceof List) {
		  List field = (List)json.get("header");
		}
	}

}
