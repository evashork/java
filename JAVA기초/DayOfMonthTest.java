/* 
 *  ()년 ()월은 총 ()일까지 존재합니다.
 *  
 *  달값이 잘못 입력된 경우 - 달값이 잘못 입력되었습니다. 라고 출력
 *  윤년인 경우는 2월을 29일로 계산
 *  달의 일수는 시스템 달력을 보고 규칙을 지정함
 *  
 * */

import java.util.Scanner;


public class DayOfMonthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도 : ");
		int year = sc.nextInt();
		
		System.out.print("달 : ");
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
			System.out.println(year + "년 " + month + "월은 총" + day + "일까지 존재합니다.");
		}else{
			System.out.println("달값이 잘못 입력되었습니다");
		}
	}

}
