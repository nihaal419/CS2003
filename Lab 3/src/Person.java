public class Person {
	static int current_year = 2017;
	private String name;
	private int birthdate;
	private int age;
	
	//constructor
	public Person(String name, int bdate){
		this.name = name;
		this.birthdate = bdate;
	}

	//resets the birthday back to the current year
	public void reset_birthday(int year){
		birthdate = year;
	}
	
	//prints out the information needed such as name, birth date, age
	public void displayInfo(){
		
		System.out.println("This is " + name);
		
		System.out.printf("I was born in %d. ",birthdate);
		
		calculateAge();
		
		checkSenior();
		
	}

	public void checkSenior() {
		if (age >= 65){
			System.out.println("\nI'm a senior citizen");
		}
		else{
			System.out.println("\nI'm not old enough to be classified as a senior by Medicare!");
		}
	}

	//calculates the age by subtracting birth year from the current year
	public void calculateAge() {
		age = current_year - birthdate;
		System.out.printf("I am %d years old ",age);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person John = new Person("John",1957);
		John.displayInfo();
		
		
	}

}
