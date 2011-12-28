/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dto;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_code_category")
@NamedQueries({
    @NamedQuery(name = "CodeCategoryDto.findAll", query = "SELECT t FROM CodeCategoryDto t")})
public class CodeCategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CAT_ID")
    private Long catId;
    @Basic(optional = false)
    @Column(name = "NME")
    private String nme;
    @Column(name = "DESC")
    private String desc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId", fetch = FetchType.LAZY)
    private List<CodeDto> codeList;

    public CodeCategoryDto() {
    }

    public CodeCategoryDto(Long catId) {
        this.catId = catId;
    }

    public CodeCategoryDto(Long catId, String nme) {
        this.catId = catId;
        this.nme = nme;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
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

    public List<CodeDto> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<CodeDto> tbCodeList) {
        this.codeList = tbCodeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeCategoryDto)) {
            return false;
        }
        CodeCategoryDto other = (CodeCategoryDto) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sg.edu.nus.iss.vms.common.dto.CodeCategoryDto[ catId=" + catId + " ]";
    }
    
}
