package require4Testing;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class LoginController implements Serializable {

    private String login;
    private String password;

    @Inject
    private UserRepository userRepository;

    // Event-Handler für das Username-Feld
    public void postValidateName(jakarta.faces.event.ComponentSystemEvent ev) {
        UIInput input = (UIInput) ev.getComponent();
        this.login = (String) input.getValue();
    }

    // Validierung des Passworts beim Login-Versuch
    public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        this.password = (String) value;

        boolean validTester = userRepository.findTesterByLoginAndPassword(login, password) != null;
        boolean validEngineer = userRepository.findEngineerByLoginAndPassword(login, password) != null;

        if (!validTester && !validEngineer) {
            throw new ValidatorException(new FacesMessage("Login fehlgeschlagen: Benutzer nicht gefunden."));
        }
    }

    // Logik zur Weiterleitung je nach Benutzerrolle
    public String login() {
        Tester tester = userRepository.findTesterByLoginAndPassword(login, password);
        if (tester != null) {
            return "testcaselisteTester?faces-redirect=true";
        }

        RequirementEngineer engineer = userRepository.findEngineerByLoginAndPassword(login, password);
        if (engineer != null) {
            return "requirementliste?faces-redirect=true";
        }

        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unbekannter Fehler beim Login", null));
        return null;
    }


    // Getter & Setter
    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
}
