package GameS.ru;

import java.awt.BasicStroke;     
import java.awt.Color;  
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.awt.Toolkit;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JPanel;




public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;


	private Thread thread;
	public static boolean running = true;

	private BufferedImage image;
	private Graphics2D g;

	private int FPS = 30;
	@SuppressWarnings("unused")
	private double averageFPS = 0;

	public static Back back;
	public static Player player;
	public static ArrayList<Bullet> bullets;
	public static ArrayList<Enemy> enemies;
	public static Wave wave;
	public static ArrayList<Explosion> explosions;
	public static ArrayList<PowerUp> powerUps;
	public static ArrayList<Text> texts;
	public static Magazine magazine;
	public static Menue menue;
	public static ArrayList<SetMenue> setMenue;
	public static ControlMenu c_menu;
	public static ArrayList<Upgrade> upgrade;
	public static ArrayList<ShopMenu> shopmenu;

	private long slowDownTime;
	private long slowDownTimeDiff;
	private int slowDownLength = 6000;

	public static long DamageDownTime;
	public static long DamageDownTimeDiff;
	public static int lengthDamage = 20000;

	public static long MaxLvlTime;
	public static long MaxLvlTimeDiff;
	public static int MaxLvlLength = 30000;



	public static boolean slowStop = false;

	public static boolean butmenu = true;
	public static boolean setmenu = false;
	public static boolean controlmenu = false;

	public static boolean easy = true;
	public static boolean norm = false;
	public static boolean hard = false;

	public static boolean aud = true;
	public static boolean control = true;

	public static boolean rules = false;

	public static boolean shopmenus = false;

	public static double startBoss;

	public static boolean N1 = false;
	public static boolean N2 = false;
	public static boolean N3 = false;
	public static boolean N4 = false;




	public static enum STATES{MENUE, PLAY, SHOP};
	public static  STATES state = STATES.MENUE;

	public static int mouseX;
	public static int mouseY;






	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			Thread thread = new Thread(this);
			thread.start();
		}
		addKeyListener(new Listener());
		addMouseMotionListener(new Listener());
		addMouseListener(new Listener());
	}

	public void run() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();

		g.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		back = new Back();
		player = new Player();
		bullets = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		wave = new Wave();
		explosions = new ArrayList<Explosion>();
		powerUps = new ArrayList<PowerUp>();
		texts = new ArrayList<Text>();
		magazine = new Magazine();
		menue = new Menue();
		setMenue = new ArrayList<SetMenue>();
		c_menu = new ControlMenu();
		upgrade = new ArrayList<Upgrade>();
		shopmenu = new ArrayList<ShopMenu>();


		GamePanel.setMenue.add(new SetMenue(500,65,620,60,"","�����"));
		GamePanel.setMenue.add(new SetMenue(900,65,620,60,"","������"));
		GamePanel.setMenue.add(new SetMenue(1300,65,620,60,"","������"));

		GamePanel.setMenue.add(new SetMenue(500,210,620,60,"","���"));
		GamePanel.setMenue.add(new SetMenue(900,210,620,60,"","����"));

		GamePanel.setMenue.add(new SetMenue(500,365,620,60,"","��������"));
		GamePanel.setMenue.add(new SetMenue(900,365,620,60,"","���������"));

		GamePanel.setMenue.add(new SetMenue(1300,1000,620,60,"","�����"));


		GamePanel.upgrade.add(new Upgrade(250,1000,620,60,"","SPEED++"));
		GamePanel.upgrade.add(new Upgrade(650,1000,620,60,"","DAMAGE++"));
		GamePanel.upgrade.add(new Upgrade(1050,1000,620,60,"","BULLETS++"));
		GamePanel.upgrade.add(new Upgrade(1450,1000,620,60,"","SHOP"));

		GamePanel.shopmenu.add(new ShopMenu(100,130,620,60,"","������ ����� + 1 = 600 #"));
		GamePanel.shopmenu.add(new ShopMenu(700,130,620,60,"","���.�� �� 30 � = 1 200 #"));
		GamePanel.shopmenu.add(new ShopMenu(1300,130,620,60,"","Kill ���� � 1 HP = 50 #"));

		GamePanel.shopmenu.add(new ShopMenu(100,230,620,60,"","���������� 5 ������ = 2 500 #"));
		GamePanel.shopmenu.add(new ShopMenu(700,230,620,60,"","�������� ���� �� 5 = 3 000 #"));
		GamePanel.shopmenu.add(new ShopMenu(1300,230,620,60,"","���. ���-� �����(20c)=4 000 #"));

		GamePanel.shopmenu.add(new ShopMenu(100,330,620,60,"","������� 1 ���� = 7 000 #"));
		GamePanel.shopmenu.add(new ShopMenu(700,330,620,60,"","���������� 30�  = 6 000 #"));
		GamePanel.shopmenu.add(new ShopMenu(1300,330,620,60,"","��� ����� ���.(1�40�) = 8 000#"));

		GamePanel.shopmenu.add(new ShopMenu(100,430,620,60,"","������ 1 count = 6 000 #"));
		GamePanel.shopmenu.add(new ShopMenu(700,430,620,60,"","�������� ���� �� 15 = 6 000 #"));
		GamePanel.shopmenu.add(new ShopMenu(1300,430,620,60,"","Kill ���� ������ = 10 000 #"));


		GamePanel.shopmenu.add(new ShopMenu(100,530,620,60,"","������ 5 count = 25 000 #"));
		GamePanel.shopmenu.add(new ShopMenu(700,530,620,60,"","������� 5 ���� = 30 000 #"));
		GamePanel.shopmenu.add(new ShopMenu(1300,530,620,60,"","Ability �� lvl(max)(1�)=30 000 #"));

		GamePanel.shopmenu.add(new ShopMenu(400, 950, 620, 60,"", "������� count(1) = 5 950 #"));
		GamePanel.shopmenu.add(new ShopMenu(1000, 950, 620, 60,"", "������(50 ����) = 100 000 #"));

		GamePanel.shopmenu.add(new ShopMenu(1620,1000,620,60,"","�����"));




		long startTime;
		long URDTime;		
		long waitTime;
		long totalTime = 0;

		int FrameCount = 0;
		int maxFrameCount = 30;

		long targetTime = 1000 / FPS;
		while(running) {
			startTime = System.nanoTime();


			if(state.equals(STATES.MENUE)) {
				back.draw(g);		
				if(butmenu) {
					menue.draw(g);
					if(GamePanel.mouseX >  menue.getX() + 19 && GamePanel.mouseX < menue.getX() + menue.getW() + 419&&
							GamePanel.mouseY > (menue.getY() + 140)* 0 && GamePanel.mouseY < (menue.getY() + 140)* 0 + menue.getH()) {
						menue.list[0] = " Game Start";
						menue.user_0 = true;
						if(Menue.click) {
							state = STATES.PLAY;
							Menue.click = false;
						}
					}else {
						menue.list[0] = String.valueOf("   ������");
						menue.user_0 = false;
					}

					if(GamePanel.mouseX >  menue.getX() + 19 && GamePanel.mouseX < menue.getX() + menue.getW() + 419&&
							GamePanel.mouseY > (menue.getY() + 130)* 1 && GamePanel.mouseY < (menue.getY() + 130)* 1 + menue.getH()) {
						menue.list[1] = "  New user";
						menue.user_1 = true;
					}else {
						menue.list[1] = String.valueOf("����� �����");
						menue.user_1 = false;
					}


					if(GamePanel.mouseX >  menue.getX() + 19 && GamePanel.mouseX < menue.getX() + menue.getW() + 419&&
							GamePanel.mouseY > ((menue.getY() + 135)* 2)  && GamePanel.mouseY < (menue.getY() + 135)* 2 + menue.getH() ) {
						menue.list[2] = "   Setting";
						if(Menue.click) {
							GamePanel.setmenu = true;
							GamePanel.butmenu = false;
						}

					}else {
						menue.list[2] = String.valueOf(" ���������");

					}
					if(GamePanel.mouseX >  menue.getX() + 19 && GamePanel.mouseX < menue.getX() + menue.getW() + 419&&
							GamePanel.mouseY > (menue.getY() + 137)* 3 && GamePanel.mouseY < (menue.getY() + 136)* 3 + menue.getH()) {
						menue.list[3] = "Game Rules";
						if(Menue.click) {
							menue.user_2 = true;
						}
					}else {
						menue.list[3] = String.valueOf("  �������");

					}

					if(GamePanel.mouseX >  menue.getX() + 19 && GamePanel.mouseX < menue.getX() + menue.getW() + 419&&
							GamePanel.mouseY > (menue.getY() + 137)* 4 && GamePanel.mouseY < (menue.getY() + 137)* 4 + menue.getH()) {
						menue.list[4] = "     Exit";
						if(Menue.click) {
							System.exit(0);
						}
					}else {
						menue.list[4] = String.valueOf("   �����");

					}
				}
				if(setmenu) {
					moveSetBut();


				}
				if(controlmenu) {
					c_menu.draw(g);
					c_menu.moveControl(c_menu.butCon_up);
					c_menu.moveControl(c_menu.butCon_d);
					c_menu.moveControl(c_menu.butCon_l);
					c_menu.moveControl(c_menu.butCon_r);
					c_menu.moveControl(c_menu.butCon_es);
					c_menu.moveControl(c_menu.butCon_k);
				}


				GameDraw();
			}
			if(state.equals(STATES.PLAY)) {
				moveSetUpgrade();
				GameUpdate();
				GameRender();
				GameDraw();
			}

			if(state.equals(STATES.SHOP)) {
				back.draw(g);
				if(shopmenus) {
					for(int i = 0 ; i < shopmenu.size(); i++) {
						shopmenu.get(i).draw(g);
						if(GamePanel.mouseX >  shopmenu.get(i).getX()  && GamePanel.mouseX < shopmenu.get(i).getX() + shopmenu.get(i).getW() - 320&&
								GamePanel.mouseY > shopmenu.get(i).getY()  && GamePanel.mouseY < shopmenu.get(i).getY() + shopmenu.get(i).getH() ){	
							shopmenu.get(i).color1 = Color.red;

							if(i == 0) {//"������ ����� + 1 = 600 #"
								if(ShopMenu.click && Player.getScore() >= 600 ) {
									Player.score -= 600;
									Player.lives++;
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 1) {//���.�� �� 30 � = 1200 #
								if(ShopMenu.click && Player.getScore() >= 1200 ) {
									Player.score -= 1200;
									slowDownLength = 30000;
									slowDownTime = System.nanoTime();
									for (int j = 0; j < enemies.size(); j++){
										enemies.get(j).setSlow(true);


									}
									if (slowDownTime != 0 ){
										slowDownTimeDiff = (System.nanoTime() - slowDownTime)/1000000;
										if (slowDownTimeDiff > slowDownLength){
											slowDownTime = 0;
											for (int j = 0; j < enemies.size(); j++){
												enemies.get(j).setSlow(false);

											}
										}
									}
									if (slowDownTime != 0) {
										g.setColor(Color.WHITE);
										g.drawRect(20, 60, 100, 8);
										g.fillRect(20, 60, (int) (100 - 100.0 * slowDownTimeDiff / slowDownLength), 8);
									}

									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 2) {//Kill ���� � 1 HP = 50 #
								if(ShopMenu.click && Player.score >= 50) {
									Player.score -= 50;

									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 3) {//���������� 5 ������ = 2500 #
								if(ShopMenu.click && Player.score >= 2500) {
									Player.score -= 2500;
									Player.lives += 5;
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 4) {//�������� ���� �� 5 = 3000 #
								if(ShopMenu.click && Player.score >= 3000) {
									Player.score -= 3000;
									player.increase(5);
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 5) {//���. ���-� �����(20c) = 4000 #
								if(ShopMenu.click && Player.score >= 4000) {
									Player.score -= 4000;
									DamageDownTime = System.nanoTime();
									for (int j = 0; j < enemies.size(); j++){
										enemies.get(j).setSlow(true);
									}
									Enemy.damage += 2;
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 6) {//������� 1 ���� = 7000 #
								if(ShopMenu.click && Player.score >= 7000) {
									Player.score -= 7000;

									Wave.waveNumber += 1;
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 7) {//���������� 30�  = 6000 #
								if(ShopMenu.click && Player.score >= 6000) {
									Player.score -= 6000;
									Player.loseLive1();                   
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}

								}
							}
							if(i == 8) {//��� ����� ���. (1�40�) = 8000#
								if(ShopMenu.click && Player.score >= 8000) {
									Player.score -= 8000;
									slowDownLength = 100000;
									slowDownTime = System.nanoTime();
									for (int j = 0; j < enemies.size(); j++){
										enemies.get(j).setSlow(true);


									}
									if (slowDownTime != 0 ){
										slowDownTimeDiff = (System.nanoTime() - slowDownTime)/1000000;
										if (slowDownTimeDiff > slowDownLength){
											slowDownTime = 0;
											for (int j = 0; j < enemies.size(); j++){
												enemies.get(j).setSlow(false);

											}
										}
									}
									if (slowDownTime != 0) {
										g.setColor(Color.WHITE);
										g.drawRect(20, 60, 100, 8);
										g.fillRect(20, 60, (int) (100 - 100.0 * slowDownTimeDiff / slowDownLength), 8);
									}
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 9) {//������ 1 count = 6000 #
								if(ShopMenu.click&& Player.score >= 6000) {
									Player.score -= 6000;
									Upgrade.count += 1;
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 10) {//�������� ���� �� 15 = 6000 #
								if(ShopMenu.click && Player.score >= 6000) {
									Player.score -= 3000;
									player.increase(15);
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}

							}
							if(i == 11) {//Kill ���� ������ = 10000 #
								if(ShopMenu.click && Player.score >= 10000) {
									Player.score -= 10000;

									enemies.clear();

									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 12) {//������ 5 count = 25000 #
								if(ShopMenu.click&& Player.score >= 25000) {
									Player.score -= 25000;
									Upgrade.count += 5;
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 13) {//������� 5 ���� = 30000 #
								if(ShopMenu.click && Player.score >= 30000) {
									Player.score -= 30000;

									Wave.waveNumber += 5;
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 14) {//ability �� max lvl(30c) = 30000 #
								if(ShopMenu.click && Player.score >= 30000) {
									Player.score -= 30000;

									MaxLvlLength = 30000;
									MaxLvlTime = System.nanoTime();

									Player.PlayerUpSpeed += 30;
									Player.PlayerUpDamage += 30;
									Player.PlayerUpBullet += 30;

									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}

							if(i == 15) {//������� count(1) = 5 950 #
								if(ShopMenu.click && Upgrade.count >= 1) {
									Player.score += 5950;
									Upgrade.count -= 1;
									try {
										Thread.sleep(100);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
							if(i == 16) {//������(������� 50 ����) = 100 000 #
								if(ShopMenu.click && Player.score >= 100000) {
									Player.score -= 100000;

									Wave.waveNumber = 50;
									GamePanel.state = STATES.PLAY;
									try {
										Thread.sleep(100);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}

							if(i == 17) {
								if(ShopMenu.click) {
									state = STATES.PLAY;
									ShopMenu.click = false;
									try {
										Thread.sleep(50);
									}catch(Exception e) {
										e.printStackTrace();
									}
								}
							}
						}else {
							shopmenu.get(i).color1 = Color.WHITE;

						}
					}

					GameDraw();
				}
			}

			URDTime = (System.nanoTime() - startTime)/ 1000000;
			waitTime = targetTime - URDTime;
			try{
				Thread.sleep(waitTime);
			}catch(Exception e){

			}
			totalTime += System.nanoTime() - startTime;
			FrameCount++;
			if (FrameCount == maxFrameCount){
				averageFPS = 1000.0 / ((totalTime / FrameCount )/ 1000000);
				FrameCount = 0;
				totalTime = 0;
			}
		}
		if(!running && Wave.waveNumber >= 51) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			String s = "G A M E  O V E R";
			int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.drawString(s, (WIDTH - length) / 2, HEIGHT / 2);
			String as = "Y O U  W I N";
			length = (int) g.getFontMetrics().getStringBounds(as, g).getWidth();
			g.drawString(as, (WIDTH - length) / 2, HEIGHT / 2 + 30);
			String a = "Score: " + player.getScore();
			length = (int) g.getFontMetrics().getStringBounds(a, g).getWidth();
			g.drawString(a, (WIDTH - length) / 2, HEIGHT / 2 + 60);
			String b = "Wave: " + Wave.waveNumber;
			length = (int) g.getFontMetrics().getStringBounds(b, g).getWidth();
			g.drawString(b, (WIDTH - length) / 2, HEIGHT / 2 + 90);
			File r = new File("./RecordWin.txt");
			try {
				if(!r.exists()) r.createNewFile();
			}catch(Exception err1) {err1.printStackTrace();}

			int lastRecord1 = 1;

			try {
				FileInputStream in = new FileInputStream(r);
				String line = Files.readAllLines(Paths.get("./RecordWin.txt")).get(0);
				lastRecord1 = Integer.parseInt(line);
				in.close();
			}catch(Exception err) {err.printStackTrace();}

			if(player.score > lastRecord1) {
				try {
					lastRecord1 = player.score;
					Writer writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream("./RecordWin.txt"), "utf-8"));
					writer.write(String.valueOf(player.score));
					writer.close();
				}catch(Exception e223) {e223.printStackTrace();}
			}

			String q = "Rec: " + lastRecord1;
			length = (int) g.getFontMetrics().getStringBounds(q, g).getWidth();
			g.drawString(q, (WIDTH - length) / 2, HEIGHT / 2 + 120);

			GameDraw();
		}
		if(!running && Wave.waveNumber < 51) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			String s = "Y O U  L O S E";
			int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.drawString(s, (WIDTH - length) / 2, HEIGHT / 2);
			g.setColor(Color.WHITE);
			String a = "Score: " + player.getScore();
			length = (int) g.getFontMetrics().getStringBounds(a, g).getWidth();
			g.drawString(a, (WIDTH - length) / 2, HEIGHT / 2 + 30);
			String b = "Wave: " + Wave.waveNumber;
			length = (int) g.getFontMetrics().getStringBounds(b, g).getWidth();
			g.drawString(b, (WIDTH - length) / 2, HEIGHT / 2 + 60);

			File r = new File("./RecordLose.txt");
			try {
				if(!r.exists()) r.createNewFile();
			}catch(Exception err1) {err1.printStackTrace();}

			int lastRecord = 1;

			try {
				FileInputStream in = new FileInputStream(r);
				String line = Files.readAllLines(Paths.get("./RecordLose.txt")).get(0);
				lastRecord = Integer.parseInt(line);
				in.close();
			}catch(Exception err) {err.printStackTrace();}

			if(player.score > lastRecord) {
				try {
					lastRecord = player.score;
					Writer writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream("./RecordLose.txt"), "utf-8"));
					writer.write(String.valueOf(player.score));
					writer.close();
				}catch(Exception e223) {e223.printStackTrace();}
			}

			String q1 = "Rec: " + lastRecord;
			length = (int) g.getFontMetrics().getStringBounds(q1, g).getWidth();
			g.drawString(q1, (WIDTH - length) / 2, HEIGHT / 2 + 90);

			GameDraw();
		}
	}
	public void moveSetBut() {
		for(int i = 0; i < setMenue.size(); i++) {
			setMenue.get(i).draw(g);
			if(GamePanel.mouseX >  setMenue.get(i).getX()  && GamePanel.mouseX < setMenue.get(i).getX() + setMenue.get(i).getW() - 320&&
					GamePanel.mouseY > setMenue.get(i).getY() && GamePanel.mouseY < setMenue.get(i).getY() + setMenue.get(i).getH()){	
				setMenue.get(i).color1 = Color.red;
				if(i == 0) {
					if(Menue.click) {
						easy = true;
						norm = false;
						hard = false;
					}
				}
				if(i == 1) {
					if(Menue.click) {
						easy = false;
						norm = true;
						hard = false;
					}
				}
				if(i == 2) {
					if(Menue.click) {
						easy = false;
						norm = false;
						hard = true;
					}
				}
				if(i == 3) {
					if(Menue.click) {
						aud = true;
					}
				}
				if(i == 4) {
					if(Menue.click) {
						aud = false;
					}
				}
				if(i == 5) {
					if(Menue.click) {
						control = true;
						c_menu.butCon_up.f = "���� �����";
						c_menu.butCon_d.f = "���� ����";
						c_menu.butCon_l.f = "���� �����";
						c_menu.butCon_r.f = "���� ������";
						c_menu.butCon_es.f = "Space";

						c_menu.butCon_up.ch_code = 38;
						c_menu.butCon_d.ch_code = 40;
						c_menu.butCon_l.ch_code = 37;
						c_menu.butCon_r.ch_code = 39;
						c_menu.butCon_es.ch_code = 32;


					}
				}
				if(i == 6) {
					if(Menue.click) {
						control = false;
						setmenu = false;
						controlmenu = true;
					}
				}
				if(i == 7) {
					if(Menue.click) {
						setmenu = false;
						butmenu = true;
					}
				}
			}else {
				setMenue.get(i).color1 = Color.WHITE;
			}
		}
	}
	public void moveSetUpgrade() {
		for(int i = 0; i < upgrade.size(); i++) {
			upgrade.get(i).draw(g);
			if(GamePanel.mouseX >  upgrade.get(i).getX()  && GamePanel.mouseX < upgrade.get(i).getX() + upgrade.get(i).getW() - 320&&
					GamePanel.mouseY > upgrade.get(i).getY() && GamePanel.mouseY < upgrade.get(i).getY() + upgrade.get(i).getH()){
				upgrade.get(i).color1 = Color.red;
				if(i == 0) {
					if((Upgrade.click && Upgrade.count != 0) ||  (Upgrade.count != 0 && N1)) {
						Player.PlayerUpSpeed++;
						Upgrade.count--;
						try {
							Thread.sleep(100);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
				if(i == 1) {
					if((Upgrade.click && Upgrade.count != 0) ||  (Upgrade.count != 0 && N2)) {
						Player.PlayerUpDamage++;
						Upgrade.count--;	
						try {
							Thread.sleep(100);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
				if(i == 2) {
					if((Upgrade.click && Upgrade.count != 0)||(Upgrade.count != 0 && N3)) {
						Player.PlayerUpBullet++;
						Upgrade.count--;	
						try {
							Thread.sleep(100);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
				if(i == 3) {
					if(Upgrade.click || N4) {
						state = STATES.SHOP;
						shopmenus = true;
						Upgrade.click = false;
						try {
							Thread.sleep(100);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}else {
				upgrade.get(i).color1 = Color.WHITE;
			}
		}
	}

	private void GameUpdate() {
		player.update();

		for(int i = 0; i < bullets.size(); i++) {
			boolean remove = bullets.get(i).update();
			if (remove){
				bullets.remove(i);
				i--;
			}
		}
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();	
		}

		wave.update();
		for (int i =0; i < explosions.size(); i++){
			boolean remove =  explosions.get(i).update();
			if (remove){
				explosions.remove(i);
				i--;
			}
		}
		for (int i = 0; i < powerUps.size(); i++) {
			powerUps.get(i).update();
		}
		for (int i = 0; i < texts.size(); i++){
			boolean remove = texts.get(i).update();
			if (remove){
				texts.remove(i);
				i--;
			}
		}

		magazine.update();

		for(int i = 0; i < bullets.size(); i++){
			Bullet b = bullets.get(i);
			double bx = b.setX();
			double by = b.setY();
			double br = b.setR();
			for (int j = 0; j < enemies.size(); j++){
				Enemy e = enemies.get(j);
				double ex = e.setX();
				double ey = e.setY();
				double er = e.setR();

				double dx = bx - ex;
				double dy = by - ey;
				double dist = Math.sqrt(dx * dx + dy * dy);
				if (dist < br + er){
					if(Wave.waveNumber == 10 || Wave.waveNumber == 20 || Wave.waveNumber == 30 || Wave.waveNumber == 50 ) {
						startBoss = (e.health -= e.damage);
						if(e.health <= 0) {
							e.dead = true;
						}
					}else{
						e.hit();
					}
					bullets.remove(i);
					i--;
					break;
				}
			}
		}


		for (int i = 0; i < enemies.size(); i++){
			if (enemies.get(i).isDead()){
				Enemy e = enemies.get(i);
				double rang = Math.random();
				if (rang < 0.002){
					powerUps.add(new PowerUp(5,e.getX(), e.getY()));
				}else if(rang < 0.010) {
					powerUps.add(new PowerUp(1, e.getX(), e.getY()));
				}else  if (rang < 0.020){
					powerUps.add(new PowerUp(4, e.getX(), e.getY()));
				}else if (rang < 0.045) {
					powerUps.add(new PowerUp(3, e.getX(), e.getY()));
				} else if (rang < 0.090){
					powerUps.add(new PowerUp(2, e.getX(), e.getY()));
				}else {}

				player.addScore(e.getType() + e.getRang());
				enemies.remove(i);
				i--;
				e.explode();
				explosions.add(new Explosion(e.getX(), e.getY(), e.getR(), e.getR() + 20));

			}
		}			    	





		if (!player.isRecovering()){
			int px = player.getX();
			int py = player.getY();
			int pr = player.getR();
			for (int i = 0; i < enemies.size(); i++){
				Enemy e = enemies.get(i);
				double ex = e.setX();
				double ey = e.setY();
				int er = e.setR();

				double dx = px - ex;
				double dy = py - ey;
				double dist = Math.sqrt(dx * dx + dy * dy);
				if (dist < pr + er){
					Player.loseLive();
				}

			}
		}

		int px = player.getX();
		int py = player.getY();
		int pr = player.getR();
		for (int i = 0 ; i < powerUps.size(); i++){
			PowerUp p = powerUps.get(i);
			double x = p.getX();
			double y = p.getY();
			int r = p.getR();

			double dx = px - x;
			double dy = py - y;
			double dust = Math.sqrt(dx * dx + dy * dy);
			if (dust < pr + r){
				int type = p.getType();
				if (type == 1){
					player.gainLive();
					texts.add(new Text(player.getX(), player.getY(), 1000, "Love + 1"));
				}
				if (type == 2){
					player.increase(1);
					texts.add(new Text(player.getX(), player.getY(), 1000, "Power + 1"));
				}
				if (type == 3){
					player.increase(2);
					texts.add(new Text(player.getX(), player.getY(), 1000, "Power + 2"));
				}

				if(type == 4){
					slowDownLength = 6000;
					slowDownTime = System.nanoTime();
					for (int j = 0; j < enemies.size(); j++){
						enemies.get(j).setSlow(true);
					}
					texts.add(new Text(player.getX(), player.getY(), 1000, "Slow Down +6 c"));
				}
				if (type == 5){
					player.DEAD();
					texts.add(new Text(player.getX(), player.getY(), 2000, "DEAD Monster"));

				}

				powerUps.remove(i);
				i--;
			}
		}

		if (slowDownTime != 0 ){
			slowDownTimeDiff = (System.nanoTime() - slowDownTime)/1000000;
			if (slowDownTimeDiff > slowDownLength){
				slowDownTime = 0;
				for (int j = 0; j < enemies.size(); j++){
					enemies.get(j).setSlow(false);
				}
			}
		}
		if (player.isDead()){
			running = false;

		}

		if (DamageDownTime != 0 ){
			DamageDownTimeDiff = (System.nanoTime() - DamageDownTime)/1000000;
			if (DamageDownTimeDiff > lengthDamage){
				DamageDownTime = 0;
				for (int j = 0; j < enemies.size(); j++){
					enemies.get(j).setSlow(false);

				}
			}
		}
		if (MaxLvlTime != 0 ){
			MaxLvlTimeDiff = (System.nanoTime() - MaxLvlTime)/1000000;
			if (MaxLvlTimeDiff > MaxLvlLength){
				MaxLvlTime = 0;
				Player.PlayerUpSpeed -= 30;
				Player.PlayerUpDamage -= 30;
				Player.PlayerUpBullet -= 30;

				Bullet.speed = 10;
			}
		}

	}

	private void GameRender() {

		back.draw(g);

		for(int i = 0; i < upgrade.size(); i++) {
			upgrade.get(i).draw(g);
		}

		player.draw(g);

		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(g);
		}
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);	
		}
		wave.draw(g);

		for(int i = 0; i < explosions.size(); i++) {
			explosions.get(i).draw(g);
		}

		for(int i = 0; i < powerUps.size(); i++) {
			powerUps.get(i).draw(g);
		}

		for(int i = 0; i < texts.size(); i++) {
			texts.get(i).draw(g);
		}

		magazine.draw(g);

		if (slowDownTime != 0) {
			g.setColor(new Color(255, 255, 255, 64));
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}

		if (slowDownTime != 0) {
			g.setColor(Color.WHITE);
			g.drawRect(20, 60, 100, 8);
			g.fillRect(20, 60, (int) (100 - 100.0 * slowDownTimeDiff / slowDownLength), 8);

		}
		if (MaxLvlTime != 0) {
			g.setColor(Color.yellow);
			g.drawRect(20, 60, 100, 8);
			g.fillRect(20, 60, (int) (100 - 100.0 * MaxLvlTimeDiff / MaxLvlLength), 8);

		}

		g.setColor(Color.YELLOW);
		g.fillRect(20, 40, player.getPower() * 8, 8);
		g.setColor(Color.YELLOW.darker());
		g.setStroke(new BasicStroke(2));
		for (int i = 0; i < player.getRequestPower(); i++) {
			g.drawRect(20 + 8 * i, 40, 8, 8);
		}
		g.setStroke(new BasicStroke(1));

		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		g.drawString("Score " + Player.getScore()+" #", WIDTH - 140, 30);


		for (int i = 0; i < player.getLives(); i++){
			g.setColor(Color.RED);
			g.fillOval(20+(20 * i), 20, player.getR() * 2, player.getR() * 2);
			g.setStroke(new BasicStroke(3));
			g.setColor(Color.RED.darker());
			g.drawOval(20+(20 * i), 20, player.getR() * 2, player.getR() * 2);
			g.setStroke(new BasicStroke(1));


		}

		if (DamageDownTime != 0) {
			g.setColor(Color.RED);
			g.drawRect(20, 60, 100, 8);
			g.fillRect(20, 60, (int) (100 - 100.0 * DamageDownTimeDiff / lengthDamage), 8);
		}


		if (Wave.waveNumber == 10) {
			g.setColor(Color.RED);
			g.fillRect(20, 60, (int) (startBoss/9), 15);

		}

		if (Wave.waveNumber == 20) {		
			g.setColor(Color.RED);
			g.fillRect(20, 70, (int) (startBoss/27), 19);

		}
		if (Wave.waveNumber == 30) {		
			g.setColor(Color.RED);
			g.fillRect(20, 80, (int) (startBoss/39), 23);
		}
		if (Wave.waveNumber == 50) {
			g.setColor(Color.RED);
			g.fillRect(20, 90, (int) (startBoss/90), 27);
		}


	}

	private void GameDraw() {
		Graphics g2 = this.getGraphics() ;
		g2.drawImage(image, 0,0,null);
		g2.dispose();

	}




}

