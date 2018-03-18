package kNN;

import java.util.ArrayList;
import java.util.Collections;

public class ConfusionMatrix {

	ArrayList<String> labels = new ArrayList<String>();

	int confusionMatrix[][];

	public ConfusionMatrix(ArrayList<String> labels) {
		Collections.sort(labels);
		this.labels = labels;
		confusionMatrix = new int[labels.size()][labels.size()];
	}

	public void setValue(String predictedLables, String realLables, int value) {
		confusionMatrix[labels.indexOf(realLables)][labels.indexOf(predictedLables)] = value;
	}

	public void addToValue(String predictedLables, String realLables, int value) {
		confusionMatrix[labels.indexOf(realLables)][labels.indexOf(predictedLables)] += value;
	}

	public int getValue(String predictedLables, String realLables) {
		return confusionMatrix[labels.indexOf(realLables)][labels.indexOf(predictedLables)];
	}

	@Override
	public String toString() {
		String str = "";
		ArrayList<Integer> sizes = new ArrayList<Integer>();

		for (String lable : labels) {
			sizes.add(lable.trim().length());
			str += "\t|" + lable.trim();
		}
		
		str += "\n------------------------------------------------------------";

		for (int i = 0; i < confusionMatrix.length; i++) {
			str += "\n" + labels.get(i).trim();
			for (int entry : confusionMatrix[i]) {
				str += "\t|" + entry;
			}
		}

		return str;
	}

}
