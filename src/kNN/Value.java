package kNN;

/**
 * This Interface is used for the different
 * values in one learning data entry
 */

abstract class Value<templateValue> {

    private templateValue value;

   abstract  boolean isKey ();

    abstract void setValue(templateValue value);

    abstract templateValue getvalue();

    public boolean equal(Object other){
        if (other instanceof Value<?>){
            if ( ((Value<?>)other).value.equals(value) ){
                return true;
            }
        }
        return false;
    }

}
