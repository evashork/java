/*
 * String Ŭ����
 * ���ڿ� Ŭ����
 * 1.��ü ���� ���
 * 1-1.���ڿ� ��� �̿��� 
 * String str1 = "aaa";
 * ���ο� String ��ü�� ������ �� ����ϴ� ���ڿ��� �̹� �����Ǿ� �ִ� ��ü�� ������
 * ���� ��ü�� �����ϰ� ���� �������� �ʴ´�. 
 * 
 * 1-2.String ������ �����
 * String str3 = new String("aaa");
 * �����ڸ� ����Ͽ� String ��ü�� ������ ���� ������ ���ο� ��ü�� �����ȴ�.
 * 
 * 2.String ��ü�� �Һ����� �ִ�.
 * �ѹ� ������ String ��ü�� ������ �� ����.
 * ���ڿ� ������ ��� �Ǵ� �۾������� �޸� �Ҹ� ���� ������ string�� ���� �ʴ´�.
 * 
 * StringBuilder,StringBuffer�� �Һ����� ���⶧���� string ��ſ� ����Ѵ�.
 * 
 */
public class StringClass {
	public static void main(String[] args) {
		
		//1-1 �Ѵ� ���� aaa
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
