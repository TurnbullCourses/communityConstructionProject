package edu.ithaca.dturnbull.construction;

import org.junit.jupiter.api.Test;

public class ConstructionSoftwareTest {
    
    ConstructionSoftware constructionSoftware = new ConstructionSoftware();

    @Test
    public void addUserTest(){
        User user = new User("user@user.com", "password", 1, "Full Name");
        constructionSoftware.addUser(user);
        assert(constructionSoftware.users.contains(user));
    }
    
    @Test
    public void addClientTest(){
        Client client = new Client("client@client.com", "password", 2, "Full Name");
        constructionSoftware.addClient(client);
        assert(constructionSoftware.clients.contains(client));
    }

    @Test
    public void addMemberTest(){
        Member member = new Member("member@member.com", "password", 3, "Full Name");
        constructionSoftware.addMember(member);
        assert(constructionSoftware.members.contains(member));
    }

    @Test
    public void addProjectTest(){
        Project project = new Project("Project Name", 1, 230000, "12/25", "9am-5pm");
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
        User user = new User("user@user.com", "password", 1, "Full Name");
        constructionSoftware.addUser(user);
        constructionSoftware.removeUser(user);
        assert(!constructionSoftware.users.contains(user));
    }

    @Test
    public void removeClientTest(){
        Client client = new Client("client@client.com", "password", 2, "Full Name");
        constructionSoftware.addClient(client);
        constructionSoftware.removeClient(client);
        assert(!constructionSoftware.clients.contains(client));
    }

    @Test
    public void removeMemberTest(){
        Member member = new Member("member@member.com", "password", 3, "Full Name");
        constructionSoftware.addMember(member);
        constructionSoftware.removeMember(member);
        assert(!constructionSoftware.members.contains(member));
    }

    @Test
    public void removeProjectTest(){
        Project project = new Project("Project Name", 1, 230000, "12/25", "9am-5pm");
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
        Project project = new Project("Project Name", 1, 230000, "12/25", "9am-5pm");
        constructionSoftware.addProject(project);
        assert(constructionSoftware.currentProjects.contains(project));
    }

    @Test
    public void pastProjectsTest(){
        Project project = new Project("Project Name", 1, 230000, "12/25", "9am-5pm");
        constructionSoftware.addProject(project);
        assert(constructionSoftware.pastProjects.contains(project));
    }

    






}
