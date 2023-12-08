package cmsc412.finalproject.angelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Angelo Barcelona
 * CMSC 412 Final
 * 2 December 2023
 * 
 */

/**
 * Project Description: Application produces a console menu that allows a user
 * to input a N value, input a reference string, and then choose between OPT or
 * NEW algorithm.
 * 
 * 1. Create Menu 2. Exit functionality 3. Options 1-4 functionality 4. @Test
 */
public class Main {

	private Scanner scanner;
	private int numberOfFrames;
	private String referenceString;
	private int numberOfPageFaults;
	private String victimPage;

	/**
	 * Default constructor
	 */
	public Main() {
		
		scanner = new Scanner(System.in);
		numberOfFrames = 0;
		referenceString = "";
		numberOfPageFaults = 0;
		victimPage = "";
	}

	/**
	 * Entry into the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Main m = new Main();
		System.out.println("Thank you for choosing Angelo's algorithm simulator.  Pleaes choose from the menu below.");
		while (true) {
			String response = m.menuChoice();
			switch (response) {
			case "0": m.exitProgram();
				break;
			case "1": m.getNumberOfFrames();
				break;
			case "2": m.getReferenceString();
				break;
			case "3": m.optAlgorithm();
				break;
			case "4": m.newAlogrithm();
				break;
			default:
				System.out.println("You did not choose a valid input. Please select 0-4, thank you.");

			}
		}
	}
	
	public void newAlogrithm() {}
	
	public void optAlgorithm() {
		
		displayAlgorithm();
		
	}
	
	public void displayAlgorithm() {
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.print("Reference String | ");
		for(int i = 0; i < referenceString.length(); i++) {
			System.out.print(referenceString.charAt(i) + " | ");
		}
		System.out.println();
		for(int i = 0; i < numberOfFrames; i++) {
			System.out.print("Physical Frame " + i + " |");
			for(int j = 0; j < referenceString.length(); j++) {
				System.out.print(" " + "  |");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.print("Page Faults:     | ");
		for(int i = 0; i < referenceString.length(); i++) {
			System.out.print(numberOfPageFaults + " | ");
		}
		System.out.println();
		System.out.print("Victim Pages:    | ");
		for(int i = 0; i < referenceString.length(); i++) {
			System.out.print(victimPage + "  | ");
		}
		System.out.println();
		
		
	}

	/**
	 * Exits the program and gives a thank you message.
	 */
	public void exitProgram() {
		
		System.out.println();
		System.out.println("Thank you for using the OPT/NEW Page replacement Algorithm.");
		System.exit(0);
	}

	/**
	 * Menu Message
	 * 
	 * @return
	 */
	public String menuChoice() {
		
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("Frames: " + numberOfFrames + " | " + "Reference String: " + referenceString);
		System.out.println("0 - Exit\n" + "1 - Input number of frames(2-8): N\n" + "2 - Input the reference string\n"
				+ "3 - Simulate the OPT algorithm\n" + "4 - Simulate the NEW algorithm\n");
		System.out.print("Select Option: ");
		String input = scanner.nextLine();
		return input;
	}

	/**
	 * Gets the reference string from the user. Checks that each element is a digit, it is returns otherwise
	 * it asks for a legal reference string of all digits.
	 */
	public void getReferenceString() {
		
		boolean allDigit = false;
		while (true) {
			System.out.print("Please enter your reference string: ");
			referenceString = scanner.nextLine();
			if(referenceString.length() < numberOfFrames || referenceString.length() > 20) {
				System.out.println();
				System.out.println("The reference string must be at least the length of frames, and 20 or less digits.");
				continue;
			}
			for (int i = 0; i < referenceString.length(); i++) {
				try {
					Integer.parseInt(String.valueOf(referenceString.charAt(i)));
					allDigit = true;
				} catch (NumberFormatException e) {
					allDigit = false;
					break;
				}
			}
			if (allDigit == true) {
				return;
			} else {
				System.out.println();
				System.out.println(referenceString + " is not a valid reference string please use only digits.");
			}

		}

	}

	/**
	 * Allows user to input the number of frames to be used
	 */
	public void getNumberOfFrames() {
		
		ArrayList<String> digitsList = new ArrayList<>(List.of("2", "3", "4", "5", "6", "7", "8"));
		while (true) {
			System.out.println();
			System.out.print("Please input the number of frames you would like from 2-8: ");
			String numberOfFrames = scanner.nextLine();
			if (!digitsList.contains(numberOfFrames)) {
				System.out.println();
				System.out.println(numberOfFrames + " is an invalid input. Please enter a digit between 2-8");
			} else {
				this.numberOfFrames = Integer.parseInt(numberOfFrames);
				return;
			}
		}
	}

}
