/*
 *  ���� Ŭ����
 */
package svc;

import java.lang.management.MemoryUsage;

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
		for (int i = 0; i < memberArray.length; i++) {
			if(memberArray[i].getId().equals(updateMember.getId())){ 
				//������ ���̵� ã�� �迭�� updateMember�� ����
				memberArray[i] = updateMember;
				break;
			}
		}
	}
	
	// ȸ������ ���� 
	public boolean removeMember(String id) {
		// TODO Auto-generated method stub
		boolean isRemoveSuccess = false;
		
		// id�� �迭 �ε����� ã�ƾ���
		int index = -1;  // ���Ƿ� ��
		for (int i = 0; i < memberArray.length; i++) {
			if(memberArray[i].getId().equals(id)){
				index = i; // i��° �ε��� 
				isRemoveSuccess = true;
				break;
			}
		}
		
		// id�� ã��
		if(isRemoveSuccess){
			MemberVO[] tempArray = memberArray;
			memberArray = new MemberVO[memberArray.length - 1];
			// ������ �迭�� ���� �ش� i�� �ǳʶٰ� �ڿ����� ���� ������ �����.
			
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
