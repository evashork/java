/*	
 *  반복문 for(){}
 */
public class ForTest {
	
	public static void main(String[] args) {
		//1부터 10까지 더하기
		int sum = 0;
		for(int i = 1; i <= 10; i++){
			sum += i;
		}
		System.out.println("sum = " + sum);
		
		//2씩 증가하여 더하기
		sum = 0;
		String expression = "";
		for(int i = 2; i <= 10; i=i+2){
			expression += ( i == 2) ? i : " + " + i; //삼항 연산자
			sum += i;
		}
		System.out.println(expression + " = " + sum);
	}

}
