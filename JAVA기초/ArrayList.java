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
		
		System.out.println("1번 인덱스 요소를 ggg로 바꿈");
		al.set(1, "ggg");
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		System.out.println("1번 인덱스 요소를 제거");
		al.remove(1);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}

}
