import java.awt.Color;
import java.awt.Graphics;
/**
 * Player class for the air pong game
 * @author Mehdi Himmiche
 * @date 2016 - 04 - 04
 *
 */
public class Player {
	private int width = 30;
	private int height = 150;	
	private int y = Pong.WINDOW_HEIGHT / 2 - height / 2;
	private int x;
	private int yVelocity = 0;
	
	/**
	 * Constructor class for the player paddle
	 * @param newX
	 */
	public Player(int newX) {
		this.x = newX;
	}
	
	/**
	 * Determine how to move the player and prevents the player from going out of bounds
	 */
	public void update() {		
		if (y < 0) {
			yVelocity = 0;
			y = 0;
		}
		else if (y + height > Pong.WINDOW_HEIGHT) {
			yVelocity = 0;
			y = Pong.WINDOW_HEIGHT - height;
		}
		y = y + yVelocity;
	}
	
	/**
	 * Draws the player on the board
	 * @param g
	 */
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	/**
	 * Setter for the velocity
	 * @param speed
	 */
	public void setYVelocity(int speed) {
		yVelocity = speed;
	}
	
	/**
	 * Returns the player's X position
	 * @return X position
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Returns the player's Y position
	 * @return Y position
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Returns the player's height
	 * @return height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Returns the player's width
	 * @return width
	 */
	public int getWidth() {
		return this.width;
	}
}
