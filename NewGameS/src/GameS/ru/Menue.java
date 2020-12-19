package GameS.ru;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Menue {

	private int n;
	private Color color1;
	private double x;
	private double y;
	private double w;
	private double h;

	public boolean user_0 = false;
	public boolean user_1 = false;
	public boolean user_2 = false;
	public static boolean click = false;

	private String img;

	String[] list = new String[5];

	public Menue() {
		x = 0;
		y = 20;
		w = 290;
		h = 140;
		n = 5;
		color1 = Color.RED;
		img = "C:\\Users\\AlexN\\OneDrive\\Рабочий стол\\Славено\\Программирование\\Resourse/Knopka1.jpg";

		list[0] = "   Играть";
		list[1] = "Новый игрок";
		list[2] = " Настройки";
		list[3] = "  Правила";
		list[4] = "   Выход";

	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getW() {
		return w;
	}
	public double getH() {
		return h;
	}

	public void update() {

	}

	public void draw(Graphics2D g) {
		for(int i = 0; i < n; i++) {
			g.drawImage(new ImageIcon(img).getImage(), (int) x + 20 , (int) (y + 140) * i, null );

			g.setColor(color1);
			Font font = new Font("Arial", Font.ITALIC, 60);
			g.setFont(font);

			long length = (int) g.getFontMetrics().getStringBounds(list[i], g).getWidth();
			g.drawString(list[i], (int) (x + w / 2) + (int) (length / 2) - 160, (int) ((y + 140) * i + (h/3) * 2));

		}

		
		g.setColor(Color.white);
		if(user_0) {
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("Прежде чем играть ознакомтесь с правилами игры", 720,70);
			g.drawString("и выберите управления под себя в настройках", 720, 90);
		}
		if(user_1) {
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("Придумайте имя для входа в игру ", 720,225);
			g.drawString("и сохранения прогресса", 720, 245);
		}
		
		if(user_2) {
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("Ваша задача, убить босса 50 уровня, для этого вы можете передвигатся стандартным управлением и стрелять.", 20,850);
			g.drawString("Вам доступны улучшения для игрока, для этого вы должны копить мощь или очки(count).", 20, 880);
			g.drawString("Если вы умрете, игра закончиться и вы проиграли.", 20, 910);
			g.drawString("Игру сделал Николаев Вячеслав(Kcandr00)", 20, 960);
		}
	}

}
