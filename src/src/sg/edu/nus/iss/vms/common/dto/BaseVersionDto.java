package sg.edu.nus.iss.vms.common.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

public class BaseVersionDto {
	private String createdBy;
	private Date createdDte;
	private String updBy;
	private Date updDte;
	private Integer version;


	@Column(name = "CREATED_BY", nullable = false, length = 20)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DTE", length = 10)
	public Date getCreatedDte() {
		return this.createdDte;
	}

	public void setCreatedDte(Date createdDte) {
		this.createdDte = createdDte;
	}

	@Column(name = "UPD_BY", nullable = false, length = 66)
	public String getUpdBy() {
		return this.updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	@Column(name = "UPD_DTE", nullable = false, length = 10)
	public Date getUpdDte() {
		return this.updDte;
	}

	public void setUpdDte(Date updDte) {
		this.updDte = updDte;
	}

	@Column(name = "VERSION", nullable = false)
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
