package kNN;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class contains
 * and manages all DataBag objects
 */

abstract class DataController {

	private Stack<Entry> learningData = new Stack<>();

	private List<DataBag> bags = new LinkedList<>();

	private Map<Value, Integer> keys = new HashMap<Value, Integer>();

	public void parseData(String filename, String entryDelimiter, String valueDelimiter){

		String content = null;

		try {
			content = new String(Files.readAllBytes(Paths.get(filename)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] lines = content != null ? content.split(entryDelimiter) : new String[0];

		for (String line : lines) {
			Entry entry = createEntry(valueDelimiter);
			handleKeyValue(entry);
			learningData.push(entry);
		}

	}

	//todo: implement for actual task
	abstract Entry createEntry(String valueDelimiter);

	public void fillDataBags(int folds, int categorisations){
		int bagSize = learningData.size()/folds;
		int keyAmount = keys.size();
		//todo: sort and make folds
		//beim letzten dann immer rest rein tun?
	}

	private void handleKeyValue(Entry entry){
		if(keys.size()>0){
			//wenn schon existiert der key value holen und um 1 erhöhen und dann wieder reintun
			if(keys.containsKey(entry.getKeyValue())){
				Integer amount = keys.get(entry.getKeyValue());
				amount++;
				keys.put(entry.getKeyValue(), amount);
			}else{
				keys.put(entry.getKeyValue(), 1);
			}

		}else{
			keys.put(entry.getKeyValue(), 1);
		}
	}

	
}
