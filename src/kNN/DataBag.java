package kNN;

import java.util.ArrayList;
import java.util.List;

/**
 * One DataBag holds a variable
 * amount of LearningData objects depending
 * on the Data object
 */

class  DataBag {

    private boolean isTest;

    private List<LearningData> evenlyDistributedEntries = new ArrayList<>();

    public void addData(LearningData learningData){
        evenlyDistributedEntries.add(learningData);
    }

    public boolean isTest() {
        return isTest;
    }

    public void setTestBag(boolean isTest){
        this.isTest = isTest;
    }
}
