import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Score class for the air pong game
 * @author Mehdi Himmiche
 * @date 2016 - 04 - 04
 *
 */
public class Scores {
	private int x;
	private int y = Pong.WINDOW_HEIGHT / 2;
	private int currScore = 0;
	boolean updateScore = false;
	
	public Scores(int newX) {
		this.x = newX;
	}
	
	/**
	 * Update the score value as needed
	 */
	public void update() {
		if (updateScore) {
			updateScore = false;
			currScore++;
		}
	}
	
	/**
	 * Draws the scores on the board
	 * @param g
	 */
	public void paint(Graphics g) {
		String score = Integer.toString(currScore);
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.PLAIN, 100)); 
		g.drawString(score, x, y);
	}
	
	/**
	 * Allows for the score update so it only increments once
	 */
	public void setScore() {
		updateScore = true;
	}
	
	/**
	 * Getter for the score value
	 * @return Goals scored
	 */
	public int getScore() {
		return currScore;
	}
	
	/**
	 * Resets the goal counter to 0
	 */
	public void resetScore() {
		currScore = 0;
	}

}
