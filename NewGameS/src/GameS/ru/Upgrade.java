package GameS.ru;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import GameS.ru.GamePanel.STATES;

public class Upgrade {

	private double x;
	private double y;
	private double w;
	private double h;


	public  Color color1;

	private String s;
	private String f;

	public static int count;

	public String img;

	public static boolean click = false;

	public Upgrade(int x, int y, int w, int h, String s, String f) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.s = s;
		this.f = f;
		color1 = Color.WHITE;
		count = 0;

		img  = "E:/Knopka2.jpg";
	}

	public double getX() {return x;}
	public double getY() {return y;}
	public double getW() {return w;}
	public double getH() {return h;}

	public void draw(Graphics2D g) {


		g.drawImage(new ImageIcon(img).getImage(), (int) x , (int) y, null );

		g.setColor(color1);

		g.setFont(new Font("Arial", Font.ITALIC, 25));

		long length = (int) g.getFontMetrics().getStringBounds(f, g).getWidth();
		g.drawString(f, (int) (x + w / 2) - (int) (length / 2) - 160, (int) y + (int) (h/3) * 2);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.ITALIC, 25));
		g.drawString("Count = " + count, GamePanel.WIDTH/2 - 900, GamePanel.HEIGHT/2 + 500);
		g.drawString("SPEED++ (" + Player.PlayerUpSpeed +")", GamePanel.WIDTH/2 - 620, GamePanel.HEIGHT/2 + 500);
		g.drawString("DAMAGE++ (" + Player.PlayerUpDamage+")", GamePanel.WIDTH/2 - 231 , GamePanel.HEIGHT/2 + 500);
		g.drawString("BULLETS++ (" + Player.PlayerUpBullet+")", GamePanel.WIDTH/2 + 167, GamePanel.HEIGHT/2 + 500);
	}
}