import java.util.Scanner;
/*
 *  do while���� �̿��� ���� ���߱�
 * 
 * */

public class NumberInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int answer = (int)(Math.random() * 100) + 1;
		// Math.random() : 0.0���� ũ�ų� ���� 1.0 ���� ���� double ���� ���� �߻�
		// 1���� 100������ ���� ����
		
		int input = 0;
		boolean isStop = false;
		
		do {
			System.out.println("���ڸ� �Է��ϼ���");
			System.out.print("���� : ");
			input = sc.nextInt();
			
			if(input > answer){
				System.out.println("�� ���� ���� �Է��ϼ���");
			}
			else if(input < answer){
				System.out.println("�� ū ���� �Է��ϼ���");
			}else{
				System.out.println("������ϴ�.");
				isStop = true;
			}
			
		} while (!isStop);
	}

}
