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
@Table(name = "tb_project_intrest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectIntrestDto.findAll", query = "SELECT t FROM ProjectIntrestDto t"),
    @NamedQuery(name = "ProjectIntrestDto.findByPrjIntrstId", query = "SELECT t FROM ProjectIntrestDto t WHERE t.prjIntrstId = :prjIntrstId"),
    @NamedQuery(name = "ProjectIntrestDto.findByReqBy", query = "SELECT t FROM ProjectIntrestDto t WHERE t.reqBy = :reqBy"),
    @NamedQuery(name = "ProjectIntrestDto.findByApprBy", query = "SELECT t FROM ProjectIntrestDto t WHERE t.apprBy = :apprBy"),
    @NamedQuery(name = "ProjectIntrestDto.findByApprDte", query = "SELECT t FROM ProjectIntrestDto t WHERE t.apprDte = :apprDte"),
    @NamedQuery(name = "ProjectIntrestDto.findByApprRmk", query = "SELECT t FROM ProjectIntrestDto t WHERE t.apprRmk = :apprRmk"),
    @NamedQuery(name = "ProjectIntrestDto.findByStsCd", query = "SELECT t FROM ProjectIntrestDto t WHERE t.stsCd = :stsCd"),
    @NamedQuery(name = "ProjectIntrestDto.findByCreatedBy", query = "SELECT t FROM ProjectIntrestDto t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "ProjectIntrestDto.findByCreatedDte", query = "SELECT t FROM ProjectIntrestDto t WHERE t.createdDte = :createdDte"),
    @NamedQuery(name = "ProjectIntrestDto.findByUpdBy", query = "SELECT t FROM ProjectIntrestDto t WHERE t.updBy = :updBy"),
    @NamedQuery(name = "ProjectIntrestDto.findByUpdDte", query = "SELECT t FROM ProjectIntrestDto t WHERE t.updDte = :updDte"),
    @NamedQuery(name = "ProjectIntrestDto.findByVersion", query = "SELECT t FROM ProjectIntrestDto t WHERE t.version = :version")})
public class ProjectIntrestDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRJ_INTRST_ID")
    private Long prjIntrstId;
    @Basic(optional = false)
    @Column(name = "REQ_BY")
    private String reqBy;
    @Column(name = "APPR_BY")
    private String apprBy;
    @Column(name = "APPR_DTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date apprDte;
    @Column(name = "APPR_RMK")
    private String apprRmk;
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
    private String updBy;
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

    public ProjectIntrestDto() {
    }

    public ProjectIntrestDto(Long prjIntrstId) {
        this.prjIntrstId = prjIntrstId;
    }

    public ProjectIntrestDto(Long prjIntrstId, String reqBy, long stsCd, String createdBy, Date createdDte, String updBy, Date updDte, int version) {
        this.prjIntrstId = prjIntrstId;
        this.reqBy = reqBy;
        this.stsCd = stsCd;
        this.createdBy = createdBy;
        this.createdDte = createdDte;
        this.updBy = updBy;
        this.updDte = updDte;
        this.version = version;
    }

    public Long getPrjIntrstId() {
        return prjIntrstId;
    }

    public void setPrjIntrstId(Long prjIntrstId) {
        this.prjIntrstId = prjIntrstId;
    }

    public String getReqBy() {
        return reqBy;
    }

    public void setReqBy(String reqBy) {
        this.reqBy = reqBy;
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

    public String getApprRmk() {
        return apprRmk;
    }

    public void setApprRmk(String apprRmk) {
        this.apprRmk = apprRmk;
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

    public String getUpdBy() {
        return updBy;
    }

    public void setUpdBy(String updBy) {
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
        hash += (prjIntrstId != null ? prjIntrstId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectIntrestDto)) {
            return false;
        }
        ProjectIntrestDto other = (ProjectIntrestDto) object;
        if ((this.prjIntrstId == null && other.prjIntrstId != null) || (this.prjIntrstId != null && !this.prjIntrstId.equals(other.prjIntrstId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.ProjectIntrestDto[ prjIntrstId=" + prjIntrstId + " ]";
    }
    
}
