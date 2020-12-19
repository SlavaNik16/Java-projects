package GameS.ru;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Text {
	private double x;
	private double y;


	private long time;


	private String s;


	private long start;

	public Text(double x ,double y, long time, String s){
		this.y = y;
		this.time = time;
		this.s = s;
		start = System.nanoTime();
	}
	public boolean update(){

		long elapsed = (System.nanoTime() - start)/1000000;
		if (elapsed > time){
			return true;
		}
		return false;
	}


	public void draw(Graphics2D g){

		g.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		g.setColor(new Color(255,255,255,128));
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s,(int) (x - length / 2), (int) y);

	}

}

