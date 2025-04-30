package require4Testing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("requirementController")
@RequestScoped
public class RequirementlisteController implements Serializable {

    @Inject
    private RequirementDAO dao;

    @Inject
    private Requirementliste requirementliste;

    private Requirement neuerRequirement = new Requirement();

    public String startEdit() {
        return "requirementEdit?faces-redirect=true";
    }

    public String stopEdit() {
        return "requirementliste?faces-redirect=true";
    }

    public String logOut() {
        return "login?faces-redirect=true";
    }

    public void speichern() {
        try {
            dao.save(neuerRequirement);
            requirementliste.refreshListe();
            neuerRequirement = new Requirement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Requirement getNeuerRequirement() {
        return neuerRequirement;
    }

    public void setNeuerRequirement(Requirement neuerRequirement) {
        this.neuerRequirement = neuerRequirement;
    }
}
