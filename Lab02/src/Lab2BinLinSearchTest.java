import java.util.Scanner;

/**
 * * 
 * This class contains the main method and menu 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 */

public class Lab2BinLinSearchTest {
	// scanner
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * Main method for printing menu and processing.
	 * 
	 * @param args Default needed for main method
	 */
	public static void main(String[] args) {
		// var for menu input
		int menu = -1;
		// searching object
		BinaryLinearSearch search = new BinaryLinearSearch();
		// array values
		int size = 30;
		int firstIndex = 0;
		int lastIndex = (size - 1);
		int searchValue;
		//int index;
		// error for printing message
		int error = 0;
		// array
		int[] array = new int[size];

		// loop through menu
		do {
			// set menu to -1 
			menu = -1;

			// print menu
			System.out.println("Select your option in the menu:\n" + 
					"1. Initialize and populate an array of 30 random integers.\n" + 
					"2. Perform recursive binary and linear search.\n" + 
					"3. Perform iterative binary and linear search.\n" + 
					"4. Exit.");
			
			// if input is an int, store
			if (input.hasNextInt()) {
				menu = input.nextInt();
				error = 0;
			} else {
				// clear input
				input.next();
				error = 1;
			}

			// if it is out of range print error and loop again
			if (menu < 1 || menu > 4) {
				// print error and loop through again
				if (error == 0) {
				System.err.println("Please choose the option 1 to 4.");
				} else {
					System.err.println("******Input Mismatch Exception******");
				}
			} else {
				// case structure for menu options
				switch (menu) {
				case 1:
					System.out.println("Array of randomly generated integers:");
					// initialize and populate an array
					array = search.generateRandomInts();
					
					// for testing, middle index
					// System.out.printf("%64s\n", "mid");
					
					break;
				case 2:			
					// perform recursive searches, get input
					searchValue = searchValue();
					
					// call array for accurate time readings
					search.callArray(array);
					
					// perform search
					search.recursiveBinarySearch(array, firstIndex, lastIndex, searchValue);
					
					// perform search
					search.recursiveLinearSearch(array, size, searchValue);
					
					break;
				case 3:
					// perform iterative searches, get input
					searchValue = searchValue();
					
					// call array for accurate time readings
					search.callArray(array);
					
					// perform search
					search.iterativeBinarySearch(array, searchValue);
					
					// perform search
					search.iterativeLinearSearch(array, searchValue);
					
					break;
				case 4:
					// print exiting message
					System.out.println("exiting...");
					break;
				}
			}

		} while (menu != 4);
	}
	
	/**
	 * Asks for a search value.
	 * @return The validated input
	 */
	public static int searchValue() {
		// specified size of array
		int search = -1;
		int error = 0;

		// ask for size, validate input with loop
		do {
			System.out.print("Please enter an integer value to search: ");

			if (input.hasNextInt()) {
				// store if an int
				search = input.nextInt();
				error = 0;
			} else {
				// clear input
				input.next();
				error = 1;
			}

			// if its not greater than 0 print error message
			if (search <= 0) {
				if (error == 0) {
				System.err.println("Please enter a positive integer.");
				} else {
					System.err.println("******Input Mismatch Exception******");
				}
			}

		} while (search <= 0);
		
		return search;
	}

}
