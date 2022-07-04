package mygame;
import mygame.model.Stage;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Container extends JFrame{

	public Container() {
		add(new Stage());
		setTitle("Anx Dev - The Spaceshipping ");
		setSize(1240,945);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Container();
	}
	
	
}
