package VO;
/*
 *  VO 
 */
public class MemberVO {
	//캡슐화
	private String id; // 식별값 - 저장시 확인
	private String name;
	private String email;
	private String nation;
	private String gender;
	private int age;
	
	// 생성자에 기본 값을 준다. 
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
	
	// private 변수를 메소드를 통해 접근
	public String getId() {
		return id; // this가 생략된 상태
	}
	public void setId(String id) {
		// this - 자기 자신 객체를 가리키는 레퍼런스 변수
		// 맴버 변수하고 파라미터 변수의 이름이 동일하면 
		// 메소드 내 에서는 파라미터 변수가 우선 인식된다.
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
