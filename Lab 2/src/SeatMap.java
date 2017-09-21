import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nihaal Manesia
 * @since 9/7/17
 * @version 1.0
 */

public class SeatMap {
	
	/**
	 * 2D array of seats which will hold names
	 */
	private String [][] seats;
	/**
	 * ArrayList of names read from input file
	 */
	private ArrayList<String> names = new ArrayList<String>();
	
	/**
	 * @param r is the number of rows of seats wanted
	 * @param c is the number of columns of seats wanted
	 * Instantiates the 2D array of seats with number of rows and columns
	 */
	public SeatMap(int r, int c) {
		seats = new String [r][c];
	}
	
	/**
	 * @param nm is the name of the file which is to be read
	 * Reads the file and writes the names to the ArrayList
	 */
	public void readFile(String nm) {
		try {
			File inputFile = new File(nm);
			Scanner input = new Scanner(inputFile, "UTF-8");
			//System.out.println(input.hasNextLine());
			while(input.hasNextLine()) {
				names.add(input.nextLine());
			}
			input.close();
		}
		catch(IOException e) {
			System.err.println("IOException in reading input file!");
		}
	}
	
	/**
	 * Writes names to 2D Array from the ArrayList
	 */
	public void populateArray() {
		for(int i = 0; i<seats.length; i++) {
			for(int j = 0; j<seats[i].length; j++) {
				if(!names.isEmpty()) {
					seats[i][j] = names.get(0);
					names.remove(0);
				}
			}
		}
	}
	
	/**
	 * @param r is the row wanted
	 * @param c is the column wanted
	 * @return Specified seat from the 2D array of seats
	 */
	public String getSeat(int r, int c) {
		return seats[r][c];
	}
	
	public static void main(String [] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("How many rows of seats would you like?");
		int rows = console.nextInt();
		System.out.println("How many columns of seats would you like?");
		int columns = console.nextInt();
		
		SeatMap map = new SeatMap(rows, columns);
		map.readFile("names.dat");
		map.populateArray();
		
		//System.out.println(map.getSeat(0,0));
		
		System.out.println("Row of seat you would like to see:");
		int r = console.nextInt();
		System.out.println("Column of seat you would like to see:");
		int c = console.nextInt();
		
		String name = map.getSeat(r, c);
		
		System.out.println("The person sitting at this seat is " + name);
		
		console.close();
	}
}