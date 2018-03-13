package kNN;

/**
 * The value class is to be constructed with a double value for normal values
 * and a String for key values
 */
public class Value {

    private double value;
    private String stringValue;    //is only not null when isKey

    private boolean isKey = false;

    public Value(double value){
        this.value = value;
    }

    public Value(String stringValue){
        this.stringValue = stringValue;
        isKey = true;
    }

    boolean isKey(){
        return isKey;
    }

    String getStringValue() {
        return stringValue;
    }

    public double getValue() {
        return value;
    }
}


/*
abstract class ValueTemplate<templateValue> {

    private templateValue value;

    abstract  boolean isKey ();

    abstract void setValue(templateValue value);

    abstract templateValue getvalue();

    public boolean equal(Object other){
        if (other instanceof ValueTemplate<?>){
            if ( ((ValueTemplate<?>)other).value.equals(value) ){
                return true;
            }
        }
        return false;
    }

}
*/