package require4Testing;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("testRunliste")
@ApplicationScoped
public class TestRunliste implements Serializable {
	private static TestRunliste instance = new TestRunliste();
	private List<TestRun> liste = new ArrayList<TestRun>();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	public TestRunliste() {
		try {
			liste.add(new TestRun("Testlauf A", "Beschreibung für den ersten Testlauf", dateFormat.parse("01.01.2025"), dateFormat.parse("03.09.2024")));
			liste.add(new TestRun("Testlauf B", "Da müssen wir noch nacharbeiten", dateFormat.parse("22.03.2025"), dateFormat.parse("10.09.2024")));
			liste.add(new TestRun("Testlauf C", "Man sollte schon arbeiten gehen", dateFormat.parse("15.11.2024"), dateFormat.parse("17.09.2024")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static TestRunliste getInstance() {
		return instance;
	}

	public List<TestRun> getListe() {
		return liste;
	}
}
