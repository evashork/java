import java.util.Scanner;

/*
 *  ���α׷��� ����Ǹ� �޴��� ����Ѵ�.
 *  1. �Ա�
 *  2. ���
 *  3. �ܾ���ȸ
 *  4. ���α׷� ����
 *  
 *  1,2 �� �����ϸ� ����� �ݾ��� �Է¹޾Ƽ� ó���Ѵ�.
 *  �ܾ���ȸ�� �����ϸ� ������ ���� �ܾ��� ����Ѵ�.
 *  "������ ���� �ܾ��� ()�� �Դϴ�."
 * 
 */
public class Banking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		Account myAccount = new Account();
		
		int money = 0;
		do{
			System.out.println("1. �Ա�");
			System.out.println("2. ���");
			System.out.println("3. �ܾ���ȸ");
			System.out.println("4. ���α׷� ����");
			
			System.out.print("�޴��Է� : ");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				System.out.print("�Աݾ� : ");
				money = sc.nextInt();
				myAccount.deposit(money);
				break;
				
			case 2:
				System.out.print("��ݾ� : ");
				money = sc.nextInt();
				myAccount.withdraw(money);
				break;
				
			case 3:
				System.out.println("�ܾ� : " + myAccount.getBalnce()); 
				break;	
				
			case 4:
				exit = true;
				break;		

			default:
				break;
			}
			
			System.out.println();
		}while(!exit);

	}

}
