import java.util.Scanner;
/*
 *  switch는 경우의 수가 많을 때 사용된다. if문과 기능은 동일 하다.
 *  switch(변수){
 *  	case 값:
 *  		실행
 *  		break;
 *  	default:
 *  		실행
 *  		break;
 *  }
 *  
 *  break를 생략하면 다시 다음으로 넘어간다.
 * */

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("피연산자1 : ");
		int mat1 = sc.nextInt();
		System.out.print("연산자 : ");
		String cal = sc.next();
		System.out.print("피연산자2 : ");
		int mat2 = sc.nextInt();
		int result = 0;
		Boolean isRightOperation = true;

		switch (cal) {
		case "+":
			result = mat1 + mat2;
			break;
		case "-":
			result = mat1 - mat2;
			break;
		case "*":
			result = mat1 * mat2;
			break;
		case "/":
			result = mat1 / mat2;
			break;
		default:
			isRightOperation = false;
			break;
		}
		
		/* if문으로 했을 경우
		 * if( cal.equals("+") ){
			result = mat1 + mat2;
		}else if( cal.equals("-") ){
			result = mat1 - mat2;
		}else if( cal.equals("*") ){
			result = mat1 * mat2;
		}else if( cal.equals("/") ){
			result = mat1 / mat2;
		}else{
			isRightOperation = false;
		}*/

		if(isRightOperation){
			System.out.println(mat1 + cal + mat2 + "=" + result);
		}else{
			System.out.println("연산자가 잘 못 입력 되었습니다.");
		}

	}

}
