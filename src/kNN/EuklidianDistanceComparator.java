package kNN;

import java.util.Comparator;

public class EuklidianDistanceComparator implements Comparator<DataEntry>{
	
	DataEntry toCompare = null;
	
	public EuklidianDistanceComparator(DataEntry entry) {
		toCompare = entry;
	}

	/**
	 * Zum berechnen des nächsten Nachbarn (siehe Folien)
	 */
	@Override
	public int compare(DataEntry test1, DataEntry test2) {

		double dist1 = 0.0d;
		double dist2 = 0.0d;
		
		double summ = 0;
		for(int i = 0; i < test1.size(); i++) {
			summ += Math.pow(test1.get(i).getValue() - toCompare.get(i).getValue(), 2);
		}
		
		dist1 = Math.sqrt( summ);
		
		summ = 0;
		for(int i = 0; i < test2.size(); i++) {
			summ += Math.pow(test2.get(i).getValue() - toCompare.get(i).getValue(), 2);
		}
		dist2 = Math.sqrt( summ);
		
		if (dist1 > dist2) {
		return 1;
		}
		if (dist1 < dist2) {
		return -1;
		}
		return 0;
		
	}
}
