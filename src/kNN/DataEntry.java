package kNN;

import java.util.LinkedList;

public class DataEntry extends LinkedList<Value>{

    public void addValue(Value value){
        this.add(value);
    }

    public int getSize(){
        return this.size();
    }

}
