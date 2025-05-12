package require4Testing;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class TesterDAO extends _GenericDAO<Tester> {

    public TesterDAO() {
        setEntityClass(Tester.class);
    }  
}

