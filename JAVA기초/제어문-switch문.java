import java.util.Scanner;
/*
 *  switch�� ����� ���� ���� �� ���ȴ�. if���� ����� ���� �ϴ�.
 *  switch(����){
 *  	case ��:
 *  		����
 *  		break;
 *  	default:
 *  		����
 *  		break;
 *  }
 *  
 *  break�� �����ϸ� �ٽ� �������� �Ѿ��.
 * */

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("�ǿ�����1 : ");
		int mat1 = sc.nextInt();
		System.out.print("������ : ");
		String cal = sc.next();
		System.out.print("�ǿ�����2 : ");
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
		
		/* if������ ���� ���
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
			System.out.println("�����ڰ� �� �� �Է� �Ǿ����ϴ�.");
		}

	}

}
