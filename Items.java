package priceGroceries;

public class Items {


	private String name;
	private String units;
	private double price;
	public Items(String name, String units, double price) {
		this.name = name;
		this.units = units;
		this.price = price;
	}
    
	public String getName() {
		return name;
	}

	String getUnits() {
		return units;
	}
    double getPrice() {
    	return price;
    }
	public void setName(String newName) {
		this.name = newName;
	}
	public void setUnits(String newUnits) {
		this.units = newUnits;
	}
	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
}