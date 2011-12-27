/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_project_experence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectExperenceDto.findAll", query = "SELECT t FROM ProjectExperenceDto t"),
    @NamedQuery(name = "ProjectExperenceDto.findByPrjExpId", query = "SELECT t FROM ProjectExperenceDto t WHERE t.prjExpId = :prjExpId"),
    @NamedQuery(name = "ProjectExperenceDto.findByCreatedBy", query = "SELECT t FROM ProjectExperenceDto t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "ProjectExperenceDto.findByCreatedDte", query = "SELECT t FROM ProjectExperenceDto t WHERE t.createdDte = :createdDte")})
public class ProjectExperenceDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRJ_EXP_ID")
    private Long prjExpId;
    @Basic(optional = false)
    @Lob
    @Column(name = "CONT")
    private String cont;
    @Basic(optional = false)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "CREATED_DTE")
    private String createdDte;
    @JoinColumn(name = "PRJ_ID", referencedColumnName = "PRJ_ID")
    @ManyToOne(optional = false)
    private ProjectDto prjId;

    public ProjectExperenceDto() {
    }

    public ProjectExperenceDto(Long prjExpId) {
        this.prjExpId = prjExpId;
    }

    public ProjectExperenceDto(Long prjExpId, String cont, String createdBy, String createdDte) {
        this.prjExpId = prjExpId;
        this.cont = cont;
        this.createdBy = createdBy;
        this.createdDte = createdDte;
    }

    public Long getPrjExpId() {
        return prjExpId;
    }

    public void setPrjExpId(Long prjExpId) {
        this.prjExpId = prjExpId;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDte() {
        return createdDte;
    }

    public void setCreatedDte(String createdDte) {
        this.createdDte = createdDte;
    }

    public ProjectDto getPrjId() {
        return prjId;
    }

    public void setPrjId(ProjectDto prjId) {
        this.prjId = prjId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prjExpId != null ? prjExpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectExperenceDto)) {
            return false;
        }
        ProjectExperenceDto other = (ProjectExperenceDto) object;
        if ((this.prjExpId == null && other.prjExpId != null) || (this.prjExpId != null && !this.prjExpId.equals(other.prjExpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.ProjectExperenceDto[ prjExpId=" + prjExpId + " ]";
    }
    
}
