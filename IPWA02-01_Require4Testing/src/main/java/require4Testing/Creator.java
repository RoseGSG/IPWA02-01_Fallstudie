package require4Testing;

public class Creator {
	String name;
	String login;
	String passwort;
	
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
	public Creator(String login, String passwort) {
		super();
		this.login = login;
		this.passwort = passwort;
	}
	public Creator() {
		super();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Creator) {
			Creator b = (Creator)obj;
			if(b.getLogin().equals(this.login) && b.getPasswort().equals(this.passwort)) {
				return true;
			}
		}
		return false;
	}
}
