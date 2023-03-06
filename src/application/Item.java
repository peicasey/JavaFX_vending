package application;

public class Item {

	private String name;
	private float calories;
	private String itemType; // only for debugging; not for polymorphism
	
	// constructor
	Item(String nm, float cals, String typ) {
		name = nm;
		calories = cals;
		itemType = typ;
	}
	
	// getters
	public String getName() { return name; }
	public float getCalories() { return calories; }
	public String getItemType() { return itemType; }
	
	// setters
	public void setName(String n) { name = n; }
	public void setCalories(float c) { calories = c; }
	public void setItemType(String i) { itemType = i; }
	
}
