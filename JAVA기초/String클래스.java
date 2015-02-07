/*
 * String 클래스
 * 문자열 클래스
 * 1.객체 생성 방법
 * 1-1.문자열 상수 이용방식 
 * String str1 = "aaa";
 * 새로운 String 객체를 생성할 때 사용하는 문자열로 이미 생성되어 있는 객체가 있으면
 * 기존 객체를 참조하고 새로 생성하지 않는다. 
 * 
 * 1-2.String 생성자 사용방식
 * String str3 = new String("aaa");
 * 생성자를 사용하여 String 객체를 생성할 때는 무조건 새로운 객체가 생성된다.
 * 
 * 2.String 객체는 불변성이 있다.
 * 한번 생성된 String 객체는 변경할 수 없다.
 * 문자열 수정이 계속 되는 작업에서는 메모리 소모가 많기 때문에 string을 쓰지 않는다.
 * 
 * StringBuilder,StringBuffer은 불변성이 없기때문에 string 대신에 사용한다.
 * 
 */
public class StringClass {
	public static void main(String[] args) {
		
		//1-1 둘다 값이 aaa
		String str1 = "aaa";
		String str2 = "aaa";
		
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println("str1 equals str2 : " + (str1.equals(str2)));
		
		//1-2 
		String str3 = new String("aaa");
		String str4 = new String("aaa");
		System.out.println("str1 == str3 : " + (str1 == str3));
		System.out.println("str3 == str4 : " + (str3 == str4));
		System.out.println("str3 equals str4 : " + (str3.equals(str4)));
		
		//2
		String str5 = "Java ";
		String str6 = str5.concat(" Fighting!!");
		System.out.println("str5 == st6 : " + (str5 == str6));
		
		StringBuffer sb = new StringBuffer("Java ");
		StringBuffer sb2 = sb.append(" Fighting!!");
		System.out.println("sb == sb2 : " + (sb == sb2));
		System.out.println(sb);
		
		
	}
}
