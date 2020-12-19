package sd;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame {

private int width = 300;
private int height = 300;

private Image img;

public Main() {
    setSize(width, height);
    setTitle("File Monitor:D");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);

}

public void loadImage(String src) {
    img = new ImageIcon(src).getImage();
}

public void drawIcon() {
    Graphics g = getGraphics();
    g.drawImage(img, 0, 0, width, height, null);
}
public static void main(String [] args) {
	Main mn = new Main();
}
}