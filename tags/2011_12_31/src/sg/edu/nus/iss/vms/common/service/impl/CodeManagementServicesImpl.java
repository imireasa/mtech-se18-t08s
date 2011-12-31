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

	/*
	 * (non-Javadoc)
	 * 
	 * @see sg.edu.nus.iss.vms.staffmgmt.service.impl.StaffManagementServices#
	 * getListOfUser()
	 */
	@Override
	public List<CodeDto> getListOfCodeByCategory(String Category) {
		this.logger.debug("@ Service Layer getting CodeList By Code Category :"
				+ Category);
		List<CodeDto> codeList = new ArrayList<CodeDto>();
		try {
			String hQL = "from CodeDto c where c.catId.nme='" + Category + "'";
			codeList = this.manager.find(hQL);
		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}
		return codeList;
	}

	@Override
	public String getCodeDescriptionByCodeId(Long codeId) {
		String codeDescription = "";
		try {
			String hQL = "from CodeDto c where c.cdId=" + codeId.toString();
			List<CodeDto> codeList = this.manager.find(hQL);
			if (!codeList.isEmpty()) {
				CodeDto codeDto = codeList.get(0);
				codeDescription = codeDto.getDesc();
			}

		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		} finally {
			return codeDescription;
		}

	}

	public CodeDto getCodeDescriptionByCodeCategoryAndCodeDesc(String category,
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

	}
}