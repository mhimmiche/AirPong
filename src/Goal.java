import java.awt.Color;
import java.awt.Graphics;
/**
 * Goal class for the air pong game
 * @author Mehdi Himmiche
 * @date 2016 - 04 - 04
 *
 */
public class Goal {
	private int width = 30;
	private int height = 250;	
	private int y = Pong.WINDOW_HEIGHT / 2 - height / 2;
	private int x;
	
	public Goal(int newX) {
		this.x = newX;
	}

	/**
	 * Draws the goals on the board
	 * @param g
	 */
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	
	/**
	 * Returns the goal's X position
	 * @return X position
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Returns the goal's Y position
	 * @return Y position
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Returns the goal's height
	 * @return height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Returns the goal's width
	 * @return width
	 */
	public int getWidth() {
		return this.width;
	}
}
