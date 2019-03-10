package chizhenko;

import java.util.Comparator;

public class UnivarsalComparator implements Comparator<Human> {

	private String field_name;
	private boolean sort_up;

	public UnivarsalComparator(String field_name, boolean sort_up) {
		super();
		this.field_name = field_name;
		this.sort_up = sort_up;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public void setSort_up(boolean sort_up) {
		this.sort_up = sort_up;
	}

	public int compare(Human h1, Human h2) {

		if (h1 == null & h2 == null) {
			return 0;
		}
		;

		if (h1 == null & h2 != null) {
			return (sort_up) ? -1 : 1;
		}

		if (h1 != null & h2 == null) {
			return (sort_up) ? 1 : -1;
		}

		if (field_name.equals("Age")) {

			if (h1.getAge() > h2.getAge()) {
				return (sort_up) ? 1 : -1;
			}
			;

			if (h1.getAge() < h2.getAge()) {
				return (sort_up) ? -1 : 1;
			}
			;

			return 0;
			
		} else if (field_name.equals("Name")) {
			return (sort_up) ? h1.getName().compareTo(h2.getName()) : h1.getName().compareTo(h2.getName()) * -1;
		} 
		
		return h1.getSurname().compareTo(h2.getSurname());

	}

}
