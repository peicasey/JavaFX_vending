package application;

import java.text.DecimalFormat;

public class Drink extends Item {

	private float ounces;
	private String type; // soda, water, other
	
	// parameterized constructor
	Drink(String nm, float cals, String typ, float oz, String drinkType) {
		super(nm, cals, typ);
		ounces = oz;
		type = drinkType;
	}
	
	// getters
	// inherited
	//	super.getName();
	//	super.getCalories();
	//	super.getItemType();
	public float getOunces() { return ounces; }
	public String getType() { return type; }
	
	// setters
	// inherited
	//	super.setName(String n);
	//	super.setCalories(float c);
	//	super.setItemType(String i);
	public void setOunces(float oz) { ounces = oz; }
	public void setType(String typ) { type = typ; }
	
	// toString
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.0");
		String format = "[ %1$-5s | %2$-10s- %3$-5s cals, %4$-5s grams, %5$-8s]";
		
		return String.format(format, "DRINK", super.getName(), df.format(super.getCalories()), df.format(getOunces()), getType());
	}
	
}
