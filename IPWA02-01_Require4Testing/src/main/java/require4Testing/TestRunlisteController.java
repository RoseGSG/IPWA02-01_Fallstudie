package require4Testing;

import java.io.Serializable;
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
	
	private TestRun neuerTestRun = new TestRun();
	
	public String startEdit() {
        return "testRunEdit?faces-redirect=true";
    }
    
    public String stopEdit() {
        return "testRunliste?faces-redirect=true";
    }
    
    public void speichernEinzeln(TestRun t) {
        try {
            dao.update(t);
            testrunliste.refreshListe();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Speichere: " + t.getName());
    }

    // Speichern des neuen Requirements
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
    
    public String logOut() {
    	return "login?faces-redirect=true";
    }
}
