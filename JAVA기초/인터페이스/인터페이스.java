/*
 *  �������̽�
 */
interface Interface{
	int c = 1;
	//�������̽����� ������ �����ϸ� ���� �տ� static final�� �ڵ� �����ȴ�. �� ����� �ȴ�.
	
	void aaa();
	//�������̽����� �Ϲ� �޼ҵ带 ���� �� �� ���� ���� �߻� �޼ҵ常 �����ϴ�. �ڵ����� abstract�� �ٴ´�. 
}

class Interface1Impl implements Interface{
	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
}
public class InterfaceTest1 {

	public static void main(String[] args) {
		Interface1Impl aa = new Interface1Impl();
	}

}
