package sg.edu.nus.iss.vms.security.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import sg.edu.nus.iss.vms.common.dto.BaseVersionDto;


@Entity
@Table(name = "tb_menu_function")
public class MenuFunctionDto extends BaseVersionDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long menuFuncId;
	private long permiId;
	private long prntMenuFuncId;
	private String menuFuncNme;

	

	@Id
	@GeneratedValue
	@Column(name = "MENU_FUNC_ID", unique = true, nullable = false)
	public Long getMenuFuncId() {
		return this.menuFuncId;
	}

	public void setMenuFuncId(Long menuFuncId) {
		this.menuFuncId = menuFuncId;
	}

	@Column(name = "PERMI_ID", nullable = false)
	public long getPermiId() {
		return this.permiId;
	}

	public void setPermiId(long permiId) {
		this.permiId = permiId;
	}

	@Column(name = "PRNT_MENU_FUNC_ID", nullable = false)
	public long getPrntMenuFuncId() {
		return this.prntMenuFuncId;
	}

	public void setPrntMenuFuncId(long prntMenuFuncId) {
		this.prntMenuFuncId = prntMenuFuncId;
	}

	@Column(name = "MENU_FUNC_NME", nullable = false, length = 100)
	public String getMenuFuncNme() {
		return this.menuFuncNme;
	}

	public void setMenuFuncNme(String menuFuncNme) {
		this.menuFuncNme = menuFuncNme;
	}


}
