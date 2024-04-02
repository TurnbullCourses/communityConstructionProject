package edu.ithaca.dturnbull.construction;

import java.time.LocalDate;
import java.time.LocalDateTime;

import edu.ithaca.dturnbull.construction.Project;

public class Client extends User{
    public Client(String fullName, String email, String password, Integer id){
        super(fullName, email, password, id);
    }

    public Project requestCurrentProject(){
        return currentProject; 
    }

    public double requestCost(){
        return currentProject.getPrice(); 
        //TODO -- Not sure what Request cost (and other methods) should do differently that viewCost in Member? 
        //Is it a setter?
    }

    public String requestOperatingHours(){ //TODO -- same as above
        return currentProject.getOperatingHours();
    }

    public LocalDate requestCompletionDate(){ //TODO -- same as above
        return currentProject.getCompletionDate();
    }

    public String requestTimeline(){ //TODO -- same as above
        return null;
    }

    

    
}
