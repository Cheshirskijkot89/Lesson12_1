package chizhenko;

import java.util.ArrayList;
import java.util.Collections;

public class Group implements Voenkom {

	//private Student[] arr = new Student[10];
	
	private ArrayList<Student> arr;
	
	//private int tos;

	public Group() {
		super();
		arr = new ArrayList<>();
//		tos = -1;
	}

 /*	public Student getSt(int ind) throws MyException {
		
		if (ind > arr.length) {
			throw new MyException(ind);
		}
		
		return arr[ind];
	}*/
	
	public ArrayList<Human> returnSoldiers() {
		ArrayList<Human> list18 = new ArrayList<>();
		for (Human st : arr) {
			if (st.getAge() > 18) {
				list18.add(st);
			}
		}
		
		return list18;
	}
	
	public ArrayList<Student>  getArr() {
		return arr;
	}


	public Student findSt(String stSurname) {
		Student result = null;
		for (Student i : arr) {
			
			if (i == null) {
				continue;
			};
			
			if (stSurname.equals(i.getSurname())) {
				result = i;
				break;
			}
		}
		return result;
	}

	public void addSt(Student st) throws MyException {
		
		arr.add(st);
	}

	public void removeSt(Student st) {
		//arr[tos--] = st;
		arr.remove(st);
	}

	public void removeSt(String stSurname) {
		Student findedSt = findSt(stSurname);
		if (findedSt == null) {
			System.out.println("fail remove");
		} else {
			removeSt(findedSt);
			System.out.println("remove complete");
		}
	}

	public void ViewGroup() {

		for (Student i : arr) {

			System.out.println(i.toString());
		}

	}
	
/*	public void SortGroup() {
		Arrays.sort(arr);
	}*/

}
