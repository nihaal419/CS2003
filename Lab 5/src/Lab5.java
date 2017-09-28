import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lab5 {

	public static boolean isaPalindrome(String expr) {
		expr = expr.toLowerCase();
		if(expr.equals("")) return true;
		if(expr.length() == 1) return true;
		else {
			String temp = expr.substring(0, 1);
			String temp2 = expr.substring(expr.length()-1, expr.length());
			if(temp.equals(temp2)) {
				String newWord = expr.substring(1, expr.length()-1);
				return isaPalindrome(newWord);
			}
			else 
				return false;
		}
	}
	
	public static void main(String [] args) {
		try {
			File inputFile = new File("words.dat");
			Scanner file = new Scanner(inputFile);
			long startTime = System.currentTimeMillis();
			while(file.hasNext()) {
				String next = file.next();
				System.out.println(next + ": " + isaPalindrome(next));
			}
			long endTime = System.currentTimeMillis();
			long finalTime = endTime - startTime;
			System.out.println("It took " + finalTime + "ms to read through and check palindromes");
		}
		catch(IOException e) {
			System.err.println("IOException in reading input file!!!");
		}
//		String name = "Able was I ere I saw Elba";
//		System.out.println(isaPalindrome(name));
	}
}