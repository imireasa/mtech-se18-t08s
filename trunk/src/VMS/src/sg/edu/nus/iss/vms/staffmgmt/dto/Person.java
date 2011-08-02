/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.staffmgmt.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author zaw
 */
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "personId", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "email")
	private String email;

	// @OneToMany(mappedBy = "personId", fetch = FetchType.LAZY)
	// private List<Staff> staffList;
	// @OneToMany(mappedBy = "personId", fetch = FetchType.LAZY)
	// private List<Volunteer> volunteerList;

	public Person() {
	}

	public Person(Long personId) {
		this.personId = personId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// public List<Staff> getStaffList() {
	// return staffList;
	// }
	//
	// public void setStaffList(List<Staff> staffList) {
	// this.staffList = staffList;
	// }
	//
	// public List<Volunteer> getVolunteerList() {
	// return volunteerList;
	// }
	//
	// public void setVolunteerList(List<Volunteer> volunteerList) {
	// this.volunteerList = volunteerList;
	// }

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (personId != null ? personId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Person)) {
			return false;
		}
		Person other = (Person) object;
		if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "sg.edu.nus.iss.vms.staffmgmt.dto.Person[ personId=" + personId + " ]";
	}

}
