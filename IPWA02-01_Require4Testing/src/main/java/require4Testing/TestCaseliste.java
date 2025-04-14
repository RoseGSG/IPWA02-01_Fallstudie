package require4Testing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class TestCaseliste implements Serializable {
    private static TestCaseliste instance = new TestCaseliste();
	private List<TestCase> testCase;

    public TestCaseliste() {
        testCase = new ArrayList<>();
        testCase.add(new TestCase(1L, 1L, 1L, 1L, "Testfall 1", "Offen"));
        testCase.add(new TestCase(2L, 2L, 2L, 2L, "Testfall 2", "Geschlossen"));
        testCase.add(new TestCase(3L, 3L, 3L, 3L, "Testfall 3", "In Bearbeitung"));
    }

    public List<TestCase> getTestCase() {
        return testCase;
    }

    public List<TestCase> getTestCaseForTester(Long testerID) {
        List<TestCase> result = new ArrayList<>();
        for (TestCase testCase : testCase) {
            if (testCase.getTesterID().equals(testerID)) {
                result.add(testCase);
            }
        }
        return result;
    }

    public List<TestCase> getTestCaseForCreator(Long creatorID) {
        List<TestCase> result = new ArrayList<>();
        for (TestCase testCase : testCase) {
            if (testCase.getCreatorID().equals(creatorID)) {
                result.add(testCase);
            }
        }
        return result;
    }

    public List<TestCase> getTestCaseForManager() {
        return testCase; // Alle Testfälle zurückgeben
    }
}