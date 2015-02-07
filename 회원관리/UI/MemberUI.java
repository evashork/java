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
		int menu = -1; // 로컬변수는 반드시 초기화가 필요
		String id = null; // 회원정보수정 및 삭제에 쓰임
		//메소드 생성 방법 ctrl + 1 
		
		do{
			System.out.println("===회원관리===");
			System.out.println("1.회원등록"); //C(Create)
			System.out.println("2.회원목록조회"); //R(Read)
			System.out.println("3.회원정보수정"); //U(Update)
			System.out.println("4.회원정보삭제"); //D(Delete)
			System.out.println("5.프로그램종료");
			
			System.out.print("메뉴입력 : ");
			menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				MemberVO newMember = consoleUtil.getNewMember(sc);
				// isRegistSuccess 제대로 등록되었는지 확인
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
				id = consoleUtil.getId(sc,"수정할 ");
				// 수정할 아이디를 찾음
				MemberVO oldMember = memberService.getOldMember(id);
				if(oldMember == null){
					consoleUtil.printIdNotFoundMessage(id);
				}else{
					MemberVO updateMember = consoleUtil.getUpdateMember(sc,oldMember);
					memberService.modifyMember(updateMember);
				}
				break;
				
			case 4:
				id = consoleUtil.getId(sc, "삭제할 "); // 삭제할 id를 입력받는다.
				boolean isRemoveSuccess = memberService.removeMember(id); // 삭제 성공 여부를 확인
				
				if(isRemoveSuccess){
					consoleUtil.printRemoveSuccessMessage(id); // 성공 메세지 
				}else{
					consoleUtil.printRemoveFalseMessage(id);  // 실패 메세지
				}
				break;

			default:
				break;
			}
			
		}while(!isStop);
	}

}
