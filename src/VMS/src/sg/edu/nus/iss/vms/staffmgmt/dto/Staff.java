/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.staffmgmt.dto;

import java.io.Serializable;
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "staff")
@PrimaryKeyJoinColumn(name="personId")
public class Staff  extends Person{ 
	//implements Serializable
    private static final long serialVersionUID = 1L;

    @Column(name = "salary")
    private Integer salary;

    public Staff() {
    }

    public Staff(Long staffId) {
        setPersonId(staffId);
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

//    public Person getPersonId() {
//        return personId;
//    }
//
//    public void setPersonId(Person personId) {
//        this.personId = personId;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getPersonId() != null ? getPersonId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.getPersonId() == null && other.getPersonId() != null) || (this.getPersonId() != null && !this.getPersonId().equals(other.getPersonId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.staffmgmt.dto.Staff[ staffId=" + getPersonId() + " ]";
    }
    
}
