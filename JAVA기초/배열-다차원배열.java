/*
 *  �������迭
 *  
 *  �迭 ��ü�� ������ �� �ʱ�ȭ ��Ű�� ������ 
 *  �����ϴ� ������ Ÿ���� �⺻������ �ڵ� �ʱ�ȭ �ȴ�.
 *  �������� �⺻���� 0
 *  �Ǽ����� �⺻���� 0.0
 *  �������� �⺻���� ' '
 *  ������ �⺻���� false
 *  ��ü���� �⺻���� null
 *  
 */	
public class DoubleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �迭 ����
		int[][] arr1;
		int[] arr2[];
		int arr3[][];
		
		arr1 = new int[3][3];
		// arr1[0] = 9 ���ȵ�
		arr1[0] = new int[3]; // ����
		arr1[0][0] = 9;
		
		for(int i = 0; i < arr1.length; i++){
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
				
		//���� �ʱ�ȭ �ϸ鼭 �迭 ��ü ����
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
