package application;

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class DataFile {

	// datamembers
	private String directoryFilename;
	private String inputFilename;
	private boolean debug = false;
	
	
	// parameterized constructor
	DataFile(String directoryFile, String inputFile) {
		directoryFilename = directoryFile;
		inputFilename = inputFile;
	}
	
	// loads instructions to load vending machine; DOESN'T ACTUALLY LOAD VENDING MACHINE
	public ArrayList<String> loadDirectory() {
		/* TO DO */
		ArrayList<String> directory = new ArrayList<String>();
		
		Scanner infile = null;
		try {
		    infile = new Scanner(new FileReader(directoryFilename));
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			System.exit(0); // Exits entire program
		}

		
		while(infile.hasNextLine()) {
			String line = infile.nextLine();
			directory.add(line);
			
			if (debug) { System.out.println("directory: " + line); }
		}

		infile.close( );
		
		return directory;
	}
	
	// load instructions to remove items
	public ArrayList<Integer> loadSampleInput() {
		ArrayList<Integer> selections = new ArrayList<Integer>();
		
		Scanner infile = null;
		try {
		      infile = new Scanner(new FileReader(inputFilename));
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			System.exit(0); // Exits entire program
		}

		Integer selection; // selection
		
		while(infile.hasNextLine())
		{
			String line = infile.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(line);

			// You should know what you are reading in
			selection = Integer.parseInt(tokenizer.nextToken());
			selections.add(selection);
			
			if (debug) { System.out.println("selection: " + selection); }
		}

		infile.close( );
		
		return selections;
	}
}
