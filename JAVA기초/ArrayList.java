import java.util.ArrayList;


public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("aaa");
		al.add("bbb");
		al.add("ccc");
		al.add("ddd");
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		System.out.println("1�� �ε��� ��Ҹ� ggg�� �ٲ�");
		al.set(1, "ggg");
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		System.out.println("1�� �ε��� ��Ҹ� ����");
		al.remove(1);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}

}
