package kNN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class contains and manages all DataBag objects T is the type of the key
 * value
 */

abstract class DataController {

	private int[][] confusionMatrix;

	private int dataAmount = 0;

	private List<DataBag> bags = new LinkedList<>();

	private Map<String, Vector<LearningData>> keysWithData = new HashMap<>();

	public LearningData parseData(String path, String entryDelimiter, String valueDelimiter) {

		String content = null;

		LearningData learningData = new LearningData();

		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path));
			int character = 0;
			String line = "";
			boolean stop = false;

			while (!stop) {
				stop = true;
				String endBuffer = "";
				while ((character = bfr.read()) != -1) {
					stop = false;
					endBuffer += "" + (char) character;

					if (!entryDelimiter.startsWith(endBuffer)) {
						line += endBuffer;
						endBuffer = "";
					}

					if (entryDelimiter.equals(endBuffer)) {
						break;
					}
				}

				if (line.split(valueDelimiter).length > 1) {

					dataAmount++;

					for (String value : line.split(valueDelimiter)) {
						try { // Zu double konvertieren
							learningData.addValue(new Value(Double.parseDouble(value)));
						} catch (NumberFormatException e) { // Sonst als string
															// speichern
							learningData.addValue(new Value(value));
						}
					}
				}

				line = "";

			}
			bfr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		handleKeyValue(learningData);

		return learningData;
	}

	// todo: wo ausreißer wegwerfen?
	public void fillDataBags(int folds) {
		int bagSize = dataAmount / folds;
		int keyAmount = keysWithData.size();

		for (int i = 0; i < folds; i++) {
			for (int a = 0; a < bagSize; a++) {
				for (int b = 0; b < keyAmount; a++) {
					DataBag dataBag = new DataBag();
					// todo: add one of each key and then delete it from vector
				}
			}
		}

		// todo: sort and make folds
		// beim letzten dann immer rest rein tun?
	}

	/**
	 * this functions sorts the entries by classification of the key value
	 * 
	 * @param learningData
	 *            the entry to be added
	 */
	private void handleKeyValue(LearningData learningData) {
		Vector<LearningData> temp = new Vector<>();
		if (keysWithData.size() > 0) {
			// wenn schon existiert der key value holen und weiteres objekt
			// reinschieben und dann wieder reintun
			if (keysWithData.containsKey(learningData.getKeyValue())) {
				temp = keysWithData.get(learningData.getKeyValue());
				temp.add(learningData);
				keysWithData.put(learningData.getKeyValue(), temp);
			} else {
				temp.add(learningData);
				keysWithData.put(learningData.getKeyValue(), temp);
			}

		} else {
			temp.add(learningData);
			keysWithData.put(learningData.getKeyValue(), temp);
		}
	}

	public void learn() {
		// todo: handles all the learning with databags and stuff.
	}

	private void createConfusionMatrix() {
		confusionMatrix = new int[keysWithData.size() - 1][keysWithData.size() - 1];
		// todo: fill it
	}

}
