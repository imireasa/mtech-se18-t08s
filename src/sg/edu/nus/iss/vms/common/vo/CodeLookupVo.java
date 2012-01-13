package sg.edu.nus.iss.vms.common.vo;

import sg.edu.nus.iss.vms.common.dto.CodeCategoryDto;
import sg.edu.nus.iss.vms.common.dto.CodeDto;

/**
 * To store the code lookup information.
 * 
 * @Class name :CodeLookupVo.java
 * @author: $Author: 
 */
public class CodeLookupVo {

    private static final long serialVersionUID = -6963286310324191406L;;

    private Long cdId;
    private String val;
    private String desc;
    private Long catId;
    private String catNme;
    private String catDesc;
    
    public CodeLookupVo() {
    	super();
    }
    
    public CodeLookupVo(CodeDto codeDto) {
    	this.setData(codeDto);
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
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCatNme() {
		return catNme;
	}
	public void setCatNme(String catNme) {
		this.catNme = catNme;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	
	private void setData(CodeDto codeDto) {
		if (codeDto != null && codeDto.getCatId() != null) {
			this.cdId = codeDto.getCdId();
	    	this.val = codeDto.getVal();
	    	this.desc = codeDto.getDesc();
	    	
	    	CodeCategoryDto codeCategoryDto = codeDto.getCatId();
	    	this.catId = codeCategoryDto.getCatId();
	    	this.catDesc = codeCategoryDto.getDesc();
	    	this.catNme = codeCategoryDto.getNme();
		}
	}
}
