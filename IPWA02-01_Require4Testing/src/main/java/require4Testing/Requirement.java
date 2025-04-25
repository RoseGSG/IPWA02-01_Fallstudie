package require4Testing;

import java.util.Date;
import java.util.List;

public class Requirement {
    private Long ID;
    private long engineerID;
    private String title;
    private String description;
    private Date createDate;

    public Requirement(long engineerID, String title, String description, Date createDate) {
        this.engineerID = engineerID;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
    }

    // Getter & Setter
    public Long getID() { return ID; }
    public void setID(Long ID) { this.ID = ID; }

    public long getEngineerID() { return engineerID; }
    public void setEngineerID(long engineerID) { this.engineerID = engineerID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }
}
