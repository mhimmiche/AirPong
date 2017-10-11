import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
/**
 * Game panel class for the air pong game
 * @author Mehdi Himmiche
 * @date 2016 - 04 - 04
 *
 */
public class ScoreList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<HighScores> scoreArray = new ArrayList<HighScores>();
	
	public ScoreList() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Method to compare a new score to the existing scores in the list
	 * @param newScore
	 * @return the index at which the new score needs to be stored
	 */
	public int compareScore(int newScore) {
		Iterator iter = scoreArray.iterator();
		boolean isFound = false;
		int curIndex = 0;
		while (iter.hasNext() && !isFound) {
			HighScores presentScore = (HighScores) iter.next();
			if (newScore <= presentScore.getScoreVal()) {
				isFound = true;
			}
			else {
				curIndex++;
			}
		}
		return curIndex;
	}
	
	/**
	 * Adds the new name and score pair to the list in its appropriate location
	 * @param index
	 * @param newScore
	 */
	public void addScoreValue(int index, HighScores newScore) {
		scoreArray.add(index, newScore);
	}
	
	/**
	 * Formats the strings and displays the top ten players and their scores
	 * @return string containing the formatted top ten players
	 */
	public String displayTopTen() {
		String result = "";
		String row = String.format("%-30s %s", "Name", "Score");
		result += (row + "\n");
		int cur = 1;
		Iterator iter = scoreArray.iterator();
		if (scoreArray.size() <= 10) {
			while (iter.hasNext()) {
				HighScores curScore = (HighScores) iter.next();
				row = String.format("%-30s %s", curScore.getName(), curScore.getScoreVal());
				result += (row + "\n");
			}			
		}
		else {
			while (iter.hasNext() && cur <= 10) {
				HighScores curScore = (HighScores) iter.next();
				row = String.format("%-30s %s", curScore.getName(), curScore.getScoreVal());
				result += (row + "\n");
				cur++;
			}		
		}		
		return result;
	}
}
