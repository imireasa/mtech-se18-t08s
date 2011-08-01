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
import javax.persistence.Table;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "volunteer")
@NamedQueries({
    @NamedQuery(name = "Volunteer.findAll", query = "SELECT v FROM Volunteer v")})
public class Volunteer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "volunteerId")
    private Long volunteerId;
    @JoinColumn(name = "personId", referencedColumnName = "personId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Person personId;

    public Volunteer() {
    }

    public Volunteer(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (volunteerId != null ? volunteerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Volunteer)) {
            return false;
        }
        Volunteer other = (Volunteer) object;
        if ((this.volunteerId == null && other.volunteerId != null) || (this.volunteerId != null && !this.volunteerId.equals(other.volunteerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.staffmgmt.dto.Volunteer[ volunteerId=" + volunteerId + " ]";
    }
    
}
