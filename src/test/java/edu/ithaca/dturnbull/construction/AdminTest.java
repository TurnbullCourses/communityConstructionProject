package edu.ithaca.dturnbull.construction;

import org.junit.jupiter.api.Test;


public class AdminTest {
<<<<<<< HEAD
   
=======
    
    ConstructionSoftware constructionSoftware = new ConstructionSoftware();

    @Test
    public void addAdminTest(){
        Admin admin = new Admin("admin@admin.com", "password", 4, "Full Name");
        constructionSoftware.addAdmin(admin);
        assert(constructionSoftware.admins.contains(admin));

    }

    @Test
    public void removeAdminTest(){
        Admin admin = new Admin("admin@admin.com", "password", 4, "Full Name");
        constructionSoftware.addAdmin(admin);
        constructionSoftware.removeAdmin(admin);
        assert(!constructionSoftware.admins.contains(admin));

    }

    @Test
    public void testManageCurrentProject(){
        // tests for manage current projects   
    }

    @Test
    public void testManagePastProject(){
        // tests for manage past projects    
    }

    @Test
    public void testManageFutureProjects(){
        // tests for manage future projects   
    }

    @Test
    public void testMarkComplete(){
        // tests for marking a project as complete
    }

    @Test
    public void testMarkIncomplete(){
        // tests for viewing a project
    }




    
>>>>>>> origin/main
}
