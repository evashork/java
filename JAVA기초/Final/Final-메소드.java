/*
 * Final 메소드
 * 메소드 앞에 final이 지정되면 오버라이딩 할 수 없다
 */
class FinalSuper{
	final void finalMethod(){
		System.out.println("final Method");
	}
}
class FinalSub extends FinalSuper{
	//오버라이딩 불가능
}

public class FinalMethodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
