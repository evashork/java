/*
 * ������ �ڽ�Ŭ����
 */
public class Student extends Person {
	String schooltype;
	int grade;
	
	@Override
	void shoeSleepStyle() {
		System.out.println("�л����� ���齺Ÿ���� ��Ģ���̴�.");
	}
	
	//�θ� Ŭ������ ���ǵ��� �ʴ� �޼ҵ�
	void study(){
		System.out.println("���θ� �Ѵ�.");
	}
}
