package mygame.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Gunshot {

	private Image image;
	private int x, y;
	private int height, width;
	private boolean isVisible;
	
	private static final int WIDTH = 1240;
	private static int SPEED = 2;
	
	public Gunshot(int x, int y) {
		this.x = x;
		this.y = y;
		isVisible = true;
	}
	
	public void load() {
		ImageIcon ref = new ImageIcon("resources\\ShootSample.png");
		image = ref.getImage();
		this.height = image.getHeight(null) ;
		this.width = image.getWidth(null) ;
	}
	
	public void update() {
		this.x += SPEED;
		if(this.x > WIDTH) {
			isVisible = false;
		}
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public static int getSPEED() {
		return SPEED;
	}

	public static void setSPEED(int sPEED) {
		SPEED = sPEED;
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
	
	
	
	
}
