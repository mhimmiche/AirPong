import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Create the pong class
 * @author Mehdi Himmiche
 * @date 2016 - 04 - 04
 *
 */
public class Pong extends JFrame {
	final static int WINDOW_HEIGHT = 500;
	final static int WINDOW_WIDTH = 1000;

	public Pong() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Air Pong!");
		add(new GamePanel());
		setVisible(true);
	}
}
