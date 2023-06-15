import com.google.gson.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Student{
	String name;
	int id;
	int age;
	public Student(String name, int id, int age){
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public String print(){
		return "이름 : "+name+", 학번: "+id+", 나이 : "+age;
	}
}

public class SP2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Student student[] = new Student[4];
		student[0] = new Student("김예진", 20161091, 24);
		student[1] = new Student("양시연", 20173922, 24);
		student[2] = new Student("김찬영", 20146037, 26);
		student[3] = new Student("최예원", 20209384, 20);
		
		Comparator<Student> comparator = new Comparator<Student>(){
			public int compare(Student s1, Student s2) {
				return Integer.compare(s1.age, s2.age); // 나이 오름차순 정렬
			}
		};
		
		Arrays.sort(student, comparator);
		
		for(int i=0;i<4;i++)
			System.out.println(student[i].print());

		System.out.println();
		
		Arrays.sort(student, new Comparator<Student>(){
			public int compare(Student s1, Student s2) {
				if(s1.age == s2.age){ // 나이가 같은 경우
					return Integer.compare(s1.id, s2.id); // 학번 오름차순으로 정렬
				}
			return Integer.compare(s2.age, s1.age); // 나이는 내림차순으로 정렬
			}
		});
		for(int i=0;i<4;i++)
			System.out.println(student[i].print());

		System.out.println();
		
		// 나이 내림차순 정렬
		Arrays.sort(student, (s1,s2) -> Integer.compare(s2.age, s1.age));
		for(int i=0;i<4;i++)
			System.out.println(student[i].print());
		
		JsonElement jsonElement = JsonParser.parseString("{ \"key\":\"value\" }");
		System.out.println(jsonElement.toString());
		
		JsonObject jsonObj = (JsonObject)jsonElement;
		System.out.println(jsonObj.get("key").getAsString());
		
		JsonObject json = new JsonObject();
		JsonObject json_sub1 = new JsonObject();
		JsonObject json_sub2 = new JsonObject();
		JsonObject json_sub3_sub1 = new JsonObject();
		JsonObject json_sub3_sub2 = new JsonObject();
		
		JsonArray value = new JsonArray();
		JsonArray value2 = new JsonArray();
	    // put some value pairs into the JSON object .
	    json.addProperty("name", "spiderman");
	    json.addProperty("age", 45);
	    json.addProperty("married", true);
	    
	    value2.add("marial art");	 // array 추가
	    value2.add("gun");			// array 추가
	    json.add("specialty", value2);
	    
	    json_sub2.addProperty("1st", "done");
	    json_sub2.addProperty("2nd", "expected");
	    json_sub2.add("3rd", null);	    
	    json.add("vaccine", json_sub2);
	    
	    json_sub3_sub1.addProperty("name", "spiderboy");
	    json_sub3_sub1.addProperty("age", 10);

	    json_sub3_sub2.addProperty("name", "spidergirl");
	    json_sub3_sub2.addProperty("age", 8);
	    
	    value.add(json_sub3_sub1);	// array 추가
	    value.add(json_sub3_sub2);	// array 추가
	    json.add("children", value);
	    json.add("address", null);
	    
	    String jsonStr = new Gson().toJson(json);
	    FileWriter fw = new FileWriter("./sample.json");
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(jsonStr);
	    System.out.println(json.toString());
	    System.out.println(jsonStr);
	    bw.close();
	    fw.close();
	    
	    String filePath = "sample.json";
		try {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new FileReader(filePath));
			JsonObject jsonObj3 = gson.fromJson(reader, JsonObject.class);

			String name = jsonObj3.get("name").getAsString();
			int age = jsonObj3.get("age").getAsInt();
			System.out.println("name(age):"+name + "("+age+")");
			
			JsonArray jsonArr = jsonObj3.get("children").getAsJsonArray();
			JsonObject jsonObj2 = jsonArr.get(1).getAsJsonObject();
			name = jsonObj2.get("name").getAsString();
			age = jsonObj2.get("age").getAsInt();
			System.out.println("name(age):"+name + "("+age+")");
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path jsonFilePath = Paths.get(filePath);
		try {
			String wholeData = new String(Files.readAllBytes(jsonFilePath));
			Gson gson = new Gson();
			JsonObject jsonObj4 = gson.fromJson(wholeData, JsonObject.class);
			for(String key:jsonObj4.keySet())
			{
				System.out.print("Key : "+key+" / Value Type : ");
				JsonElement je = jsonObj4.get(key);
				if(je.isJsonPrimitive()) {
					if(je.isJsonPrimitive()) {
						if(je.getAsJsonPrimitive().isString())
						{
							System.out.println("String");
						}
						else if(je.getAsJsonPrimitive().isNumber())
						{
							System.out.println("Number");
						}
						else if(je.getAsJsonPrimitive().isBoolean())
						{
							System.out.println("Boolean");
						}
						else if(je.getAsJsonPrimitive().isJsonNull())
						{
							System.out.println("null");
						}
					}
				}
				else if(je.isJsonArray())
				{
					System.out.println("Array");
				}
				else if(je.isJsonObject())
				{
					System.out.println("Object");
				}
				else if(je.isJsonNull())
				{
					System.out.println("null");
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
