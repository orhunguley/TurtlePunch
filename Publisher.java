package System;

import java.util.ArrayList;

public class Publisher extends Account {
	
	private ArrayList<Product> product_list;

	public Publisher(String username, String name ,String surname, String email, String password, String birthdate,String nationality) {
		super(username, name, surname, email, password, birthdate, nationality);
	
	product_list=new ArrayList<Product>();

	}

	//get/set

	public void addproduct(Product pr){
		
	    product_list.add(pr);
	}

	public ArrayList<Product> getProduct_list() {
		return product_list;
	}

	

}
