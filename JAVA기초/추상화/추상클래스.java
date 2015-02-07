/*
 * �߻� Ŭ�������� �Ϲ� ������ �Ϲ� �޼ҵ尡 ���� �� �� ������
 * �߻� �޼ҵ尡 �ϳ��� �����ϸ� �ش� Ŭ������ �߻� Ŭ������ �Ǿ�� �ϰ�, abstract ���Ǿ
 * �����Ǿ�� �Ѵ�.
 * �߻� Ŭ������ ��ü�� ������ �� ����.
 * �߻� Ŭ������ ����� �ڽ� Ŭ�������� �߻� Ŭ������ �߻� �޼ҵ带 �ݵ�� ������ �� ���Ǿ�� �Ѵ�.
 * 
 * �߻� Ŭ������ �ݵ�� �����ǰ� �ʿ��� �� ���δ�.
 */

abstract class AbstractClass{
	//�Ϲ� ����
	int age;
	
	//�Ϲ� �޼ҵ�
	void generalMethod(){
		System.out.println("�Ϲ� �޼ҵ�");
	}
	
	//�߻� �޼ҵ�
	//���Ǻδ� ���������� �����ΰ� �������� �ʴ� �޼ҵ�
	//�޼ҵ� ���� �ο� abstract�� �����Ǿ�� ��.
	abstract void abstractMethod();
}

class AbstractClassChild extends AbstractClass{
	@Override
	void abstractMethod() {
		
	}
}

public class AbstractTest1 {
	
	public static void main(String[] args) {
		AbstractClass ac = new AbstractClassChild();
	}
	
}
