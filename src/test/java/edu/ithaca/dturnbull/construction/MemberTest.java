
package edu.ithaca.dturnbull.construction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class MemberTest {


    @Test
    public void testGettersSetters() {
        Member member = new Member("Joe A", "member@email.com", "samplePassword", 1);

        // Getters
        assertEquals("member@email.com", member.getEmail());
        assertEquals("samplePassword", member.getPassword());
        assertEquals(Integer.valueOf(1), member.getId());
        assertEquals("Joe A", member.getFullName());

        // Setters
        member.setEmail("setEmail@email.com");
        assertEquals("setEmail@email.com", member.getEmail());
        member.setPassword("setPassword");
        assertEquals("setPassword", member.getPassword());
        member.setFullName("Amir S");
        assertEquals("Amir S", member.getFullName());
    }


    @Test
    public void testAllViews() {
        Member member = new Member("Joe A", "member@email.com", "samplePassword", 1);
        LocalDateTime time = LocalDateTime.now();
        Project project = new Project("Project Name", 1, 0.0 , time, time, time);
        member.currentProject = project;
        // View Current Project
        assertEquals(project, member.viewCurrentProject());
        // View Cost of the Current Project
        assertEquals(0.0, member.viewCost());
        // View Operating Hours of the Current Project
        assertEquals("From " + time.toLocalTime().toString() + " to " + time.toLocalTime().toString(), member.viewOperatingHours());
        // View Timeline of the Current Project
        assertEquals("From NO START DATE IN PROJECT to " + time.toString(), member.viewTimeline());
    }

}
