/*	
 *  �ݺ��� for(){}
 */
public class ForTest {
	
	public static void main(String[] args) {
		//1���� 10���� ���ϱ�
		int sum = 0;
		for(int i = 1; i <= 10; i++){
			sum += i;
		}
		System.out.println("sum = " + sum);
		
		//2�� �����Ͽ� ���ϱ�
		sum = 0;
		String expression = "";
		for(int i = 2; i <= 10; i=i+2){
			expression += ( i == 2) ? i : " + " + i; //���� ������
			sum += i;
		}
		System.out.println(expression + " = " + sum);
	}

}
