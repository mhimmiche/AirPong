import java.io.Serializable;
/**
 * Class of possible high score
 * @author Mehdi Himmiche
 * @date Apr 6, 2016
 */
public class HighScores implements Serializable {
	private static final long serialVersionUID = 1L;
	private String playerName;
	private int scoreValue;
	
	public HighScores(String name, int score) {
		this.playerName = name;
		this.scoreValue = score; 
	}
	
	/**
	 * Return the score value associate with the name/score pair
	 * @return the score
	 */
	public int getScoreVal() {
		return scoreValue;
	}
	
	/**
	 * Return the name value associate with the name/score pair
	 * @return the name
	 */
	public String getName() {
		return playerName;
	}

}
