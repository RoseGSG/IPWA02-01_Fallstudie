package require4Testing;

import jakarta.persistence.*;

@Entity
public class RequirementEngineer {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	String name;
	String login;
	String passwort;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public RequirementEngineer(String login, String passwort) {
		super();
		this.login = login;
		this.passwort = passwort;
	}
	public RequirementEngineer() {
		super();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof RequirementEngineer) {
			RequirementEngineer b = (RequirementEngineer)obj;
			if(b.getLogin().equals(this.login) && b.getPasswort().equals(this.passwort)) {
				return true;
			}
		}
		return false;
	}
}
