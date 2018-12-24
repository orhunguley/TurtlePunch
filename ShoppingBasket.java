package System;

import java.util.ArrayList;

public class ShoppingBasket {
	
	private ArrayList<Product> basket_list;
	private static double totalPrice;

	public ShoppingBasket(){
	    basket_list= new ArrayList<Product>();
	    totalPrice=0;
	}

	//get/set

	public void addProduct(Product pr){
	    basket_list.add(pr);
	    totalPrice +=pr.getPrice();
	}
	public void removeProduct(Product pr){
		int i =0;
	    for(Product product: basket_list){
	        if(product.equals(pr)){
	            basket_list.remove(pr);
	            totalPrice -=pr.getPrice();
	            i++;
	        }
	        else if(! product.equals(pr) && basket_list.size()==i){
	    
	       System.out.println("error");
	       }
	    }


}

	public ArrayList<Product> getBasket_list() {
		return basket_list;
	}

	

	public static double getTotalPrice() {
		return totalPrice;
	}

	
	

}
