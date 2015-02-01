import java.util.Scanner;
/*
 *  do while문을 이용한 숫자 맞추기
 * 
 * */

public class NumberInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int answer = (int)(Math.random() * 100) + 1;
		// Math.random() : 0.0보다 크거나 같고 1.0 보다 작은 double 형의 난수 발생
		// 1부터 100까지의 값을 생성
		
		int input = 0;
		boolean isStop = false;
		
		do {
			System.out.println("숫자를 입력하세요");
			System.out.print("숫자 : ");
			input = sc.nextInt();
			
			if(input > answer){
				System.out.println("더 작은 수를 입력하세요");
			}
			else if(input < answer){
				System.out.println("더 큰 수를 입력하세요");
			}else{
				System.out.println("맞췄습니다.");
				isStop = true;
			}
			
		} while (!isStop);
	}

}
