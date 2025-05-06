package require4Testing;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class TestRunDAO extends _GenericDAO<TestRun> {

    public TestRunDAO() {
        setEntityClass(TestRun.class);
    }  
}

