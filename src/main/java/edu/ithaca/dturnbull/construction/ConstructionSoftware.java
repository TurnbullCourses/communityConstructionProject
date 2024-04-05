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

    public User getUser(String username){
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public Client getClient(String username){
        for(Client client : clients){
            if(client.getUsername().equals(username)){
                return client;
            }
        }
        return null;
    }

    public Member getMember(String username){
        for(Member member : members){
            if(member.getUsername().equals(username)){
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

    public Admin getAdmin(String username){
        for(Admin admin : admins){
            if(admin.getUsername().equals(username)){
                return admin;
            }
        }
        return null;
    }

    public boolean userExists(String username){
        for(User user : users){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean clientExists(String username){
        for(Client client : clients){
            if(client.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean memberExists(String username){
        for(Member member : members){
            if(member.getUsername().equals(username)){
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

    public boolean adminExists(String username){
        for(Admin admin : admins){
            if(admin.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean userPasswordMatches(String username, String password){
        for(User user : users){
            if(user.getUsername().equals(username)){
                if(user.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean clientPasswordMatches(String username, String password){
        for(Client client : clients){
            if(client.getUsername().equals(username)){
                if(client.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean memberPasswordMatches(String username, String password){
        for(Member member : members){
            if(member.getUsername().equals(username)){
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
                if(project.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean adminPasswordMatches(String username, String password){
        for(Admin admin : admins){
            if(admin.getUsername().equals(username)){
                if(admin.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean userIsAdmin(String username){
        for(Admin admin : admins){
            if(admin.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean userIsMember(String username){
        for(Member member : members){
            if(member.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean userIsClient(String username){
        for(Client client : clients){
            if(client.getUsername().equals(username)){
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
