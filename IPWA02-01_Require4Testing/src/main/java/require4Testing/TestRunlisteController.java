package require4Testing;

import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("testRunlisteController")
@ViewScoped
public class TestRunlisteController
             implements Serializable
{
    public String startEdit() {
        return "testRunEdit";
    }
    
    public String stopEdit() {
        return "testRunliste";
    }
    
    public String logOut() {
    	return "login";
    }
}
