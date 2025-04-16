package require4Testing;

import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class TestCaselisteController
             implements Serializable
{
    public String startEdit1() {
        return "testcaselisteTesterEdit";
    }
    
    public String stopEdit1() {
        return "testcaselisteTester";
    }

    public String startEdit2() {
        return "testcaselisteCreatorEdit";
    }
    
    public String stopEdit2() {
        return "testcaselisteCreator";
    }
    
    public String logOut() {
    	return "login";
    }
}
