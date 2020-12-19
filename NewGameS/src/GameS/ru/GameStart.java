package GameS.ru;

import java.awt.Dimension; 
import java.awt.Toolkit;


import javax.swing.JFrame;



public class GameStart {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Run");

		frame.setContentPane(new GamePanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0,0);
		Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize);
		frame.pack();
		frame.setVisible(true);


	}


}







































































//nikolaev