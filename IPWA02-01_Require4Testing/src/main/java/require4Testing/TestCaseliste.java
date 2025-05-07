package require4Testing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class TestCaseliste implements Serializable {

    @Inject
    private TestCaseDAO testCaseDAO;

    public List<TestCase> getTestCase() {
        return testCaseDAO.findAll();
    }

    public List<TestCase> getTestCaseForTester(Long testerId) {
        return testCaseDAO.findAll().stream()
                .filter(tc -> tc.getTester() != null && testerId.equals(tc.getTester().getId()))
                .collect(Collectors.toList());
    }

    public List<TestCase> getTestCaseForRequirement(Long requirementId) {
        return testCaseDAO.findAll().stream()
                .filter(tc -> tc.getRequirement() != null && requirementId.equals(tc.getRequirement().getID()))
                .collect(Collectors.toList());
    }

    public List<TestCase> getTestCaseForTestRun(Long testRunId) {
        return testCaseDAO.findAll().stream()
                .filter(tc -> tc.getTestRun() != null && testRunId.equals(tc.getTestRun().getID()))
                .collect(Collectors.toList());
    }
}
