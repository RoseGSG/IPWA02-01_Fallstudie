package require4Testing;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class TestCaseDAO extends _GenericDAO<TestCase> {

    public TestCaseDAO() {
        setEntityClass(TestCase.class);
    }  
}

