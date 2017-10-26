import java.util.Stack;

public class DelimiterChecker {
	private Stack<Character> stack;
	
	public DelimiterChecker() {
		stack = new Stack<Character>();
	}
	
	public boolean check(String s) {
		for(int i=0; i<s.length();i++){
			char c = s.charAt(i);
		    if(c == '{' || c == '(' || c == '['){
		      stack.push(c);
		    }
		    else if(c == '}'){
		      if(stack.isEmpty()) {System.out.println("Missing right delimiter error"); return false;}
		      if(stack.peek() != '{') return false;
		      stack.pop();
		    }
		    else if(c == ')'){
		      if(stack.isEmpty()) {System.out.println("Missing right delimiter error"); return false;}
		      if(stack.peek() != '(') return false;
		      stack.pop();
		    }
		    else if(c == ']'){
		      if(stack.isEmpty()) {System.out.println("Missing right delimiter error"); return false;}
		      if(stack.peek() != '[') return false;
		      stack.pop();
		    }
		}

		return stack.isEmpty();
	}
	
	public static void main(String [] args) {
		DelimiterChecker dcheck = new DelimiterChecker();
		System.out.println(dcheck.check("{}"));
	}
}
