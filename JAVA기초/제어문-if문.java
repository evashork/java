import java.util.Scanner;

/*
 * 1-1. �ܼ�if��
 * if(���ǽ�){
 * 	���ǽ��� true �� ��� ����� ��ɹ�;
 * }

 * 1-2. if ~ else ��
 * if(���ǽ�){
 * 	���ǽ��� true �� ��� ����� ��ɹ�;
 * }else{
 * 	���ǽ��� false �� ��� ���۵� ��ɹ�;
 * }
 * 
 * 1-3. ���� if ~ else ��
 * if(���ǽ�){
 * 	���ǽ��� true �� ��� ����� ��ɹ�;
 * }else if(���ǽ�2){
 * 	���ǽ�2�� true �� ��� ����� ��ɹ�;
 * }else{
 * 	���ǽ��� false �� ��� ���۵� ��ɹ�;
 * }
 * 
 * if�� ����
 * -���α׷��� ���۵Ǹ� ������ �Է¹޴´�.
 * ����:
 * -�ý����� �Է� ���� ������ �������� �ƴ��� �Ǵ��Ͽ� ����� ����Ѵ�.
 * ������ ��� ()���� �����Դϴ�.
 * ������ �ƴ� ��� ()���� ������ �ƴմϴ�.
 * 
 * �����Ģ
 * - ������ 4�� ������ �������� 100���� ������ �������� �ʴ´�.
 * - ������ 400���� ������ ��������.
 * 
 * 2016�� ����..
 * */
public class ifTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 9;
		
		// �ܼ�if��
		if(x > 10){
			System.out.println("x�� 10���� ũ��");
		}
		
		// if ~ else ��
		if(x > 10){
			System.out.println("x�� 10���� ũ��");
		}else{
			System.out.println("x�� 10���� �۴�.");
		}
		
		// ���� if ~ else ��
		if(x > 10){
			System.out.println("x�� 10���� ũ��");
		}else if(x > 8){
			System.out.println("x�� 10���� �۴�.");
		}else{
			System.out.println("x�� ???");
		}
		
		
		// if�� ��������
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int year = sc.nextInt();

		boolean isLeapYear = false;
		
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			isLeapYear = true;
		}
		
		if(isLeapYear){
			System.out.println(year + "�� �����Դϴ�.");
		}else{
			System.out.println(year + "�� ������ �ƴմϴ�.");
		}
	}

}
