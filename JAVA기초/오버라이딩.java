/*
 *  �������̵�
 *  �θ�Ŭ�������� ���ǵ� �޼ҵ带 �ڽ� Ŭ�������� ������ �ϴ� ��
 *  �������Ѱ� ���� Ÿ���� ���ƾ� �Ѵ�.
 * 
 *  �θ� Ŭ������ ���� �� ������ �޼ҵ带 �ڽ� Ŭ�������� �������ϸ�
 *  �θ� Ŭ�������� �����ǵ� ������ �޼ҵ�� �νĵ��� �ʴ´�.
 */
class Super{
	int money = 30;
	void parentMethod(){
		System.out.println("parent method");
	}
}

class Sub extends Super{
	String money = "30��";
	@Override  // ��Ʈ�� �����̽�
	void parentMethod() {
		// TODO Auto-generated method stub
		System.out.println("overriding method");
	}
}

public class OverRiding {
	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.parentMethod();
		sub.money = "90��";
	}
}
