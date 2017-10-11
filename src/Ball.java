import java.awt.Graphics;
import java.awt.Color;
/**
 * Ball class for the air pong game
 * @author Mehdi Himmiche
 * @date 2016 - 04 - 04
 *
 */
public class Ball {
	private int y = Pong.WINDOW_HEIGHT / 2;
	private int x = Pong.WINDOW_WIDTH / 2;	
	private int startXVel = 15;	
	private int xVelocity = startXVel;
	private int yVelocity = 7;	
	private int size = 15;
	
	/**
	 * Update method for the ball
	 * Moves the ball and determines the bouncing of the ball. 
	 */
	public void Update() {		
		x = x + xVelocity;
		y = y + yVelocity;
		
		if (x < 0) {
			xVelocity = Math.abs(xVelocity);
		}
		else if (x + size > Pong.WINDOW_WIDTH) {
			xVelocity = -xVelocity;
		}
		
		if (y < 0) {
			yVelocity = Math.abs(yVelocity);;
		}
		else if (y + size + 30  > Pong.WINDOW_HEIGHT) {
			yVelocity = -yVelocity;
		}
	}
	
	/**
	 * Draws the ball... erm, I mean the puck!
	 * @param g
	 */
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(x,  y,  size,  size);
	}
	
	/**
	 * Determines if there's a collision between the puck and the player.
	 * @param player
	 */
	public void checkCollision(Player player) {
		if (xVelocity < 0) {
			if (this.x == (player.getX() + player.getWidth())) {
				if (this.y > player.getY() && this.y < (player.getY() + player.getHeight())) {
					xVelocity = -xVelocity;
				}
			}
		}else {
			if (this.x == player.getX()) {
				if (this.y > player.getY() && this.y < (player.getY() + player.getHeight())) {
					xVelocity = -xVelocity;
				}
			}
		}
		
		if (yVelocity < 0) {
			if (this.y == player.getY() + player.getHeight()) {
				if (this.x > player.getX() && this.x < (player.getX() + player.getWidth())) {
					yVelocity = -yVelocity;
				}
			}
		}else {
			if (this.y == player.getY()) {
				if (this.x > player.getX() && this.x < (player.getX() + player.getWidth())) {
					yVelocity = -yVelocity;
				}
			}
		}
	}
	
	/**
	 * Determines if a goal was scored and resets the puck's position. 
	 * @param goal
	 */
	public void goalCheck(Goal goal) {
		if (this.x < (goal.getX() + goal.getWidth()) && this.x > goal.getX()) {
			if (this.y > goal.getY() && this.y < (goal.getY() + goal.getHeight())) {
				xVelocity *= -1;
				y = Pong.WINDOW_HEIGHT / 2;
				x = Pong.WINDOW_WIDTH / 2;
			}
		}	
	}
	
	/**
	 * Checks if a goal was scored and returns a boolean to help with checks. 
	 * @param goal
	 * @return true if a goal was scored, false otherwise. 
	 */
	public boolean scoreCheck(Goal goal) {
		boolean hitGoal = false;
		if (this.x < (goal.getX() + goal.getWidth()) && this.x > goal.getX()) {
			if (this.y > goal.getY() && this.y < (goal.getY() + goal.getHeight())) {
				hitGoal = true;
			}
		}	
		return hitGoal;
	}

}
