package sg.edu.nus.iss.vms.member.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import sg.edu.nus.iss.vms.common.SessionBean;
import sg.edu.nus.iss.vms.common.dto.BaseTable;
import sg.edu.nus.iss.vms.common.dto.Codes;
import sg.edu.nus.iss.vms.common.dto.Person;
import sg.edu.nus.iss.vms.common.orm.Manager;
import sg.edu.nus.iss.vms.constant.PersonType;

import sg.edu.nus.iss.vms.member.dto.Staff;
import sg.edu.nus.iss.vms.member.dto.Volunteer;
import sg.edu.nus.iss.vms.member.service.MemberManagementService;
import sg.edu.nus.iss.vms.member.vo.MemberVo;

public class MemberManagementServiceImpl implements MemberManagementService {
	private Manager manager;
	private SessionBean sessionBean;
	private Logger logger = Logger.getLogger(MemberManagementServiceImpl.class);

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
	public List<MemberVo> getListOfMembers() {
//		try{debug();}catch(Exception ex){ex.printStackTrace();}
		List<MemberVo> userList = new ArrayList<MemberVo>();
		try {
			this.logger.debug("@ Service Layer getting user 1");
			List<Person> tempList = this.manager.list(Person.class);
			for (Person person : tempList) {
				MemberVo newMember = new MemberVo();
				newMember.setPersonId(person.getPersonId());
				newMember.setFirstName(person.getFirstName());
				newMember.setLastName(person.getLastName());
				newMember.setEmail(person.getEmail());
				newMember.setMobile(person.getMobile());
				newMember.setMemberType(person.getTypeId().getCodeName());
				userList.add(newMember);
			}

		} catch (Exception ex) {
			this.logger.error("Data Access Error", ex);
		} finally {
			this.logger.debug("@ Service Layer getting user 2");
		}
		return userList;
	}

	public void debug() throws Exception{
		logger.debug("Start Debug Data");
		String name[] = { "Karina Gourdine", "Darren Babineau", "Darren Vaugh", "Fernando Montalbo", "Guy La", "Darcy Arocho", "Nelson Shires", "Sharron Frew", "Nelson Berkman",
				"Clayton Patricio", "Gay Wint", "Julio Stairs", "Allie Precourt", "Hugh Lauffer", "Lance Cunniff", "Clayton Tatman", "Guy Newcomer", "Fernando Thelen", "Tameka Galdi",
				"Clayton Waynick", "Amie Wei", "Javier Baisden", "Ted Balog", "Kurt Bergeson", "Mathew Lige", "Hugh Michelsen", "Earnestine Peloquin", "Esmeralda Hankerson",
				"Allan Ariza", "Battista" };
		for (int i = 1000; i < 1100; i++) {
			
			String _name[] = name[(i % 30)].split("[ ]");
			BaseTable base = new BaseTable();
			base.setCreatedBy(1);
			base.setCreateDate(new Date());
			manager.save(base);
			
			if ((i % 2) == 1) {
				Staff newStaff = new Staff();
				newStaff.setFirstName(_name[0]==null?"":_name[0]);
				newStaff.setLastName(_name[1]==null?"":_name[1]);
				newStaff.setMobile("" + i);
				newStaff.setSalary(i);
				newStaff.setTypeId((Codes) manager.get(Codes.class, PersonType.STAFF));
				newStaff.setBaseTable(base);
				this.manager.save(newStaff);
				logger.debug("Data " + newStaff.getFirstName());
			} else {
				Volunteer newStaff = new Volunteer();
				newStaff.setFirstName(_name[0]==null?"":_name[0]);
				newStaff.setLastName(_name[1]==null?"":_name[1]);
				newStaff.setMobile("" + i);
				newStaff.setVolunteerExperience(i);
				newStaff.setTypeId((Codes) manager.get(Codes.class, PersonType.VOLUNTEER));
				newStaff.setBaseTable(base);
				this.manager.save(newStaff);
				logger.debug("Data " + newStaff.getFirstName());
			}
		}
		logger.debug("End Debug Data");
	}
}
