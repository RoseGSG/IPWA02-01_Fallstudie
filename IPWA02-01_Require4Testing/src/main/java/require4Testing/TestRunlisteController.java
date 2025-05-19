package require4Testing;

import java.io.Serializable;
import java.util.ArrayList;
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
            // Wenn ein TestCase über die UI ausgewählt wurde
            if (t.getTestCase() != null) {
                TestCase ausgewaehlterTestCase = t.getTestCase();

                // Optional: TestCase frisch aus der DB laden (nicht zwingend, aber sicherer)
                ausgewaehlterTestCase = testCaseDAO.findById(ausgewaehlterTestCase.getId());

                if (ausgewaehlterTestCase != null) {
                    // Den ausgewählten TestRun setzen → setzt den Fremdschlüssel in TestCase
                    ausgewaehlterTestCase.setTestRun(t);

                    // TestCase speichern (damit der Fremdschlüssel in DB geschrieben wird!)
                    testCaseDAO.update(ausgewaehlterTestCase);

                    // Bidirektionale Beziehung pflegen (für View-Logik oder spätere Abfragen)
                    if (t.getTestCases() == null) {
                        t.setTestCases(new ArrayList<>());
                    }
                    if (!t.getTestCases().contains(ausgewaehlterTestCase)) {
                        t.getTestCases().add(ausgewaehlterTestCase);
                    }
                }
            }

            // TestRun aktualisieren (Name, Beschreibung etc.)
            dao.update(t);

            // Liste neu laden
            testrunliste.refreshListe();

            // Log-Ausgabe
            String testfallInfo = (t.getTestCases() != null && !t.getTestCases().isEmpty())
                ? t.getTestCases().get(0).getDescription()
                : "keiner";
            System.out.println("Gespeichert: " + t.getName() + " mit Testfall: " + testfallInfo);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    public Class<TestRun> getTestRunType() {
    	return TestRun.class;
    }

    public List<TestCase> getAlleTestCases() {
        return alleTestCases;
    }
    
    public Class<TestCase> getTestCaseType() {
    	return TestCase.class;
    }
    
    public List<Tester> getAlleTester() {
        return alleTester;
    }

}
