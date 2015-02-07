/*
 * �Ķ���� ������
 */
class PersonInfo{
	//�ĸ����ͷ� �Ѿ�� ����� ���ڴ� ��Ÿ���� �����ϴ� �޼ҵ�
	void displayInfo(Person person){
		
		if(person instanceof Student){
			Student student = (Student)person;
			student.study();
		}
		
		person.shoeSleepStyle();
	}
}
public class ParameterPolyTest {
	public static void main(String[] args) {
		PersonInfo pf = new PersonInfo();
		Student student = new Student();
		Employee employee = new Employee();
		President president = new President();
		
		pf.displayInfo(student);
		pf.displayInfo(employee);
		pf.displayInfo(president);
		
		System.out.println("----------------------");
		
		// �迭���� �������� �����ȴ�. 
		Person[] personArray = new Person[3];
		personArray[0] = employee;
		personArray[1] = student;
		personArray[2] = president;
		
		for (int i = 0; i < personArray.length; i++) {
			personArray[i].shoeSleepStyle();
		}
	}
}
