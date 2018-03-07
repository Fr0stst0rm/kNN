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

	private Map<Entry, Integer> keys = new HashMap<>();

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

	abstract Entry createEntry(String valueDelimiter);

	void fillDataBags(int folds, int categorisations){
		int bagSize = learningData.size()/folds;

		//beim letzten dann immer rest rein tun?
	}

	void handleKeyValue(Entry entry){

	}

	
}
