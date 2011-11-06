package sg.edu.nus.iss.vms.common;

import java.io.Serializable;

import sg.edu.nus.iss.vms.common.dto.Person;

/**
 * 
 * @author zaw.htet
 */
public class SessionBean implements Serializable {

	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
