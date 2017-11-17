
public class Simulation {
	//Last 5 miles of highway where there is construction
			static Queue construction = new Queue();
			//15 miles of highway before construction begins
			static Queue highway = new Queue();
			
	public static void simulate() {
		//Using max size of 10 cars at a time for every 5 mile stretch
		construction.setMaxSize(10);
		highway.setMaxSize(30);
		
		int count = 0;
		int numcars = 0;
		
//		Car car1 = new Car();
//		construction.enQueue(car1);
//		speed(car1);
//		System.out.println(car1.getSpeed());
//		remove();
//		System.out.println(car1.getSpeed());
		
		while(!construction.isMaxed()) {
			Car car = new Car();
			if(count<10) {
				if(!highway.isEmpty()) {
					Queue temp = new Queue();
					while(!highway.isEmpty()) {
						Car tmp = (Car) highway.deQueue();
						//System.out.println(tmp.getTime());
						if(tmp.getTime() >= 12) {
							construction.enQueue(tmp);
							speed(tmp);
						}
						else {
							temp.enQueue(tmp);
						}
					}
					while(!temp.isEmpty()) {
						highway.enQueue(temp.deQueue());
					}
				}
			}
			car.setStartTime(1000*System.currentTimeMillis());
			if(count < 10) {
				highway.enQueue(car);
				count++;
			}
			
			if(!construction.isEmpty()) {
				if(((Car) construction.peek()).getSpeed() == 45.0) {
					if(((Car) construction.peek()).getTime() >= 6.6) {
						Car temp = (Car) construction.deQueue();
						numcars++;
						System.out.println("Car #" + numcars + " - Time: " + temp.getTime());
						speed();
					}
				}
				else if(((Car) construction.peek()).getSpeed() == (45.0*.75)) {
					if(((Car) construction.peek()).getTime() >= 8.8) {
						Car temp = (Car) construction.deQueue();
						numcars++;
						System.out.println("Car #" + numcars + " - Time: " + temp.getTime());
						speed();
					}
				}
				else if(((Car) construction.peek()).getSpeed() == (45*.5)) {
					if(((Car) construction.peek()).getTime() >= 13.3) {
						Car temp = (Car) construction.deQueue();
						numcars++;
						System.out.println("Car #" + numcars + " - Time: " + temp.getTime());
						speed();
					}
				}
				else if(((Car) construction.peek()).getSpeed() == (45*.25)) {
					if(((Car) construction.peek()).getTime() >= 26.6) {
						Car temp = (Car) construction.deQueue();
						numcars++;
						System.out.println("Car #" + numcars + " - Time: " + temp.getTime());
						speed();
					}
				}
			}
		}
	}
	
	public static void remove() {
		Car c = (Car) construction.deQueue();
		c.setSpeed(75.0);
	}
	
	public static void speed() {
		Queue temp = new Queue();
		if(construction.percent()<.5) {
			while(!construction.isEmpty()) {
				Car tmp = (Car) construction.deQueue();
				tmp.setSpeed(45.0);
				temp.enQueue(tmp);
			}
			while(!temp.isEmpty()) {
				construction.enQueue(temp.deQueue());
			}
			//c.setSpeed(45.0);
		}
		else if(construction.percent()>.5 && construction.percent()<.75) {
			while(!construction.isEmpty()) {
				Car tmp = (Car) construction.deQueue();
				tmp.setSpeed(45*.75);
				temp.enQueue(tmp);
			}
			while(!temp.isEmpty()) {
				construction.enQueue(temp.deQueue());
			}
			//c.setSpeed(45*.75);
		}
		else if(construction.percent()>.75 && construction.percent()<.9) {
			while(!construction.isEmpty()) {
				Car tmp = (Car) construction.deQueue();
				tmp.setSpeed(45*.5);
				temp.enQueue(tmp);
			}
			while(!temp.isEmpty()) {
				construction.enQueue(temp.deQueue());
			}
			//c.setSpeed(45*.5);
		}
		else if(construction.percent()>.9) {
			while(!construction.isEmpty()) {
				Car tmp = (Car) construction.deQueue();
				tmp.setSpeed(45*.25);
				temp.enQueue(tmp);
			}
			while(!temp.isEmpty()) {
				construction.enQueue(temp.deQueue());
			}
			//c.setSpeed(45*.25);
		}
	}
	
	public static void speed(Car c) {
		if(construction.percent()<.5) {
			c.setSpeed(45.0);
		}
		else if(construction.percent()>.5 && construction.percent()<.75) {
			c.setSpeed(45*.75);
		}
		else if(construction.percent()>.75 && construction.percent()<.9) {
			c.setSpeed(45*.5);
		}
		else if(construction.percent()>.9) {
			c.setSpeed(45*.25);
		}
	}
	
	public static void main(String [] args) {
		simulate();
	}
}
