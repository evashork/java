import java.util.Scanner;


public class ScannerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : "); // println 줄바꿈,
		String name = sc.next();		
		System.out.println("name = " + name);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.println("age = " + age);
	}

}
