package chizhenko;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		String name_temp;
		String surname_temp;
		String patronymic_temp;
		Gender sex_temp;
		int age_temp;
		Student student_temp;
		int readFromFile;
		ArrayList<String[]> list;
		
		Group myGroup = new Group();
	
		readFromFile = 0;
		readFromFile = JOptionPane.showConfirmDialog(null,"ЗагрузитьИзФайла?","ЗагрузитьИзФайла?",JOptionPane.YES_NO_OPTION );
		
		if (readFromFile == 0) {
		
			list = downloadFromFile();
			
			for (String[] arr: list) {
			
				try {
					
					name_temp = arr[0];
					surname_temp = arr[1];
					patronymic_temp = arr[2];
					sex_temp = Gender.valueOf(arr[3]);
					age_temp = Integer.parseInt(arr[4]);
					
					student_temp = new Student(name_temp, surname_temp, patronymic_temp, sex_temp, age_temp);

					try {
						myGroup.addSt(student_temp);
					} catch (MyException e) {
						System.out.println("Error");
					}
					
				}
				
				catch (NullPointerException e) {

					//JOptionPane.showMessageDialog(null, "Значение не задано");
					if (continueEntering("начать заново?") == false) {
					break;	
					}
				}

				catch (NumberFormatException e) {

					//JOptionPane.showMessageDialog(null, "Не верный формат");
					if (continueEntering("начать заново?") == false) {
					break;	
					}

				}
			}
			
		} else {
			
			for (;;) {

				try {

					name_temp = JOptionPane.showInputDialog("Введите имя");				
					if (name_temp == "" || name_temp == null) {
						throw new NullPointerException();	
					}
					
					surname_temp = JOptionPane.showInputDialog("Введите фамилию");
					if (surname_temp == "" || surname_temp == null) {
						throw new NullPointerException();	
					}
					
					patronymic_temp = JOptionPane.showInputDialog("Введите отчество");
					if (patronymic_temp == "" || patronymic_temp == null) {
						throw new NullPointerException();	
					}
								
					sex_temp = null;

					//boolean sex_chosen = false;
					for (Gender g : Gender.values()) {

						int response = JOptionPane.showConfirmDialog(null, g.toString(), "Выберите пол",
								JOptionPane.YES_NO_OPTION);
						if (response == 0) {
							//sex_chosen = true;
							sex_temp = g;
							break;
						}

					}

					if (sex_temp == null) {
						throw new NullPointerException();
					}

					
					age_temp = Integer.valueOf(JOptionPane.showInputDialog("Введите возраст"));
					
//					if (age_temp == 0 ) {
//						throw new NullPointerException();	
//					}
					
					student_temp = new Student(name_temp, surname_temp, patronymic_temp, sex_temp, age_temp);

					try {
						myGroup.addSt(student_temp);
					} catch (MyException e) {
						System.out.println("Error");
					}

					if (continueEntering("Студент добавлен. Продолжить?") == false) {
						break;
					}

				}

				catch (NullPointerException e) {

					//JOptionPane.showMessageDialog(null, "Значение не задано");
					if (continueEntering("начать заново?") == false) {
					break;	
					}
				}

				catch (NumberFormatException e) {

					//JOptionPane.showMessageDialog(null, "Не верный формат");
					if (continueEntering("начать заново?") == false) {
					break;	
					}

				}

			}
			
		}
		
		for (Human temp : myGroup.getArr()) {
			if (temp != null) System.out.println(temp.toString());
		}
		
/*		if ((JOptionPane.showConfirmDialog(null,"Сортировать по возрасту?","Сортировать по возрасту?",JOptionPane.YES_NO_OPTION)) == 0) {
			
			if ((JOptionPane.showConfirmDialog(null,"Сортировать по возрастанию?","Сортировать по возрастанию?",JOptionPane.YES_NO_OPTION)) == 0) {
				Collections.sort(myGroup.getArr(), new AgeComparatorUp());
			} else {
				Collections.sort(myGroup.getArr(), new AgeComparatorDown());
			}
			
		} else if ((JOptionPane.showConfirmDialog(null,"Сортировать по имени?","Сортировать по имени?",JOptionPane.YES_NO_OPTION)) == 0) {
			
			if ((JOptionPane.showConfirmDialog(null,"Сортировать по возрастанию?","Сортировать по возрастанию?",JOptionPane.YES_NO_OPTION)) == 0) {
				Collections.sort(myGroup.getArr(), new NameComparatorUp());
			} else {
				Collections.sort(myGroup.getArr(), new NameComparatorDown());
			}
			
		}*/
		
		String sort_temp = JOptionPane.showInputDialog("Введите поле сортировки (Age, Name)");				
		if (sort_temp == "" || sort_temp == null) {
			throw new NullPointerException();	
		} else {
			if ((JOptionPane.showConfirmDialog(null,"Сортировать по возрастанию?","Сортировать по возрастанию?",JOptionPane.YES_NO_OPTION)) == 0) {
				Collections.sort(myGroup.getArr(), new UnivarsalComparator(sort_temp, true));
			} else {
				Collections.sort(myGroup.getArr(), new UnivarsalComparator(sort_temp, false));
			}
		};
		
		//myGroup.SortGroup();
		System.out.println();
		
		for (Human temp : myGroup.getArr()) {
			if (temp != null) System.out.println(temp.toString());
		}
		
		System.out.println();
		System.out.println("Студенты после 18");
		System.out.println();
		
		for ( Human st : myGroup.returnSoldiers()) {
			System.out.println(st.toString());
		}
	}

	static boolean continueEntering(String message) {
		int response = JOptionPane.showConfirmDialog(null, message, "", JOptionPane.YES_NO_OPTION);
		return response == 0;
	}
	
	
	static ArrayList<String[]> downloadFromFile() {
		
		ArrayList<String[]> list = new ArrayList<>();
		String text = "";
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")));
			
			for(;(text = br.readLine()) != null;) {
				
				list.add(text.split("\t"));
				
			}
			
			br.close();
			
		} catch(IOException e) {
			System.out.println(e);
		}
		
		return list;
	}
	
}

enum Gender {
	MALE, FEMALE, ROBOT
}