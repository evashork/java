/*
 *  서비스 클래스
 */
package svc;

import java.lang.management.MemoryUsage;

import VO.MemberVO;

public class MemberService {
	private MemberVO[] memberArray;
	public MemberService(){
		memberArray = new MemberVO[0];
	}
	
	// 1. 회원등록
	public boolean registMember(MemberVO newMember) {
		// TODO Auto-generated method stub
		boolean isRegistSuccess = true;
		
		// 아이디가 기존에 있을 경우를 확인
		for (int i = 0; i < memberArray.length; i++) {
			if(newMember.getId().equals(memberArray[i].getId())){
				isRegistSuccess = false;
				break;
			}
		}
		
		// 정보를 배열에 등록
		if(isRegistSuccess){
			//tempArray 기존의 배열보다 더큰 배열을 만든다. 
			MemberVO[] tempArray = memberArray;
			memberArray = new MemberVO[memberArray.length + 1];
			
			for (int i = 0; i < tempArray.length; i++) {
				memberArray[i] = tempArray[i];
			}
			
			memberArray[memberArray.length - 1] = newMember;
		}
		return isRegistSuccess;
	}
	
	// 2.회원목록조회
	public MemberVO[] getMemberArray() {
		return memberArray;
	}
	
	// 3.회원정보 수정
	public MemberVO getOldMember(String id) {
		// TODO Auto-generated method stub
		MemberVO OldMember = null;
		for (int i = 0; i < memberArray.length; i++) {
			if(id.equals(memberArray[i].getId())){ 
				//동일한 아이디를 찾고 OldMember에 대입
				OldMember = memberArray[i];
				break;
			}
		}
		return OldMember;
	}
	
	// 회원정보 수정
	public void modifyMember(MemberVO updateMember) {
		// TODO Auto-generated method stub
		for (int i = 0; i < memberArray.length; i++) {
			if(memberArray[i].getId().equals(updateMember.getId())){ 
				//동일한 아이디를 찾고 배열에 updateMember를 대입
				memberArray[i] = updateMember;
				break;
			}
		}
	}
	
	// 회원정보 삭제 
	public boolean removeMember(String id) {
		// TODO Auto-generated method stub
		boolean isRemoveSuccess = false;
		
		// id의 배열 인덱스를 찾아야함
		int index = -1;  // 임의로 줌
		for (int i = 0; i < memberArray.length; i++) {
			if(memberArray[i].getId().equals(id)){
				index = i; // i번째 인덱스 
				isRemoveSuccess = true;
				break;
			}
		}
		
		// id를 찾음
		if(isRemoveSuccess){
			MemberVO[] tempArray = memberArray;
			memberArray = new MemberVO[memberArray.length - 1];
			// 임의의 배열을 만들어서 해당 i를 건너뛰고 뒤에오는 값은 앞으로 땡긴다.
			
			for(int i = 0; i < tempArray.length; i++){
				if(i < index){
					memberArray[i] = tempArray[i];
				}else if(i > index){
					memberArray[i - 1] = tempArray[i];
				}
			}
		}
		
		return isRemoveSuccess;
	}
}
