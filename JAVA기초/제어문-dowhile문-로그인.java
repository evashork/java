import java.util.Scanner;


public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbId = "java";
		String dbPwd = "java";
		Scanner sc = new Scanner(System.in);
		int loginResult;  // �α��λ���
		
		// ����ڷκ��� ������ �Է�
		do{
			System.out.print("���̵� : ");
			String userId = sc.next();
			System.out.print("��й�ȣ : ");
			String userPwd = sc.next();
		
			// ����
			if(!dbId.equals(userId)){
				loginResult = 1;
				//���̵� ���� ���� ���
			}else if(!dbPwd.equals(userPwd)){
				loginResult = 2;
				//���̵�� ������ ��й�ȣ�� Ʋ�� ���
			}else{
				loginResult = 3;
				//��� �� ������ ���
			}
		
			if(loginResult == 1){
				System.out.println("���̵� �����ϴ�.");
			}else if(loginResult == 2){
				System.out.println("��й�ȣ�� Ʋ���ϴ�.");
			}else{
				System.out.println("��������");
			}
		}while (loginResult != 3);	
	}

}
