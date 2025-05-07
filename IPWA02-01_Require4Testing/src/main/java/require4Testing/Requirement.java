package require4Testing;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String title;
    private String description;
    private Date createDate;
    
    @OneToMany(mappedBy = "requirement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestCase> testCases = new ArrayList<>();

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
    
    public List<TestCase> getTestCases() { return testCases; }
    public void setTestCases(List<TestCase> testCases) { this.testCases = testCases; }

    // Equals und HashCode basierend auf der ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Requirement that = (Requirement) o;
        return ID != null && ID.equals(that.ID);
    }

    @Override
    public int hashCode() {
        return 31 + (ID != null ? ID.hashCode() : 0);
    }

    // Optionale ToString-Methode
    @Override
    public String toString() {
        return "Requirement[ID=" + ID + ", title=" + title + "]";
    }
}
