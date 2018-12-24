package System;

import java.util.ArrayList;

public class User extends Account {
	private ArrayList<Product> purchased_products;
	private ArrayList<Product> wish_list;
	private ShoppingBasket shoppingbasket;
	private static double money;
	
	//String surname, String email, String password, String birthdate,String nationality
	//, surname, email, password, birthdate, nationality
	public User(String username, String name ,String surname, String email, String password, String birthdate,String nationality) {
		super(username, name, surname, email, password, birthdate, nationality);
		this.money=0;
		
		purchased_products =new ArrayList<Product>();
		wish_list =new ArrayList <Product>();
		
	}
  

	public void purchase(){
		if(money <= shoppingbasket.getTotalPrice()){
			for(Product product: shoppingbasket.getBasket_list()){
				addProductToLibrary(product);
				shoppingbasket.getBasket_list().remove(product);
			}
			deposit(shoppingbasket.getTotalPrice());
		} else
			
			System.out.println("you have not enough money");
	}
	
	
	public ArrayList<Product> getPurchased_products() {
		return purchased_products;
	}
	public void addProductToLibrary(Product pr) {
		
		purchased_products.add(pr);
	}
	public ArrayList<Product> getWish_list() {
		return wish_list;
	}
	public void addProductToWishList(Product pr) {
		wish_list.add(pr);
	}
	
	public void remove(Product pr) {
		for(Product product:wish_list ){
			if(pr.equals(product)){	
				wish_list.remove(pr);
			}
		}
	}
	public double getMoney() {
		return money;
	}
	public void deposit(double price) {
		if(price<=money)
		money=money-price;
		else
		System.out.println("error not enough money");
	}
	
	
	
}
