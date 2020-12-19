package speed.ru;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {

	int x;//x
	int y;//y
	int v;//скорость
	Image img = new ImageIcon("Res/Enemy.png").getImage();
	Road road;
	
	public Rectangle getRect() {
		return new Rectangle(x,y,150,63);
	}
	
	public Enemy(int x, int y, int v, Road road) {
		this.x = x;
		this.y = y;
		this.v = v;
		this.road = road;
	}
	
	public void move() {
		x = x - road.p.v + v;
	}
}
