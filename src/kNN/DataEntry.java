package kNN;

import java.util.LinkedList;

public class DataEntry extends LinkedList<Double>{

    public void addValue(Double value){
        this.add(value);
    }

    public int getSize(){
        return this.size();
    }

}
