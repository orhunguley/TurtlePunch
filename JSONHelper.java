package Json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONHelper {
	public JSONHelper() {
		super();

	}
	
	public boolean FileIsEmpty(String filepath) {
		File fl = new File(filepath);
		if(fl.length()>0) {
			return false;
		}else return true;
	}
	
	public void AddToDatabase(String filepath, String[] info, String type) {

		JSONObject obj = new JSONObject();
		obj.put("Name", info[0]);
		obj.put("Surname", info[1]);
		obj.put("User Name", info[2]);
		obj.put("Password", info[3]);
		obj.put("Birth Date", info[4]);
		obj.put("Email", info[5]);
		System.out.println(FileIsEmpty(filepath));
		
		
		
//		
//		try {
//			Files.write(Paths.get(filepath), obj.toJSONString().getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
		
		// try-with-resources statement based on post comment below :)
		try (FileWriter file = new FileWriter(filepath,true)) {
			if(FileIsEmpty(filepath)) {
				file.write("[");
				file.write(System.getProperty("line.separator"));
				
			}else {
				
				DeleteLastLine(filepath);
				file.write(",");
				
//			    String lastLine = "";
//			    String sCurrentLine;
//			    BufferedReader br = new BufferedReader(new FileReader(filepath));
//			    while ((sCurrentLine = br.readLine()) != null) 
//			    {
//			        System.out.println(sCurrentLine);
//			        lastLine = sCurrentLine;
//			        
//			    }
//			    
//			    lastLine = lastLine.substring(0, lastLine.length()-1) + ",";
			}
			
			file.write(obj.toJSONString());
			file.write(System.getProperty("line.separator"));
			file.write("]");
			
			
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void DeleteLastLine(String filepath) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile f = new RandomAccessFile(filepath, "rw");
		long length = f.length() - 1;
		byte b = 0;
		
		do {                     
		  length -= 1;
		  f.seek(length);
		  try {
			b = f.readByte();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} while(b != 10);
		f.setLength(length+1);
		f.close();
		
	}
	
	public JSONObject findJSONObject(String filepath,String key, String value) {
		
		
		JSONParser parser = new JSONParser();
		JSONArray array = null;
		Object json;
		try {
			json = parser.parse(new FileReader(filepath));
			array = (JSONArray) json;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int i = 0; i < array.size(); i++) {
			
			JSONObject obj = new JSONObject();
			obj = (JSONObject) array.get(i);
			
			if(obj.get(key).equals(value)) {
				
				return obj;
				
			}
			
			
			
		}
		
		return null;
	}
	
	
	public void SearchObject(String filepath, String username) {

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader(filepath));
			JSONArray jsonObject = (JSONArray) obj;
			
//			JSONArray array = (JSONArray) jsonObject.get("User Name");
//			Iterator<JSONObject> iterator = array.iterator();
//			while (iterator.hasNext()) {
//
//				System.out.println(iterator.next().get("User Name"));
//
//			}
		
			System.out.println(obj.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
