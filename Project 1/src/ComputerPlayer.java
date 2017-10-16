import java.util.Random;

public class ComputerPlayer {
	char playerColor;
	
	ComputerPlayer(){
	}
	
	ComputerPlayer(char pColor){
		playerColor = pColor;
	}
	
	public void setColor(char pColor) {
		playerColor = pColor;
	}
	
	public char getColor() {
		return playerColor;
	}
	
	public int pickRow() {
		Random rand = new Random();
		int pick = rand.nextInt(8);
		return pick;
	}
	
	public int pickCol() {
		Random rand = new Random();
		int pick = rand.nextInt(8);
		return pick;
	}
}
