package edu.ithaca.dturnbull.construction;
public class User {
    private String fullName;
    private String email;
    private String password;
    private Integer id;
    protected Project currentProject; //current project when user logged in and last project viewed when user logged out

    public User (String fullName, String email, String password, Integer id){
        this.fullName = fullName;
        this.email = email;
        this.password = password; // stored as a hash
        this.id = id;
    }

    //getters
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Integer getId() { return id; }
    public String getFullName() { return fullName; }

    //setters
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public void deleteAccount(){
        //TODO delete account from database
        System.out.println("Account Deleted");
    }
       
    /*-----------------------------------*/
    /**
     * View the current project that is being worked on
     * @return The current project
     */
    public Project viewCurrentProject(){
        return currentProject; 
    }

     /**
     * View the operating hours associated with the current project
     * @return The operating hours
     */
    public String viewOperatingHours() {
        return currentProject.getOperatingHours(); 
    }



}


