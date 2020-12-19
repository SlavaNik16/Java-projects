package speed.ru;

import javax.swing.*;

public class Game {

	public static void main(String[] args) {
	
		JFrame frame = new JFrame("Spedding");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new Road());
		
		frame.setSize(752,480);
		frame.setVisible(true);
		
		

	}

}
