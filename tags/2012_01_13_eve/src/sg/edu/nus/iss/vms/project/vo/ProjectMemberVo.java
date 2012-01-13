package sg.edu.nus.iss.vms.project.vo;

public class ProjectMemberVo {

	private String usrLoginId;
	private String roleCd;
	private boolean actInd;
	private Long prjMbrId;
	private String role;
	private Long prjId;
	private Long titleCd;
	private String title;
	private String nme;
	private String ctry;
	private String email;
	private String mobile;
	private Integer version;

	public ProjectMemberVo() {
		super();
	}

	public String getCtry() {
		return ctry;
	}

	public void setCtry(String ctry) {
		this.ctry = ctry;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNme() {
		return nme;
	}

	public void setNme(String nme) {
		this.nme = nme;
	}

	public Long getPrjId() {
		return prjId;
	}

	public void setPrjId(Long prjId) {
		this.prjId = prjId;
	}

	public Long getPrjMbrId() {
		return prjMbrId;
	}

	public void setPrjMbrId(Long prjMbrId) {
		this.prjMbrId = prjMbrId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getTitleCd() {
		return titleCd;
	}

	public void setTitleCd(Long titleCd) {
		this.titleCd = titleCd;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getUsrLoginId() {
		return usrLoginId;
	}

	public void setUsrLoginId(String usrLoginId) {
		this.usrLoginId = usrLoginId;
	}

	public String getRoleCd() {
		return roleCd;
	}

	public void setRoleCd(String roleCd) {
		this.roleCd = roleCd;
	}

	public boolean getActInd() {
		return actInd;
	}

	public void setActInd(boolean actInd) {
		this.actInd = actInd;
	}
}
