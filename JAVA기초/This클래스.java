/*
 * this()
 * �ڱ� �ڽ� Ŭ������ �ٸ� �����ڸ� ȣ��
 * Ŭ���� �ȿ� �����ڰ� ������ ���ǵ� �� ��� �����ڿ��� ���������� �����ؾ��ϴ� �۾���
 * Ư�� �����ڿ� �����ϰ� �ٸ� �����ڿ����� �ش� �����ڸ� ȣ���ؼ� ���� �۾��� 
 * ���������ν� �ߺ� �ڵ带 �����ϱ� ���ؼ� ����.
 * 
 * 
 * ����� Ŭ���� ����
 * 1.�̸��� �������� ������ ���� �⺻��
 * 2.������ �������� ������ 800���� ���ذ����� ����
 * 
 * ��Ģ
 * �ٸ� �������� ù ���๮���� �;� ��
 */

class Drink{
	String name;
	int price;
	
	public Drink() {
		// TODO Auto-generated constructor stub		
		// name = "��";
		// price = 800;
		
		this("��",800);
	}
	
	public Drink(String name) {
		// TODO Auto-generated constructor stub
		//this.name = name;
		//price = 800;
		
		this(name,800);
	}
	
	public Drink(int price) {
		// TODO Auto-generated constructor stub
		//name = "��";
		//this.price = price;
		this("��",price);
	}
	
	public Drink(String name,int price) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		
		//this.(name,price) �� �������� �ʴ´�.
	}
}

public class ThisContructTest {
	public static void main(String[] args) {
	}
}
