package require4Testing;

import jakarta.persistence.*;

@Entity
public class Testmanager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // ID wird automatisch von der DB generiert
    private Long id;

    private String name;
    private String login;
    private String password;

    // Standardkonstruktor
    public Testmanager() {
    }

    // Konstruktor für die Initialisierung
    public Testmanager(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
	public boolean equals(Object obj) {
		if(obj instanceof Testmanager) {
			Testmanager b = (Testmanager)obj;
			if(b.getLogin().equals(this.login) && b.getPassword().equals(this.password)) {
				return true;
			}
		}
		return false;
	}
    
}
