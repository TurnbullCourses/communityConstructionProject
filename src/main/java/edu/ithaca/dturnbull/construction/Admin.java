package edu.ithaca.dturnbull.construction;

public class Admin extends User {

    public String email;
    public String password;
    public int id;
    public String fullName;

    public Admin(String email, String password, int id, String fullName){
        super(fullName, email, password, id);
    }
    
    public void manageCurrentProject(){
        // manage current projects
    }

    public void managePastProject(){
        // manage past projects
    }

    public void manageFutureProjects(){
        // manage future projects
    }

    public void markComplete(){
        // mark a project as complete
    }

    public void markIncomplete(){
        // mark a project as incomplete
    }

    public void viewProjectNotes(){
        // view project notes
    }
  


}
