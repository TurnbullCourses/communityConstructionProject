package edu.ithaca.dturnbull.construction;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class ConstructionSoftwareTest {
    
    ConstructionSoftware constructionSoftware = new ConstructionSoftware();

    @Test
    public void addUserTest(){
        User user = new User("user@user.com", "password", "Full Name", 1);
        constructionSoftware.addUser(user);
        assert(constructionSoftware.users.contains(user));
    }
    
    @Test
    public void addClientTest(){
        Client client = new Client("client@client.com", "password",  "Full Name",2);
        constructionSoftware.addClient(client);
        assert(constructionSoftware.clients.contains(client));
    }

    @Test
    public void addMemberTest(){
        Member member = new Member("member@member.com", "password","Full Name",3);
        constructionSoftware.addMember(member);
        assert(constructionSoftware.members.contains(member));
    }

    @Test
    public void addProjectTest(){
        LocalDateTime time = LocalDateTime.now();
        Project project = new Project("Project Name", 1, 230000, time, time, time);
        constructionSoftware.addProject(project);
        assert(constructionSoftware.projects.contains(project));
    }

    @Test
    public void addAdminTest(){
        Admin admin = new Admin("admin@admin.com", "password", 4, "Full Name");
        constructionSoftware.addAdmin(admin);
        assert(constructionSoftware.admins.contains(admin));
    }

    @Test
    public void removeUserTest(){
        User user = new User("user@user.com", "password", "Full Name",1);
        constructionSoftware.addUser(user);
        constructionSoftware.removeUser(user);
        assert(!constructionSoftware.users.contains(user));
    }

    @Test
    public void removeClientTest(){
        Client client = new Client("client@client.com", "password", "Full Name",2);
        constructionSoftware.addClient(client);
        constructionSoftware.removeClient(client);
        assert(!constructionSoftware.clients.contains(client));
    }

    @Test
    public void removeMemberTest(){
        Member member = new Member("member@member.com", "password", "Full Name",3);
        constructionSoftware.addMember(member);
        constructionSoftware.removeMember(member);
        assert(!constructionSoftware.members.contains(member));
    }

    @Test
    public void removeProjectTest(){
        LocalDateTime time = LocalDateTime.now();
        Project project = new Project("Project Name", 1, 230000, time, time, time);
        constructionSoftware.addProject(project);
        constructionSoftware.removeProject(project);
        assert(!constructionSoftware.projects.contains(project));
    }

    @Test
    public void removeAdminTest(){
        Admin admin = new Admin("admin@admin.com", "password", 4, "Full Name");
        constructionSoftware.addAdmin(admin);
        constructionSoftware.removeAdmin(admin);
        assert(!constructionSoftware.admins.contains(admin));
    }

    @Test
    public void currentProjectsTest(){
        LocalDateTime time = LocalDateTime.now();
        Project project = new Project("Project Name", 1, 230000, time, time, time);
        constructionSoftware.addCurrentProject(project); // addCurrentProject is similar to addProject
        assert(constructionSoftware.currentProjects.contains(project));
    }

    @Test
    public void pastProjectsTest(){
        LocalDateTime time = LocalDateTime.now();
        Project project = new Project("Project Name", 1, 230000, time, time, time);
        constructionSoftware.addPastProject(project); 
        assert(constructionSoftware.pastProjects.contains(project));
    }

    






}
