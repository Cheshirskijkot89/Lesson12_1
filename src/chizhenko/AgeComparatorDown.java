package chizhenko;

import java.util.Comparator;

public class AgeComparatorDown implements Comparator<Human> {
	
	public int compare(Human h1, Human h2) {
		
		if (h1.getAge() < h2.getAge()) {
			return 1;
		};
		
		if (h1.getAge() > h2.getAge()) {
			return -1;
		};
		
		return 0;
	}

}
