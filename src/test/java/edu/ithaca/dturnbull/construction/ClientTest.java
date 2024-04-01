package edu.ithaca.dturnbull.construction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class ClientTest {

    @Test
    public void testLogin(){
        Client client = new Client("name", "email", "password");
        assertEquals("name", client.getName());
        assertEquals("email", client.getEmail());
        assertTrue(client.checkPassword("password"));
        client.changePassword("newPassword");
        assertTrue(client.checkPassword("newPassword"));
        client.changeName("newName");
        assertEquals("newName", client.getName());






    }

}
