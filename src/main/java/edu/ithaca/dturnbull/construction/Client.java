package edu.ithaca.dturnbull.construction;

public class Client implements User{
    private String name;
    private String email;
    private String password;
    private Project currentProject; //current project when user logged in and last project viewed when user logged out

    public Client(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password; // stored as a hash
    }
    

    public void deleteAccount(){
        //TODO delete account from database
        System.out.println("Account Deleted");
    }   

    public void updateAccount(){
        //TODO update account in database
        System.out.println("Account Updated");
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public boolean checkPassword(String password){
        if(this.password == password){
            return true;
        }
        else{
            return false;
        }
    
    }

    public void changeEmail(String email){
        this.email = email;
    }

    public void changeName(String name){
        this.name = name;
    } 

    public Project viewCurrentProject(){
        return currentProject;
    }

    public String viewOperatingHours(){
        //TODO -- will be replaced with actual operating hours
        return null;
    }

    public Project requestCurrentProject(){
        return null; //TODO -- will be replaced with actual project object
    }

    public double requestCost(){
        return 0; //TODO -- will be replaced with actual cost
    }

    public String requestOperatingHours(){
        return null; //TODO -- will be replaced with actual operating hours
    }

    public String requestTimeline(){
        return null; //TODO -- will be replaced with actual timeline
    }

    

    
}
