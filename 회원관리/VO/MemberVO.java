package VO;
/*
 *  VO 
 */
public class MemberVO {
	//ĸ��ȭ
	private String id; // �ĺ��� - ����� Ȯ��
	private String name;
	private String email;
	private String nation;
	private String gender;
	private int age;
	
	// �����ڿ� �⺻ ���� �ش�. 
		public MemberVO(String id, String name, String email, String nation,
				String gender, int age) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.nation = nation;
			this.gender = gender;
			this.age = age;
		}	
	
	// private ������ �޼ҵ带 ���� ����
	public String getId() {
		return id; // this�� ������ ����
	}
	public void setId(String id) {
		// this - �ڱ� �ڽ� ��ü�� ����Ű�� ���۷��� ����
		// �ɹ� �����ϰ� �Ķ���� ������ �̸��� �����ϸ� 
		// �޼ҵ� �� ������ �Ķ���� ������ �켱 �νĵȴ�.
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
