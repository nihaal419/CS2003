/**
 * CS 2003 - Lab 1
 * Code to find the maximum integer in a given file
 * NOTE:
 * there are bugs including those causing compilation errors and
 * resulting in runtime logical problems
 *
 * @author Nihaal Manesia
 * @since 08/31/2017
 * @version 1.0
 */

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.IOException;


public class lab1 {
    
    /**stores the data retrieved from the file */
    Vector <Integer> intVector; 
    /** variable used to compute the run-time */
    long startTime, endTime, totalTime;
    /** Constructor: computes the running time and call readFile
     * method
     */
    public lab1() {
	startTime = System.currentTimeMillis();
	readFile();
	endTime = System.currentTimeMillis();    
	totalTime = endTime - startTime;
	System.out.println("total time taken: " + totalTime + " milliseconds");
    }

    /** Reads the integers from the file lab1a.dat and stores them in
     * a vector */
    public void readFile() {
	try {
	    File inputFile = new File("Lab1a.dat");
	    Scanner input = new Scanner(inputFile);
	    intVector = new Vector<Integer>();
	    int max = 0;
	    int elt = 0;
	    int count = 0;
	    // store all elements in a vector
	    while (input.hasNext()) {
	    elt = input.nextInt();
		count++;
		intVector.addElement(elt);
	    }
	    // print on the terminal each elements of intVector
	    System.out.printf("There are %d integers in the input file:\n",
			       count);
	    for (int value: intVector)
		System.out.printf("%d ",value);
	    System.out.println();
	    
	    // find the max (use a random index to start the search)
	    Random generator = new Random();
	    int vectorSize = intVector.size();
	    int index = generator.nextInt(vectorSize);
	    max = intVector.get(index);      
	    for(int i=1;i<vectorSize;i++){
		int value = intVector.get((index+i)%vectorSize);
		if(max < value)
		    max = value;
	    }
	    //output results
	    System.out.printf("The maximum integer in the input file is %d\n",max);
	    input.close();
	} 
	catch (IOException e) {
	    System.err.println("IOException in reading input file!!!");
	}	
    } //end readFile()
    
    /** main : creates an Object Lab1a */
    public static void main(String args[]) {
	lab1 lab = new lab1();
    } //end main
    
} //end class Lab1a
