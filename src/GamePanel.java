import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Game panel class for the air pong game
 * @author Mehdi Himmiche
 * @date 2016 - 04 - 04
 *
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
	private Ball ball = new Ball();
	private Player player1 = new Player(50);
	private Player player2 = new Player(Pong.WINDOW_WIDTH - 80);	
	private Scores score1 = new Scores(Pong.WINDOW_WIDTH / 4);
	private Scores score2 = new Scores(Pong.WINDOW_WIDTH - Pong.WINDOW_WIDTH / 4);
	private ScoreList scoreList;	
	private Goal goal1 = new Goal(-15);
	private Goal goal2 = new Goal(Pong.WINDOW_WIDTH - 20);	
	private int allowedScore = 7;	
	private Long startTime = System.nanoTime();
	private Long endTime;
	private int finalScore = 0;	
	boolean gameOn = true;
	boolean setScore = false;
	boolean gameOver = false;
	private ScoreSaver saver = new ScoreSaver();
	private int speed = 20;	
	private int width = Pong.WINDOW_WIDTH;
	private int height = Pong.WINDOW_HEIGHT;
	/**
	 * Constructor for the game panel
	 */
	public GamePanel() {
		Timer tim = new Timer(50, this);
		tim.start();		
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	/**
	 * Frame update method.
	 */
	public void update() {
		if (gameOn) {
			ball.Update();
			player1.update();
			player2.update();
			if (ball.scoreCheck(goal1)) {
				score1.setScore();
			}
			if (ball.scoreCheck(goal2)) {
				score2.setScore();
			}
			score1.update();
			score2.update();			
			ball.checkCollision(player1);
			ball.checkCollision(player2);			
			ball.goalCheck(goal1);
			ball.goalCheck(goal2);			
			if (score1.getScore() == allowedScore || score2.getScore() == allowedScore) {
				gameOn = false;
				setScore = true;
				gameOver = true;
			}
		} else {
			updateScore();
			endOfGame();
		}		
	}
	
	/**
	 * Method to calculate the final score
	 */
	public void updateScore() {
		if (setScore) {
			scoreList = saver.loadScores();
			String s = "";
			setScore = false;	
			endTime = (System.nanoTime() - startTime) / 100000000;
			finalScore = Integer.valueOf(endTime.intValue()) * 7;
			int index = scoreList.compareScore(finalScore);	
			HighScores newScore = new HighScores(s, finalScore);
			if (index < 10) {
				s = (String)JOptionPane.showInputDialog(null, "Please Enter Your Name", "You made it!",  JOptionPane.PLAIN_MESSAGE);
			}
			if (s != null) {
				newScore = new HighScores(s, finalScore);
			}
			scoreList.addScoreValue(index, newScore);
			saver.saveScores(scoreList);
		}
	}
	
	/**
	 * Determine what to do for the end of the game. 
	 */
	public void endOfGame() {
		if (gameOver) {
			gameOver = false;
			String winner = "";
			if (score1.getScore() == 7) {
				winner = "Player 1";
			}
			else if (score2.getScore() == 7) {
				winner = "Player 2";
			}
			String topTen = scoreList.displayTopTen();
			int n = JOptionPane.showConfirmDialog(
				    null,
				    "Congratulations to " + winner + "\n"
				    + "You won with a score of " + finalScore + 
				    ", what a champ! I wish I could be like you...\n" +
				    topTen + "Would you like to play again?",
				    "Congratulations!!!",
				    JOptionPane.YES_NO_OPTION);
			if (n != JOptionPane.YES_NO_OPTION) {
				System.exit(4);
			}
			else {
				startTime = System.nanoTime();
				score1.resetScore();
				score2.resetScore();
				gameOn = true;
			}
		}
	}
	
	/**
	 * Draws the background of the game
	 */
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		player1.paint(g);
		player2.paint(g);
		goal1.paint(g);
		goal2.paint(g);
		score1.paint(g);
		score2.paint(g);
		ball.paint(g);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();
	}
	
	/**
	 * Moves the player paddles up and down depending on the button clicked. 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player2.setYVelocity(-speed);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player2.setYVelocity(speed);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player1.setYVelocity(-speed);
		}
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			player1.setYVelocity(speed);
		}
	}
	
	/**
	 * Stops the player from moving when button is released. 
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
			player1.setYVelocity(0);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
			player2.setYVelocity(0);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
