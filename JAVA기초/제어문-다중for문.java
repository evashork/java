/*
 *  ¥Ÿ¡ﬂforπÆ
 */
public class DoubleForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= 5; j++){
				System.out.print("i = " + i + ", j = " + j + " ");
			}
			System.out.println();
		}
		
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
		
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= i; j++){
				System.out.print("#");
			}
			System.out.println();
		}
		
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= 6 - i; j++){
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
