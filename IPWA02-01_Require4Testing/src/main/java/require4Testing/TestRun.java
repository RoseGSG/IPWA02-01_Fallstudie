package require4Testing;

import java.util.Date;

public class TestRun {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

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

}