package kNN;

import java.util.LinkedList;

public class Data {

    private LinkedList<Value> values = new LinkedList<>();

    public void addValue(Value value){
        values.add(value);
    }

    public int getSize(){
        return values.size();
    }

}
