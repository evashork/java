/*
 *  while��
 */
public class WhileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1���� 10���� ���ϱ�
		int sum = 0;
		int t = 1;
		
		while ( t <= 10) {
			sum += t;
			t++;
		}
		
		System.out.println("sum = " + sum);
		
		//���� while��
		
		// #
		// ##
		// ###
		// ####
		// #####
		// #####
		// ####
		// ###
		// ##
		// #
		
		int i = 1;
		while(i<=10){
			
			if(i <= 5){
				int j = 1;
				while(j <= i){
					System.out.print("#");
					j++;
				}
			}else{
				int j = 1;
				while(j <= 11 - i){
					System.out.print("#");
					j++;
				}
			}
			
			i++;
			System.out.println();
		}
	}

}
