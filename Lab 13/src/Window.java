import java.awt.*;
import javax.swing.*;

public class Window {
	
	private static void createWindow() {
		JFrame frame = new JFrame("Color Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(300, 100);
		
		JButton change = new JButton("Change");
		change.setSize(50,20);
		JButton reset = new JButton("Reset");
		reset.setSize(50,20);
		JButton exit = new JButton("Exit");
		exit.setSize(50,20);
		frame.add(exit);
		frame.add(reset);
		frame.add(change);
		
		frame.setLocationRelativeTo(null);
		//frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String [] args) {
		createWindow();
	}
}
