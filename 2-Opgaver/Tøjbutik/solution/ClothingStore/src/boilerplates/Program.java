package boilerplates;

import java.util.Scanner;

import models.*;

public class Program {
	
	private static Store store = Store.getInstance();
	
	public void start() {
		System.out.print("\tWelcome\n\nPress exit whenever to exit\n\n");
		procedure();
	}
	
	public void procedure() {
		while (true) {
			System.out.println("Would you like to:\n\n\tAdd Mannequin\n\tRemove Mannequin\n\tView Mannequin");
			decide(handlePrompt());
		}
	}
	
	private void decide(String input) {
		switch (input) {
			case "Add Mannequin": {
				addMannequin();
				break;
			}
			case "Remove Mannequin": {
				removeMannequin();
				break;
			}
			case "View Mannequin": {
				viewMannequin();
				break;
			}
		}
	}
	
	private void addMannequin() {
		Clothing[] clothing = new Clothing[3];
		Mannequin mannequin;
		
		clothing[0] = addClothing(Clothing.Type.HEAD_WEAR);
		clothing[1] = addClothing(Clothing.Type.TOP);
		clothing[2] = addClothing(Clothing.Type.PANTS);
		
		while (true) {
			System.out.println("Type the gender for the mannequin:\n\n\tm/f");
			String input = handlePrompt();
			
			if (input.equalsIgnoreCase("m") || input.equalsIgnoreCase("f")) {
				mannequin = new Mannequin(store.getAmountOfMannequins(), input.equalsIgnoreCase("f") ? true : false, clothing);
				break;
			}
		}
		
		store.addMannequin(mannequin);
		System.out.println("The added mannequin is " + store.getMannequin(store.getAmountOfMannequins() - 1));
	}
	
	private Clothing addClothing(Clothing.Type type) {
		int choice;
		
		while (true) {
			System.out.println("Which material is the " + type + "?\n\n\t1. Leather\n\t2. Rubber\n\t3. Polyester\n\t4. Denim\n");
			
			try {
				choice = Integer.parseInt(handlePrompt());
				break;
			} catch (Exception e) {
				System.out.println("That was not an option, pick a number");
			}	
		}
		
		System.out.println("Describe the brand and model, delimtter with | ");
		String[] brandAndModel = handlePrompt().split(" | ");
		
		return new Clothing(type, pickMaterial(choice), brandAndModel[0], brandAndModel[1]);
	}
	
	private Clothing.Material pickMaterial(int choice) {
		switch (choice) {
			case 1: return Clothing.Material.LEATHER;
			case 2: return Clothing.Material.RUBBER;
			case 3: return Clothing.Material.POLYESTER;
			case 4: return Clothing.Material.DENIM;
			default: return null;
		}
	}
	
	private void removeMannequin() {
		int formerLength = store.getAmountOfMannequins(),
			length = store.getAmountOfMannequins();

		while (formerLength == length) {
			int id;
			
			while (true) {
				System.out.print("Type the id of a mannequin to remove");
				try {
					id = Integer.parseInt(handlePrompt());
					break;
				} catch (Exception e) {
					System.out.println("That is not an id");
				}
			}
			
			store.removeMannequin(id);
			length = store.getAmountOfMannequins();
			if (length == formerLength)
				System.out.println("The id must not exist, nothing is removed.");
		}
	}
	
	private void viewMannequin() {
		String display = "";
		
		for (Mannequin mannequin : store.getMannequns())
			display += "\n" + mannequin;
		
		System.out.println("\tThe mannequins are:\n" + display);
	}
	
	private String handlePrompt() {
		String input = new Scanner(System.in).nextLine();
		
		if (input.equalsIgnoreCase("exit")) {
			System.out.println("System is shutting down...");
			System.exit(0);
		}
		
		if (input.equalsIgnoreCase("go back"))
			procedure();
		
		return input;
	}
}