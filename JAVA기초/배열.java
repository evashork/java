/*
 *  배열 
 * */
public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 배열 선언
		int[] arr1; // 데이터타입[] 배열변수명;
		int arr2[]; // 데이터타입 배열변수명[];
		
		// 자바에서 배열은 객체이다.
		// 배열 객체 생성
		arr1 = new int[3];
		
		// 값 할당
		// 배열의 index는 0부터 시작한다.
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		
		// 값 사용 
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i]);
		}
		
		// 값을 초기화 하면서 배열 객체 생성
		
		// 첫번째
		int[] arr3 = {1,2,3,4};
		
		System.out.println("int[] arr3 = {1,2,3,4};");
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("arr3[" + i + "] = " + arr3[i]);
		}
		
		// 두번째
		int[] arr4 = new int[]{3,4,5,6};
		
		System.out.println("int[] arr4 = {3,4,5,6};");
		for (int i = 0; i < arr4.length; i++) {
			System.out.println("arr4[" + i + "] = " + arr4[i]);
		}
		
		// 두가지 방식의 차이점은
		// 1. 배열선언과 생성 부분이 분리될 경우 두번째 방식만 허용함
		int[] arr5;
		// arr5 = {7,8,9,10}; 허용 안됨
		arr5 = new int[] {7,8,9,10};
		
		// 2. 메소드의 인자값으로 배열 객체를 생성해서 넘길 때는 두번째 방식만 허용
		// aaa({2,3}); 허용 안됨
		// aaa(new int[]{2,2}); 허용
	}

}
