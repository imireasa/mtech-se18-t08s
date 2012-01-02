package sg.edu.nus.iss.vms.project.vo;

public class ProjectProposalVo {

	private String name;
	private String desc;
	private String ctryCd;
	private String loc;
	private String rmk;
	private String status;
	private int estDuration;
	private String proposerId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCtryCd() {
		return ctryCd;
	}

	public void setCtryCd(String ctryCd) {
		this.ctryCd = ctryCd;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEstDuration() {
		return estDuration;
	}

	public void setEstDuration(int estDuration) {
		this.estDuration = estDuration;
	}

	public String getProposerId() {
		return proposerId;
	}

	public void setProposerId(String proposerId) {
		this.proposerId = proposerId;
	}

}
