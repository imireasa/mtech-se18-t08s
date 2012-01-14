package sg.edu.nus.iss.vms.common.service;

import java.util.List;

import sg.edu.nus.iss.vms.common.vo.CodeLookupVo;

public interface CodeManagementServices {

	/**
	 * Returns a list of codes based on the category name.
	 * 
	 * @param category - the category name to retrieve the list of corresponding code value.
	 * @return a list of CodeLookupVo
	 */
	public List<CodeLookupVo> getCodeListByCategory(String category);

	/**
	 * Returns the code description based on the code Id.
	 * 
	 * @param codeId - the code Id
	 * @return the code description.
	 */
	public String getCodeDescriptionByCodeId(Long codeId);

	/**
	 * Returns the code value based on the code Id.
	 * 
	 * @param codeId - the code Id
	 * @return the code value.
	 */
	public String getCodeValueByCodeId(Long codeId);
	
	/**
	 * Returns a code object based on the category name and code value.
	 * 
	 * @param category - the category name to retrieve the code object.
	 * @param value - the value to retrieve the code object.
	 * @return a CodeLookupVo object
	 */
	public CodeLookupVo getCodeByCategoryAndCodeValue(String category, String catVal);
	
	/**
	 * Returns a code object based on the code Id.
	 * 
	 * @param id - the code id.
	 * @return a CodeDto object
	 */
	public CodeLookupVo getCodeById(Long id);

	//public CodeDto getCodeDescriptionByCodeCategoryAndCodeDesc(String category, String codeDesc);

	//public CodeDto getCodeByCodeCategoryAndCodeDesc(String category, String codeValue);

	
}