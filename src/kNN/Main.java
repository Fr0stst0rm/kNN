package kNN;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {

		kNNClassification algorithm = new kNNClassification(1);

		ArrayList<LearningDataEntry<String>> learningData = DataController.parseLearningData("winequality-white.csv", "\n", ";");
		//ArrayList<LearningDataEntry<String>> learningData = DataController.parseLearningData("iris.csv", "\n", ",");

		algorithm.learn(learningData);

//		ArrayList<DataEntry> testData1000 = new ArrayList<>();
//		for (int i = 0; i < 1000; i++) {
//			testData1000.add(learningData.get(i % learningData.size()));
//		}
//		ArrayList<DataEntry> testData10000 = new ArrayList<>();
//		for (int i = 0; i < 10000; i++) {
//			testData10000.add(learningData.get(i % learningData.size()));
//		}
		ArrayList<DataEntry> testData100000 = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			testData100000.add(learningData.get(i % learningData.size()));
		}
//		ArrayList<DataEntry> testData1000000 = new ArrayList<>();
//		for (int i = 0; i < 1000000; i++) {
//			testData1000000.add(learningData.get(i % learningData.size()));
//		}
		
		algorithm.classify(testData100000);

	}
}
