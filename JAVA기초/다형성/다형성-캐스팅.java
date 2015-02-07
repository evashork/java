/*
 * 클래스의 형변환
 * 1-1 다운캐스팅은 반드시 캐스팅이 가능한지 판단해야 한다.
 */
public class CastingTest {
	public static void main(String[] args) {
		// 다형성을 이용하지 않을 때
		President president1 = new President();
		
		// 자식 클래스 타입의 객체를 부모 클래스 타입의 레퍼런스 변수가 참조하면
		// 자식 객체의 레퍼런스 값의 타입이 자동으로 부모 클래스 타입으로 변환되어 참조된다.
		
		Person person1 = president1; // 자동으로 변환 업캐스팅(자식 값이 부모로)
		
		// 부모 클래스 타입의 레퍼런스 값을 자식 클래스 타입의 레퍼런스 변수가 참조하면 에러 발생
		// 명시적으로 다운캐스팅을 해야한다.
		// President president2 = person1; 불가능
		
		// 1-1
		if(person1 instanceof President){
			President president2 = (President)person1;
		}else{
			System.out.println("캐스팅 불가");
		}
		
		// 캐스팅은 부모 자식 클래스 끼리만 가능
		// Student student = (Student)new President();
		
		/*
		 *  자바에서는 부모 클래스 타입으로 자식 클래스 타입의 레퍼런스 값을 참조할 수 있지만
		 *  자식 클래스 타입의 레퍼런스 변수로 부모 클래스 타입의 객체를 참조하는 것을 허용하지 않는다.
		 */
		Person person2 = new Person();
		
		if(person2 instanceof President){
			President president3 = (President)person2;
		}else{
			System.out.println("캐스팅 불가");
		}
		
		/*
		 *  부모 클래스에 정의된 메소드를 자식클래스에서 재정의 하였고,
		 *  부모 클래스 타입의 레퍼런스 변수로 자식클래스 객체의 오버라이딩한 메소드를 호출할 때는
		 *  항상 오버라이딩된 메소드가 호출된다.
		 *  즉 자바에서 호출되는 메소드는 컴파일 타입에 결정되는 것이 아니라 런타임시 결정된다.
		 *  즉 메소드 다형성을 제공한다.
		 */
		
		Person person3 = new Student();
		person3.shoeSleepStyle();
		person3 = new Employee();
		person3.shoeSleepStyle();
		
		/*
		 *  부모 클래스에 정의된 변수를 자식클래스에서 재정의 하였고,
		 *  부모 클래스 타입의 레퍼런스 변수로 자식클래스 객체의 재정의된 변수를 호출할 때는
		 *  레퍼런스 변수의 타입에 따라서 호출되는 변수가 결정된다.
		 *  즉 자바에서 호출되는 변수는 컴파일 타입에 결정된다.
		 *  즉 변수는 다형성을 제공하지 않는다.
		 */
		
		person3 = new Employee();
		System.out.println("person3.age = " + person3.age);
		
		Employee employee1 = (Employee)person3;
		System.out.println("employee1.age = " + employee1.age);
		
		/*
		 *  자식 클래스에서 부모 클래스에 정의되지 않은 메소드를 정의한 경우
		 *  부모 클래스 타입으로 자식 객체를 참조하면 메소드의 접근할 수 없다.
		 *  접근하려면 다운캐스팅이 필요하다. 
		 */
		
		Person person4 = new Student();
		// person4.study(); 불가
		
		if(person4 instanceof Student){
			Student student1 = (Student)person4; //다운캐스팅
			student1.study();
		}
	}
}
