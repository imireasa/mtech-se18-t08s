package sg.edu.nus.iss.vms.project.vo;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.vms.common.constants.VMSConstants;
import sg.edu.nus.iss.vms.common.util.CodeLookupUtil;
import sg.edu.nus.iss.vms.common.util.DateUtil;
import sg.edu.nus.iss.vms.common.web.util.UserUtil;
import sg.edu.nus.iss.vms.project.dto.ProjectDto;

public class ProjectVo {

	private String loginId;
	private Long prjId;
	private Long prjIdDisplayed;
	private String name;
	private String desc;
	private String prjMgr;
	private String strDte;
	private String endDte;
	private String ctryCd;
	private String ctry;
	private String loc;
	private String rmk;
	private String prjPropId;
	private String stsCd;

	private List<ProjectMemberVo> projectMemberVo = new ArrayList<ProjectMemberVo>();
	private String msg;

	public ProjectVo() {
		super();
	}

	public ProjectVo(ProjectDto projectDto) {
		setProjectDto(projectDto);
	}

	public void setProjectDto(ProjectDto projectDto) {
		this.loginId = UserUtil.getUserSessionInfoVo().getUserID();
		setPrjId(projectDto.getPrjId());
		setName(projectDto.getNme());
		setDesc(projectDto.getDesc());
		setPrjMgr(UserUtil.getUserSessionInfoVo().getUserID());
		setStrDte(DateUtil.formatDate(projectDto.getStrDte(),
				DateUtil.DEFAULT_DATE_FORMAT));
		setEndDte(DateUtil.formatDate(projectDto.getEndDte(),
				DateUtil.DEFAULT_DATE_FORMAT));
		setCtryCd(projectDto.getCtryCd() + "");
		setCtry(CodeLookupUtil.getCodeValueByCodeId(projectDto.getCtryCd()));
		setLoc(projectDto.getLoc());
		setRmk(projectDto.getRmk());
		if (projectDto.getPrjPropId() != null) {
			setPrjPropId(Long
					.toString(projectDto.getPrjPropId().getPrjPropId()));
		} else {
			setPrjPropId("0");
		}
		setStsCd(CodeLookupUtil.getCodeValueByCodeId(projectDto.getStsCd()));
	}

	public ProjectDto getProjectDto() {
		ProjectDto project = new ProjectDto();
		project.setPrjId(getPrjId());
		project.setNme(getName());
		project.setDesc(getDesc());
		project.setPrjMgr(UserUtil.getUserSessionInfoVo().getUserID());
		project.setStrDte(DateUtil.parseDate(getStrDte(),
				DateUtil.DEFAULT_DATE_FORMAT));
		project.setEndDte(DateUtil.parseDate(getEndDte(),
				DateUtil.DEFAULT_DATE_FORMAT));
		project.setCtryCd(Long.parseLong(getCtryCd()));
		project.setLoc(getLoc());
		project.setRmk(getRmk());
		project.setPrjPropId(null);
		project.setStsCd(CodeLookupUtil.getCodeByCategoryAndCodeValue(
				VMSConstants.PROJECT_STATUS, getStsCd()).getCdId());
		return project;
	}

	public String getCtry() {
		return ctry;
	}

	public void setCtry(String ctry) {
		this.ctry = ctry;
	}

	public List<ProjectMemberVo> getProjectMemberVo() {
		return projectMemberVo;
	}

	public void setProjectMemberVo(List<ProjectMemberVo> projectMemberVo) {
		this.projectMemberVo = projectMemberVo;
	}

	public String getLoginId() {
		return loginId;
	}

	public String version;
	private String cmdType;

	public Long getPrjId() {
		return prjId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
