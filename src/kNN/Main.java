package kNN;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		
		kNNClassification algorithm = new kNNClassification(7);
		
		ArrayList<LearningDataEntry<String>> learningData = DataController.parseLearningData("winequality-white.csv", "\n", ";");
		
		algorithm.learn(learningData);
	}
}
