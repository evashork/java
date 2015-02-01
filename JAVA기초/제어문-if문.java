import java.util.Scanner;

/*
 * 1-1. 단순if문
 * if(조건식){
 * 	조건식이 true 일 경우 실행될 명령문;
 * }

 * 1-2. if ~ else 문
 * if(조건식){
 * 	조건식이 true 일 경우 실행될 명령문;
 * }else{
 * 	조건식이 false 일 경우 실핼될 명령문;
 * }
 * 
 * 1-3. 다중 if ~ else 문
 * if(조건식){
 * 	조건식이 true 일 경우 실행될 명령문;
 * }else if(조건식2){
 * 	조건식2가 true 일 경우 실행될 명령문;
 * }else{
 * 	조건식이 false 일 경우 실핼될 명령문;
 * }
 * 
 * if문 문제
 * -프로그램이 시작되면 연도를 입력받는다.
 * 연도:
 * -시스템은 입력 받은 연도가 윤년인지 아닌지 판단하여 결과를 출력한다.
 * 윤년인 경우 ()년은 윤년입니다.
 * 윤년이 아닌 경우 ()년은 윤년이 아닙니다.
 * 
 * 윤년규칙
 * - 연도를 4로 나누어 떨어지고 100으로 나누어 떨어지지 않는다.
 * - 연도를 400으로 나누어 떨어진다.
 * 
 * 2016년 윤년..
 * */
public class ifTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 9;
		
		// 단순if문
		if(x > 10){
			System.out.println("x는 10보다 크다");
		}
		
		// if ~ else 문
		if(x > 10){
			System.out.println("x는 10보다 크다");
		}else{
			System.out.println("x는 10보다 작다.");
		}
		
		// 다중 if ~ else 문
		if(x > 10){
			System.out.println("x는 10보다 크다");
		}else if(x > 8){
			System.out.println("x는 10보다 작다.");
		}else{
			System.out.println("x는 ???");
		}
		
		
		// if문 연습문제
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도 : ");
		int year = sc.nextInt();

		boolean isLeapYear = false;
		
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			isLeapYear = true;
		}
		
		if(isLeapYear){
			System.out.println(year + "는 윤년입니다.");
		}else{
			System.out.println(year + "는 윤년이 아닙니다.");
		}
	}

}
