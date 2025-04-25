package require4Testing;

import java.util.Date;
import java.util.List;

public class Requirement {
    private Long ID;
    private String title;
    private String description;
    private Date createDate;

    public Requirement(String title, String description, Date createDate) {
        this.title = title;
        this.description = description;
        this.createDate = createDate;
    }

    // Getter & Setter
    public Long getID() { return ID; }
    public void setID(Long ID) { this.ID = ID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }
}
