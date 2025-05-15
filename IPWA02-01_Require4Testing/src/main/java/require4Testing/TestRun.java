package require4Testing;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
public class TestRun {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    
    @OneToMany(mappedBy = "testRun", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestCase> testCases = new ArrayList<>();

    @Transient
    private TestCase testCase;
    
    public TestRun() {
    	}
    
    public TestRun(String name, String description, Date startDate, Date endDate) {
    	this.name = name;
    	this.description = description;
    	this.startDate = startDate;
    	this.endDate = endDate;
    }
    
    
    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public TestCase getTestCase() { return testCase; }
    public void setTestCase (TestCase testCase) {this.testCase = testCase; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestRun testRun = (TestRun) o;
        return id != null && id.equals(testRun.id);
    }

    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : 0;
    }

}