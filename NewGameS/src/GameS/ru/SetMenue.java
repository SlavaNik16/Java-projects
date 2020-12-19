package GameS.ru;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class SetMenue {
	private double x;
	private double y;
	private double w;
	private double h;

	public Color color1;
	public String f;
	public String s;
	private String img;

	public SetMenue(int x, int y, int w, int h, String s, String f) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.s = s;
		this.f = f;
		color1 = Color.WHITE;

		img  = "C:\\Users\\AlexN\\OneDrive\\Рабочий стол\\Славено\\Программирование\\Resourse/Knopka2.jpg";

	}

	public double getX() {return x;}
	public double getY() {return y;}
	public double getW() {return w;}
	public double getH() {return h;}


	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.ITALIC, 60));
		g.drawString("Сложность", 40, 110);
		g.drawString("Звук", 40, 260);
		g.drawString("Управление", 40, 410);

		g.drawImage(new ImageIcon(img).getImage(), (int) x , (int) y, null );

		g.setColor(color1);
		Font font = new Font("Arial", Font.ITALIC, 50);
		g.setFont(font);

		long length = (int) g.getFontMetrics().getStringBounds(f, g).getWidth();
		g.drawString(f, (int) (x + w / 2) - (int) (length / 2) - 160, (int) y + (int) (h/3) * 2);

		g.setColor(Color.red);
		g.setFont(new Font("Arial", Font.ITALIC, 40));
		if(GamePanel.easy) g.drawString("Легко", 1650, 110);
		if(GamePanel.norm) g.drawString("Средне", 1650, 110);
		if(GamePanel.hard) g.drawString("Сложно", 1650, 110);

		if(GamePanel.aud) g.drawImage(new ImageIcon("C:\\Users\\AlexN\\OneDrive\\Рабочий стол\\Славено\\Программирование\\Resourse/Aud3.png").getImage(),(int) 1300,(int) 200, null);
		if(!GamePanel.aud) g.drawImage(new ImageIcon("C:\\Users\\AlexN\\OneDrive\\Рабочий стол\\Славено\\Программирование\\Resourse/Aug2.png").getImage(), (int) 1300, (int) 200, null);

		if(GamePanel.control) g.drawString("Стандарт", 1300, 410);
		if(!GamePanel.control) g.drawString("Пользовательский", 1300, 410);

	}
}
