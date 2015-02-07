package UI;

import java.util.Scanner;

import VO.MemberVO;
import svc.MemberService;
import util.ConsoleUtil;

public class MemberUI {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MemberService memberService = new MemberService();
		ConsoleUtil consoleUtil = new ConsoleUtil();
		boolean isStop = false;
		int menu = -1; // ���ú����� �ݵ�� �ʱ�ȭ�� �ʿ�
		String id = null; // ȸ���������� �� ������ ����
		//�޼ҵ� ���� ��� ctrl + 1 
		
		do{
			System.out.println("===ȸ������===");
			System.out.println("1.ȸ�����"); //C(Create)
			System.out.println("2.ȸ�������ȸ"); //R(Read)
			System.out.println("3.ȸ����������"); //U(Update)
			System.out.println("4.ȸ����������"); //D(Delete)
			System.out.println("5.���α׷�����");
			
			System.out.print("�޴��Է� : ");
			menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				MemberVO newMember = consoleUtil.getNewMember(sc);
				// isRegistSuccess ����� ��ϵǾ����� Ȯ��
				boolean isRegistSuccess = memberService.registMember(newMember);
				if (isRegistSuccess) {
					consoleUtil.printRegistSucessMessage(newMember.getId());
				}
				else{
					consoleUtil.printRegistFailMessage(newMember.getId());
				}
				break;
				
			case 2:
				MemberVO[] memberArray = memberService.getMemberArray();
				consoleUtil.printMemberArray(memberArray);
				break;
				
			case 3:
				id = consoleUtil.getId(sc,"������ ");
				// ������ ���̵� ã��
				MemberVO oldMember = memberService.getOldMember(id);
				if(oldMember == null){
					consoleUtil.printIdNotFoundMessage(id);
				}else{
					MemberVO updateMember = consoleUtil.getUpdateMember(sc,oldMember);
					memberService.modifyMember(updateMember);
				}
				break;
				
			case 4:
				id = consoleUtil.getId(sc, "������ "); // ������ id�� �Է¹޴´�.
				boolean isRemoveSuccess = memberService.removeMember(id); // ���� ���� ���θ� Ȯ��
				
				if(isRemoveSuccess){
					consoleUtil.printRemoveSuccessMessage(id); // ���� �޼��� 
				}else{
					consoleUtil.printRemoveFalseMessage(id);  // ���� �޼���
				}
				break;

			default:
				break;
			}
			
		}while(!isStop);
	}

}
