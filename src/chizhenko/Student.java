package chizhenko;

public class Student extends Human {

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String surname, String patronymic, Gender sex, int age) {
		super(name, surname, patronymic, sex, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [name=" + getName() + ", surname=" + getSurname() + ", patronymic="
				+ getPatronymic() + ", sex=" + getSex() + ", age=" + getAge() + "]";

	}

}
