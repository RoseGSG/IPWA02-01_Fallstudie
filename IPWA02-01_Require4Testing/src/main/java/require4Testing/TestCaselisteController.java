package require4Testing;

import java.io.Serializable;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class TestCaselisteController implements Serializable {

    @Inject
    private TestCaseDAO testCaseDAO;

    @Inject
    private RequirementDAO requirementDAO;
    
    @Inject
    private TesterDAO testerDAO;

    private List<TestCase> testCases;
    private List<Requirement> alleRequirements;
    private List<Tester> alleTester; 

    private TestCase neuerTestCase = new TestCase();

    @PostConstruct
    public void init() {
        testCases = testCaseDAO.findAll();
        alleRequirements = requirementDAO.findAll();
        neuerTestCase.setStatus("offen");
        alleTester = testerDAO.findAll();
    }

    // Getter für View
    public List<TestCase> getTestCases() {
        return testCases;
    }

    public List<Requirement> getAlleRequirements() {
        return alleRequirements;
    }

    public TestCase getNeuerTestCase() {
        return neuerTestCase;
    }
    
    public Class<TestCase> getTestCaseType() {
    	return TestCase.class;
    }

    public Class<Requirement> getRequirementType() {
        return Requirement.class;
    }
    
    public List<Tester> getAlleTester() {
        return alleTester;
    }
    
    public Class<Tester> getTesterType(){
    	return Tester.class;
    }

    // Methoden
    public void speichernEinzeln(TestCase testCase) {
        testCaseDAO.update(testCase);
    }

    public void speichernEinzeln(Tester tester) {
        testerDAO.update(tester);
    }
    public void speichernNeuenTestCase() {
        testCaseDAO.save(neuerTestCase);
        testCases = testCaseDAO.findAll(); // Liste aktualisieren
        neuerTestCase = new TestCase();    // leeren für nächste Eingabe
        neuerTestCase.setStatus("offen"); 
    }
    
    public void deleteTestCase(TestCase testCase) {
        testCaseDAO.delete(testCase);  // Löschen aus der Datenbank
        testCases = testCaseDAO.findAll();  // Liste neu laden, um die Anzeige zu aktualisieren
    }

    public String startEdit1() {
        return "testcaselisteTesterEdit?faces-redirect=true";
    }

    public String stopEdit1() {
        return "testcaselisteTester?faces-redirect=true";
    }

    public String startEdit2() {
        return "testcaselisteCreatorEdit?faces-redirect=true";
    }

    public String stopEdit2() {
        return "testcaselisteCreator?faces-redirect=true";
    }

    public String logOut() {
        return "login?faces-redirect=true";
    }
}
