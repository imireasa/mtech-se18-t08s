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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_project_feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectFeedbackDto.findAll", query = "SELECT t FROM ProjectFeedbackDto t"),
    @NamedQuery(name = "ProjectFeedbackDto.findByPrjFbId", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.prjFbId = :prjFbId"),
    @NamedQuery(name = "ProjectFeedbackDto.findByTitle", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.title = :title"),
    @NamedQuery(name = "ProjectFeedbackDto.findByApprBy", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.apprBy = :apprBy"),
    @NamedQuery(name = "ProjectFeedbackDto.findByApprDte", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.apprDte = :apprDte"),
    @NamedQuery(name = "ProjectFeedbackDto.findByStsCd", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.stsCd = :stsCd"),
    @NamedQuery(name = "ProjectFeedbackDto.findByCreatedBy", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "ProjectFeedbackDto.findByCreatedDte", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.createdDte = :createdDte"),
    @NamedQuery(name = "ProjectFeedbackDto.findByUpdBy", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.updBy = :updBy"),
    @NamedQuery(name = "ProjectFeedbackDto.findByUpdDte", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.updDte = :updDte"),
    @NamedQuery(name = "ProjectFeedbackDto.findByVersion", query = "SELECT t FROM ProjectFeedbackDto t WHERE t.version = :version")})
public class ProjectFeedbackDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRJ_FB_ID")
    private Long prjFbId;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "CONT")
    private String cont;
    @Column(name = "APPR_BY")
    private String apprBy;
    @Column(name = "APPR_DTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date apprDte;
    @Basic(optional = false)
    @Column(name = "STS_CD")
    private long stsCd;
    @Basic(optional = false)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "CREATED_DTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDte;
    @Basic(optional = false)
    @Column(name = "UPD_BY")
    private long updBy;
    @Basic(optional = false)
    @Column(name = "UPD_DTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDte;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private int version;
    @JoinColumn(name = "PRJ_ID", referencedColumnName = "PRJ_ID")
    @ManyToOne(optional = false)
    private ProjectDto prjId;

    public ProjectFeedbackDto() {
    }

    public ProjectFeedbackDto(Long prjFbId) {
        this.prjFbId = prjFbId;
    }

    public ProjectFeedbackDto(Long prjFbId, String title, String cont, long stsCd, String createdBy, Date createdDte, long updBy, Date updDte, int version) {
        this.prjFbId = prjFbId;
        this.title = title;
        this.cont = cont;
        this.stsCd = stsCd;
        this.createdBy = createdBy;
        this.createdDte = createdDte;
        this.updBy = updBy;
        this.updDte = updDte;
        this.version = version;
    }

    public Long getPrjFbId() {
        return prjFbId;
    }

    public void setPrjFbId(Long prjFbId) {
        this.prjFbId = prjFbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getApprBy() {
        return apprBy;
    }

    public void setApprBy(String apprBy) {
        this.apprBy = apprBy;
    }

    public Date getApprDte() {
        return apprDte;
    }

    public void setApprDte(Date apprDte) {
        this.apprDte = apprDte;
    }

    public long getStsCd() {
        return stsCd;
    }

    public void setStsCd(long stsCd) {
        this.stsCd = stsCd;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDte() {
        return createdDte;
    }

    public void setCreatedDte(Date createdDte) {
        this.createdDte = createdDte;
    }

    public long getUpdBy() {
        return updBy;
    }

    public void setUpdBy(long updBy) {
        this.updBy = updBy;
    }

    public Date getUpdDte() {
        return updDte;
    }

    public void setUpdDte(Date updDte) {
        this.updDte = updDte;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
        hash += (prjFbId != null ? prjFbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectFeedbackDto)) {
            return false;
        }
        ProjectFeedbackDto other = (ProjectFeedbackDto) object;
        if ((this.prjFbId == null && other.prjFbId != null) || (this.prjFbId != null && !this.prjFbId.equals(other.prjFbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.ProjectFeedbackDto[ prjFbId=" + prjFbId + " ]";
    }
    
}
