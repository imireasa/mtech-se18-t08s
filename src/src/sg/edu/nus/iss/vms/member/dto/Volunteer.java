/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.member.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import sg.edu.nus.iss.vms.common.dto.BaseTable;
import sg.edu.nus.iss.vms.common.dto.Person;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "volunteer")
@PrimaryKeyJoinColumn(name="VolunteerId")
@NamedQueries({
    @NamedQuery(name = "Volunteer.findAll", query = "SELECT v FROM Volunteer v")})
public class Volunteer extends Person {
    private static final long serialVersionUID = 1L;
    @Column(name = "VolunteerExperience")
    private Integer volunteerExperience;
    @Column(name = "IsDeleted")
    private Short isDeleted;
    @JoinColumn(name = "BaseId", referencedColumnName = "BaseId")
    @ManyToOne
    private BaseTable baseTable;

    public Volunteer() {
    }

    public Volunteer(Long volunteerId) {
        super(volunteerId);
    }

    public Long getVolunteerId() {
        return getPersonId();
    }

    public void setVolunteerId(Long volunteerId) {
        this.setPersonId(volunteerId);
    }

    public Integer getVolunteerExperience() {
        return volunteerExperience;
    }

    public void setVolunteerExperience(Integer volunteerExperience) {
        this.volunteerExperience = volunteerExperience;
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
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
        hash += (getPersonId() != null ? getPersonId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Volunteer)) {
            return false;
        }
        Volunteer other = (Volunteer) object;
        if ((this.getPersonId() == null && other.getPersonId() != null) || (this.getPersonId() != null && !this.getPersonId().equals(other.getPersonId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.Volunteer[ volunteerId=" + getPersonId() + " ]";
    }
    
}
