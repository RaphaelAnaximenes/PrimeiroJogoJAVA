package mygame.model;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
	private int x, y;
	private int dx, dy;
	private Image image;
	private int height, width;
	private List <Gunshot> shots;
	
	
	public Player() {
		this.x = 100;
		this.y = 100;
		
		shots = new ArrayList<Gunshot>();
		}
	
	public void load() {
		ImageIcon ref = new ImageIcon("resources\\starship.png");
		image = ref.getImage();
		height = image.getHeight(null) ;
		width = image.getWidth(null) ;
	}
	
	public void update() {
		x += dx;
		y += dy;
	}
	
	public void shotSample() {
		this.shots.add(new Gunshot(x + width, y + (height/2)));
	}
	
	public void keyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		
		switch(code) {
		case KeyEvent.VK_A:
			shotSample();
			return;
		case KeyEvent.VK_UP:
			dy = -3;
			return;
		case KeyEvent.VK_DOWN:
			dy = 3;
			return;
		case KeyEvent.VK_LEFT: 
			dx = -3;
			return;
		case KeyEvent.VK_RIGHT:
			dx = 3;
			return;
		
		}
	}
	
	
	public void keyReleased(KeyEvent key) {
		int code = key.getKeyCode();

		switch(code) {
		case KeyEvent.VK_UP:
			dy = 0;
			return;
		case KeyEvent.VK_DOWN:
			dy = 0;
			return;
		case KeyEvent.VK_LEFT: 
			dx = 0;
			return;
		case KeyEvent.VK_RIGHT:
			dx = 0;
			return;}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}

	public List<Gunshot> getShots() {
		return shots;
	}
	
	
	
	
	
}
