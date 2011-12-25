package sg.edu.nus.iss.vms.security.dto;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;

@Entity
@Table(name = "tb_user")
@PrimaryKeyJoinColumn(name = "usr_id")
@NamedQueries( { @NamedQuery(name = "UserDto.findAll", query = "SELECT u FROM UserDto u") })
public class UserDto extends BaseVersionDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long usrId;
	private String usrLoginId;
	private Long tpCd;
	private String nme;
	private String email;
	private String pwd;
	private String mobile;
	private String addr;
	private Integer postCd;
	private Long ctryCd;
	private boolean actInd;
	private Date joinDte;


	public UserDto() {
	}



	@Id
	@GeneratedValue
	@Column(name = "USR_ID", unique = true, nullable = false)
	public Long getUsrId() {
		return this.usrId;
	}

	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}

	@Column(name = "USR_LOGIN_ID", nullable = false, length = 20)
	public String getUsrLoginId() {
		return this.usrLoginId;
	}

	public void setUsrLoginId(String usrLoginId) {
		this.usrLoginId = usrLoginId;
	}

	@Column(name = "TP_CD", nullable = false)
	public Long getTpCd() {
		return this.tpCd;
	}

	public void setTpCd(Long tpCd) {
		this.tpCd = tpCd;
	}

	@Column(name = "NME", nullable = false, length = 100)
	public String getNme() {
		return this.nme;
	}

	public void setNme(String nme) {
		this.nme = nme;
	}

	@Column(name = "EMAIL", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PWD", length = 50)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "MOBILE", length = 100)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "ADDR")
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name = "POST_CD")
	public Integer getPostCd() {
		return this.postCd;
	}

	public void setPostCd(Integer postCd) {
		this.postCd = postCd;
	}

	@Column(name = "CTRY_CD")
	public Long getCtryCd() {
		return this.ctryCd;
	}

	public void setCtryCd(Long ctryCd) {
		this.ctryCd = ctryCd;
	}

	@Column(name = "ACT_IND", nullable = false)
	public boolean isActInd() {
		return this.actInd;
	}

	public void setActInd(boolean actInd) {
		this.actInd = actInd;
	}
	@Column(name = "JOIN_DTE", nullable = false, length = 10)
	public Date getJoinDte() {
		return this.joinDte;
	}

	public void setJoinDte(Date joinDte) {
		this.joinDte = joinDte;
	}

	


}
