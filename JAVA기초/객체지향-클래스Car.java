/*
 *  ��ü ���� ���
 *  ���� 
 *  1. Ư¡ ���� �� �ִ� ��� ���� �� ��ü �̴�.
 *  2. ��ü�� Ư���� ������� ǥ���� �� �ִ�.
 *  	�ڵ��� - Ư��(�ڵ�����,����,�ӵ�) ���(�޸���,�����,�ӵ��� �ø���)
 *  
 *  ��ü�� ���α׷������� �߻�ȭ ��Ų ���� Ŭ����
 *  ��ü ---> Ŭ����
 *  Ư�� ---> �Ӽ�(����,���)
 *  ��� ---> �޼ҵ�
 */
//Ŭ����
public class Car {
	//�Ӽ�
	String name;
	int velocity;
	String company;
	String color;
	
	//�޼ҵ�
	/*
	 * ����Ÿ�� �޼ҵ��̸�(�Ķ���� - ������Ÿ�� ������){
	 * 	��ɹ�;
	 * }
	 * 
	 * �޼ҵ� ���� �� �������ִ� ���� ������ ���� ���� void�� �����Ѵ�.
	 */
	
	void run(){
		System.out.println("�޸���.");
	}
	
	void stop(){
		System.out.println("�����.");
	}
	
	void upSpeed(){
		velocity += 1;
	}
	
	void upSpeed(int amount){
		velocity += amount;
	}
	
	void downSpeed(){
		velocity -= 1;
	}
	
	void downSpeed(int amount){
		velocity -= amount;
	}
}
