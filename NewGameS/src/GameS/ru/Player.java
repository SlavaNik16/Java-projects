package GameS.ru;

import java.awt.Color;  
import java.awt.Graphics2D;






public class Player {


	private static  int x;
	private static int y;
	private static int r;

	private double dx;
	private double dy;

	private static double speed;

	private static boolean up;
	private static boolean down;
	private static boolean left;
	private static boolean right;

	private static boolean firing;
	private long firingTime;
	private long firingDelay;

	private Color color1;
	private Color color2;

	public static int lives;

	private static int score;


	private static boolean recovering;
	private static long recoveringTime;

	public static int powerLevel;
	private int power;
	private int[] requestPower = {
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
			21, 22, 23 ,24 ,25, 26, 27, 28 ,29 ,30, 31,32,33,34,35,36,37,38,39,40
	};

	public static int PlayerUpSpeed;

	public static int PlayerUpBullet;

	public static int PlayerUpDamage;


	private boolean pressed1 = true;
	private boolean pressed2 = true;
	private boolean pressed3 = true;
	private boolean pressed4 = true;
	private boolean pressed5 = true;
	private boolean pressed6 = true;
	private boolean pressed7 = true;
	private boolean pressed8 = true;
	private boolean pressed9 = true;
	private boolean pressed10 = true;
	private boolean pressed11 = true;
	private boolean pressed12 = true;
	private boolean pressed13 = true;
	private boolean pressed14 = true;
	private boolean pressed15 = true;

	public Player() {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		r = 7;

		dx = 0;
		dy = 0;

		speed = 7;

		color1 = Color.WHITE;
		color2 = Color.RED;

		lives = 5;

		firing = false;
		firingTime = System.nanoTime();
		firingDelay = 200;

		recovering = false;
		recoveringTime = 0;

		score = 0;

		PlayerUpSpeed = 0;
		PlayerUpBullet = 0;
		PlayerUpDamage = 0;
	}

	public static int getX() {
		return x;
	}

	public  static int getY() {
		return y;
	}

	public static int getR() {
		return r;
	}

	public  int getLives() {
		return lives;
	}
	public void gainLive() {
		lives++;
	}

	public static void setUp(boolean b) {
		up = b;
	}

	public static void setDown(boolean b) {
		down = b;
	}

	public static void setLeft(boolean b) {
		left = b;
	}

	public static void setRight(boolean b) {
		right = b;
	}

	public static void setFiring(boolean b) {
		firing = b;
	}

	public static int getScore() {
		return score;
	}

	public static void addScore(int i) {
		score += i;
	}

	public static void loseLive() {
		lives--;
		recovering = true;
		recoveringTime = System.nanoTime();
	}

	public boolean isRecovering() {
		return recovering;
	}

	public void increase(int i) {
		power += i;
		if (power == 50) {
			if (power >= requestPower[powerLevel]) {
				power = requestPower[powerLevel];
			}
			return;
		}
		if (power >= requestPower[powerLevel]) {
			power -= requestPower[powerLevel];
			powerLevel++;
		}
	}


	public int getPower() {
		return power;
	}

	public int getRequestPower() {
		return requestPower[powerLevel];
	}

	public boolean isDead() {
		return lives <= 0;
	}

	public void DEAD() {
		GamePanel.enemies.clear();
	}
	public static int PlayersUpsSpeed() {
		return PlayerUpSpeed;
	}

	public static int PlayersUpsBullet() {
		return PlayerUpBullet;
	}

	public static int PlayersUpsDamage(){ return PlayerUpDamage;}





	public void update() {

		if(GamePanel.norm) speed = 6;
		if(GamePanel.hard) speed = 5;

		if (up) {
			dy = -speed;
		}

		if (down) {
			dy = speed;
		}

		if (left) {
			dx = -speed;
		}

		if (right) {
			dx = speed;
		}

		if (GamePanel.slowStop){
			x += dx * 0;
			y += dy * 0;
		}else {
			x += dx;
			y += dy;
		}

		if (x < r) x = r;
		if (y < r) y = r;
		if (x > GamePanel.WIDTH - r) x = GamePanel.WIDTH - r;
		if (y > GamePanel.HEIGHT - r - 35) y = GamePanel.HEIGHT - r - 35;

		dx = 0;
		dy = 0;

		if (firing) {
			long elapsed = (System.nanoTime() - firingTime) / 1000000;

			if (elapsed > firingDelay) {

				firingTime = System.nanoTime();

				if (powerLevel < 2) {
					GamePanel.bullets.add(new Bullet(270, x, y));
				} else if (powerLevel >= 2 && pressed1) {
					Upgrade.count++;
					pressed1 = false;
				} else if (powerLevel >= 4  && pressed2){

					Upgrade.count++;
					pressed2 = false;

				} else if (powerLevel >= 6  && pressed3) {

					Upgrade.count++;
					pressed3 = false;

				} else if (powerLevel >= 8 && pressed4) {

					Upgrade.count++;
					pressed4 = false;

				} else if (powerLevel >= 10 && pressed5) {

					Upgrade.count++;
					pressed5 = false;

				} else if (powerLevel >= 12 && pressed6 ){

					Upgrade.count++;
					pressed6 = false;

				} else if (powerLevel >= 14 && pressed7){
					Upgrade.count++;				
					pressed7 = false;

				} else if (powerLevel >= 16&& pressed8){

					Upgrade.count++;
					pressed8 = false;

				} else if (powerLevel >= 18 && pressed9) {

					Upgrade.count++;
					pressed9 = false;

				} else if (powerLevel == 20 && pressed10) {

					Upgrade.count++;
					pressed10 = false;

				}else if (powerLevel >= 21  && pressed11){

					Upgrade.count++;
					pressed11 = false;

				}else if(powerLevel == 23 && pressed12 ) {

					Upgrade.count++;
					pressed12 = false;

				} else if(powerLevel == 24 && pressed13) {
					Upgrade.count++;
					pressed13 = false;

				} else if(powerLevel == 25 && pressed14) {

					Upgrade.count++;
					pressed14 = false;

				}else if(powerLevel == 26 && pressed15) {

					Upgrade.count++;
					pressed15 = false;
				}



				for(int i = 0; i < 16; i++) {
					if(PlayerUpSpeed == i) {
						firingDelay = (200 - i * 20);
						GamePanel.bullets.add(new Bullet(270, x, y));

					}
				}


				for(int i = 0; i < 16; i++) {
					if(PlayerUpDamage == i) {
						Enemy.damage = 1 + i;
						GamePanel.bullets.add(new Bullet(270, x, y));

					}
				}


			if(PlayerUpBullet == 0) {
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpBullet == 1) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(270, x - 5, y));
					GamePanel.bullets.add(new Bullet(270, x + 5, y));
				}
				if (PlayerUpBullet == 2) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));
				}
				if (PlayerUpBullet == 3) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));
				}
				if (PlayerUpBullet == 4) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));
				}
				if (PlayerUpBullet == 5) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));
				}
				if (PlayerUpBullet == 6) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));
				}
				if (PlayerUpBullet == 7) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));
				}
				if (PlayerUpBullet == 8) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));
				}
				if (PlayerUpBullet == 9) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 5, y));
					GamePanel.bullets.add(new Bullet(85, x - 5, y));

				}
				if (PlayerUpBullet == 10) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 5, y));
					GamePanel.bullets.add(new Bullet(85, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 10, y));
					GamePanel.bullets.add(new Bullet(85, x - 10, y));

				}
				if (PlayerUpBullet == 11) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 5, y));
					GamePanel.bullets.add(new Bullet(85, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 10, y));
					GamePanel.bullets.add(new Bullet(85, x - 10, y));

					GamePanel.bullets.add(new Bullet(95, x + 15, y));
					GamePanel.bullets.add(new Bullet(85, x - 15, y));

				}
				if (PlayerUpBullet >= 12) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 5, y));
					GamePanel.bullets.add(new Bullet(85, x - 5, y));

					GamePanel.bullets.add(new Bullet(100, x + 5, y));
					GamePanel.bullets.add(new Bullet(80, x - 5, y));

					GamePanel.bullets.add(new Bullet(105, x + 5, y));
					GamePanel.bullets.add(new Bullet(75, x - 5, y));

					GamePanel.bullets.add(new Bullet(110, x + 5, y));
					GamePanel.bullets.add(new Bullet(70, x - 5, y));
					}
			}
		}
		if (recovering) {
			long elapsed = (System.nanoTime() - recoveringTime) / 1000000;
			if (elapsed > 2000) {
				recoveringTime = 0;
				recovering = false;
			}

		}
	}

	public void draw(Graphics2D g) {
		if (recovering) {
			g.setColor(color2);
			g.fillOval(x - r, y - r, 2 * r, 2 * r);
		} else {
			g.setColor(color1);
			g.fillOval(x - r, y - r, 2 * r, 2 * r);
		}
	}


}
