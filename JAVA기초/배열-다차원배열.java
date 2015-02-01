/*
 *  이차원배열
 *  
 *  배열 객체를 생성할 때 초기화 시키지 않으면 
 *  저장하는 데이터 타입의 기본값으로 자동 초기화 된다.
 *  정수형의 기본값은 0
 *  실수형의 기본값은 0.0
 *  문자형의 기본값은 ' '
 *  논리형의 기본값은 false
 *  객체형의 기본값은 null
 *  
 */	
public class DoubleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 선언
		int[][] arr1;
		int[] arr2[];
		int arr3[][];
		
		arr1 = new int[3][3];
		// arr1[0] = 9 허용안됨
		arr1[0] = new int[3]; // 가능
		arr1[0][0] = 9;
		
		for(int i = 0; i < arr1.length; i++){
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
				
		//값을 초기화 하면서 배열 객체 생성
		//1.
		int[][] arr5 = {{1,2},{3,4}};
		
		System.out.println("int[][] arr5 = {{1,2},{3,4}}");
		for(int i = 0; i < arr5.length; i++){
			for (int j = 0; j < arr5[i].length; j++) {
				System.out.print(arr5[i][j] + " ");
			}
			System.out.println();
		}
		
		//2.
		int[][] arr6 = new int[][] {{1,2},{3,4}};
		
		System.out.println("int[][] arr6 = new int[][] {{1,2},{3,4}};");
		for(int i = 0; i < arr6.length; i++){
			for (int j = 0; j < arr6[i].length; j++) {
				System.out.print(arr6[i][j] + " ");
			}
			System.out.println();
		}
	}

}
