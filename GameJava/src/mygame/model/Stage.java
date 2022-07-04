package mygame.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Stage extends JPanel implements ActionListener {

	private Image background;
	private Player player;
	private Timer timer;
	
	public Stage() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon ref = new ImageIcon("resources\\spacebackground.jpg");
		background = ref.getImage();
	
		player = new Player();
		player.load();
		
		addKeyListener(new KeyboarAdapter());
	
		timer = new Timer(5, this);
		timer.restart();
	}
	
	public void paint(Graphics g) {
		Graphics2D graphs = (Graphics2D) g;
		graphs.drawImage(background, 0, 0, null);
		graphs.drawImage(player.getImage(), player.getX(), player.getY(), this);
		
		List<Gunshot> shots = player.getShots();
		for( int i = 0; i < shots.size(); i++) {
			Gunshot m = shots.get(i);
			m.load();
			graphs.drawImage(m.getImage(), m.getX(), m.getY(), this);
			}
				
		
		graphs.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		
		List<Gunshot> shots = player.getShots();
		for( int i = 0; i < shots.size(); i++) {
			Gunshot m = shots.get(i);
			if(m.isVisible()) {
				m.update();
			} else {
				shots.remove(i);
			}
		}
		
		repaint();
	}
	
	
	private class KeyboarAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e){
			player.keyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e){
			player.keyReleased(e);
		}
	}
	
	
}








