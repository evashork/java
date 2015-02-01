package util;

import java.lang.reflect.Member;
import java.util.Scanner;

import VO.MemberVO;

public class ConsoleUtil {

	// 1.회원등록
	public MemberVO getNewMember(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====회원등록====");
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("국적 : ");
		String nation = sc.next();
		System.out.print("성별 : ");
		String gender = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		return new MemberVO(id, name, email, nation, gender, age);
		//ctrl 엔터
	}

	public void printRegistSucessMessage(String id) {
		// TODO Auto-generated method stub
		System.out.println(id + " 회원님의 정보가 추가 되었습니다.");	
	}
	
	public void printRegistFailMessage(String id) {
		// TODO Auto-generated method stub
		System.out.println(id + " 회원님의 정보가 추가 실패했습니다.");	
	}
	
	// 2.회원목록조회
	public void printMemberArray(MemberVO[] memberArray) {
		// TODO Auto-generated method stub
		if(memberArray.length == 0){
			System.out.println("등록된 회원이 존재하지 않습니다.");
		}else{
			for (int i = 0; i < memberArray.length; i++) {
				System.out.print("아이디 : " + memberArray[i].getId() +
				" 이름 : " + memberArray[i].getName() +
				" 이메일 : " + memberArray[i].getEmail() +
				" 국적 : " + memberArray[i].getNation() +
				" 성별 : " + memberArray[i].getGender() +
				" 나이 : " + memberArray[i].getAge());
				System.out.println();
			}
		}
	}
	
	// 3. 아이디 입력
	public String getId(Scanner sc, String msgKind) {
		System.out.print(msgKind + " 아이디 입력 : ");
		return sc.next();
	}
	
	// 3. 아이디가 없음
	public void printIdNotFoundMessage(String id) {
		System.out.println(id + " 회원이 존재하지 않습니다.");
	}

	public MemberVO getUpdateMember(Scanner sc, MemberVO oldMember) {
		System.out.println("====회원등록====");
		System.out.print("이전 이름 : " + oldMember.getName());
		String name = sc.next();
		System.out.print("이전 이메일 : "  + oldMember.getEmail());
		String email = sc.next();
		System.out.print("이전 국적 : " + oldMember.getNation());
		String nation = sc.next();
		System.out.print("이전 성별 : " + oldMember.getGender());
		String gender = sc.next();
		System.out.print("이전 나이 : " + oldMember.getAge());
		int age = sc.nextInt();
		return new MemberVO(oldMember.getId(), name, email, nation, gender, age);
	}
}
