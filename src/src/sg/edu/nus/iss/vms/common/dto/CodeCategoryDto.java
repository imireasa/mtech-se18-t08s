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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zaw
 */
@Entity
@Table(name = "tb_code_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeCategoryDto.findAll", query = "SELECT t FROM CodeCategoryDto t"),
    @NamedQuery(name = "CodeCategoryDto.findByCatId", query = "SELECT t FROM CodeCategoryDto t WHERE t.catId = :catId"),
    @NamedQuery(name = "CodeCategoryDto.findByNme", query = "SELECT t FROM CodeCategoryDto t WHERE t.nme = :nme"),
    @NamedQuery(name = "CodeCategoryDto.findByDesc", query = "SELECT t FROM CodeCategoryDto t WHERE t.desc = :desc")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private List<CodeDto> tbCodeList;

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

    @XmlTransient
    public List<CodeDto> getTbCodeList() {
        return tbCodeList;
    }

    public void setTbCodeList(List<CodeDto> tbCodeList) {
        this.tbCodeList = tbCodeList;
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
