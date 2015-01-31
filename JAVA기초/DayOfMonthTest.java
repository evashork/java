/* 
 *  ()�� ()���� �� ()�ϱ��� �����մϴ�.
 *  
 *  �ް��� �߸� �Էµ� ��� - �ް��� �߸� �ԷµǾ����ϴ�. ��� ���
 *  ������ ���� 2���� 29�Ϸ� ���
 *  ���� �ϼ��� �ý��� �޷��� ���� ��Ģ�� ������
 *  
 * */

import java.util.Scanner;


public class DayOfMonthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int year = sc.nextInt();
		
		System.out.print("�� : ");
		int month = sc.nextInt();
		
		int day;

		boolean isLeapYear = false;
		boolean isMonth = false;
		
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			isLeapYear = true;
		}
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 2:
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		default:
			isMonth = false;
			break;
		}
		
		if(isLeapYear){
			System.out.println(year + "�� " + month + "���� ��" + day + "�ϱ��� �����մϴ�.");
		}else{
			System.out.println("�ް��� �߸� �ԷµǾ����ϴ�");
		}
	}

}
