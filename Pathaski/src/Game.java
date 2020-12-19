/*
 * ѕривет от ƒани
 * Ќаписал систему времени €
 * =D
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Game extends JPanel {
	private static final long serialVersionUID = 1L;
	
	static final int countTiles = 16 ;
	private int size;//размер игрового пол€;

	private int nbTiles;
	
	private static final Color FOREGROUND_COLOR = new Color(239, 83, 80);

	private static final Random RANDOM = new Random();

	private int[] tiles;//п€тнашка, котора€ представл€ет собой одномерный массив целых чисел.
	// ажда€ из п€тнашек получит уникальное значение в диапазоне [0, nbTiles]. 

	private int tileSize;

	private int blankPos;//позици€ пустого квадрата.

	private int margin;//высота

	private int gridSize;
	private boolean gameOver;

	public long begin;
	public String lastBegn;

	public Game(int size, int dim, int mar) {
		this.size = size;
		margin = mar;


		nbTiles = size * size - 1;//перемещение
		tiles = new int[size * size];// количество п€тнашек в поле.

		gridSize = (dim - 2 * mar);//отступление от пол€
		tileSize = gridSize / size;//–азмер

		begin = System.currentTimeMillis();
		lastBegn = "0 секунд";

		setPreferredSize(new Dimension(dim, dim + mar));
		setBackground(Color.WHITE);
		setForeground(FOREGROUND_COLOR);
		setFont(new Font("Century Gothic", Font.BOLD, Math.round(60f * (4f / size))));

		gameOver = true;

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (gameOver) {
					newGame();
				} else {
					int ex = e.getX() - margin;//перемещение кнопок по x
					int ey = e.getY() - margin;//перемещение кнопок по y


					if (ex < 0 || ex > gridSize  || ey < 0  || ey > gridSize)
						return;


					int c1 = ex / tileSize;
					int r1 = ey / tileSize;


					int c2 = blankPos % size;
					int r2 = blankPos / size;


					int clickPos = r1 * size + c1;

					int dir = 0;


					if (c1 == c2  &&  Math.abs(r1 - r2) > 0)
						dir = (r1 - r2) > 0 ? size : -size;
						else if (r1 == r2 && Math.abs(c1 - c2) > 0)
							dir = (c1 - c2) > 0 ? 1 : -1;

							if (dir != 0) {

								do {
									int newBlankPos = blankPos + dir;
									tiles[blankPos] = tiles[newBlankPos];
									blankPos = newBlankPos;
								} while(blankPos != clickPos);

								tiles[blankPos] = 0;
							}


							gameOver = isSolved();
				}


				repaint();
			}
		});

		newGame();
	}

	private void newGame() {
		do {
			reset();
			shuffle();
		} while(!isSolvable());

		begin = System.currentTimeMillis();
		gameOver = false;
	}

	private void reset() {//цифры
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = (i + 1) % tiles.length;
		}


		blankPos = tiles.length - 1;//—колько всего можно двигать
	}

	private void shuffle() {//ѕеремешиваем

		int n = nbTiles;

		while (n > 1) {
			int r = RANDOM.nextInt(n--);
			int tmp = tiles[r];
			tiles[r] = tiles[n];
			tiles[n] = tmp;
		}
	}


	private boolean isSolvable() {
		int countInversions = 0;

		for (int i = 0; i < nbTiles; i++) {
			for (int j = 0; j < i; j++) {
				if (tiles[j] > tiles[i])
					countInversions++;
			}
		}

		return countInversions % 2 == 0;
	}

	private boolean isSolved() {
		if (tiles[tiles.length - 1] != 0)
			return false;

		for (int i = nbTiles - 1; i >= 0; i--) {
			if (tiles[i] != i + 1)
				return false;
		}

		return true;
	}

	private void drawGrid(Graphics2D g) {
		for (int i = 0; i < tiles.length; i++) {

			int r = i / size;//высота
			int c = i % size;//ширина между кнопками

			int x = margin + c * tileSize;//–асположение кнопок по кардинате х
			int y = margin + r * tileSize;//–асположение кнопок по кардинате у


			if(tiles[i] == 0) {
				if (gameOver) {
					g.setColor(FOREGROUND_COLOR);
					drawCenteredString(g, "\u2713", x, y);
				}

				continue;
			}


			g.setColor(getForeground());
			g.fillRoundRect(x, y, tileSize, tileSize, 25, 25);
			g.setColor(Color.BLACK);
			g.drawRoundRect(x, y, tileSize, tileSize, 25, 25);
			g.setColor(Color.WHITE);

			drawCenteredString(g, String.valueOf(tiles[i]), x , y);
		}
	}

	String GetTime(long t) {
		String cc = "";
		double ost = t;
		if (ost >= 3600)
		{
			cc += (int) Math.floor(ost / 3600f) + " часов ";
			ost -= Math.floor(ost / 3600f) * 3600f;
		}
		if (ost >= 60)
		{
			cc += (int) Math.floor(ost / 60f) + " минут ";
			ost -= Math.floor(ost / 60f) * 60f;
		}
		cc += String.valueOf((int)ost % 60) + " секунд";
		return cc;
	}

	public void DrawTime(Graphics g2) {
		if(!gameOver) {
			Graphics2D g = (Graphics2D) g2;
			String s = GetTime((System.currentTimeMillis() - begin) / 1000);
			g.setFont(getFont().deriveFont(Font.BOLD, 18));

			g.setColor(Color.white);
			g.drawString(lastBegn, ((getWidth() - g.getFontMetrics().stringWidth(lastBegn)) / 2) - 100,
					getHeight() - margin );

			g.setColor(Color.red);
			g.drawString(s, ((getWidth() - g.getFontMetrics().stringWidth(s)) / 2) - 100,
					getHeight() - margin );

			lastBegn = s;
		}
	}



	private void drawStartMessage(Graphics2D g) {
		if (gameOver) {
			g.setFont(getFont().deriveFont(Font.BOLD, 18));
			g.setColor(Color.red);
			g.drawString(lastBegn, ((getWidth() - g.getFontMetrics().stringWidth(lastBegn)) / 2) - 100,
					getHeight() - margin );
			g.setColor(FOREGROUND_COLOR);
			String s = "Ќачать заново";
			g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) / 2 + 140,
					getHeight() - margin);
		}
	}

	private void drawCenteredString(Graphics2D g, String s, int x, int y) {
		FontMetrics fm = g.getFontMetrics();
		int asc = fm.getAscent();
		int desc = fm.getDescent();
		g.drawString(s,  x + (tileSize - fm.stringWidth(s)) / 2,
				y + (asc + (tileSize - (asc + desc)) / 2));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawGrid(g2D);
		drawStartMessage(g2D);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Game");
			frame.setResizable(false);
			Game g2 = new Game(Game.countTiles, 900, 25);
			frame.add(g2, BorderLayout.CENTER);
			frame.pack();
			// center on the screen
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

			new Updater(g2).start();
		});
	}
}

class Updater extends Thread {
	Game g3;

	public Updater(Game game) {
		g3 = game;
	}

	public void run() {
		while(true) {
			g3.DrawTime(g3.getGraphics());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}