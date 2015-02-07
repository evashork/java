/*
 * Ŭ������ ����ȯ
 * 1-1 �ٿ�ĳ������ �ݵ�� ĳ������ �������� �Ǵ��ؾ� �Ѵ�.
 */
public class CastingTest {
	public static void main(String[] args) {
		// �������� �̿����� ���� ��
		President president1 = new President();
		
		// �ڽ� Ŭ���� Ÿ���� ��ü�� �θ� Ŭ���� Ÿ���� ���۷��� ������ �����ϸ�
		// �ڽ� ��ü�� ���۷��� ���� Ÿ���� �ڵ����� �θ� Ŭ���� Ÿ������ ��ȯ�Ǿ� �����ȴ�.
		
		Person person1 = president1; // �ڵ����� ��ȯ ��ĳ����(�ڽ� ���� �θ��)
		
		// �θ� Ŭ���� Ÿ���� ���۷��� ���� �ڽ� Ŭ���� Ÿ���� ���۷��� ������ �����ϸ� ���� �߻�
		// ��������� �ٿ�ĳ������ �ؾ��Ѵ�.
		// President president2 = person1; �Ұ���
		
		// 1-1
		if(person1 instanceof President){
			President president2 = (President)person1;
		}else{
			System.out.println("ĳ���� �Ұ�");
		}
		
		// ĳ������ �θ� �ڽ� Ŭ���� ������ ����
		// Student student = (Student)new President();
		
		/*
		 *  �ڹٿ����� �θ� Ŭ���� Ÿ������ �ڽ� Ŭ���� Ÿ���� ���۷��� ���� ������ �� ������
		 *  �ڽ� Ŭ���� Ÿ���� ���۷��� ������ �θ� Ŭ���� Ÿ���� ��ü�� �����ϴ� ���� ������� �ʴ´�.
		 */
		Person person2 = new Person();
		
		if(person2 instanceof President){
			President president3 = (President)person2;
		}else{
			System.out.println("ĳ���� �Ұ�");
		}
		
		/*
		 *  �θ� Ŭ������ ���ǵ� �޼ҵ带 �ڽ�Ŭ�������� ������ �Ͽ���,
		 *  �θ� Ŭ���� Ÿ���� ���۷��� ������ �ڽ�Ŭ���� ��ü�� �������̵��� �޼ҵ带 ȣ���� ����
		 *  �׻� �������̵��� �޼ҵ尡 ȣ��ȴ�.
		 *  �� �ڹٿ��� ȣ��Ǵ� �޼ҵ�� ������ Ÿ�Կ� �����Ǵ� ���� �ƴ϶� ��Ÿ�ӽ� �����ȴ�.
		 *  �� �޼ҵ� �������� �����Ѵ�.
		 */
		
		Person person3 = new Student();
		person3.shoeSleepStyle();
		person3 = new Employee();
		person3.shoeSleepStyle();
		
		/*
		 *  �θ� Ŭ������ ���ǵ� ������ �ڽ�Ŭ�������� ������ �Ͽ���,
		 *  �θ� Ŭ���� Ÿ���� ���۷��� ������ �ڽ�Ŭ���� ��ü�� �����ǵ� ������ ȣ���� ����
		 *  ���۷��� ������ Ÿ�Կ� ���� ȣ��Ǵ� ������ �����ȴ�.
		 *  �� �ڹٿ��� ȣ��Ǵ� ������ ������ Ÿ�Կ� �����ȴ�.
		 *  �� ������ �������� �������� �ʴ´�.
		 */
		
		person3 = new Employee();
		System.out.println("person3.age = " + person3.age);
		
		Employee employee1 = (Employee)person3;
		System.out.println("employee1.age = " + employee1.age);
		
		/*
		 *  �ڽ� Ŭ�������� �θ� Ŭ������ ���ǵ��� ���� �޼ҵ带 ������ ���
		 *  �θ� Ŭ���� Ÿ������ �ڽ� ��ü�� �����ϸ� �޼ҵ��� ������ �� ����.
		 *  �����Ϸ��� �ٿ�ĳ������ �ʿ��ϴ�. 
		 */
		
		Person person4 = new Student();
		// person4.study(); �Ұ�
		
		if(person4 instanceof Student){
			Student student1 = (Student)person4; //�ٿ�ĳ����
			student1.study();
		}
	}
}
