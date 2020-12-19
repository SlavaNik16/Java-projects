package speed.ru;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	
	public static final int MAX_V = 100;
	public static final int MAX_TOP = 220;
	public static final int MAX_BOTTOM = 362;
	
	Image img = new ImageIcon("Res/Player.png").getImage();
	
	

	public Rectangle getRect() {
		return new Rectangle(x,y,150,60);
	}
	
	int v = 4;//Скорость
	int dv = 0;//Ускорение
	int s = 0;//Путь
	

	
	int x = 30;
	int y = 250;
	int dy = 0;
	
	int layer1 = 0;//Координата 1 слоя картинки дороги
	int layer2 = 852;
	
	public void move() {
		v += dv;
		s += v;
		
		if(v <= 0) v = 0;
		if(v >= MAX_V) v = MAX_V;
		y -= dy;
		if(y <= MAX_TOP) y = MAX_TOP;
		if(y >= MAX_BOTTOM) y = MAX_BOTTOM;
		//Если второй слой равен 0 то возвращаем 1 слой перед 2  слоем
		if(layer2 - v <= 0) {
		   layer1 = 0;
		   layer2 = 852;
	     }else {
		layer1 -= v;
		layer2 -= v;
	   }
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {
			dv = 5;
		}
		if(key == KeyEvent.VK_LEFT) {
			dv = -5;
		}
		if(key == KeyEvent.VK_UP) {
			dy = 5;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = -5;
		}
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {
			dv = 0;
		}
		if(key == KeyEvent.VK_LEFT) {
			dv = 0;
		}
		if(key == KeyEvent.VK_UP) {
			dy = 0;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
	}
}
