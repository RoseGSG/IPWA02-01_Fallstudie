package require4Testing;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class Requirementliste implements Serializable {

    @Inject
    private RequirementDAO dao;

    private List<Requirement> liste;

    public Requirementliste() {
    }

    public List<Requirement> getListe() {
        if (liste == null) {
            liste = dao.findAll();
        }
        return liste;
    }

    public void refreshListe() {
        liste = dao.findAll();
    }
}
