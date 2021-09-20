package priceGroceries;
import java.util.ArrayList;
public class DiscountTable {
	
		private ArrayList DiscountList;

		public DiscountTable (){
		DiscountList = new ArrayList<Discounts>();
		}
		public void add(Discounts z) {
			DiscountList.add(z);
		}

		public int count() {
			return DiscountList.size();
		}
/*
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
*/
		public Discounts get(int i) {
			// TODO Auto-generated method stub
			return (Discounts)DiscountList.get(i);
		}		

	}


