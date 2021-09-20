package priceGroceries;

import java.text.ParseException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Discounts {

	private String name;
	private int units;
	private String discountedProduct;
	private double percent;
	private LocalDate start;
	private LocalDate end;

	public Discounts(String name, int units, String discountedProduct, double percent, LocalDate start, LocalDate end) {
		this.name = name;
		this.units = units;
		this.discountedProduct = discountedProduct;
		this.percent = percent;
		this.start = start;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	int getUnits() {
		return units;
	}

	String getDiscountedProduct() {
		return discountedProduct;
	}

	double getPercent() {
		return percent;
	}

	LocalDate getStart() {
		return start;
	}

	LocalDate getEnd() {
		return end;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setUnits(int newUnits) {
		this.units = newUnits;
	}

	public void setDiscountedProduct(String newName) {
		this.discountedProduct = newName;
	}

	public void setPercent(double newPercent) {
		this.percent = newPercent;
	}

	public void setStart(LocalDate newStart) {
		this.start = newStart;
	}

	public void setEnd(LocalDate newEnd) {
		this.end = newEnd;
	}

	public boolean withinDiscountRange(LocalDate td) {

		return (td.isEqual(start) || td.isEqual(end)) || (td.isBefore(end) && td.isAfter(start));

	}
/***
	public boolean buyingConditionSatisfied(Basket b) {
		boolean flag = true;
		
		int num = 0;
		System.out.println( name);
		num = b.findUnits(name);
		System.out.println("number " + num);
		//if (units < number) flag = false;
		if(num == 0) flag  =false;
			return flag;
	}
*/
	public boolean buyingConditionSatisfied() {
		boolean flag = true;
		
		int num = 0;
		//System.out.println( name);
		if(name.equals("")) flag =false;
		
			return flag;
	}


}