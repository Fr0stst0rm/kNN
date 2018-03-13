package kNN;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class contains
 * and manages all DataBag objects
 * T is the type of the key value
 */

abstract class DataController{

	private int[][] confusionMatrix;

	private int dataAmount = 0;

	private List<DataBag> bags = new LinkedList<>();

	private Map<String, Vector<LearningData>> keysWithData = new HashMap<>();

	public void parseData(String filename, String entryDelimiter, String valueDelimiter){

		String content = null;

		try {
			content = new String(Files.readAllBytes(Paths.get(filename)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] lines = content != null ? content.split(entryDelimiter) : new String[0];

		for (String line : lines) {
			LearningData learningData = createEntry(valueDelimiter);
			handleKeyValue(learningData);
			dataAmount++;
		}

	}

	//todo: implement for actual task
	abstract LearningData createEntry(String valueDelimiter);

	public void fillDataBags(int folds){
		int bagSize = dataAmount/folds;
		int keyAmount = keysWithData.size();

		//todo: sort and make folds
		//beim letzten dann immer rest rein tun?
	}

	/**
	 * this functions sorts the entries
	 * by classification of the key value
	 * @param learningData the entry to be added
	 */
	private void handleKeyValue(LearningData learningData){
		Vector<LearningData> temp = new Vector<>();
		if(keysWithData.size()>0){
			//wenn schon existiert der key value holen und weiteres objekt reinschieben und dann wieder reintun
			if(keysWithData.containsKey(learningData.getKeyValue())){
				temp = keysWithData.get(learningData.getKeyValue());
				temp.add(learningData);
				keysWithData.put(learningData.getKeyValue(), temp);
			}else{
				temp.add(learningData);
				keysWithData.put(learningData.getKeyValue(), temp);
			}

		}else{
			temp.add(learningData);
			keysWithData.put(learningData.getKeyValue(), temp);
		}
	}

	public void learn(){
		//todo: handles all the learning with databags and stuff.
	}

	private void createConfusionMatrix(){
		confusionMatrix = new int[keysWithData.size()-1][keysWithData.size()-1];
		//todo: fill it
	}

	
}
