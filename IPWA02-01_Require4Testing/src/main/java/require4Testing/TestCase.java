package require4Testing;

import java.io.Serializable;

public class TestCase implements Serializable {
    private Long ID;
    private Long requirementID;
    private Long testRunID;
    private Long testerID;
    private Long creatorID;
    private String description;
    private String status;

    public TestCase(long requirementID, long testRunID, long testerID, long creatorID, String description, String status) {
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

    public Long getRequirementID() { return requirementID; }
    public void setRequirementID(Long requirementID) { this.requirementID = requirementID; }

    public Long getTestRunID() { return testRunID; }
    public void setTestRunID(Long testRunID) { this.testRunID = testRunID; }

    public Long getTesterID() { return testerID; }
    public void setTesterID(Long testerID) { this.testerID = testerID; }

    public Long getCreatorID() { return creatorID; }
    public void setCreatorID(Long creatorID) { this.creatorID = creatorID; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}