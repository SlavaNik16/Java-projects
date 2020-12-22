package GameS.ru;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class ControlMenu {

	public static String img = "E:/Knopka2.jpg";
	ButControl butCon_up = new ButControl(550,10,300,67,img, "Курс вверх",38);
	ButControl butCon_d =  new ButControl(550,110,300,67,img, "Курс вниз",40);
	ButControl butCon_l = new ButControl(550,210,300,67,img, "Курс влево",37);
	ButControl butCon_r = new ButControl(550,310,300,67,img, "Курс вправо",39);
	ButControl butCon_es = new ButControl(550,410,300,67,img, "Space",32);
	ButControl butCon_k = new ButControl(1550,1000,300,67,img, "Назад",8);
	
	public void draw(Graphics2D g){
		butCon_up.draw(g);
		butCon_d.draw(g);
		butCon_l.draw(g);
		butCon_r.draw(g);
		butCon_es.draw(g);
		butCon_k.draw(g);
	}

	public void moveControl(ButControl b) {
		if(GamePanel.mouseX > b.getX() && GamePanel.mouseX < b.getX() + b.getW() &&
				GamePanel.mouseY > b.getY() && GamePanel.mouseY < b.getY() + b.getH()) {
			b.color1 = Color.red;
			if(b.equals(butCon_up)) {
				editContr(b);
			}
			if(b.equals(butCon_d)) {
				editContr(b);
			}
			if(b.equals(butCon_l)) {
				editContr(b);
			}
			if(b.equals(butCon_r)) {
				editContr(b);
			}
			if(b.equals(butCon_es)) {
				editContr(b);
			}
			if(b.equals(butCon_k)) {
				if(Menue.click) {
					GamePanel.butmenu = false;
					GamePanel.controlmenu = false;
					GamePanel.setmenu = true;
				}
			}
		}else {
			b.color1 = Color.WHITE;
			b.zamen = false;
		}
	}
	public void editContr(ButControl b) {
		if(Menue.click) {
			b.f = "";
			b.zamen = true;
		}
	}


	class ButControl {

		private double x;
		private double y;
		private double w;
		private double h;


		public Color color1;

		public String f;
		public String s;
		public boolean zamen = false;

		public int ch_code;

		public ButControl(int x, int y, int w, int h, String s, String f, int ch_code) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.s = s;
			this.f = f;
			this.ch_code = ch_code;
			this.zamen = zamen;

			color1 = Color.BLACK;


		}
		public double getX() {return x;}
		public double getY() {return y;}
		public double getW() {return w;}
		public double getH() {return h;}

		public void draw(Graphics2D g) {
			g.drawImage(new ImageIcon("E:/Knopka2.jpg").getImage(), (int) x, (int) y, null);
			g.setColor(color1);
			g.setFont(new Font("Arial", Font.ITALIC, 40));

			long length = (int) g.getFontMetrics().getStringBounds(f, g).getWidth();
			g.drawString(f, (int) (x + w /2) - (int) (length / 2), (int) y + (int) (h/3)* 2);

			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.ITALIC, 20));
			g.drawString("Движение вверх", 950, 40);
			g.drawString("Движение вниз", 950, 140);
			g.drawString("Движение влево", 950, 240);
			g.drawString("Движение вправо",950, 340);
			g.drawString("Атака", 950, 440);

		}


	}
}
