package require4Testing;

import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("testCaselisteController")
@ViewScoped
public class TestCaselisteController
             implements Serializable
{
    public String startEdit() {
        return "testcaselisteTesterEdit";
    }
    
    public String stopEdit() {
        return "testcaselisteTester";
    }
}
