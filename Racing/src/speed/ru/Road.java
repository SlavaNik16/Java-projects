package speed.ru;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener, Runnable{

	Timer GameTimer = new Timer(20,this);

	Image img = new ImageIcon("Res/Doroga.jpg").getImage();//Загружает фото дороги

	Player p = new Player();

	Thread enemyFactory = new Thread(this);

	List<Enemy> enemies = new ArrayList<Enemy>();

	public Road() {
		GameTimer.start();
		enemyFactory.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);
	}

	private class MyKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			p.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			p.keyReleased(e);
		}

	}

	//Перерисовывает рисунок
	public void paint(Graphics g) {
		g = (Graphics2D) g;
		g.drawImage(img,p.layer1,0,null);
		g.drawImage(img,p.layer2,0,null);
		g.drawImage(p.img,p.x,p.y,null);

		double v = (200/Player.MAX_V) * p.v;
		g.setColor(Color.RED);
		g.setFont(new Font("Century Gothic", Font.ITALIC,20));
		g.drawString("Скорость: "+ v + " км/ч", 100, 30);

		Iterator<Enemy> i = enemies.iterator();
		while(i.hasNext()) {
			Enemy e = i.next();
			if(e.x >= 2400 || e.x <= - 240) {
				i.remove();
			}else {
				e.move();
				g.drawImage(e.img, e.x,e.y,null);

			}
		}
	}

	public void actionPerformed(ActionEvent e ) {
		p.move();
		repaint();
		testCollisionWithEnemies();
		testWin();
	}

	private void testCollisionWithEnemies() {

		Iterator<Enemy> i = enemies.iterator();
		while(i.hasNext()) {
			Enemy e = i.next();
			if(p.getRect().intersects(e.getRect())) {//Если прямоугольники пересекаються
				File r = new File("./Record.txt");
				
				try {
					if(!r.exists()) r.createNewFile();
				}catch(Exception err1) {err1.printStackTrace();}
				
				int lastRecord = 1;
				
				try {
					FileInputStream in = new FileInputStream(r);
					String line = Files.readAllLines(Paths.get("./Record.txt")).get(0);
					lastRecord = Integer.parseInt(line);
					in.close();
				}catch(Exception err) {err.printStackTrace();}

				if(p.s > lastRecord) {
					try {
						lastRecord = p.s;
						Writer writer = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream("./Record.txt"), "utf-8"));
						writer.write(String.valueOf(p.s));
						writer.close();
					}catch(Exception e223) {e223.printStackTrace();}
				}
				JOptionPane.showMessageDialog(null,"Вы проиграли!!! Вы проехали: "+ p.s + " м из 200000 м. Рекорд: " + lastRecord + " м");
				System.exit(0);
			}
		}

	}

	private void testWin() {
		if(p.s >= 200000) {
			JOptionPane.showMessageDialog(null, "Вы выиграли. У вас s = "+ p.s);
		}
	}

	@Override
	public void run() {
		while(true) {
			Random random = new Random();
			try {
				Thread.sleep(random.nextInt(2000));//Делаем врагов случайно от 0 до 2000 млс
				enemies.add(new Enemy(852,
						350,
						random.nextInt(50),
						this));
				Thread.sleep(random.nextInt(2000));
				enemies.add(new Enemy(852,
						250,
						random.nextInt(50),
						this));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
