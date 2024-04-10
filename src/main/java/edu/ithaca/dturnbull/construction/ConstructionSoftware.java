package edu.ithaca.dturnbull.construction;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ConstructionSoftware {
    protected ArrayList<User> users;
    protected ArrayList<Client> clients;
    protected ArrayList<Member> members;
    protected ArrayList<Project> projects;
    protected ArrayList<Admin> admins;
    protected ArrayList<Project> pastProjects;
    protected ArrayList<Project> currentProjects;


    public ConstructionSoftware(){
        this.users = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.members = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.pastProjects = new ArrayList<>();
        this.currentProjects = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void addProject(Project project){
        projects.add(project);
    }

    public void addAdmin(Admin admin){
        admins.add(admin);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public void removeClient(Client client){
        clients.remove(client);
    }

    public void removeMember(Member member){
        members.remove(member);
    }

    public void removeProject(Project project){
        projects.remove(project);
    }

    public void removeAdmin(Admin admin){
        admins.remove(admin);
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<Client> getClients(){
        return clients;
    }

    public ArrayList<Member> getMembers(){
        return members;
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }

    public ArrayList<Admin> getAdmins(){
        return admins;
    }

    public User getUser(String fullName){
        for(User user : users){
            if(user.getFullName().equals(fullName)){
                return user;
            }
        }
        return null;
    }

    public Client getClient(String fullName){
        for(Client client : clients){
            if(client.getFullName().equals(fullName)){
                return client;
            }
        }
        return null;
    }

    public Member getMember(String fullName){
        for(Member member : members){
            if(member.getFullName().equals(fullName)){
                return member;
            }
        }
        return null;
    }

    public Project getProject(String projectName){
        for(Project project : projects){
            if(project.getName().equals(projectName)){
                return project;
            }
        }
        return null;
    }

    public Admin getAdmin(String fullName){
        for(Admin admin : admins){
            if(admin.getFullName().equals(fullName)){
                return admin;
            }
        }
        return null;
    }

    public boolean userExists(String fullName){
        for(User user : users){
            if(user.getFullName().equals(fullName)){
                return true;
            }
        }
        return false;
    }

    public boolean clientExists(String fullName){
        for(Client client : clients){
            if(client.getFullName().equals(fullName)){
                return true;
            }
        }
        return false;
    }

    public boolean memberExists(String fullName){
        for(Member member : members){
            if(member.getFullName().equals(fullName)){
                return true;
            }
        }
        return false;
    }

    public boolean projectExists(String projectName){
        for(Project project : projects){
            if(project.getName().equals(projectName)){
                return true;
            }
        }
        return false;
    }

    public boolean adminExists(String fullName){
        for(Admin admin : admins){
            if(admin.getFullName().equals(fullName)){
                return true;
            }
        }
        return false;
    }

    public boolean userPasswordMatches(String email, String password){
        for(User user : users){
            if(user.getEmail().equals(email)){
                if(user.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean clientPasswordMatches(String email, String password){
        for(Client client : clients){
            if(client.getEmail().equals(email)){
                if(client.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean memberPasswordMatches(String email, String password){
        for(Member member : members){
            if(member.getEmail().equals(email)){
                if(member.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean projectPasswordMatches(String projectName, String password){
        for(Project project : projects){
            if(project.getName().equals(projectName)){
                if(project.getPassword().equals(password)){ //not sure what to do -- there is no password for projects
                    return true;
                }
            }
        }
        return false;
    }

    public boolean adminPasswordMatches(String email, String password){
        for(Admin admin : admins){
            if(admin.getEmail().equals(email)){
                if(admin.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean userIsAdmin(String fullName){
        for(Admin admin : admins){
            if(admin.getFullName().equals(fullName)){
                return true;
            }
        }
        return false;
    }

    public boolean userIsMember(String fullName){
        for(Member member : members){
            if(member.getFullName().equals(fullName)){
                return true;
            }
        }
        return false;
    }

    public boolean userIsClient(String fullName){
        for(Client client : clients){
            if(client.getFullName().equals(fullName)){
                return true;
            }
        }
        return false;
    }

    public void addPastProject(Project project){
        pastProjects.add(project);
    }

    public void addCurrentProject(Project project){
        currentProjects.add(project);
    }

    public void removePastProject(Project project){
        pastProjects.remove(project);
    }

    public void removeCurrentProject(Project project){
        currentProjects.remove(project);
    }

    public ArrayList<Project> getPastProjects(){
        return pastProjects;
    }

    public ArrayList<Project> getCurrentProjects(){
        return currentProjects;
    }
}

    
