package chizhenko;

import java.util.Comparator;

public class NameComparatorDown implements Comparator<Human> {
	
	public int compare(Human h1, Human h2) {
		
		if (h1 == null & h2 == null) {
			return 0;
		}
		;

		if (h1 == null & h2 != null) {
			return 11;
		}

		if (h1 != null & h2 == null) {
			return -1;
		}

		return h1.getSurname().compareTo(h2.getSurname()) * -1;
	}

}
