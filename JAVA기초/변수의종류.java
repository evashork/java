/*
 *  자바에서 변수는 "{}" 으로 묶인 곳에서 선언할 수 있다.
 * 
 */
public class VarKindTest {
	int memberVar;
	// 1.맴버 변수 : 클래스 영역에 선언된 변수
	// 1-1. 초기화 시점 : 객체를 생성할 때 각 객체마다 초기화
	// 1-2. 변수를 선언할 때 값을 할당하지 않으면 컴파일러가 자동으로 기본값을 할당
	
	static int staticVar;
	// 2.static 변수
	// 2-1. 초기화 시점 : 클래스가 로딩될 때 클래스 영역에 초기화
	// 2-2. 해당 클래스를 사용해서 생성된 모든 객체에서 공유됨.
	// 2-3. static 변수는 객체를 생성하지 않고 클래스 이름만으로도 접근할 수 있다.
	
	void testMethod(int parm){
		// parm 파라미터 변수 : 메소드 기능을 실행할 때 필요한 값을 받는 역할을 하는 변수
		// 특징은 로컬변수와 동일
	}
	
	void memberMethod1(){
		// 맴버베소드 : 클래스 객체를 생성해야 접근할 수 있다.
	}
	
	void memberMethod2(){
		// 맴버베소드 : 클래스 객체를 생성해야 접근할 수 있다.
	}
	
	static void staticMethod1(){
		// 3. static 메소드 : 객체를 생성하지 않아도 클래스 이름으로 접근 가능함.
		
	}
	
	static void staticMethod2(){
		// int x = memberVar;
		// static 메소드에서는 맴버변수를 사용할 수 없다.
				
		int x = staticVar;
		staticMethod1();
		// static 메소드는 static변수는 사용할 수 있다. 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1-2. 예제
		VarKindTest vt1 = new VarKindTest();
		System.out.println("vt1.memberVar = " + vt1.memberVar);
		
		// 1-2. 예제
		VarKindTest vt2 = new VarKindTest();
		vt1.memberVar = 1;
		System.out.println("vt1.memberVar = " + vt1.memberVar);
		System.out.println("vt2.memberVar = " + vt2.memberVar);
		
		// 2-2. 예제
		vt1.staticVar = 100;
		System.out.println("vt1.staticVar = " + vt1.staticVar);
		System.out.println("vt2.staticVar = " + vt2.staticVar);
		
		// 2-3. 예제
		System.out.println("VarKindTest.staticVar = " + staticVar);
		
		int localVar;
		// 로컬변수-지역변수
		// 초기화 시점 : 메소드가 실행될 때 초기화 되었다가 메소드 종료하면 소멸된다.
		// 변수 선언 시 값을 할당 하지 않으면 컴파일 오류, 사용하기 전에 반드시 값이 할당되어야 한다.
		
		int x = 5;
		int y = 6;
		if(x > y){
			localVar = 10;
		}else{
			localVar = 10; // 값을 할당
		}
		
		System.out.println(localVar);
		
		// 3. 예제
		VarKindTest.staticMethod1();
		
	}

}
