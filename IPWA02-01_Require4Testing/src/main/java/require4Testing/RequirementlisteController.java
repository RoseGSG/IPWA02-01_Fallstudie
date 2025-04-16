package require4Testing;

import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("requirementController")
@ViewScoped
public class RequirementlisteController
             implements Serializable
{
    public String startEdit() {
        return "requirementEdit";
    }
    
    public String stopEdit() {
        return "requirementliste";
    }
    
    public String logOut() {
    	return "login";
    }
}
