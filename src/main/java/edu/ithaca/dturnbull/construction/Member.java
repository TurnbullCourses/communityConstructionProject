package edu.ithaca.dturnbull.construction;

public class Member extends User {

    private String email;
    private String password;
    private Integer id;
    private String fullName;

    // Member Constructor 
    public Member(String email, String password, Integer id, String fullName) {
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
    public Project viewCurrentProject() {
        
        return null;
    }

    /**
     * View the cost associated with the current project
     * @return The cost
     */
    public double viewCost() {
        
        return null;
    }

    /**
     * View the operating hours associated with the current project
     * @return The operating hours
     */
    public String viewOperatingHours() {
        
        return null;
    }

    /**
     * View the timeline associated with the current project
     * @return The timeline
     */
    public String viewTimeline() {
        
        return null;
    }

}
