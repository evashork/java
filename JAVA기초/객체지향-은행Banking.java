import java.util.Scanner;

/*
 *  프로그램이 실행되면 메뉴를 출력한다.
 *  1. 입금
 *  2. 출금
 *  3. 잔액조회
 *  4. 프로그램 종료
 *  
 *  1,2 를 선택하면 입출금 금액을 입력받아서 처리한다.
 *  잔액조회를 선택하면 다음과 같이 잔액을 출력한다.
 *  "계좌의 현재 잔액은 ()원 입니다."
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
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 잔액조회");
			System.out.println("4. 프로그램 종료");
			
			System.out.print("메뉴입력 : ");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				System.out.print("입금액 : ");
				money = sc.nextInt();
				myAccount.deposit(money);
				break;
				
			case 2:
				System.out.print("출금액 : ");
				money = sc.nextInt();
				myAccount.withdraw(money);
				break;
				
			case 3:
				System.out.println("잔액 : " + myAccount.getBalnce()); 
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
