/* 
 *  Continue문  
 *  label을 넣을 경우 해당 label로 이동한다.
 * */
public class Continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
aaa:		for(int i=1; i<=9; i++){
			for(int j=1; j<=9; j++){
				if(j == 5)
					continue aaa;
				System.out.println("i = " + i + ", j = " + j);
			}
			
			System.out.println();
		}
	}

}
