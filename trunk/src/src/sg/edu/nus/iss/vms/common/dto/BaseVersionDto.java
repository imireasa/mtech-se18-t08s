package sg.edu.nus.iss.vms.common.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

public class BaseVersionDto {
	@Column(name = "version")
	private Integer version;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_ts")
	private Date createdTimeStamp;
	@Column(name = "ls_upd_by")
	private String lastUpdatedBy;
	@Column(name = "ls_upd_ts")
	private Date lastUpdatedTimeStamp;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedTimeStamp() {
		return lastUpdatedTimeStamp;
	}

	public void setLastUpdatedTimeStamp(Date lastUpdatedTimeStamp) {
		this.lastUpdatedTimeStamp = lastUpdatedTimeStamp;
	}

}
