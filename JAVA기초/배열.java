/*
 *  �迭 
 * */
public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �迭 ����
		int[] arr1; // ������Ÿ��[] �迭������;
		int arr2[]; // ������Ÿ�� �迭������[];
		
		// �ڹٿ��� �迭�� ��ü�̴�.
		// �迭 ��ü ����
		arr1 = new int[3];
		
		// �� �Ҵ�
		// �迭�� index�� 0���� �����Ѵ�.
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		
		// �� ��� 
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1[" + i + "] = " + arr1[i]);
		}
		
		// ���� �ʱ�ȭ �ϸ鼭 �迭 ��ü ����
		
		// ù��°
		int[] arr3 = {1,2,3,4};
		
		System.out.println("int[] arr3 = {1,2,3,4};");
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("arr3[" + i + "] = " + arr3[i]);
		}
		
		// �ι�°
		int[] arr4 = new int[]{3,4,5,6};
		
		System.out.println("int[] arr4 = {3,4,5,6};");
		for (int i = 0; i < arr4.length; i++) {
			System.out.println("arr4[" + i + "] = " + arr4[i]);
		}
		
		// �ΰ��� ����� ��������
		// 1. �迭����� ���� �κ��� �и��� ��� �ι�° ��ĸ� �����
		int[] arr5;
		// arr5 = {7,8,9,10}; ��� �ȵ�
		arr5 = new int[] {7,8,9,10};
		
		// 2. �޼ҵ��� ���ڰ����� �迭 ��ü�� �����ؼ� �ѱ� ���� �ι�° ��ĸ� ���
		// aaa({2,3}); ��� �ȵ�
		// aaa(new int[]{2,2}); ���
	}

}
