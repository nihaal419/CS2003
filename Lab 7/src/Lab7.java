
import java.util.Collection;
import java.util.LinkedList;

public class Lab7{
	public static void main(String [] args) {
		LinkedList<String> list1 = new LinkedList();
		LinkedList<String> list2 = new LinkedList();

		list1.add("Tulsa");
		list1.add("Ada");
		list1.add("Broken Arrow");
		list1.add("Owasso");
		
		list1.add(1, "OKC");
		
		list2.add("74104");
		list2.add("74135");
		list2.add("foo");
		list2.add("hello world");
		list2.add("777");
		
		list1.addAll(list2);
//		while(!list2.isEmpty()) {
//			list1.add(list2.remove());
//		}
		
		System.out.println(list1.toString());
		list1.remove(1);
		list1.remove(3);
		list1.remove(5);
		System.out.println(list1.toString());
		System.out.println(list2.toString());
	}
}