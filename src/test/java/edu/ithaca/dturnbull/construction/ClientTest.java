package edu.ithaca.dturnbull.construction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;


public class ClientTest {

    @Test
    public void testAccountInfo(){
        Client client = new Client("name", "email", "password",0);
        assertEquals("name", client.getFullName());
        assertEquals("email", client.getEmail());
        assertEquals("password", client.getPassword());
        assertEquals(0, client.getId());
        client.setPassword("newPassword");
        assertEquals(client.getPassword(), "newPassword");
        client.setFullName("newName");
        assertEquals("newName", client.getFullName());
        client.setEmail("newEmail");
        assertEquals("newEmail", client.getEmail());
    }

    @Test
    public void testRequestCurrentProject(){
        Client client = new Client("name", "email", "password",0);
        LocalDateTime time = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        Project project = new Project("name", 0, 0.0, date, time, time);
        client.currentProject = project;
        // View Current Project
        assertEquals(project, client.requestCurrentProject());
        // Sets and views Cost of the Current Project
        assertEquals(0.0, client.viewCurrentProject().getPrice());
        client.requestCost(10.0);
        assertEquals(10.0, client.viewCurrentProject().getPrice());
        // Sets and views Operating Hours of the Current Project
        assertEquals("From " + time.toLocalTime().toString() + " to " + time.toLocalTime().toString(), client.viewOperatingHours());
        LocalDateTime time2 = LocalDateTime.of(2024, 4, 1, 17, 0);
        client.requestOperatingHours(time2, time2);
        assertEquals("From " + time2.toLocalTime().toString() + " to " + time2.toLocalTime().toString(), client.viewOperatingHours());

        }

}
