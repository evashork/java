/*
 *  다차원배열 문제
 *  
 *  1 0 0 0
 *  0 1 0 0
 *  0 0 1 0
 *  0 0 0 1
 *  
 * */
public class DoubleArray2 {
	public static void main(String[] args) {
		int[][] arr1;
		
		arr1 = new int[4][4];
		
		for(int i = 0; i < arr1.length; i++){
			for (int j = 0; j < arr1[i].length; j++) {
				if( i == j){
					arr1[i][j] = 1;
				}
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		
		/*
		 *  다차원배열 문제 2
		 *  
		 *  1 1 1 1 (0,0)(0,0)
		 *  1 1 0 1 (1,2)
		 *  1 0 1 1 (2,1)
		 *  1 1 1 1 (3,1)
		 *  
		 * */
		
		System.out.println("");
		
		int[][] arr2;
		
		arr2 = new int[4][4];
		
		// 값 할당하는 부분
		for(int i = 0; i < arr2.length; i++){
			for (int j = 0; j < arr2[i].length; j++) {
				if( i == j || i == 0 || i == arr2.length - 1 || j == 0 || j ==arr2.length - 1){
					arr2[i][j] = 1;
				}
			}
		}
		
		// 값 출력하는 부분
		for(int i = 0; i < arr2.length; i++){
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
