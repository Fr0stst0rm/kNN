package kNN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class contains and manages all DataBag objects
 * T is the type of the key
 * value
 */

public class DataController {

	public static ArrayList<DataEntry> parseData(String path, String entryDelimiter, String valueDelimiter) {

		String content = null;

		ArrayList<DataEntry> data = new ArrayList<>();

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

					DataEntry dataEntry = new DataEntry();
					for (String value : line.split(valueDelimiter)) {
						dataEntry.addValue(Double.parseDouble(value));
					}
					data.add(dataEntry);
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

		System.out.println(data.size() + " lines of data loaded.");

		return data;
	}

	public static ArrayList<LearningDataEntry<String>> parseLearningData(String path, String entryDelimiter, String valueDelimiter) {
		return parseLearningData(path, entryDelimiter, valueDelimiter, -1);
	}

	public static ArrayList<LearningDataEntry<String>> parseLearningData(String path, String entryDelimiter, String valueDelimiter, int indexOfKey) {

		String content = null;

		ArrayList<LearningDataEntry<String>> data = new ArrayList<LearningDataEntry<String>>();

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

					if (indexOfKey < 0) {
						indexOfKey = line.split(valueDelimiter).length - 1;
					}

					LearningDataEntry<String> dataEntry = new LearningDataEntry<String>();
					for (int i = 0; i < line.split(valueDelimiter).length; i++) {
						if (i == indexOfKey) {
							dataEntry.setKeyValue(line.split(valueDelimiter)[i].trim());
						} else {
							dataEntry.addValue(Double.parseDouble(line.split(valueDelimiter)[i]));
						}
					}
					data.add(dataEntry);
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

		System.out.println(data.size() + " lines of data loaded.");

		return data;
	}

}
