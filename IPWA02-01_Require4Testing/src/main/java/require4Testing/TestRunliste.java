package require4Testing;

import java.io.Serializable;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.*;

@Named
@RequestScoped
public class TestRunliste implements Serializable {

	@Inject
    private TestRunDAO dao;

    private List<TestRun> liste;

    public TestRunliste() {
    }

    public List<TestRun> getListe() {
            return dao.findAll();
    }

    public void refreshListe() {
        liste = dao.findAll();
    }
}
