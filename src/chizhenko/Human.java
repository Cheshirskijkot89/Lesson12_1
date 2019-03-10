package chizhenko;

public class Human implements Comparable {

	private String name;
	private String surname;
	private String patronymic;
	private Gender sex;
	private int age;

	public Human() {
		super();
	}

	public Human(String name, String surname, String patronymic, Gender sex, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", surname=" + surname + ", patronymic=" + patronymic + ", sex=" + sex + ", age="
				+ age + "]";
	}

	@Override
	public int compareTo(Object o) {
		
		Human anotherHuman;
		
		if (o == null) return -1;
		
		try {
			anotherHuman = (Human) o;
		} catch (NullPointerException e) {
			return -1;
		}
		
		return this.surname.compareTo(anotherHuman.getSurname());
	}
	
	

}


