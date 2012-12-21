import java.awt.event.*;
import javax.swing.*;

//because why not

@SuppressWarnings("serial")
public class TankTest extends JFrame
{	
	private GamePaint cb;
	
	public TankTest(){
		super("TankTest");
		ImageStorage.init();
		cb = new GamePaint(800,600);
		getContentPane().setLayout(null);
		setContentPane(cb);
		
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		cb.start();
		
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent k) {
				cb.pressed(k);
			}
			@Override
			public void keyReleased(KeyEvent k) {
				cb.released(k);
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
	}
	
	public static void main(String[] args){
		new TankTest();
	}
}
