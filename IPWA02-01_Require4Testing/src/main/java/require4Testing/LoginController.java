package require4Testing;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {

    private String login;
    private String password;

    private Tester loggedTester;
    private RequirementEngineer loggedEngineer;
    private Testfallersteller loggedTestfallersteller;
    private Testmanager loggedTestmanager;

    @Inject
    private UserRepository userRepository;


    public String login() {

        loggedTester = userRepository.findTesterByLoginAndPassword(login, password);
        if (loggedTester != null) {
            return "testcaselisteTester?faces-redirect=true";
        }

        loggedEngineer = userRepository.findEngineerByLoginAndPassword(login, password);
        if (loggedEngineer != null) {
            return "requirementliste?faces-redirect=true";
        }
        
        loggedTestfallersteller = userRepository.findTestfallerstellerByLoginAndPassword(login, password);
        if (loggedTestfallersteller != null) {
            return "testcaselisteCreator?faces-redirect=true";
        }
        
        loggedTestmanager = userRepository.findTestmanagerByLoginAndPassword(login, password);
        if (loggedTestmanager != null) {
            return "testRunliste?faces-redirect=true";
        }

        // Falls kein Login erfolgreich war
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login fehlgeschlagen", "Benutzername oder Passwort ist ungültig."));
        return null;
    }

    // Logout und Session invalidieren
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    // Getter & Setter
    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Tester getLoggedTester() {return loggedTester;}

    public RequirementEngineer getLoggedEngineer() {return loggedEngineer;}
    
    public Testfallersteller getLoggedTestfallersteller() {return loggedTestfallersteller;}
    
    public Testmanager getLoggedTestmanager() {return loggedTestmanager;}

    public boolean isLoggedIn() {return loggedTester != null || loggedEngineer != null;}

    public boolean isTesterLoggedIn() {return loggedTester != null;}

    public boolean isEngineerLoggedIn() {return loggedEngineer != null;}
    
    public boolean isTestfallerstellerLoggedIn() {return loggedTestfallersteller != null;}
    
    public boolean isTestmanagerLoggedIn() {return loggedTestmanager != null;}
}
