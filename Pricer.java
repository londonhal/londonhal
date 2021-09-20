package priceGroceries;

import java.util.ArrayList;
import java.text.ParseException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Pricer {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");

		LocalDate today = LocalDate.parse("2021-09-18", dtf);

		Items A = new Items("soup", "tin", 0.65);
		Items B = new Items("bread", "loaf", 0.80);
		Items C = new Items("milk", "bottle", 1.30);
		Items D = new Items("apples", "single", 0.10);
//	ArrayList products= new ArrayList<Items>();
		Products products = new Products();
		products.add(A);
		products.add(B);
		products.add(C);
		products.add(D);
		int c = products.count();
		System.out.println("number of Products " + c);

		LocalDate yesterday = LocalDate.parse("2021-09-18", dtf);
		LocalDate threedayshence = LocalDate.parse("2021-09-21", dtf);
		LocalDate nextmonthend = LocalDate.parse("2021-10-31", dtf);
		LocalDate sevendays = LocalDate.parse("2021-09-24", dtf);
		Discounts one = new Discounts("soup", 2, "bread", 50.0, yesterday, sevendays);
		Discounts two = new Discounts("", 0, "apples", 10.0, threedayshence, nextmonthend);
		DiscountTable dt = new DiscountTable();
		dt.add(one);
		dt.add(two);

		System.out.println("Basket B1");

		Basket B1 = new Basket(today);
		B1.add(3, "soup");
		B1.add(2, "bread");
		B1.GrossPrice(products);

		B1.calculateDiscount(products, dt);
		B1.printOutput();

		System.out.println("Basket B2");
		Basket B2 = new Basket(today);
		B2.add(6, "apples");
		B2.add(1, "milk");
		B2.GrossPrice(products);
		B2.calculateDiscount(products, dt);
		B2.printOutput();

		System.out.println("Basket B3");

		LocalDate d5 = LocalDate.parse("2021-09-23", dtf);
		Basket B3 = new Basket(d5);
		B3.add(6, "apples");
		B3.add(1, "milk");
		B3.GrossPrice(products);
		B3.calculateDiscount(products, dt);
		B3.printOutput();

		System.out.println("Basket B4");
		LocalDate d6 = LocalDate.parse("2021-09-23", dtf);
		Basket B4 = new Basket(d6);
		B4.add(3, "apples");
		B4.add(2, "soup");
		B4.add(1, "bread");
		B4.GrossPrice(products);
		B4.calculateDiscount(products, dt);
		B4.printOutput();

	}
}
