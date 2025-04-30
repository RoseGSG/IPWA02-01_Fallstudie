package require4Testing;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Requirement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String title;
    private String description;
    private Date createDate;

    public Requirement() {
    	}
    
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
