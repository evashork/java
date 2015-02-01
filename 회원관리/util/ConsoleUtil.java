package util;

import java.lang.reflect.Member;
import java.util.Scanner;

import VO.MemberVO;

public class ConsoleUtil {

	// 1.ȸ�����
	public MemberVO getNewMember(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====ȸ�����====");
		System.out.print("���̵� : ");
		String id = sc.next();
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("�̸��� : ");
		String email = sc.next();
		System.out.print("���� : ");
		String nation = sc.next();
		System.out.print("���� : ");
		String gender = sc.next();
		System.out.print("���� : ");
		int age = sc.nextInt();
		return new MemberVO(id, name, email, nation, gender, age);
		//ctrl ����
	}

	public void printRegistSucessMessage(String id) {
		// TODO Auto-generated method stub
		System.out.println(id + " ȸ������ ������ �߰� �Ǿ����ϴ�.");	
	}
	
	public void printRegistFailMessage(String id) {
		// TODO Auto-generated method stub
		System.out.println(id + " ȸ������ ������ �߰� �����߽��ϴ�.");	
	}
	
	// 2.ȸ�������ȸ
	public void printMemberArray(MemberVO[] memberArray) {
		// TODO Auto-generated method stub
		if(memberArray.length == 0){
			System.out.println("��ϵ� ȸ���� �������� �ʽ��ϴ�.");
		}else{
			for (int i = 0; i < memberArray.length; i++) {
				System.out.print("���̵� : " + memberArray[i].getId() +
				" �̸� : " + memberArray[i].getName() +
				" �̸��� : " + memberArray[i].getEmail() +
				" ���� : " + memberArray[i].getNation() +
				" ���� : " + memberArray[i].getGender() +
				" ���� : " + memberArray[i].getAge());
				System.out.println();
			}
		}
	}
	
	// 3. ���̵� �Է�
	public String getId(Scanner sc, String msgKind) {
		System.out.print(msgKind + " ���̵� �Է� : ");
		return sc.next();
	}
	
	// 3. ���̵� ����
	public void printIdNotFoundMessage(String id) {
		System.out.println(id + " ȸ���� �������� �ʽ��ϴ�.");
	}

	public MemberVO getUpdateMember(Scanner sc, MemberVO oldMember) {
		System.out.println("====ȸ�����====");
		System.out.print("���� �̸� : " + oldMember.getName());
		String name = sc.next();
		System.out.print("���� �̸��� : "  + oldMember.getEmail());
		String email = sc.next();
		System.out.print("���� ���� : " + oldMember.getNation());
		String nation = sc.next();
		System.out.print("���� ���� : " + oldMember.getGender());
		String gender = sc.next();
		System.out.print("���� ���� : " + oldMember.getAge());
		int age = sc.nextInt();
		return new MemberVO(oldMember.getId(), name, email, nation, gender, age);
	}
}
