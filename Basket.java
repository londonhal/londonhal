package priceGroceries;

import java.util.ArrayList;

import java.text.ParseException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Basket {

	private double GrossPrice;
	private double DiscountedPrice;
	private double NetPrice;
	private LocalDate transDate;
	private ArrayList<Quantities> group;

//private Products p;
	public Basket(LocalDate transDate) {
		this.transDate = transDate;
		group = new ArrayList<Quantities>();
		GrossPrice = 0.0;
		DiscountedPrice = 0.0;
		NetPrice = 0.0;
	}

	public void add(int num, String name) {
		Quantities q = new Quantities(name, num);
		group.add(q);
	}

	public double GrossPrice(Products products) {
		// double Grossprice = 0.0;
		for (int i = 0; i < group.size(); i++)

		{
			Quantities q = group.get(i);
			String name = q.getName();
			double price = products.findPrice(name);
			double number = (double) q.getNumber();
			double value = price * number;
			System.out.println(name + ":" + number + "value " + value);
			GrossPrice += value;
		}

		return GrossPrice;
	}

	public int findUnits(String name) {
		int number = 0;
		for (int i = 0; i < group.size(); i++) {
			Quantities q = group.get(i);
			if (name.equals(q.getName())) {
				number = q.getNumber();
			}
		}
		// System.out.println( name + ":" + "units " + number);
		return number;
	}

	public double DiscountPrice(Products products, Discounts dis, boolean buyFlag) {
		double Discountprice = 0.0;
		String keyName = dis.getDiscountedProduct();
		double percent = dis.getPercent() / 100.0;
		double price = products.findPrice(keyName);
		double number = 0.0;
		for (int i = 0; i < group.size(); i++)

		{
			Quantities q = group.get(i);
			String name = q.getName();
			if (keyName.equals(name)) {
				number = (double) q.getNumber();
			}
			System.out.println(keyName + number);
		}
		if (buyFlag)
			number= Math.min(number,1.0);
		double value = price * percent * number;
		System.out.println( keyName + ":"+ number + "disc value " + value);
		Discountprice = value;
		return Discountprice;
	}

	public void calculateDiscount(Products products, DiscountTable dt) {
		boolean buyFlag = false;

		for (int i = 0; i < dt.count(); i++)

		{
			System.out.println("calculateDiscount" + i);
			Discounts dis = dt.get(i);
			// System.out.println("within rang3" + dis.withinDiscountRange(transDate));
			if (dis.withinDiscountRange(transDate)) {

				buyFlag = dis.buyingConditionSatisfied();
				System.out.print("withinRange buyflag" + buyFlag);
				// System.out.println("buyingConditoine" + buyFlag);
				DiscountedPrice += DiscountPrice(products, dis, buyFlag);
				// System.out.println("discountedPrice " +DiscountedPrice);
			}

		}
	}

	public void printOutput() {
		GrossPrice = Math.round(GrossPrice * 100.0) / 100.0;
		DiscountedPrice = Math.round(DiscountedPrice * 100.0) / 100.0;
		NetPrice = GrossPrice - DiscountedPrice;
		NetPrice = Math.round(NetPrice*100.0)/100.0;
		System.out.println("gross" + GrossPrice + " discounted " + DiscountedPrice + "netprice " + NetPrice);

	}
}
