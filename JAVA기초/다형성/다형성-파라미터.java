/*
 * 파라미터 다형성
 */
class PersonInfo{
	//파리미터로 넘어온 사람의 잠자는 스타일을 제공하는 메소드
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
		
		// 배열에도 다형성이 지원된다. 
		Person[] personArray = new Person[3];
		personArray[0] = employee;
		personArray[1] = student;
		personArray[2] = president;
		
		for (int i = 0; i < personArray.length; i++) {
			personArray[i].shoeSleepStyle();
		}
	}
}
