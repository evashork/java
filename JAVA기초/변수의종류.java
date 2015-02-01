/*
 *  �ڹٿ��� ������ "{}" ���� ���� ������ ������ �� �ִ�.
 * 
 */
public class VarKindTest {
	int memberVar;
	// 1.�ɹ� ���� : Ŭ���� ������ ����� ����
	// 1-1. �ʱ�ȭ ���� : ��ü�� ������ �� �� ��ü���� �ʱ�ȭ
	// 1-2. ������ ������ �� ���� �Ҵ����� ������ �����Ϸ��� �ڵ����� �⺻���� �Ҵ�
	
	static int staticVar;
	// 2.static ����
	// 2-1. �ʱ�ȭ ���� : Ŭ������ �ε��� �� Ŭ���� ������ �ʱ�ȭ
	// 2-2. �ش� Ŭ������ ����ؼ� ������ ��� ��ü���� ������.
	// 2-3. static ������ ��ü�� �������� �ʰ� Ŭ���� �̸������ε� ������ �� �ִ�.
	
	void testMethod(int parm){
		// parm �Ķ���� ���� : �޼ҵ� ����� ������ �� �ʿ��� ���� �޴� ������ �ϴ� ����
		// Ư¡�� ���ú����� ����
	}
	
	void memberMethod1(){
		// �ɹ����ҵ� : Ŭ���� ��ü�� �����ؾ� ������ �� �ִ�.
	}
	
	void memberMethod2(){
		// �ɹ����ҵ� : Ŭ���� ��ü�� �����ؾ� ������ �� �ִ�.
	}
	
	static void staticMethod1(){
		// 3. static �޼ҵ� : ��ü�� �������� �ʾƵ� Ŭ���� �̸����� ���� ������.
		
	}
	
	static void staticMethod2(){
		// int x = memberVar;
		// static �޼ҵ忡���� �ɹ������� ����� �� ����.
				
		int x = staticVar;
		staticMethod1();
		// static �޼ҵ�� static������ ����� �� �ִ�. 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1-2. ����
		VarKindTest vt1 = new VarKindTest();
		System.out.println("vt1.memberVar = " + vt1.memberVar);
		
		// 1-2. ����
		VarKindTest vt2 = new VarKindTest();
		vt1.memberVar = 1;
		System.out.println("vt1.memberVar = " + vt1.memberVar);
		System.out.println("vt2.memberVar = " + vt2.memberVar);
		
		// 2-2. ����
		vt1.staticVar = 100;
		System.out.println("vt1.staticVar = " + vt1.staticVar);
		System.out.println("vt2.staticVar = " + vt2.staticVar);
		
		// 2-3. ����
		System.out.println("VarKindTest.staticVar = " + staticVar);
		
		int localVar;
		// ���ú���-��������
		// �ʱ�ȭ ���� : �޼ҵ尡 ����� �� �ʱ�ȭ �Ǿ��ٰ� �޼ҵ� �����ϸ� �Ҹ�ȴ�.
		// ���� ���� �� ���� �Ҵ� ���� ������ ������ ����, ����ϱ� ���� �ݵ�� ���� �Ҵ�Ǿ�� �Ѵ�.
		
		int x = 5;
		int y = 6;
		if(x > y){
			localVar = 10;
		}else{
			localVar = 10; // ���� �Ҵ�
		}
		
		System.out.println(localVar);
		
		// 3. ����
		VarKindTest.staticMethod1();
		
	}

}
