package require4Testing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class TestCaseliste implements Serializable {
    private static TestCaseliste instance = new TestCaseliste();
    private List<TestCase> testCase;

    public TestCaseliste() {
        testCase = new ArrayList<>();
        
        // Beispielhafte Erstellung von Requirement, TestRun, Tester und Creator Objekten
        Requirement req1 = new Requirement("Title 1", "Description 1", new Date());
        TestRun run1 = new TestRun();
        Tester tester1 = new Tester();
        Creator creator1 = new Creator();

        testCase.add(new TestCase(req1, run1, tester1, creator1, "Testfall 1", "Offen"));

        Requirement req2 = new Requirement("Title 2", "Description 2", new Date());
        TestRun run2 = new TestRun();
        Tester tester2 = new Tester();
        Creator creator2 = new Creator();

        testCase.add(new TestCase(req2, run2, tester2, creator2, "Testfall 2", "Geschlossen"));

        Requirement req3 = new Requirement("Title 3", "Description 3", new Date());
        TestRun run3 = new TestRun();
        Tester tester3 = new Tester();
        Creator creator3 = new Creator();

        testCase.add(new TestCase(req3, run3, tester3, creator3, "Testfall 3", "In Bearbeitung"));
    }

    public List<TestCase> getTestCase() {
        return testCase;
    }

    public List<TestCase> getTestCaseForTester(Long testerID) {
        List<TestCase> result = new ArrayList<>();
        for (TestCase testCase : testCase) {
            if (testCase.getTesterID().getID().equals(testerID)) {
                result.add(testCase);
            }
        }
        return result;
    }

    public List<TestCase> getTestCaseForCreator(Long creatorID) {
        List<TestCase> result = new ArrayList<>();
        for (TestCase testCase : testCase) {
            if (testCase.getCreatorID().getID().equals(creatorID)) {
                result.add(testCase);
            }
        }
        return result;
    }

    public List<TestCase> getTestCaseForManager() {
        return testCase; // Alle Testfälle zurückgeben
    }
}