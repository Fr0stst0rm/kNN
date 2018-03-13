package kNN;

import java.util.LinkedList;

/**
 * One LearningData object is the equivalent
 * of one learning data entry
 */

class LearningData extends Data {

    private String keyValue;

    private LinkedList<Value> values = new LinkedList<>();

    @Override
    public void addValue(Value value){
        if(value.isKey()){
            keyValue = value.getStringValue();
        }
        values.add(value);
    }

    String getKeyValue() {
        return keyValue;
    }

    LinkedList getValues(){
        return values;
    }

}
