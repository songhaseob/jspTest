package kr.or.ddit.user.model;

public class UserVo {
	private String userid;
	private String usernm;
	private String pass;
	private String reg_dt;
	private String alias;
	
	// getter, setter, toString
	// 대다수의 framework는 기본 생성자를 필요로 한다
	// 생성자 생성
	public UserVo() {
		
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", usernm=" + usernm + ", pass=" + pass + ", reg_dt=" + reg_dt + ", alias="
				+ alias + "]";
	}
	
	
	
}
