package application;

import java.text.DecimalFormat;

public class Snack extends Item {

	private float weight;
	private boolean containsNuts;
	
	// parameterized constructor
	Snack(String nm, float cals, String typ, float wght, boolean hasNuts) {
		super(nm, cals, typ);
		weight = wght;
		containsNuts = hasNuts;
	}
	
	// getters
	// inherited
	//	super.getName();
	//	super.getCalories();
	//	super.getItemType();
	public float getWeight() { return weight; }
	public boolean containsNuts() { return containsNuts; }
	
	// setters
	// inherited
	//	super.setName(String n);
	//	super.setCalories(float c);
	//	super.setItemType(String i);
	public void setWeight(float wght) { weight = wght; }
	public void setContainsNuts(boolean hasNuts) { containsNuts = hasNuts; }
	
	// toString
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.0");
		String format = "[ %1$-5s | %2$-10s- %3$-5s cals, %4$-5s grams, %5$-8s]";
		
		if (containsNuts) {
			return String.format(format, "SNACK", super.getName(), df.format(super.getCalories()), df.format(getWeight()), "NUTS");
		}
		else {
			return String.format(format, "SNACK", super.getName(), df.format(super.getCalories()), df.format(getWeight()), "NO NUTS");
		}
	}
	
}
