package GameS.ru;

import java.awt.BasicStroke; 
import java.awt.Color;
import java.awt.Graphics2D;





public class Enemy {

	private  double x;
	private  double y;
	private  int r;

	private double dx;
	private double dy;

	private Color color1;

	private double rad;
	public static double speed;

	public int health;
	private int type;
	private int rang;
	public double startBoss;;

	private boolean ready;
	public  boolean dead;

	private  boolean hit;
	public static  int damage;
	private  long hitTime;

	private boolean slow;

	public static int lvl;

	public Enemy(int type, int rang) {
		this.type = type;
		this.rang = rang;

		if(GamePanel.easy) lvl = 0;
		if(GamePanel.norm) lvl = 5;
		if(GamePanel.hard) lvl = 10;

		if (type == 1) {
			color1 = Color.GREEN.darker();
			if (rang == 1) {
				speed = 4 + lvl;
				r = 10 + lvl;
				health = 1 + lvl;

			}
			if (rang == 2) {
				speed = 4 + lvl;
				r = 12 + lvl;
				health = 2 + lvl;
			}
			if (rang == 3) {
				speed = 4 + lvl;
				r = 14 + lvl;
				health = 3 + lvl;
			}
			if (rang == 4) {
				speed = 4 + lvl;
				r = 16 + lvl;
				health = 4 + lvl;
			}
			if (rang == 5) {
				speed = 5 + lvl;
				r = 18 + lvl;
				health = 5 + lvl;
			}
			if (rang == 6) {
				speed = 4 + lvl;
				r = 20 + lvl;
				health = 6 + lvl;
			}
			if (rang == 7) {
				speed = 5 + lvl;
				r = 22 + lvl;
				health = 6 + lvl;
			}
			if (rang == 8){
				speed = 2 + lvl;
				r = 24 + lvl;
				health = 6 + lvl;
			}
			if (rang == 9) {
				speed = 24 + lvl;
				r = 6 + lvl;
				health = 5 + lvl;
			}
			if (rang == 10){
				speed = 30 + lvl;
				r = 80 + lvl;
				health = 4725 +  (lvl * 100);
			}
		}
		if (type == 2) {
			color1 = Color.YELLOW;
			if (rang == 1) {
				speed = 6 + lvl;
				r = 8 + lvl;
				health = 6 + lvl;
			}
			if(rang == 2){
				speed = 7 + lvl;
				r  = 10 + lvl;
				health = 7 + lvl;
			}
			if(rang == 3){
				speed = 8 + lvl;
				r  = 12 + lvl;
				health = 8 + lvl;
			}
			if(rang == 4){
				speed = 9 + lvl;
				r  = 14 + lvl;
				health = 9 + lvl;
			}

			if (rang == 5) {
				speed = 9 + lvl ;
				r = 16 + lvl;
				health = 10 + lvl;
			}
			if (rang == 6) {
				speed = 9 + lvl;
				r = 18 + lvl;
				health = 10 + lvl;
			}
			if (rang == 7) {
				speed = 9 + lvl;
				r = 20 + lvl;
				health = 11 + lvl;
			}
			if (rang == 8){
				speed = 11 + lvl;
				r = 22 + lvl;
				health = 12 + lvl;
			}
			if (rang == 9) {
				speed = 30 + lvl;
				r = 24 + lvl;
				health = 40 + lvl;
			}
			if (rang == 10){
				speed = 40 + lvl;
				r = 150 + lvl;
				health = 14175 + (lvl * 100);

			}

		}
		if (type == 3) {
			color1 = Color.RED;
			if (rang == 1) {
				speed = 11 + lvl;
				r = 15 + lvl;
				health = 11 + lvl;
			}
			if(rang == 2){
				speed = 12 + lvl;
				r  = 18 + lvl;
				health = 12 + lvl;
			}
			if(rang == 3){
				speed = 13 + lvl;
				r  = 21 + lvl;
				health = 14 + lvl;
			}
			if(rang == 4){
				speed = 13 + lvl;
				r  = 24 + lvl;
				health = 16 + lvl;
			}

			if (rang == 5) {
				speed = 13 + lvl;
				r = 26 + lvl;
				health = 18 + lvl;
			}
			if (rang == 6) {
				speed = 13 + lvl;
				r = 28 + lvl;
				health = 20 + lvl;
			}
			if (rang == 7) {
				speed = 13 + lvl;
				r = 30 + lvl;
				health = 22 + lvl;
			}
			if (rang == 8){
				speed = 13 + lvl;
				r = 32 + lvl;
				health = 24 + lvl;
			}
			if (rang == 9) {
				speed = 35 + lvl;
				r = 20 + lvl;
				health = 70 + lvl;
			}
			if (rang == 10){
				speed = 60 + lvl;
				r = 100 + lvl;
				health = 20475 + (lvl * 100);

			}
		}

		if (type == 4) {
			color1 = Color.BLACK;
			if (rang == 1) {
				speed = 15 + lvl;
				r = 10 + lvl;
				health = 25 + lvl;
			}
			if(rang == 2){
				speed = 15 + lvl;
				r  = 18 + lvl;
				health = 28 + lvl;
			}
			if(rang == 3){
				speed = 15 + lvl;
				r  = 21 + lvl;
				health = 31 + lvl;
			}
			if(rang == 4){
				speed = 15 + lvl;
				r  = 24 + lvl;
				health = 34 + lvl;
			}

			if (rang == 5) {
				speed = 15 + lvl;
				r = 26 + lvl;
				health = 37 + lvl;
			}
			if (rang == 6) {
				speed = 15 + lvl;
				r = 28 + lvl;
				health = 40 + lvl;
			}
			if (rang == 7) {
				speed = 15 + lvl;
				r = 30 + lvl;
				health = 43 + lvl;
			}
			if (rang == 8){
				speed = 15 + lvl;
				r = 32 + lvl;
				health = 46 + lvl;
			}
			if (rang == 9) {
				speed = 70 + lvl;
				r = 30 + lvl;
				health = 50 + lvl;
			}
			if (rang == 10){
				speed = 50 + lvl;
				r = 150 + lvl;
				health = 47250 + (lvl * 100);

			}
		}
		x = Math.random() * GamePanel.WIDTH / 2 + GamePanel.WIDTH / 4;
		y = -r;

		double angle = Math.random() * 140 + 20;
		rad = Math.toRadians(angle);

		dx = Math.cos(rad) * speed;
		dy = Math.sin(rad) * speed;

		ready = false;
		dead = false;

		hit = false;
		damage = 1;
		hitTime = 0;
	}

	public double setX () {
		return x;
	}
	public double setY () {
		return y;
	}
	public int setR () {
		return r;
	}
	public boolean isDead () {
		return dead;
	}

	public int getType () {
		return type;
	}
	public int getRang () {
		return rang;
	}

	public double getX () {
		return x;
	}
	public double getY () {
		return y;
	}
	public int getR () {
		return r;
	}
	public void setSlow(boolean b){ slow = b;}

	public  void hit() {
		health -= damage;
		if (health <= 0) {
			dead = true;
		}

		hit = true;
		hitTime = System.nanoTime();
	}

	public void explode(){
		if (rang > 1) {
			int amount = 0;
			if (type == 1) {
				if (rang < 9 && rang > 1) {
					amount = 2;
				}else if (rang == 10 || rang == 9){
					amount = 0;
				}
			}
			if (type == 2) {
				if (rang < 9 && rang > 1) {
					amount = 2;
				}else if (rang == 10 || rang == 9){
					amount = 0;
				}
			}
			if (type == 3) {
				if (rang <= 9 && rang > 1) {
					amount = 2;
				}else if (rang == 10){
					amount = 0;
				}
			}
			if (type == 4) {
				if (rang < 10 && rang > 1) {
					amount = 2;
				}else if (rang == 10){
					amount = 0;
				}
			}




			for (int i = 0; i < amount; i++) {
				Enemy e = new Enemy(getType(), getRang() - 1);
				e.setSlow(slow);
				e.x = this.x;
				e.y = this.y;
				double angle = 0;
				if (!ready) {
					angle = Math.random() * 140 + 20;
				} else {
					angle = Math.random() * 360;
				}
				e.rad = Math.toRadians(angle);
				GamePanel.enemies.add(e);
			}
		}

	}
	public void update () {
		if (GamePanel.slowStop){
			x += dx * 0;
			y += dy * 0;
		}else if (slow){
			x += dx * 0.3;
			y += dy * 0.3;
		}else {
			x += dx;
			y += dy;
		}

		if (!ready) {
			if (x > r && x < GamePanel.WIDTH - r &&
					y > r && y < GamePanel.HEIGHT - r) {
				ready = true;
			}
		}
		if (x < r && dx < 0) {
			dx = -dx;
		}
		if (y < r && dy < 0) {
			dy = -dy;
		}
		if (x > GamePanel.WIDTH - r && dx > 0) {
			dx = -dx;
		}
		if (y > GamePanel.HEIGHT - r - 85 && dy > 0) {
			dy = -dy;
		}

		if (hit){
			long elapsed = (System.nanoTime() - hitTime )/ 1000000;
			if (elapsed > 50 ){
				hit = false;
				hitTime = 0;
			}
		}

	}
	public void draw (Graphics2D g){
		if (hit) {
			g.setColor(Color.WHITE);
			g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
			g.setStroke(new BasicStroke(3));
			g.setColor(Color.WHITE.darker());
			g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
			g.setStroke(new BasicStroke(1));
		}else {
			g.setColor(color1);
			g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
			g.setStroke(new BasicStroke(3));
			g.setColor(color1.darker());
			g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
			g.setStroke(new BasicStroke(1));
		}


	}
}
