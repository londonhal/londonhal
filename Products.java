package priceGroceries;

import java.util.ArrayList;

public class Products {
	private ArrayList ItemList;

	public Products() {
		ItemList = new ArrayList<Items>();
	}

	public void add(Items z) {
		ItemList.add(z);
	}

	public int count() {
		return ItemList.size();
	}

	public double findPrice(String name) {
		double price = 0.0;
		// for (Items it : ItemList) {
		for (int i = 0; i < ItemList.size(); i++) {
			Items it = (Items) ItemList.get(i);

			String nam = it.getName();
		//	System.out.println("nam" + nam);
		
			 if (nam.equals(name)) { price = it.getPrice(); 
			 }
			 }
			return price;
		}
	

}
