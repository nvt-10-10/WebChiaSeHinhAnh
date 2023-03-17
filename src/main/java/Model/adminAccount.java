package Model;

public class adminAccount {
	private String adminId;
	private String adUsername;
	private String adPassword;
	private String member;
	private String adName;
	public adminAccount() {
		// TODO Auto-generated constructor stub
	}
	public adminAccount(String adminId, String adUsername, String adPassword, String member, String adName) {
		super();
		this.adminId = adminId;
		this.adUsername = adUsername;
		this.adPassword = adPassword;
		this.member = member;
		this.adName = adName;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdUsername() {
		return adUsername;
	}
	public void setAdUsername(String adUsername) {
		this.adUsername = adUsername;
	}
	public String getAdPassword() {
		return adPassword;
	}
	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}

	
}
