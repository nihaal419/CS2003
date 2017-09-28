
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
		String name = "Able was I ere I saw Elba";
		System.out.println(isaPalindrome(name));
	}
}