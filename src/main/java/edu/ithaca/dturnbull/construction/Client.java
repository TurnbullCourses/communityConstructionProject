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

    //sets price of current project
    public void requestCost(double newCost){
        if (newCost < 0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        currentProject.setPrice(newCost); 
    }
    //sets price of current project
    public void requestOperatingHours(LocalDateTime start, LocalDateTime end){
        currentProject.setOperatingHours(start, end);
    }
    //sets completion date of current project
    public void requestCompletionDate(LocalDate newDate){ 
        currentProject.setCompletionDate(newDate);
    }
    
    public String requestTimeline(){ //TODO -- what should this method do?
        return null;
    }

    

    
}
