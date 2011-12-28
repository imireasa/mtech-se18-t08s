/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dto;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_code")
@NamedQueries({
    @NamedQuery(name = "CodeDto.findAll", query = "SELECT t FROM CodeDto t")})
public class CodeDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ID")
    private Long cdId;
    @Basic(optional = false)
    @Column(name = "VAL")
    private String val;
    @Basic(optional = false)
    @Column(name = "DESC")
    private String desc;
    @JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CodeCategoryDto catId;

    public CodeDto() {
    }

    public CodeDto(Long cdId) {
        this.cdId = cdId;
    }

    public CodeDto(Long cdId, String val, String desc) {
        this.cdId = cdId;
        this.val = val;
        this.desc = desc;
    }

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public CodeCategoryDto getCatId() {
        return catId;
    }

    public void setCatId(CodeCategoryDto catId) {
        this.catId = catId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdId != null ? cdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeDto)) {
            return false;
        }
        CodeDto other = (CodeDto) object;
        if ((this.cdId == null && other.cdId != null) || (this.cdId != null && !this.cdId.equals(other.cdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.CodeDto[ cdId=" + cdId + " ]";
    }
    
}
