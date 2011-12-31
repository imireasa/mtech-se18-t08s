package sg.edu.nus.iss.vms.project.vo;

public class ProjectVo {

	private Long prjId;
	private Long prjIdDisplayed;
	private String name;
	private String desc;
	private String prjMgr;
	private String strDte;
	private String endDte;
	private String ctryCd;
	private String loc;
	private String rmk;
	private String prjPropId;
	private String stsCd;
	public String version;
	private String cmdType;
		
	public Long getPrjId() {
		return prjId;
	}
	public void setPrjId(Long prjId) {
		this.prjId = prjId;
	}
	public Long getPrjIdDisplayed() {
		return prjIdDisplayed;
	}
	public void setPrjIdDisplayed(Long prjIdDisplayed) {
		this.prjIdDisplayed = prjIdDisplayed;
	}
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
	public String getPrjMgr() {
		return prjMgr;
	}
	public void setPrjMgr(String prjMgr) {
		this.prjMgr = prjMgr;
	}
	public String getStrDte() {
		return strDte;
	}
	public void setStrDte(String strDte) {
		this.strDte = strDte;
	}
	public String getEndDte() {
		return endDte;
	}
	public void setEndDte(String endDte) {
		this.endDte = endDte;
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
	public String getPrjPropId() {
		return prjPropId;
	}
	public void setPrjPropId(String prjPropId) {
		this.prjPropId = prjPropId;
	}

	public String getStsCd() {
		return stsCd;
	}
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCmdType() {
		return cmdType;
	}
	public void setCmdType(String cmdType) {
		this.cmdType = cmdType;
	}


}
