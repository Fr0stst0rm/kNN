package kNN;

/**
 * One LearningData object is the equivalent of one learning data entry
 */

class LearningDataEntry<T extends Comparable<T>> extends DataEntry implements Comparable<LearningDataEntry<T>>{

	private T keyValue;

	public void setKeyValue(T keyValue) {
		this.keyValue = keyValue;
	}

	public T getKeyValue() {
		return keyValue;
	}

	@Override
	public int compareTo(LearningDataEntry<T> o) {
		return keyValue.compareTo(o.keyValue);
	}

}
