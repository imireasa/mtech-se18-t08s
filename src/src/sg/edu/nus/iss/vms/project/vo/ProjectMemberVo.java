package sg.edu.nus.iss.vms.project.vo;

public class ProjectMemberVo {

	private String usrLoginId;
	private String roleCd;
	private boolean actInd;

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
