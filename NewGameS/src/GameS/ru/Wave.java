package GameS.ru;


import java.awt.Color; 
import java.awt.Font;
import java.awt.Graphics2D;





public class Wave {

	public long waveStartTime;
	public long waveStartTimeDiff;
	public static int waveNumber;
	public boolean waveStart;
	public static int waveDelay = 2000;

	public Wave() {
		waveStartTime = 0;
		waveStartTimeDiff = 0;
		waveNumber = 0;
		waveStart = true;

	}

	public void createNewEnemies() {
		GamePanel.enemies.clear();
		if (waveNumber == 1) {
			for (int i = 0 ; i < 4 ; i++){
				GamePanel.enemies.add(new Enemy(1, 1));
			}
		}
		if(waveNumber == 2){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(1, 2));
			}
		}
		if (waveNumber == 3) {
			for (int i = 0 ; i < 4 ; i++){
				GamePanel.enemies.add(new Enemy(1, 3));

			}
		}
		if(waveNumber == 4){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(1, 4));

			}
		}
		if(waveNumber == 5) {
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(1, 5));
			}
		}
		if(waveNumber == 6) {
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(1, 6));
			}
		}
		if(waveNumber == 7) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 7));
			}
		}
		if(waveNumber == 8) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 8));
			}
		}
		if(waveNumber == 9) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 9));
			}
		}
		if(waveNumber == 10) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(1, 10));
			}
		}


		if (waveNumber == 11){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(2, 1));
			}
		}
		if(waveNumber == 12){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(2, 2));
			}
		}
		if (waveNumber == 13) {
			for (int i = 0 ; i < 4 ; i++){
				GamePanel.enemies.add(new Enemy(2, 3));

			}
		}
		if(waveNumber == 14){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(2, 4));

			}
		}
		if(waveNumber == 15) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 5));
			}
		}
		if(waveNumber == 16) {
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(2, 6));
			}
		}
		if(waveNumber == 17) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(2, 7));
			}
		}
		if(waveNumber == 18) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(2, 8));
			}
		}
		if(waveNumber == 19) {
			for (int i = 0; i < 15; i++) {
				GamePanel.enemies.add(new Enemy(2, 9));
			}
		}
		if(waveNumber == 20) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(2, 10));
			}
		}
		if(waveNumber == 21) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 1));
			}
		}
		if (waveNumber == 22){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 2));
			}
		}
		if(waveNumber == 23){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 3));
			}
		}
		if (waveNumber == 24) {
			for (int i = 0 ; i < 2 ; i++){
				GamePanel.enemies.add(new Enemy(3, 4));

			}
		}
		if(waveNumber == 25){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 5));

			}
		}
		if(waveNumber == 26) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 6));
			}
		}
		if(waveNumber == 27) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 7));
			}
		}
		if(waveNumber == 28) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 8));
			}
		}
		if(waveNumber == 29) {
			for (int i = 0; i < 15; i++) {
				GamePanel.enemies.add(new Enemy(3, 9));
			}
		}
		if(waveNumber == 30) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(3, 10));
			}
		}
		if(waveNumber == 31) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 6));
				GamePanel.enemies.add(new Enemy(2, 3));
				GamePanel.enemies.add(new Enemy(3, 1));
			}
		}
		if(waveNumber == 32) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 7));
				GamePanel.enemies.add(new Enemy(2, 4));
				GamePanel.enemies.add(new Enemy(3, 2));
			}
		}
		if (waveNumber == 33){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 8));
				GamePanel.enemies.add(new Enemy(2, 4));
				GamePanel.enemies.add(new Enemy(3, 3));
			}
		}
		if(waveNumber == 34){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 1));
				GamePanel.enemies.add(new Enemy(2, 5));
				GamePanel.enemies.add(new Enemy(3, 4));
			}
		}
		if (waveNumber == 35) {
			for (int i = 0 ; i < 2 ; i++){
				GamePanel.enemies.add(new Enemy(2, 2));
				GamePanel.enemies.add(new Enemy(2, 6));
				GamePanel.enemies.add(new Enemy(3, 5));

			}
		}
		if(waveNumber == 36){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 3));
				GamePanel.enemies.add(new Enemy(2, 7));
				GamePanel.enemies.add(new Enemy(3, 6));

			}
		}
		if(waveNumber == 37) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 8));
				GamePanel.enemies.add(new Enemy(3, 7));
			}
		}
		if(waveNumber == 38) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 9));
				GamePanel.enemies.add(new Enemy(3, 8));
			}
		}
		if(waveNumber == 39) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 1));
				GamePanel.enemies.add(new Enemy(3, 8));
			}
		}
		if(waveNumber == 40) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 10));
				GamePanel.enemies.add(new Enemy(2, 10));
				GamePanel.enemies.add(new Enemy(3, 9));

			}
		}
		if(waveNumber == 41) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 1));

			}
		}
		if(waveNumber == 42){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 2));

			}
		}
		if(waveNumber == 43) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 3));
			}
		}
		if(waveNumber == 44) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 4));
			}
		}
		if(waveNumber == 45) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 5));
			}
		}
		if(waveNumber == 46) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 6));

			}
		}
		if(waveNumber == 47){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 7));

			}
		}
		if(waveNumber == 48) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 8));
			}
		}
		if(waveNumber == 49) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 9));
			}
		}
		if(waveNumber == 50) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(4, 10));
			}
		}
		if (waveNumber == 51){
			GamePanel.running = false;
		}
	}
	public void update() {
		if(waveStartTime == 0 && GamePanel.enemies.size() == 0 ){
			waveNumber++;
			waveStart = false;
			waveStartTime = System.nanoTime();
		}else{
			waveStartTimeDiff = (System.nanoTime() - waveStartTime)/1000000;
			if (waveStartTimeDiff > waveDelay){
				waveStart = true;
				waveStartTime = 0;
				waveStartTimeDiff = 0;

			}
		}
		if (waveStart && GamePanel.enemies.size() == 0){
			createNewEnemies();
		}
	}
	public void draw(Graphics2D g){
		if (waveStartTime != 0) {
			g.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			String s = "- Â Î Ë Í À " + waveNumber + " - ";
			int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			int alpha = (int) (255 * Math.sin(3.14 * waveStartTimeDiff / waveDelay));
			if (alpha > 255) alpha = 255;
			g.setColor(new Color(255, 255, 255, alpha));
			g.drawString(s, GamePanel.WIDTH / 2 - length + 60, GamePanel.HEIGHT / 2);
		}

	}

}
