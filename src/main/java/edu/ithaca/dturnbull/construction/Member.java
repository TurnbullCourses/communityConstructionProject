package edu.ithaca.dturnbull.construction;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Member extends User {

    private String email;
    private String password;
    private Integer id;
    private String fullName;

    // Member Constructor 
    public Member(Project project, String email, String password, Integer id, String fullName) {
        super(project, email, password, id, fullName)
        this.email = email;
        this.password = password;
        this.id = id;
        this.fullName = fullName;
    }

    // Getter Methods
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Integer getId() { return id; }
    public String getFullName() { return fullName; }

    // Setter Methods
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setId(Integer id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    /*-----------------------------------*/
    /**
     * View the current project that is being worked on
     * @return The current project
     */
    public String viewCurrentProject() {
        int id = Project.getProjectId();
        String name = Project.getName();
        return "Project ID: " + String.valueOf(id) + "\n" + "Project name: " + name;
    }

    /**
     * View the price associated with the current project
     * @return The cost
     */
    public double viewPrice() {
        double price = Project.getPrice();
        return price;
    }

    /**
     * View the operating hours associated with the current project
     * @return The operating hours
     */
    public String viewOperatingHours() {
        String operatingHours = Project.getOperatingHours();
        return operatingHours;
    }

    /**
     * View the timeline associated with the current project
     * @return The timeline
     */
    public LocalDate viewTimeline() {
        LocalDate completionDate = Project.getCompletionDate();
        return completionDate;
    }

}
