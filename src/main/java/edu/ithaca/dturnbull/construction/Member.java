package edu.ithaca.dturnbull.construction;

import java.time.LocalDate;

public class Member extends User {
    // Member Constructor 
    public Member(String fullName, String email, String password, Integer id) {
        super(fullName, email, password, id);
    }

    /**
     * View the cost associated with the current project
     * @return The cost
     */
    public Double viewCost() {
        
        return currentProject.getPrice(); 
    }

    /**
     * View the completionDate associated with the current project
     * @return The Completion Date
     */
    public LocalDate viewCompletionDate() {
        return currentProject.getCompletionDate();
    }

    /**
     * View the timeline associated with the current project
     * @return A string with the start date and completion date of the project
     */
    public String viewTimeline() {
        return "From " + "NO START DATE IN PROJECT" + " to " + currentProject.getCompletionDate().toString();
        //TODO -- Add start date to project(get current time in Project constructor)
    }



}
