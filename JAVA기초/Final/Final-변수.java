/*
 * final ����
 * ����� ���� �ٲ� �� ����.
 * ������ final�� ������ ����� �Ǿ� �ٲ� �� ����.
 */
class FinalVarClass{
	final int X;
	// final ���� static ���Ǿ� ���� ������ �����Ǹ� �ν��Ͻ� ������ ��
	// �� �����Ǵ� ��ü ������ ����� �νĵȴ�.
	public FinalVarClass(int x) {
		// �����ڿ��� final�� ���� �־��ش�.
		X = x;
	}
	
	static final int Y;
	//�ش� Ŭ���� ��ü���� ����� ���ȴ�.
	static{ 
		Y = 9;
	}
}
public class FinalVarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalVarClass fv1 = new FinalVarClass(10);
		// fv1.X = 10; ����� ���� �ٲ� �� ����.
		System.out.println("FinalVarTest.Y = " + FinalVarClass.Y);
	}

}
