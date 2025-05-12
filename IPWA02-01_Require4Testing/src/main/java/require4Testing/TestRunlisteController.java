package require4Testing;

import java.io.Serializable;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("testRunlisteController")
@ViewScoped
public class TestRunlisteController implements Serializable {

    @Inject
    private TestRunDAO dao;

    @Inject
    private TestRunliste testrunliste;

    @Inject
    private TestCaseDAO testCaseDAO; // NEU: DAO für Testfälle

    @Inject
    private TesterDAO testerDAO;     // NEU: DAO für Tester

    private TestRun neuerTestRun = new TestRun();

    private List<TestCase> alleTestCases; // Für Dropdown
    private List<Tester> alleTester;      // Für Dropdown

    @PostConstruct
    public void init() {
        alleTestCases = testCaseDAO.findAll(); // Liste aller Testfälle laden
        alleTester = testerDAO.findAll();      // Liste aller Tester laden
    }

    public String startEdit() {
        return "testRunEdit?faces-redirect=true";
    }

    public String stopEdit() {
        return "testRunliste?faces-redirect=true";
    }

    public void speichernEinzeln(TestRun t) {
        try {
        	TestCase selectedCase = t.getTestCase();
            if (selectedCase != null) {
                selectedCase.setTestRun(t);
                testCaseDAO.update(selectedCase);
            }
        	
            dao.update(t);
            testrunliste.refreshListe();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Speichere: " + t.getName());
        System.out.println("Beschreibung: " + t.getDescription());
    }

    public void speichernNeuen() {
        System.out.println("speichernNeuen() wird aufgerufen!");
        try {
            if (isNeuerTestRunValid()) {
                dao.save(neuerTestRun);
                testrunliste.refreshListe();
                neuerTestRun = new TestRun(); // Zurücksetzen
                System.out.println("Neuer TestRun gespeichert.");
            } else {
                System.out.println("Validierung TestRun fehlgeschlagen!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isNeuerTestRunValid() {
        return neuerTestRun.getName() != null 
            && !neuerTestRun.getName().isBlank()
            && neuerTestRun.getStartDate() != null;
    }

    public void loeschen(TestRun trun) {
        try {
            dao.delete(trun);
            testrunliste.refreshListe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TestRun getNeuerTestRun() {
        return neuerTestRun;
    }

    public void setNeuerTestRun(TestRun neuerTestRun) {
        this.neuerTestRun = neuerTestRun;
    }

    public List<TestCase> getAlleTestCases() {
        return alleTestCases;
    }

    public List<Tester> getAlleTester() {
        return alleTester;
    }

    public String logOut() {
        return "login?faces-redirect=true";
    }
}
