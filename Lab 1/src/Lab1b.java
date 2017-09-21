
/**
 * CS 2003 - Lab 1. Code to compute the sum of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @author Nihaal Manesia
 * @since 08/31/2017
 * @version 1.0
 */

import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.IOException;

public class Lab1b {
    
    // data members
	Vector <Double> doubleVector; 

    /** Constructor: calls method readFile that reads the doubles
     * contained in the file "<code>filename</code>" and computes the
     * sum of the elements.
     @param filename name of the file containing doubles.
    */
    public Lab1b(String filename) {
	readFile(filename);
    }

    /** Reads double from a file named <code>filename</code> and
     * computes the average of the elements contained in the file 
     * @param filename name of the file containing the doubles 
     */
    public void readFile(String filename) {
	try{
		File inputFile = new File(filename);
		Scanner input = new Scanner(inputFile);
		doubleVector = new Vector<Double>();
		while(input.hasNext()){
			double temp = input.nextDouble();
			doubleVector.addElement(temp);
		}//end while
		double sum = 0;
		for(double value:doubleVector)
			sum += value;
		double avg = sum / doubleVector.size();
		System.out.printf("The average of the values in the file is %f\n", avg);
		input.close();
	}
	catch (IOException e) {
	    System.err.println("IOException in reading input file!!!");
	}
    } //end readFile()
    
    

    /** main : creates a Lab1b Object with the filename passed in
     * argument*/
    public static void main(String args[]) {
    	args = new String[1];
    	args[0] = "Lab1b.dat";
	if (args.length == 0)
	    System.err.println("enter the data file name!");
	else
	    new Lab1b(args[0]);
    } //end main
    
} //end class Lab1b
