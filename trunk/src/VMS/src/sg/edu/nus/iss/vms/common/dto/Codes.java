/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dto;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "codes")
@NamedQueries({
    @NamedQuery(name = "Codes.findAll", query = "SELECT c FROM Codes c")})
public class Codes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodeId")
    private Long codeId;
    @Column(name = "CodeName")
    private String codeName;
    @Column(name = "CodeValue")
    private String codeValue;
    @Column(name = "IsDeleted")
    private Short isDeleted;
    @JoinColumn(name = "BaseId", referencedColumnName = "BaseId")
    @OneToOne
    private BaseTable baseTable;
    @JoinColumn(name = "CodeCategoryId", referencedColumnName = "CodeCategoryId")
    @ManyToOne
    private CodeCategory codeCategory;
    @OneToMany(mappedBy = "codes")
    private List<ProjectMember> projectMemberList;

    public Codes() {
    }

    public Codes(Long codeId) {
        this.codeId = codeId;
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
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

    public CodeCategory getCodeCategory() {
        return codeCategory;
    }

    public void setCodeCategory(CodeCategory codeCategory) {
        this.codeCategory = codeCategory;
    }

    public List<ProjectMember> getProjectMemberList() {
        return projectMemberList;
    }

    public void setProjectMemberList(List<ProjectMember> projectMemberList) {
        this.projectMemberList = projectMemberList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeId != null ? codeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codes)) {
            return false;
        }
        Codes other = (Codes) object;
        if ((this.codeId == null && other.codeId != null) || (this.codeId != null && !this.codeId.equals(other.codeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.Codes[ codeId=" + codeId + " ]";
    }
    
}
