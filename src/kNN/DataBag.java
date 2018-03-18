package kNN;

import java.util.ArrayList;

/**
 * One DataBag holds a variable amount of LearningData objects depending on the
 * Data object
 */

public class DataBag extends ArrayList<LearningDataEntry<String>> {

	public void addData(LearningDataEntry<String> learningData) {
		this.add(learningData);
	}

}
