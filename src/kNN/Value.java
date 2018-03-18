package kNN;

/**
 * The value class is to be constructed with a double value for normal values
 * and a String for key values
 */
public class Value {

    private double value;
    
    public Value(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}