package require4Testing;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("requirementController")
@ViewScoped
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

    // Speichern eines existierenden Requirements
    public void speichernEinzeln(Requirement r) {
        try {
            dao.update(r);
            requirementliste.refreshListe();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Speichere: " + r.getTitle());
    }

    // Speichern des neuen Requirements
    public void speichernNeuen() {
        System.out.println("speichernNeuen() wird aufgerufen!");
        try {
            if (isNeuerRequirementValid()) {
                dao.save(neuerRequirement);
                requirementliste.refreshListe();
                neuerRequirement = new Requirement(); // Zurücksetzen
                System.out.println("Neues Requirement gespeichert.");
            } else {
                System.out.println("Validierung fehlgeschlagen!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean isNeuerRequirementValid() {
        return neuerRequirement.getTitle() != null 
        	   && !neuerRequirement.getTitle().isBlank()
               && neuerRequirement.getCreateDate() != null;
    }



    public void loeschen(Requirement req) {
        try {
            dao.delete(req);
            requirementliste.refreshListe();
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
    
    public String logOut() {
    	return "login?faces-redirect=true";
    }
    
}
