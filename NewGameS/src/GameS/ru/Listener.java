package GameS.ru;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;






public class Listener implements KeyListener, MouseMotionListener, MouseListener {

	public void keyTyped(KeyEvent e) {
		char sin = e.getKeyChar();

		if(GamePanel.c_menu.butCon_up.zamen) {
			GamePanel.c_menu.butCon_up.f = String.valueOf(sin);
			GamePanel.c_menu.butCon_up.zamen = false;
		}
		if(GamePanel.c_menu.butCon_d.zamen) {
			GamePanel.c_menu.butCon_d.f = String.valueOf(sin);
			GamePanel.c_menu.butCon_d.zamen = false;
		}
		if(GamePanel.c_menu.butCon_l.zamen) {
			GamePanel.c_menu.butCon_l.f = String.valueOf(sin);
			GamePanel.c_menu.butCon_l.zamen = false;
		}
		if(GamePanel.c_menu.butCon_r.zamen) {
			GamePanel.c_menu.butCon_r.f = String.valueOf(sin);
			GamePanel.c_menu.butCon_r.zamen = false;
		}
		if(GamePanel.c_menu.butCon_es.zamen) {
			GamePanel.c_menu.butCon_es.f = String.valueOf(sin);
			GamePanel.c_menu.butCon_es.zamen = false;
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == GamePanel.c_menu.butCon_up.ch_code) {
			Player.setUp(true);
		}
		if (key == GamePanel.c_menu.butCon_d.ch_code) {
			Player.setDown(true);
		}
		if (key == GamePanel.c_menu.butCon_l.ch_code) {
			Player.setLeft(true);
		}
		if (key == GamePanel.c_menu.butCon_r.ch_code) {
			Player.setRight(true);
		}
		if (key == GamePanel.c_menu.butCon_es.ch_code) {
			Player.setFiring(true);
		}
		if (key == KeyEvent.VK_ESCAPE) {
			if(GamePanel.state == GamePanel.STATES.PLAY) {
				GamePanel.state = GamePanel.STATES.MENUE;
			}
		}
		if(GamePanel.c_menu.butCon_up.zamen) {
			GamePanel.c_menu.butCon_up.ch_code = e.getKeyCode();
		}
		if(GamePanel.c_menu.butCon_d.zamen) {
			GamePanel.c_menu.butCon_d.ch_code = e.getKeyCode();
		}
		if(GamePanel.c_menu.butCon_l.zamen) {
			GamePanel.c_menu.butCon_l.ch_code = e.getKeyCode();
		}
		if(GamePanel.c_menu.butCon_r.zamen) {
			GamePanel.c_menu.butCon_r.ch_code = e.getKeyCode();
		}
		if(GamePanel.c_menu.butCon_es.zamen) {
			GamePanel.c_menu.butCon_es.ch_code = e.getKeyCode();
		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == GamePanel.c_menu.butCon_up.ch_code) {
			Player.setUp(false);
		}
		if (key == GamePanel.c_menu.butCon_d.ch_code) {
			Player.setDown(false);
		}
		if (key == GamePanel.c_menu.butCon_l.ch_code) {
			Player.setLeft(false);
		}
		if (key == GamePanel.c_menu.butCon_r.ch_code) {
			Player.setRight(false);
		}
		if (key == GamePanel.c_menu.butCon_es.ch_code) {
			Player.setFiring(false);
		}
	}
	public void mouseClicked(MouseEvent e) {

	}



	public void mousePressed(MouseEvent e) {

		if(e.getButton() == MouseEvent.BUTTON1) {
			if(GamePanel.state == GamePanel.STATES.MENUE) {
				Menue.click = true;
			}
		}
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(GamePanel.state == GamePanel.STATES.PLAY) {
				Upgrade.click = true;
			}
		}
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(GamePanel.state == GamePanel.STATES.SHOP) {
				ShopMenu.click = true;
			}
		}


		/*if (e.getButton() == MouseEvent.BUTTON1){
				GamePanel.leftmouse = true;
			}
			if (e.getButton() == MouseEvent.BUTTON2){
				GamePanel.rightmouse = true;
				}
		 */

	}



	public void mouseReleased(MouseEvent e) {

		if(e.getButton() == MouseEvent.BUTTON1) {
			if(GamePanel.state == GamePanel.STATES.MENUE) {
				Menue.click = false;
			}
		}
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(GamePanel.state == GamePanel.STATES.PLAY) {
				Upgrade.click = false;
			}
		}
		if(e.getButton() == MouseEvent.BUTTON1) {
			if(GamePanel.state == GamePanel.STATES.SHOP) {
				ShopMenu.click = false;
			}
		}
		/*
			if (e.getButton() == MouseEvent.BUTTON1){
				GamePanel.leftmouse = false;
			}
			if (e.getButton() == MouseEvent.BUTTON2){
				GamePanel.rightmouse = false;
			}
		 */
	}


	public void mouseEntered(MouseEvent e) {

	}


	public void mouseExited(MouseEvent e) {

	}


	public void mouseDragged(MouseEvent e) {
		//GamePanel.mouseX = e.getX();
		//GamePanel.mouseY = e.getY();


	}


	public void mouseMoved(MouseEvent e) {
		GamePanel.mouseX = e.getX();
		GamePanel.mouseY = e.getY();
	}


}
