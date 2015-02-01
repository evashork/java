/*
 *  ���� Ŭ����
 */
package svc;

import VO.MemberVO;

public class MemberService {
	private MemberVO[] memberArray;
	public MemberService(){
		memberArray = new MemberVO[0];
	}
	
	// 1. ȸ�����
	public boolean registMember(MemberVO newMember) {
		// TODO Auto-generated method stub
		boolean isRegistSuccess = true;
		
		// ���̵� ������ ���� ��츦 Ȯ��
		for (int i = 0; i < memberArray.length; i++) {
			if(newMember.getId().equals(memberArray[i].getId())){
				isRegistSuccess = false;
				break;
			}
		}
		
		// ������ �迭�� ���
		if(isRegistSuccess){
			//tempArray ������ �迭���� ��ū �迭�� �����. 
			MemberVO[] tempArray = memberArray;
			memberArray = new MemberVO[memberArray.length + 1];
			
			for (int i = 0; i < tempArray.length; i++) {
				memberArray[i] = tempArray[i];
			}
			
			memberArray[memberArray.length - 1] = newMember;
		}
		return isRegistSuccess;
	}
	
	// 2.ȸ�������ȸ
	public MemberVO[] getMemberArray() {
		return memberArray;
	}
	
	// 3.ȸ������ ����
	public MemberVO getOldMember(String id) {
		// TODO Auto-generated method stub
		MemberVO OldMember = null;
		for (int i = 0; i < memberArray.length; i++) {
			if(id.equals(memberArray[i].getId())){ 
				//������ ���̵� ã�� OldMember�� ����
				OldMember = memberArray[i];
				break;
			}
		}
		return OldMember;
	}
	
	// ȸ������ ����
	public void modifyMember(MemberVO updateMember) {
		// TODO Auto-generated method stub
	}
}
