package require4Testing;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class TestRun {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    
    @OneToMany(mappedBy = "testRun", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestCase> testCases = new ArrayList<>();

    public TestRun() {
    	}
    
    public TestRun(String name, String description, Date startDate, Date endDate) {
    	this.name = name;
    	this.description = description;
    	this.startDate = startDate;
    	this.endDate = endDate;
    }
    
    // Getter & Setter
    public Long getID() { return ID; }
    public void setID(Long ID) { this.ID = ID; }

    public String getName() { return name; }
    public void setName (String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public List<TestCase> getTestCases() {return testCases;}
    public void setTestCases(List<TestCase> testCases) {this.testCases = testCases;}

}