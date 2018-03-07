package kNN;

import java.util.LinkedList;

/**
 * One Entry object is the equivalent
 * of one learning data entry
 */

class Entry {

    private Value keyValue;

    private LinkedList<Value> values = new LinkedList<>();

    public void addValue(Value value){
        if(value.isKey()){
            keyValue = value;
        }
        values.add(value);
    }

    public int getSize(){
        return values.size();
    }

    public Value getKeyValue() {
        return keyValue;
    }
}
