package edu.ithaca.dturnbull.construction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class MemberTest {


    @Test
    public void testGettersSetters() {
        Member member = new Member("member@email.com", "samplePassword", 1, "Joe A");

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
        member.setId(2);
        assertEquals(Integer.valueOf(2), member.getId());
        member.setFullName("Amir S");
        assertEquals("Amir S", member.getFullName());
    }


    @Test
    public void testAllViews() {
        // View Current Project
        
        // View Cost of the Current Project

        // View Operating Hours of the Current Project

        // View Timeline of the Current Project
    }

}
