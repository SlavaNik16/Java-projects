package GameS.ru;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;

public class Back {
	Image img = new ImageIcon("C:\\Users\\AlexN\\OneDrive\\Рабочий стол\\Славено\\Программирование\\Resourse/AG3.jpg").getImage();
	Image imgs = new ImageIcon("C:\\Users\\AlexN\\OneDrive\\Рабочий стол\\Славено\\Программирование\\Resourse/Menue.jpg").getImage();

	public void draw(Graphics2D g) {
		if(GamePanel.state.equals(GamePanel.STATES.MENUE ) || GamePanel.state.equals(GamePanel.STATES.SHOP)) {
			g.drawImage(imgs,0,0,null);
			
		}
		if(GamePanel.state.equals(GamePanel.STATES.PLAY)) {
			g.drawImage(img,0,0,null);
		}
	}
}
