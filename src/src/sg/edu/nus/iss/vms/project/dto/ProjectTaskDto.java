/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.project.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_project_task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectTaskDto.findAll", query = "SELECT t FROM ProjectTaskDto t"),
    @NamedQuery(name = "ProjectTaskDto.findByPrjTaskId", query = "SELECT t FROM ProjectTaskDto t WHERE t.prjTaskId = :prjTaskId"),
    @NamedQuery(name = "ProjectTaskDto.findByNme", query = "SELECT t FROM ProjectTaskDto t WHERE t.nme = :nme"),
    @NamedQuery(name = "ProjectTaskDto.findByDesc", query = "SELECT t FROM ProjectTaskDto t WHERE t.desc = :desc"),
    @NamedQuery(name = "ProjectTaskDto.findByOdrNo", query = "SELECT t FROM ProjectTaskDto t WHERE t.odrNo = :odrNo"),
    @NamedQuery(name = "ProjectTaskDto.findByStrDte", query = "SELECT t FROM ProjectTaskDto t WHERE t.strDte = :strDte"),
    @NamedQuery(name = "ProjectTaskDto.findByEndDte", query = "SELECT t FROM ProjectTaskDto t WHERE t.endDte = :endDte"),
    @NamedQuery(name = "ProjectTaskDto.findByStsCd", query = "SELECT t FROM ProjectTaskDto t WHERE t.stsCd = :stsCd"),
    @NamedQuery(name = "ProjectTaskDto.findByDelInd", query = "SELECT t FROM ProjectTaskDto t WHERE t.delInd = :delInd"),
    @NamedQuery(name = "ProjectTaskDto.findByCreatedBy", query = "SELECT t FROM ProjectTaskDto t WHERE t.createdBy = :createdBy"),
    @NamedQuery(name = "ProjectTaskDto.findByCreatedDte", query = "SELECT t FROM ProjectTaskDto t WHERE t.createdDte = :createdDte"),
    @NamedQuery(name = "ProjectTaskDto.findByUpdBy", query = "SELECT t FROM ProjectTaskDto t WHERE t.updBy = :updBy"),
    @NamedQuery(name = "ProjectTaskDto.findByUpdDte", query = "SELECT t FROM ProjectTaskDto t WHERE t.updDte = :updDte"),
    @NamedQuery(name = "ProjectTaskDto.findByVersion", query = "SELECT t FROM ProjectTaskDto t WHERE t.version = :version")})
public class ProjectTaskDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRJ_TASK_ID")
    private Long prjTaskId;
    @Basic(optional = false)
    @Column(name = "NME")
    private String nme;
    @Column(name = "DESC")
    private String desc;
    @Basic(optional = false)
    @Column(name = "ODR_NO")
    private int odrNo;
    @Basic(optional = false)
    @Column(name = "STR_DTE")
    private Date strDte;
    @Basic(optional = false)
    @Column(name = "END_DTE")
    private Date endDte;
    @Basic(optional = false)
    @Column(name = "STS_CD")
    private long stsCd;
    @Column(name = "DEL_IND")
    private Boolean delInd;
    @Basic(optional = false)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "CREATED_DTE")
    private Date createdDte;
    @Basic(optional = false)
    @Column(name = "UPD_BY")
    private long updBy;
    @Basic(optional = false)
    @Column(name = "UPD_DTE")
    private Date updDte;
    @Basic(optional = false)
    @Column(name = "VERSION")
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prjTaskId")
    private List<ProjectTaskMemberDto> tbProjectTaskMemberList;
    @JoinColumn(name = "PRJ_ID", referencedColumnName = "PRJ_ID")
    @ManyToOne(optional = false)
    private ProjectDto prjId;

    public ProjectTaskDto() {
    }

    public ProjectTaskDto(Long prjTaskId) {
        this.prjTaskId = prjTaskId;
    }

    public ProjectTaskDto(Long prjTaskId, String nme, int odrNo, Date strDte, Date endDte, long stsCd, String createdBy, Date createdDte, long updBy, Date updDte, int version) {
        this.prjTaskId = prjTaskId;
        this.nme = nme;
        this.odrNo = odrNo;
        this.strDte = strDte;
        this.endDte = endDte;
        this.stsCd = stsCd;
        this.createdBy = createdBy;
        this.createdDte = createdDte;
        this.updBy = updBy;
        this.updDte = updDte;
        this.version = version;
    }

    public Long getPrjTaskId() {
        return prjTaskId;
    }

    public void setPrjTaskId(Long prjTaskId) {
        this.prjTaskId = prjTaskId;
    }

    public String getNme() {
        return nme;
    }

    public void setNme(String nme) {
        this.nme = nme;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getOdrNo() {
        return odrNo;
    }

    public void setOdrNo(int odrNo) {
        this.odrNo = odrNo;
    }

    public Date getStrDte() {
        return strDte;
    }

    public void setStrDte(Date strDte) {
        this.strDte = strDte;
    }

    public Date getEndDte() {
        return endDte;
    }

    public void setEndDte(Date endDte) {
        this.endDte = endDte;
    }

    public long getStsCd() {
        return stsCd;
    }

    public void setStsCd(long stsCd) {
        this.stsCd = stsCd;
    }

    public Boolean getDelInd() {
        return delInd;
    }

    public void setDelInd(Boolean delInd) {
        this.delInd = delInd;
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

    @XmlTransient
    public List<ProjectTaskMemberDto> getTbProjectTaskMemberList() {
        return tbProjectTaskMemberList;
    }

    public void setTbProjectTaskMemberList(List<ProjectTaskMemberDto> tbProjectTaskMemberList) {
        this.tbProjectTaskMemberList = tbProjectTaskMemberList;
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
        hash += (prjTaskId != null ? prjTaskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectTaskDto)) {
            return false;
        }
        ProjectTaskDto other = (ProjectTaskDto) object;
        if ((this.prjTaskId == null && other.prjTaskId != null) || (this.prjTaskId != null && !this.prjTaskId.equals(other.prjTaskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.ProjectTaskDto[ prjTaskId=" + prjTaskId + " ]";
    }
    
}
