/*
 * final 변수
 * 상수는 값을 바꿀 수 없다.
 * 변수에 final이 붙으면 상수가 되어 바꿀 수 없다.
 */
class FinalVarClass{
	final int X;
	// final 예약어가 static 예악어 없이 변수에 지정되면 인스턴스 상수라고 함
	// 즉 생성되는 객체 단위로 상수가 인식된다.
	public FinalVarClass(int x) {
		// 생성자에서 final에 값을 넣어준다.
		X = x;
	}
	
	static final int Y;
	//해당 클래스 전체에서 상수로 사용된다.
	static{ 
		Y = 9;
	}
}
public class FinalVarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalVarClass fv1 = new FinalVarClass(10);
		// fv1.X = 10; 상수는 값을 바꿀 수 없다.
		System.out.println("FinalVarTest.Y = " + FinalVarClass.Y);
	}

}
