/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author zaw
 */
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({ @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p") })
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "PersonId")
	private Long personId;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "LastName")
	private String lastName;
	@Column(name = "Mobile")
	private String mobile;
	@Column(name = "Email")
	private String email;
	@Column(name = "IsDeleted")
	private Short isDeleted;
	@JoinColumn(name = "TypeId", referencedColumnName = "CodeId")
	@ManyToOne(optional = false)
	private Codes typeId;
	@JoinColumn(name = "BaseId", referencedColumnName = "BaseId")
	@ManyToOne
	private BaseTable baseTable;

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

	public Short getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Codes getTypeId() {
		return typeId;
	}

	public void setTypeId(Codes typeId) {
		this.typeId = typeId;
	}

	public BaseTable getBaseTable() {
		return baseTable;
	}

	public void setBaseTable(BaseTable baseTable) {
		this.baseTable = baseTable;
	}

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
		return "sg.edu.nus.iss.vms.common.dto.Person[ personId=" + personId + " ]";
	}

}
