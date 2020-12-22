package GameS.ru;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class ShopMenu {

	private double x;
	private double y;
	private double w;
	private double h;

	public Color color1;
	public String f;
	public String s;
	private String img;

	public static boolean click = false;

	public ShopMenu(int x, int y, int w, int h, String s, String f) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.s = s;
		this.f = f;
		color1 = Color.WHITE;

		img  = "E:/Knopka2.jpg";

	}

	public double getX() {return x;}
	public double getY() {return y;}
	public double getW() {return w;}
	public double getH() {return h;}


	public void draw(Graphics2D g) {


		g.drawImage(new ImageIcon(img).getImage(), (int) x , (int) y, null );

		g.setColor(color1);
		Font font = new Font("Arial", Font.ITALIC, 20);
		g.setFont(font);

		long length = (int) g.getFontMetrics().getStringBounds(f, g).getWidth();
		g.drawString(f, (int) (x + w / 2) - (int) (length / 2) - 160, (int) y + (int) (h/3) * 2);

		g.setColor(Color.red);
		g.setFont(new Font("Arial", Font.ITALIC, 45));

		g.drawString("Навыки", 150,50);
		g.drawString("Бонусы", 750,50);
		g.drawString("Баффы", 1350,50);
		g.drawString("Score = " + Player.score + " #", 50,1000);
		g.drawString("Count = " + Upgrade.count, 50,950);



	}
}