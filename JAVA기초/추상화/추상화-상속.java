/*
 * �߻�Ŭ���� ���
 * 1-1. �ٸ� �߻� Ŭ������ ��� ���� �߻� Ŭ������ ��� �޴� Ŭ������ 
 * ��� ������ �ִ� ��� �߻� �޼ҵ带 �� �����ؾ� �Ѵ�
 */
abstract class AbClass1{
	abstract void abMethod1();
}

abstract class AbClass2 extends AbClass1{
	abstract void abMethod2();
}

class GeneralCalss extends AbClass2{
	@Override
	void abMethod1() {
		// 1.1
		
	}
	
	@Override
	void abMethod2() {
		// 1.1
		
	}
}
public class AbstractTest2 {

}
