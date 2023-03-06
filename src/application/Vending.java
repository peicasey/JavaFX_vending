package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Vending {
	
	// data members
	private ArrayList<String> directory;
	private ArrayList<Queue<Item>> slots;
	
	// parameterized constructor
	Vending(ArrayList<String> data) {
		
		directory = new ArrayList<String>();
		String delim = "[ ,]+";
		
		for (String line : data) {
			String[] info  = line.split(delim);
			directory.add(info[1]);
		}
		
		slots = new ArrayList<Queue<Item>>();
		
		loadItem(data);
	}
	
	// loads items according to directory.txt instructions
	public void loadItem(ArrayList<String> items) {
		/* TO DO */
		
		int slot = 0;
		String delim = "[ ,]+";
		
		for (String i : items) {
			
			String[] i_info  = i.split(delim);
			
			Queue<Item> newSlot = new LinkedList<Item>();
			slots.add(newSlot);
			
			switch(i_info[0]) {
			  case "Drink":
				  // Drink(String nm, float cals, String typ, float oz, String drinkType)
				  // Drink, Coca-Cola, 120, 16, soda, 2 
				  for (int d = 0; d < Integer.parseInt(i_info[5]); d++) {
					  Drink item = new Drink(i_info[1], Float.parseFloat(i_info[2]), "DRINK", Float.parseFloat(i_info[3]), i_info[4]);
					  slots.get(slot).add(item);
				  }
			    break;
			    
			  case "Snack":
				  // Snack(String nm, float cals, String typ, float wght, boolean hasNuts)
				  // Snack, Chips, 220, 4, false, 8 
				  for (int s = 0; s < Integer.parseInt(i_info[5]); s++) {
					  Snack item = new Snack(i_info[1], Float.parseFloat(i_info[2]), "SNACK", Float.parseFloat(i_info[3]), Boolean.parseBoolean(i_info[4]));
					  slots.get(slot).add(item);
				  }
			    break;
			    
			  default:
			    // shouldn't happen
			}
			
			slot++;
			
		}
		
	}
	
	// removes an item but makes sure there isn't an empty slot if possible
	public void unloadItem(int index) {
		
		// add logic for choosing
		String itemName = directory.get(index);
		Integer itemQueueSize = slots.get(index).size();
		Integer largestSlot = index; // largest slot
		
		for (Integer i = 0; i < slots.size(); i++) {
			// empty slot; ignore
			if (slots.get(i).size() <= 0) { continue; }
			// get similar item with largest queue
			else if (slots.get(i).size() > itemQueueSize && slots.get(i).peek().getName().equals(itemName)) {
				itemQueueSize = slots.get(i).size();
				largestSlot = i;
			}
			// get similar item with lowest index if queue is same
			else if (slots.get(i).peek().getName().equals(itemName) && slots.get(i).size() == itemQueueSize && i < largestSlot) {
				largestSlot = i;
			}
		}
		
		if (slots.get(largestSlot).size() > 0) { slots.get(largestSlot).remove(); }
	}
	
	// removes multiple items
	public void unloadItems(ArrayList<Integer> indices) {
		for (Integer index : indices) { unloadItem(index); }
	}
	
	// returns the indices of products in the vending machine that match the target product
	public ArrayList<Integer> findProduct(String product) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		for (Integer i = 0; i < slots.size(); i++) {
			if (slots.get(i).peek().getName().equals(product) ) { indices.add(i); }
		}
		
		return indices;
	}
	
	// returns the amount of products in each slot of the vending machine
	public ArrayList<Integer> getSlotAmounts() {
		ArrayList<Integer> amounts = new ArrayList<Integer>();
		
		for (Queue<Item> slot : slots) {
			amounts.add(slot.size());
		}
		
		return amounts;
	}
	
	
	// deconstructor
	protected void finalize() {  
		System.out.println("Object is destroyed by the Garbage Collector");  
		displayItems();
	}  
	
	// debug function
	public void displayItems() {
		for (int i = 0; i < slots.size(); i++) {
			Queue<Item> slot = slots.get(i);
			System.out.print("[" + i + "] ");
			for (Item item : slot) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
	
	// toString()
	@Override
	public String toString() {
		//	Coca-Cola: (Soda): 2
		//	Coca-Cola: (Soda): 4
		//	Coca-Cola: (Soda): 1
		//	Chips: (Snack): 8
		
		String vending_output = "";
		
		for (Queue<Item> slot : slots) {
			vending_output += slot.peek().getName() + ": (" + slot.peek().getItemType() + "): " + slot.size() + "\n";
		}

		return vending_output;
	}
	

}
