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

	public void setValue(String lable1, String lable2, int value) {
		confusionMatrix[labels.indexOf(lable1)][labels.indexOf(lable2)] = value;
	}
	
	public void addToValue(String lable1, String lable2, int value) {
		confusionMatrix[labels.indexOf(lable1)][labels.indexOf(lable2)] += value;
	}

	public int getValue(String lable1, String lable2) {
		return confusionMatrix[labels.indexOf(lable1)][labels.indexOf(lable2)];
	}

	@Override
	public String toString() {
		String str = "";
		ArrayList<Integer> sizes = new ArrayList<Integer>();
			
		for (String lable : labels) {
			sizes.add(lable.length());
			str += " | " + lable;
		}
		
		//TODO

		return str;
	}

}
