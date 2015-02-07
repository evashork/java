/*
 * super �� super()
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
		return "�̸� =" + name + ", dept = " + dept;
	}
}

class Sales extends Sawon{
	int commission;  // ������ �� ����
	
	public Sales(String name,String dept,int commission) { 
		
		super(name,dept); //�θ��� �޼ҵ��� ���� �����´�.
		this.commission = commission;
		System.out.println("child");
	}
	
	@Override
	String getInfo() {
		// �θ� Ŭ������ getInfo�� �����´�. this�� �ڱ� �ڽ�, super�� �θ�
		return super.getInfo() + ", commission = " + commission;
	}
}
public class SuperTest {
	public static void main(String[] args) {
		Sales sales = new Sales("aaa","a",1);
	}
}
