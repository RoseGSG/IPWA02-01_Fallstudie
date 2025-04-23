package require4Testing;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
public class TestCase implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "requirementID")
    private Requirement requirementID;

    @ManyToOne
    @JoinColumn(name = "testRunID")
    private TestRun testRunID;

    @ManyToOne
    @JoinColumn(name = "testerID")
    private Tester testerID;

    @ManyToOne
    @JoinColumn(name = "creatorID")
    private Creator creatorID;

    private String description;
    private String status;

    public TestCase() {}

    public TestCase(Requirement requirementID, TestRun testRunID, Tester testerID, Creator creatorID, String description, String status) {
        this.requirementID = requirementID;
        this.testRunID = testRunID;
        this.testerID = testerID;
        this.creatorID = creatorID;
        this.description = description;
        this.status = status;
    }

    // Getter & Setter
    public Long getID() { return ID; }
    public void setID(Long ID) { this.ID = ID; }

    public Requirement getRequirementID() { return requirementID; }
    public void setRequirementID(Requirement requirementID) { this.requirementID = requirementID; }

    public TestRun getTestRunID() { return testRunID; }
    public void setTestRunID(TestRun testRunID) { this.testRunID = testRunID; }

    public Tester getTesterID() { return testerID; }
    public void setTesterID(Tester testerID) { this.testerID = testerID; }

    public Creator getCreatorID() { return creatorID; }
    public void setCreatorID(Creator creatorID) { this.creatorID = creatorID; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
