package tw.brad.myclass;

public class Member {
	private int id;
	private String account,password,realname;
	
	public Member(int id, String account, String password, String realname) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.realname = realname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
}
