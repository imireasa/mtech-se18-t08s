/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sg.edu.nus.iss.vms.common.dto.BaseTable;
import sg.edu.nus.iss.vms.common.dto.Codes;
import sg.edu.nus.iss.vms.member.dto.Volunteer;

/**
 * 
 * @author zaw
 */
@Entity
@Table(name = "project_member")
@NamedQueries({ @NamedQuery(name = "ProjectMember.findAll", query = "SELECT p FROM ProjectMember p") })
public class ProjectMember implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ProjectMemberId")
	private Long projectMemberId;
	@Column(name = "JoinDate")
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	@Column(name = "IsDeleted")
	private Short isDeleted;
	@JoinColumn(name = "VolunteerId", referencedColumnName = "VolunteerId")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Volunteer volunteerId;
	@JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
	@ManyToOne(fetch = FetchType.EAGER)
	private ProjectRole roleId;
	@JoinColumn(name = "BaseId", referencedColumnName = "BaseId")
	@ManyToOne(fetch = FetchType.EAGER)
	private BaseTable baseId;
	@JoinColumn(name = "MemberStatus", referencedColumnName = "CodeId")
	@ManyToOne(fetch = FetchType.EAGER)
	private Codes memberStatus;
	@JoinColumn(name = "ProjectId", referencedColumnName = "ProjectId")
	@ManyToOne(fetch = FetchType.EAGER)
	private Project projectId;

	public ProjectMember() {
	}

	public ProjectMember(Long projectMemberId) {
		this.projectMemberId = projectMemberId;
	}

	public Long getProjectMemberId() {
		return projectMemberId;
	}

	public void setProjectMemberId(Long projectMemberId) {
		this.projectMemberId = projectMemberId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Short getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Volunteer getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(Volunteer volunteerId) {
		this.volunteerId = volunteerId;
	}

	public ProjectRole getRoleId() {
		return roleId;
	}

	public void setRoleId(ProjectRole roleId) {
		this.roleId = roleId;
	}

	public BaseTable getBaseId() {
		return baseId;
	}

	public void setBaseId(BaseTable baseId) {
		this.baseId = baseId;
	}

	public Codes getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(Codes memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectMemberId != null ? projectMemberId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectMember)) {
			return false;
		}
		ProjectMember other = (ProjectMember) object;
		if ((this.projectMemberId == null && other.projectMemberId != null)
				|| (this.projectMemberId != null && !this.projectMemberId
						.equals(other.projectMemberId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "sg.edu.nus.iss.vms.common.dto.ProjectMember[ projectMemberId="
				+ projectMemberId + " ]";
	}

}
