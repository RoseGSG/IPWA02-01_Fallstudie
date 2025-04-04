package require4Testing;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("requirementListe")
@ApplicationScoped
public class Requirementliste implements Serializable {
	private static Requirementliste instance = new Requirementliste();
	private List<Requirement> liste = new ArrayList<Requirement>();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	public Requirementliste() {
		try {
			liste.add(new Requirement(1L, "", "Anforderung 1", dateFormat.parse("03.09.2024")));
			liste.add(new Requirement(2L, "", "Anforderung 2", dateFormat.parse("10.09.2024")));
			liste.add(new Requirement(3L, "", "Anforderung 3", dateFormat.parse("17.09.2024")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static Requirementliste getInstance() {
		return instance;
	}

	public List<Requirement> getListe() {
		return liste;
	}
}
