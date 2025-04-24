package require4Testing;

import java.io.Serializable;
import java.util.List;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;

@Named("requirementController")
@ViewScoped
public class RequirementlisteController implements Serializable {
    @Inject
    private GenericDAO<Requirement> requirementDAO;
    private List<Requirement> requirements;
    private Requirement selectedRequirement;

    public RequirementlisteController() {
        requirementDAO = new GenericDAO<>(Requirement.class);
        requirements = requirementDAO.findAll();
    }

    public String startEdit(Requirement requirement) {
        selectedRequirement = requirement;
        return "requirementEdit";
    }

    public String stopEdit() {
        if (selectedRequirement != null) {
            requirementDAO.update(selectedRequirement);
        }
        return "requirementliste";
    }

    public void deleteRequirement(Long id) {
        requirementDAO.delete(id);
        requirements = requirementDAO.findAll(); // Refresh the list
    }

    public void addRequirement() {
        Requirement newRequirement = new Requirement();
        requirementDAO.create(newRequirement);
        requirements.add(newRequirement);
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public Requirement getSelectedRequirement() {
        return selectedRequirement;
    }

    public void setSelectedRequirement(Requirement selectedRequirement) {
        this.selectedRequirement = selectedRequirement;
    }

    public String logOut() {
        return "login";
    }
}
