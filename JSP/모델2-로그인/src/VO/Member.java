package VO;
/*
 * VO(value object) Ŭ����
 * Ư�� ������ �����͸� �����ϴ� ������ �ϴ� Ŭ����
 */
public class Member {
	private String id;
	private String addr;
	private String password;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}	
