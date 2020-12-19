package Snake1;

import javax.swing.*;

public class Game extends JFrame {


	public Game(){
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(320, 345);
        setLocation(400, 400);
        add(new GameStart());
        setVisible(true);
    }

    public static void main(String[] args){
        Game gm = new Game();
    }
}
