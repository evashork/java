/*
 * super 와 super()
 */

class Sawon{
	String name;
	String dept;
	
	public Sawon() {
		System.out.println("parent");
	}
	
	public Sawon(String name,String dept ) {
		this.name = name;
		this.dept = dept;
	}
	
	String getInfo(){
		return "이름 =" + name + ", dept = " + dept;
	}
}

class Sales extends Sawon{
	int commission;  // 수당이 더 붙음
	
	public Sales(String name,String dept,int commission) { 
		
		super(name,dept); //부모의 메소드의 값을 가져온다.
		this.commission = commission;
		System.out.println("child");
	}
	
	@Override
	String getInfo() {
		// 부모 클래스의 getInfo를 가져온다. this는 자기 자신, super는 부모
		return super.getInfo() + ", commission = " + commission;
	}
}
public class SuperTest {
	public static void main(String[] args) {
		Sales sales = new Sales("aaa","a",1);
	}
}
