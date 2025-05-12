package require4Testing;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class TestCase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requirement_id")
    private Requirement requirement;

    @ManyToOne
    @JoinColumn(name = "test_run_id")
    private TestRun testRun;

    @ManyToOne
    @JoinColumn(name = "tester_id")
    private Tester tester;

    private String description;
    private String status;

    public TestCase() {
    }

    public TestCase(Requirement requirement, TestRun testRun, Tester tester, String description, String status) {
        this.requirement = requirement;
        this.testRun = testRun;
        this.tester = tester;
        this.description = description;
        this.status = status;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Requirement getRequirement() { return requirement; }
    public void setRequirement(Requirement requirement) { this.requirement = requirement; }

    public TestRun getTestRun() { return testRun; }
    public void setTestRun(TestRun testRun) { this.testRun = testRun; }

    public Tester getTester() { return tester; }
    public void setTester(Tester tester) { this.tester = tester; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
