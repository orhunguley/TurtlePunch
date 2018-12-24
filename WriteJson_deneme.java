package Json;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJson_deneme {
	public static void main(String[] args) throws IOException {

		
		
		
		String filepath = System.getProperty("user.dir");
        filepath = (filepath+"\\customer.json");
        
		JSONHelper helper = new JSONHelper();
		helper.SearchObject(filepath, "User");
        
        
		
//		String[] info = new String[5];
//		Date birthdate = null;
//		String date="16/04/1994";
//		try {
//			birthdate=new SimpleDateFormat("dd/MM/yyyy").parse(date);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//
//		info[0] = "Orhun";
//		info[1] = "Güley";
//		info[2] = "orhunguley";
//		info[3] = "ooo123";
//		info[4] = "orhunguley@gmail.com";
//		System.out.println(birthdate.toString());

		
	}
}
