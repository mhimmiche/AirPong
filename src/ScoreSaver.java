import java.io.*;
import javax.swing.JOptionPane;
/**
 * A class used to save, load, and possibly alter score data. 
 * @author Mehdi Himmiche
 * @date Apr 6, 2016
 */
public class ScoreSaver {

	public ScoreSaver() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Saves the name and score pairs into a document called scoreList.ser
	 * @param scores
	 */
	public void saveScores(ScoreList scores) {
		try {
			FileOutputStream fout = new FileOutputStream("Saved Files/scoresList.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(scores);
			oos.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "There was an error saving the scores", "Save error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Loads the document with saved names and scores
	 * @return a ScoreList object containing previous name/score pairs
	 */
	public ScoreList loadScores() {
		ScoreList list = new ScoreList();
		try {
			FileInputStream fin = new FileInputStream("Saved Files/scoresList.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			list = (ScoreList) ois.readObject();
			ois.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "There was an error loading the scores", "Load error",
					JOptionPane.ERROR_MESSAGE);
		}
		return list;
	}

}
