package sg.edu.nus.iss.vms.member.vo;

import sg.edu.nus.iss.vms.common.dto.Person;

public class MemberVo extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8976171070174297963L;
	public String memberType;
	

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	
}
