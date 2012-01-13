package sg.edu.nus.iss.vms.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.dto.CodeDto;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.common.service.CodeManagementServices;
import sg.edu.nus.iss.vms.common.vo.CodeLookupVo;

public class CodeManagementServicesImpl implements CodeManagementServices {

	private final Logger logger = Logger
			.getLogger(CodeManagementServicesImpl.class);
	private Manager manager;
	private SessionBean sessionBean;

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public SessionBean getSessionBean() {
		return this.sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	@Override
	public List<CodeLookupVo> getCodeListByCategory(String category) {
		logger.debug("getCodeListByCategory(String) - start");
		logger.debug("getCodeListByCategory(String) @ Service Layer getting CodeList By Code Category :"
				+ category);
		List<CodeDto> codeList = new ArrayList<CodeDto>();
		List<CodeLookupVo> codeLookupVoList = null;
		try {
			String hQL = "from CodeDto c where c.catId.nme='" + category + "'";
			codeList = this.manager.find(hQL);
			
			if (codeList != null && codeList.size() != 0) {
				codeLookupVoList = new ArrayList<CodeLookupVo>(); 
				for (CodeDto codeDto: codeList) {
					CodeLookupVo codeLookupVo = new CodeLookupVo(codeDto);
					codeLookupVoList.add(codeLookupVo);
				}
			}
		} catch (Exception ex) {
			this.logger.error("getCodeListByCategory(String)", ex);
		} finally {
			this.logger.debug("getCodeListByCategory(String) - end");
		}
		return codeLookupVoList;
	}

	@Override
	public String getCodeDescriptionByCodeId(Long codeId) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeDescriptionByCodeId(Long) - start");
		}

		String codeDescription = "";
		try {
			String hQL = "from CodeDto c where c.cdId=" + codeId.toString();
			List<CodeDto> codeList = this.manager.find(hQL);
			if (!codeList.isEmpty()) {
				CodeDto codeDto = codeList.get(0);
				codeDescription = codeDto.getDesc();
			}

		} catch (Exception ex) {
			this.logger.error("getCodeDescriptionByCodeId(Long)", ex);
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("getCodeDescriptionByCodeId(Long) - end");
			}
			return codeDescription;
		}

	}

	@Override
	public String getCodeValueByCodeId(Long codeId) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeValueByCodeId(Long) - start");
		}

		String codeValue = "";
		try {
			String hQL = "from CodeDto c where c.cdId=" + codeId.toString();
			List<CodeDto> codeList = this.manager.find(hQL);
			if (!codeList.isEmpty()) {
				CodeDto codeDto = codeList.get(0);
				codeValue = codeDto.getVal();
			}

		} catch (Exception ex) {
			this.logger.error("getCodeValueByCodeId(Long)", ex);
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("getCodeValueByCodeId(Long) - end");
			}
			return codeValue;
		}

	}

	/*public CodeDto getCodeDescriptionByCodeCategoryAndCodeDesc(String category,
			String codeDesc) {

		try {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(CodeDto.class);
			criteria.setFetchMode("catId", FetchMode.JOIN)
					.createAlias("catId", "cat")
					.add(Restrictions.eq("cat.nme", category))
					.add(Restrictions.eq("val", codeDesc));

			return (CodeDto) manager.findByDetachedCriteria(criteria).get(0);

		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
			return null;
		}

	}*/

	@Override
	public CodeLookupVo getCodeById(Long id) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeById(Long) - start");
		}

		CodeLookupVo codeLookupVo = null;

		try {
			manager.get(CodeDto.class, id);
			
			CodeDto codeDto = (CodeDto)manager.get(CodeDto.class, id); 
			if (codeDto != null) {
				codeLookupVo = new CodeLookupVo(codeDto);
			}

			if (logger.isDebugEnabled()) {
				logger.debug("getCodeById(Long) - end");
			}
		} catch (Exception ex) {
			logger.error("getCodeById(Long)", ex);
			return codeLookupVo;
		}
		return codeLookupVo;
	}

	@Override
	public CodeLookupVo getCodeByCategoryAndCodeValue(String category, String val) {
		if (logger.isDebugEnabled()) {
			logger.debug("getCodeByCategoryAndCodeValue(String, String) - start");
			logger.debug("getCodeByCategoryAndCodeValue(String, String) - @ Getting Code DTO by a specific Category Value."
					+ category + ", Category Value:" + val);
		}
		
		List<CodeDto> codeList = new ArrayList<CodeDto>();
		CodeLookupVo codeLookupVo = null;
		try {
			String hQL = "from CodeDto c where c.catId.nme='" + category
					+ "' and c.val='" + val + "'";
			codeList = this.manager.find(hQL);
			if (codeList != null) {
				codeLookupVo = new CodeLookupVo(codeList.get(0));
			}
		} catch (Exception ex) {
			this.logger.error("getCodeByCategoryAndCodeValue(String, String)", ex);
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("getCodeByCategoryAndCodeValue(String, String) - end");
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getCodeByCategoryAndCodeValue(String, String) - end");
		}
		return codeLookupVo;
	}

	/*public CodeDto getCodeByCodeCategoryAndCodeDesc(String category, String codeValue) {
		this.logger
				.debug("@ Service Layer Getting Code DTO by a specific Category Value."
						+ category + ", Category Value:" + codeValue);
		List<CodeDto> codeList = new ArrayList<CodeDto>();
		try {
			String hQL = "from CodeDto c where c.catId.nme='" + category
					+ "' and c.desc='" + codeValue + "'";
			codeList = this.manager.find(hQL);
			if (codeList != null)
				return codeList.get(0);
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		} finally {
			this.logger.debug("@ Service Layer: getCodeDtoByCatVal");
		}
		return null;
	}*/
}