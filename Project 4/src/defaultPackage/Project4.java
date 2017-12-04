package defaultPackage;
import Heaps.*;
import Trees.*;
import Algorithms.*;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Project4 {
	private int listSize = 1000;
	private static Comparable[] L1;
	private double startTime;
	private double endTime;
	private double avgTime;
	
	private void arrayGenerator() {
		L1 = new Comparable[listSize];
		Random rand = new Random();
		for(int i = 0; i<listSize; i++) {
			L1[i] = rand.nextInt();
		}
		listSize += 1000;
	}
	
	private double sort() {
		startTime = System.currentTimeMillis();
		sortAlgorithms.selectionSort(L1, L1.length);
		endTime = System.currentTimeMillis();
		avgTime = endTime - startTime;
		return avgTime;
	}
	
	public static void main(String [] args) {
		Project4 project4 = new Project4();
		String fileName = "";
		File file = new File(fileName);
		if(file.exists()&&file.canRead()&&file.canWrite()) {
			project4.arrayGenerator();
			project4.sort();
		}
		else {
			System.out.println("File is bad!");
		}
	}
}
