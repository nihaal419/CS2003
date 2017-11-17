
public class Car {
	private double speed;
	private long starttime;
	
	public Car() {
		speed = 75.0;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double s) {
		speed = s;
	}
	
	public void setStartTime(long l) {
		starttime = l;
	}
	
	public long getTime() {
		return starttime - System.currentTimeMillis();
	}
}
