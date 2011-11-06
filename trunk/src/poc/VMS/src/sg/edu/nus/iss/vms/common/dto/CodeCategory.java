/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.dto;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author zaw
 */
@Entity
@Table(name = "code_category")
@NamedQueries({ @NamedQuery(name = "CodeCategory.findAll", query = "SELECT c FROM CodeCategory c") })
public class CodeCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CodeCategoryId")
	private Long codeCategoryId;
	@Column(name = "CodeCategoryName")
	private String codeCategoryName;
	@Column(name = "CodeCategoryNameDesc")
	private String codeCategoryNameDesc;
	@Column(name = "IsDeleted")
	private Short isDeleted;
	@OneToMany(mappedBy = "codeCategory")
	private List<Codes> codesList;
	@JoinColumn(name = "BaseId", referencedColumnName = "BaseId")
	@ManyToOne
	private BaseTable baseTable;

	public CodeCategory() {
	}

	public CodeCategory(Long codeCategoryId) {
		this.codeCategoryId = codeCategoryId;
	}

	public Long getCodeCategoryId() {
		return codeCategoryId;
	}

	public void setCodeCategoryId(Long codeCategoryId) {
		this.codeCategoryId = codeCategoryId;
	}

	public String getCodeCategoryName() {
		return codeCategoryName;
	}

	public void setCodeCategoryName(String codeCategoryName) {
		this.codeCategoryName = codeCategoryName;
	}

	public String getCodeCategoryNameDesc() {
		return codeCategoryNameDesc;
	}

	public void setCodeCategoryNameDesc(String codeCategoryNameDesc) {
		this.codeCategoryNameDesc = codeCategoryNameDesc;
	}

	public Short getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Short isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Codes> getCodesList() {
		return codesList;
	}

	public void setCodesList(List<Codes> codesList) {
		this.codesList = codesList;
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
		hash += (codeCategoryId != null ? codeCategoryId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CodeCategory)) {
			return false;
		}
		CodeCategory other = (CodeCategory) object;
		if ((this.codeCategoryId == null && other.codeCategoryId != null) || (this.codeCategoryId != null && !this.codeCategoryId.equals(other.codeCategoryId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "sg.edu.nus.iss.vms.common.dto.CodeCategory[ codeCategoryId=" + codeCategoryId + " ]";
	}

}
