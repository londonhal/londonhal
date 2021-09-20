package priceGroceries;

public class Quantities {
	private String name;
	private int number;
	
	public Quantities(String name, int number) {
		this.name = name;
		this.number = number;
		
	}
    
	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}
   
	public void setName(String newName) {
		this.name = newName;
	}
	public void setNumber(int newNumber ){
		this.number = newNumber;
	}
	

}
