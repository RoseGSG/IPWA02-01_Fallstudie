package require4Testing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class Requirementliste implements Serializable {

    @Inject
    private RequirementDAO dao;

    private List<Requirement> liste;

    public Requirementliste() {
    }

    public List<Requirement> getListe() {
            return dao.findAll();
    }

    public void refreshListe() {
        liste = dao.findAll();
    }
}
