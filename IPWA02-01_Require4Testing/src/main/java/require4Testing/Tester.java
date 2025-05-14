package require4Testing;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class Tester {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // ID wird automatisch von der DB generiert
    private Long id;

    private String name;
    private String login;
    private String password;
    
    @OneToMany(mappedBy = "tester", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestCase> testCases = new ArrayList<>();

    // Standardkonstruktor
    public Tester() {
    }

    // Konstruktor für die Initialisierung
    public Tester(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    // Getter & Setter
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}
    
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    
    @Override
	public boolean equals(Object obj) {
		if(obj instanceof Tester) {
			Tester b = (Tester)obj;
			if(b.getLogin().equals(this.login) && b.getPassword().equals(this.password)) {
				return true;
			}
		}
		return false;
	}
    
    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : 0;
    }
    
    public List<TestCase> getTestCases() {return testCases;}
    public void setTestCases(List<TestCase> testCases) {this.testCases = testCases;}

}
