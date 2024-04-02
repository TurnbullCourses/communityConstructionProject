package edu.ithaca.dturnbull.construction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

public class ProjectTest {

    private Project project;
    private String name = "Project Construction";
    private Integer id = 123;
    private double price = 1000.0;
    private LocalDate completionDate = LocalDate.of(2024, 4, 1);
    private LocalDateTime operatingHoursStart = LocalDateTime.of(2024, 4, 1, 8, 0);
    private LocalDateTime operatingHoursEnd = LocalDateTime.of(2024, 4, 1, 17, 0);

    

    @Test
    public void ProjectAttributesTest() {
        project = new Project(name, id, price, completionDate, operatingHoursStart, operatingHoursEnd);
        assertNotNull(project);
        assertEquals(name, project.getName());
        assertEquals(id.intValue(), project.getProjectId());
        assertEquals(price, project.getPrice(), 0.001);
        assertEquals(completionDate, project.getCompletionDate());
        assertEquals("From 08:00 to 17:00", project.getOperatingHours());
    }

    @Test
    public void SetProjectIdTest() {
        project = new Project(name, id, price, completionDate, operatingHoursStart, operatingHoursEnd);
        int newId = 456;
        project.setProjectId(newId);
        assertEquals(newId, project.getProjectId());
    }

    @Test
    public void SetNameTest() {
        project = new Project(name, id, price, completionDate, operatingHoursStart, operatingHoursEnd);
        String newName = "Project Y";
        project.setName(newName);
        assertEquals(newName, project.getName());
    }

    @Test
    public void SetPriceTest() {
        project = new Project(name, id, price, completionDate, operatingHoursStart, operatingHoursEnd);
        double newPrice = 1500.0;
        project.setPrice(newPrice);
        assertEquals(newPrice, project.getPrice(), 0.001);
    }

    @Test
    public void SetCompletionDateTest() {
        project = new Project(name, id, price, completionDate, operatingHoursStart, operatingHoursEnd);
        LocalDate newCompletionDate = LocalDate.of(2024, 5, 1);
        project.setCompletionDate(newCompletionDate);
        assertEquals(newCompletionDate, project.getCompletionDate());
    }

    @Test
    public void SetOperatingHoursTest() {
        project = new Project(name, id, price, completionDate, operatingHoursStart, operatingHoursEnd);
        LocalDateTime newOperatingHoursStart = LocalDateTime.of(2024, 4, 1, 9, 0);
        LocalDateTime newOperatingHoursEnd = LocalDateTime.of(2024, 4, 1, 18, 0);
        project.setOperatingHours(newOperatingHoursStart, newOperatingHoursEnd);
        assertEquals("From 09:00 to 18:00", project.getOperatingHours());
    }
}
